/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.globals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.records.cat.CatThmlfObject01;
import opsw.uci.prj.records.cat.CatThmlfObject02;
import opsw.uci.prj.system.OpswJsonTenant;
import opsw.uci.prj.system.OpswSystemConnections;
import opsw.uci.prj.system.OpswTenants;

/**
 *
 * @author oulis
 */
public class OpswErpRecords01
{

  private static class ErairComp implements Comparator<CatThmlfObject02>
  {

    @Override
    public int compare(CatThmlfObject02 o1, CatThmlfObject02 o2)
    {
      return o1.getCode().compareTo(o2.getCode());
    }

  }

  private static final ErairComp FETAIR_COMP = new ErairComp();

  public static List<CatThmlfObject02> OpswListXrhshListObj()
          throws CatException
  {
    List<CatThmlfObject02> list = new ArrayList<>();

//    CatThmlfObject02 obj = new CatThmlfObject02();
//    obj.setCode(new Long(1));
//    obj.setDescr("DEFAULT CONNECTION (ORCLH MINLO)");
//    list.add(obj);
//
//    obj = new CatThmlfObject02();
//    obj.setCode(new Long(2));
//    obj.setDescr("CONNECTION 1");
//    list.add(obj);
//
//    obj = new CatThmlfObject02();
//    obj.setCode(new Long(3));
//    obj.setDescr("CONNECTION 2");
//    list.add(obj);
    if (OpswTenants.OPSW_GLOBAL_TENANTS() != null)
    {

      List<OpswJsonTenant> vtenants = OpswTenants.OPSW_GLOBAL_TENANTS().getTenants();

      if (vtenants != null)
      {
        CatThmlfObject02 obj = null;
        for (OpswJsonTenant o : vtenants)
        {
          obj = new CatThmlfObject02();
          list.add(obj);

          obj.setCode((long) o.getTenantNo());
          obj.setDescr(o.getDescr());
        }
      }
    }

    return list;
  }

  public static CatThmlfObject02 OpswGetXrhshObj(short ietai)
          throws CatException
  {
    List<CatThmlfObject02> vlist = OpswListXrhshListObj();

    CatThmlfObject02 vobj = new CatThmlfObject02();
    vobj.setCode(new Long(ietai));

    Collections.sort(vlist, FETAIR_COMP);
    int j = Collections.binarySearch(vlist, vobj, FETAIR_COMP);

    if (j > -1)
    {
      vobj.setDescr(vlist.get(j).getDescr());
    }
    return vobj;
  }

  public static void OpswXrhshByEtairSetConnection(OpswLoginVars wLoginVar, short ietai)
          throws CatException
  {
    try
    {
      OpswSystemConnections.OpswConnection[] cons = OpswSystemConnections.OpswConnectionsGet01();

      if (cons != null)
      {
        if (OpswTenants.OPSW_GLOBAL_TENANTS().getTenants() != null)
        {
          for (OpswJsonTenant c : OpswTenants.OPSW_GLOBAL_TENANTS().getTenants())
          {
            if (ietai == c.getTenantNo())
            {
              wLoginVar.setConnectionDs(c.getDatasourceName());
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
  }
}
