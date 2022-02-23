/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.assetsapi.logic;

import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import opsw.uci.prj.api.client.OpswHttpRequest01;
import opsw.uci.prj.api.client.OpswHttpRequestBase;
import opsw.uci.prj.api.client.XmlReaderWriter;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.cat.CatExceptionUser;
import opsw.uci.prj.entity.Opswconstsv;
import opsw.uci.prj.entity.Uciremservreq;
import opsw.uci.prj.external.entities.Estate;
import opsw.uci.prj.external.entities.ProducerEstates;
import opsw.uci.prj.globals.OpswLoginVars;
import opsw.uci.prj.records.Assets00Rec02;
import opsw.uci.prj.services.Assets00Service;
import opsw.uci.prj.services.OpswconstvService;
import opsw.uci.prj.services.UciremservreqService;
import opsw.uci.prj.utils.OpswArrayUtils;
import opsw.uci.prj.utils.OpswDateUtils;
import opsw.uci.prj.utils.OpswStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author n.oulis
 */
@Component
@Service
public class LcOpswAssetsApi
{

  @Autowired
  private Assets00Service Assets00Service;

  @Autowired
  private OpswconstvService constsvService;

  @Autowired
  private UciremservreqService UciremservreqService;

  public LcOpswAssetsApi()
  {

  }

  public Assets00Service getAssets00Service()
  {
    return Assets00Service;
  }

  public void setAssets00Service(Assets00Service Assets00Service)
  {
    this.Assets00Service = Assets00Service;
  }

  public OpswconstvService getConstsvService()
  {
    return constsvService;
  }

  public void setConstsvService(OpswconstvService constsvService)
  {
    this.constsvService = constsvService;
  }

  public Assets00Rec02 InternalCRMCall(Long asset, OpswLoginVars ilogvars) throws CatException
  {
    Assets00Rec02 res = null;
    ProducerEstates prodEst = null;
    try
    {
      if (asset != null)
      {
        res = this.Assets00Service.Assets00SelectEd01(asset);
        if (res != null)
        {
          Calendar vcal = Calendar.getInstance();
          vcal.add(Calendar.HOUR_OF_DAY, -2);

          prodEst = this.ProducerEstatesFromLocal(vcal);

          if (prodEst == null || prodEst.getEstates() == null || prodEst.getEstates().isEmpty())
          {
            prodEst = this.ProducerEstatesFromRemoteAndSave(ilogvars);
          }

          Estate vest = null;

          if (prodEst != null)
          {
            vest = this.EstateGetByInternalKey(res.getIntrnlkey_rec(), prodEst.getEstates());
          }

          if (vest != null)
          {
            res.setImage1(vest.getPhoto1());
            res.setImage2(vest.getPhoto2());
            res.setImage3(vest.getPhoto3());
            res = this.Assets00Service.Assets00PostEd01(asset, res, ilogvars);
          }
        }
      }
    }
    catch (Exception e)
    {
      CatException.RethrowCatException(e);
    }
    return res;
  }

  private Estate EstateGetByInternalKey(String assets00InternlKey, List<Estate> iestlist) throws CatException
  {
    Estate vest = null;
    try
    {
      if (iestlist != null && !iestlist.isEmpty())
      {
        for (Estate e : iestlist)
        {
          if (!OpswStringUtils.OpswStringIsEmpty(e.getMlsCode()))
          {
            if (assets00InternlKey.equals(e.getMlsCode()))
            {
              vest = e;

              break;
            }
          }
        }
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return vest;
  }

  private ProducerEstates ProducerEstatesFromRemoteAndSave(OpswLoginVars iloginVars) throws CatException
  {
    ProducerEstates prds = null;
    try
    {
      prds = this.ProducerEstatesFromRemote(iloginVars, true);
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return prds;
  }

  private ProducerEstates ProducerEstatesFromRemote(OpswLoginVars iloginvars,
          boolean saveResponseOnSystem) throws CatException
  {
    ProducerEstates prodEst = null;
    try
    {
      Opswconstsv constv = this.constsvService.OpswconstvSelect02(Opswconstsv.CRM_SERVER_URL,
              "CRM_SERVER_URL_1");

      String vurl = null;

      if (constv != null)
      {
        vurl = constv.getValue1();
      }

      if (OpswStringUtils.OpswStringIsEmpty(vurl))
      {
        throw new CatExceptionUser("Δεν βρέθηκε η σταθερά που περιλαμβάνει το url του CRM endpoint!");
      }

      OpswHttpRequest01 httpRequest01 = new OpswHttpRequest01();

      XmlReaderWriter xmlReaderWriter = new XmlReaderWriter();
      httpRequest01.setXmlReaderWriter(xmlReaderWriter);

      OpswHttpRequestBase httpRequestBase = httpRequest01;

      httpRequestBase.setUrl(vurl);
      httpRequestBase.setMethod(OpswHttpRequestBase.OpswHttpMethod.OPSW_HTTP_MENTHOD_GET);
      httpRequestBase.setHttpProtocol(OpswHttpRequestBase.OpswHttpRequestProtocol.OPSW_HTTP_PROTOCOL_HTTP);
      httpRequestBase.setDateFormat(OpswDateUtils.OPSW_DATE_XMLFORMAT);
      httpRequestBase.setResponseBody(ProducerEstates.class);

      Map<String, Object> parameters = new HashMap<>();
      parameters.put("Portal", "Ext");
      parameters.put("action", "synconly");

      httpRequestBase.setUrlParameters(parameters);

      prodEst = (ProducerEstates) httpRequestBase.OpswHttpSend(null);

      if (saveResponseOnSystem)
      {
        Uciremservreq vuciremservreq = new Uciremservreq();
        vuciremservreq.setDate_modify(Calendar.getInstance());
        vuciremservreq.setUser_modify(iloginvars.getLoginUser());
        vuciremservreq.setRema("Received on " + OpswDateUtils.DateTimeToStr01(Calendar.getInstance()) + ".");
        vuciremservreq.setUrlreq(vurl);
        vuciremservreq.setRespbody(httpRequestBase.getHttpResponseBody());

        this.UciremservreqService.UciremservreqPost01(vuciremservreq);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }

    return prodEst;
  }

  private ProducerEstates ProducerEstatesFromLocal(Calendar date_cr_from) throws CatException
  {
    ProducerEstates pr = null;
    try
    {
      List<Uciremservreq> vlist = this.UciremservreqService.UciremservreqList01(date_cr_from);

      if (OpswArrayUtils.OpswArrayContainsAtLeastOne(vlist))
      {
        Uciremservreq vrec = vlist.get(0);

        XmlReaderWriter xmlReader = new XmlReaderWriter();
        xmlReader.setDateFormat(OpswDateUtils.OPSW_DATE_XMLFORMAT);

        pr = (ProducerEstates) xmlReader.EntityPorcess_Data02(vrec.getRespbody(), ProducerEstates.class);
      }
    }
    catch (Exception ex)
    {
      CatException.RethrowCatException(ex);
    }
    return pr;
  }
}
