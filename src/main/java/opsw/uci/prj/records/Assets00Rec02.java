/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.records;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import opsw.uci.prj.cat.CatException;
import opsw.uci.prj.entity.Assets00;
import opsw.uci.prj.logic.OpswReflection;
import opsw.uci.prj.utils.OpswDateUtils;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author n.oulis
 */
public class Assets00Rec02
{

  private Long asset;
  private Long aauci_rec;
  @DateTimeFormat(pattern = OpswDateUtils.OPSW_DATE_THYMLEAF_02)
  private Date assfile_rec;
  private String intrnlkey_rec;
  private String statusdeff;
  private String uniqcode;
  private String auctionurl;
  private Long symb_id;
  /*private String symb_name;
  private String symb_surename;
  private String symb_tele;
  private String symb_mail;
*/
  private String borrname;
  private String property_id;
  private String callateral1;
  private String callateral_sub_type;
  private String municipality;
  private String city;
  private String address;
  private String zipcode;
  private String gpscords;
  private String description;
  private Double landarea;
  private Double buildarea;
  private Double mainsurefacearea;
  private Double auxilliarysurefacearea;
  private Double arbitarysurefacearea;
  private Byte fullownership;
  private Short constructionyear;
  private String floor;
  private String auction_id;
  private String uniqauction_code;
  @DateTimeFormat(pattern = OpswDateUtils.OPSW_DATE_THYMLEAF_02)
  private Date auction_datedate;
  private Double startingprice;
  private String landealink;
  private String region;
  private String prefecture;
  private Byte ownership_type;
  private String auctiondate;
  private String image1;
  private String image2;
  private String image3;
  private String comments_sea;
  private Byte ekth_ektim;
  private Byte techn_fakel;
  private Byte teaser;
  private String site;
  private String broker_site;
  private String subbroker_name;
  private Integer visitors_count;
  private Byte begin_endiaferon;
  private Integer leads;
  private String endiaferomenos_info;
  private String endiaferomenos_info1;
  private String endiaferomenos_info2;
  private String endiaferomenos_info3;
  private String endiaferomenos_info4;
  private String endiaferomenos_info5;
  private String comments1;
  private String comments2;
  private Integer marketability_name;
  private String landea_leads;
  private String landea_comments;
  private String update_auction;
  private String high_interest;
  private String user_create;
  private Calendar date_create;
  private String user_modify;
  private Calendar date_modify;

  private List<Assets00flRec01> assets00flrec;

  public Assets00Rec02()
  {
    this.asset = null;
    this.aauci_rec = null;
    this.assfile_rec = null;
    this.intrnlkey_rec = null;
    this.statusdeff = null;
    this.uniqcode = null;
    this.auctionurl = null;
    this.symb_id = null;
    this.borrname = null;
    this.property_id = null;
    this.callateral1 = null;
    this.callateral_sub_type = null;
    this.municipality = null;
    this.city = null;
    this.address = null;
    this.zipcode = null;
    this.gpscords = null;
    this.description = null;
    this.landarea = null;
    this.buildarea = null;
    this.mainsurefacearea = null;
    this.auxilliarysurefacearea = null;
    this.arbitarysurefacearea = null;
    this.fullownership = null;
    this.constructionyear = null;
    this.floor = null;
    this.auction_id = null;
    this.uniqauction_code = null;
    this.auction_datedate = null;
    this.startingprice = null;
    this.landealink = null;
    this.region = null;
    this.prefecture = null;
    this.ownership_type = null;
    this.auctiondate = null;
    this.image1 = null;
    this.image2 = null;
    this.image3 = null;
    this.comments_sea = null;
    this.ekth_ektim = null;
    this.techn_fakel = null;
    this.teaser = null;
    this.site = null;
    this.broker_site = null;
    this.subbroker_name = null;
    this.visitors_count = null;
    this.begin_endiaferon = null;
    this.leads = null;
    this.endiaferomenos_info = null;
    this.endiaferomenos_info1 = null;
    this.endiaferomenos_info2 = null;
    this.endiaferomenos_info3 = null;
    this.endiaferomenos_info4 = null;
    this.endiaferomenos_info5 = null;
    this.comments1 = null;
    this.comments2 = null;
    this.marketability_name = null;
    this.landea_leads = null;
    this.landea_comments = null;
    this.update_auction = null;
    this.high_interest = null;
//    this.symb_name = null;
//    this.symb_surename = null;
//    this.symb_tele = null;
//    this.symb_mail = null;
    this.assets00flrec = null;
    this.user_create = null;
    this.date_create = null;
    this.user_modify = null;
    this.date_modify = null;
  }

  public Long getAsset()
  {
    return asset;
  }

  public void setAsset(Long asset)
  {
    this.asset = asset;
  }

  public Long getAauci_rec()
  {
    return aauci_rec;
  }

  public void setAauci_rec(Long aauci_rec)
  {
    this.aauci_rec = aauci_rec;
  }

  public Date getAssfile_rec()
  {
    return assfile_rec;
  }

  public void setAssfile_rec(Date assfile_rec)
  {
    this.assfile_rec = assfile_rec;
  }

  public String getIntrnlkey_rec()
  {
    return intrnlkey_rec;
  }

  public void setIntrnlkey_rec(String intrnlkey_rec)
  {
    this.intrnlkey_rec = intrnlkey_rec;
  }

  public String getStatusdeff()
  {
    return statusdeff;
  }

  public void setStatusdeff(String statusdeff)
  {
    this.statusdeff = statusdeff;
  }

  public String getUniqcode()
  {
    return uniqcode;
  }

  public void setUniqcode(String uniqcode)
  {
    this.uniqcode = uniqcode;
  }

  public String getAuctionurl()
  {
    return auctionurl;
  }

  public void setAuctionurl(String auctionurl)
  {
    this.auctionurl = auctionurl;
  }

  public Long getSymb_id()
  {
    return symb_id;
  }

  public void setSymb_id(Long symb_id)
  {
    this.symb_id = symb_id;
  }

  public String getBorrname()
  {
    return borrname;
  }

  public void setBorrname(String borrname)
  {
    this.borrname = borrname;
  }

  public String getProperty_id()
  {
    return property_id;
  }

  public void setProperty_id(String property_id)
  {
    this.property_id = property_id;
  }

  public String getCallateral1()
  {
    return callateral1;
  }

  public void setCallateral1(String callateral1)
  {
    this.callateral1 = callateral1;
  }

  public String getCallateral_sub_type()
  {
    return callateral_sub_type;
  }

  public void setCallateral_sub_type(String callateral_sub_type)
  {
    this.callateral_sub_type = callateral_sub_type;
  }

  public String getMunicipality()
  {
    return municipality;
  }

  public void setMunicipality(String municipality)
  {
    this.municipality = municipality;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getZipcode()
  {
    return zipcode;
  }

  public void setZipcode(String zipcode)
  {
    this.zipcode = zipcode;
  }

  public String getGpscords()
  {
    return gpscords;
  }

  public void setGpscords(String gpscords)
  {
    this.gpscords = gpscords;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public Double getLandarea()
  {
    return landarea;
  }

  public void setLandarea(Double landarea)
  {
    this.landarea = landarea;
  }

  public Double getBuildarea()
  {
    return buildarea;
  }

  public void setBuildarea(Double buildarea)
  {
    this.buildarea = buildarea;
  }

  public Double getMainsurefacearea()
  {
    return mainsurefacearea;
  }

  public void setMainsurefacearea(Double mainsurefacearea)
  {
    this.mainsurefacearea = mainsurefacearea;
  }

  public Double getAuxilliarysurefacearea()
  {
    return auxilliarysurefacearea;
  }

  public void setAuxilliarysurefacearea(Double auxilliarysurefacearea)
  {
    this.auxilliarysurefacearea = auxilliarysurefacearea;
  }

  public Double getArbitarysurefacearea()
  {
    return arbitarysurefacearea;
  }

  public void setArbitarysurefacearea(Double arbitarysurefacearea)
  {
    this.arbitarysurefacearea = arbitarysurefacearea;
  }

  public Byte getFullownership()
  {
    return fullownership;
  }

  public void setFullownership(Byte fullownership)
  {
    this.fullownership = fullownership;
  }

  public Short getConstructionyear()
  {
    return constructionyear;
  }

  public void setConstructionyear(Short constructionyear)
  {
    this.constructionyear = constructionyear;
  }

  public String getFloor()
  {
    return floor;
  }

  public void setFloor(String floor)
  {
    this.floor = floor;
  }

  public String getAuction_id()
  {
    return auction_id;
  }

  public void setAuction_id(String auction_id)
  {
    this.auction_id = auction_id;
  }

  public String getUniqauction_code()
  {
    return uniqauction_code;
  }

  public void setUniqauction_code(String uniqauction_code)
  {
    this.uniqauction_code = uniqauction_code;
  }

  public Date getAuction_datedate()
  {
    return auction_datedate;
  }

  public void setAuction_datedate(Date auction_datedate)
  {
    this.auction_datedate = auction_datedate;
  }

  public Double getStartingprice()
  {
    return startingprice;
  }

  public void setStartingprice(Double startingprice)
  {
    this.startingprice = startingprice;
  }

  public String getLandealink()
  {
    return landealink;
  }

  public void setLandealink(String landealink)
  {
    this.landealink = landealink;
  }

  public String getRegion()
  {
    return region;
  }

  public void setRegion(String region)
  {
    this.region = region;
  }

  public String getPrefecture()
  {
    return prefecture;
  }

  public void setPrefecture(String prefecture)
  {
    this.prefecture = prefecture;
  }

  public Byte getOwnership_type()
  {
    return ownership_type;
  }

  public void setOwnership_type(Byte ownership_type)
  {
    this.ownership_type = ownership_type;
  }

  public String getAuctiondate()
  {
    return auctiondate;
  }

  public void setAuctiondate(String auctiondate)
  {
    this.auctiondate = auctiondate;
  }

  public String getImage1()
  {
    return image1;
  }

  public void setImage1(String image1)
  {
    this.image1 = image1;
  }

  public String getImage2()
  {
    return image2;
  }

  public void setImage2(String image2)
  {
    this.image2 = image2;
  }

  public String getImage3()
  {
    return image3;
  }

  public void setImage3(String image3)
  {
    this.image3 = image3;
  }

  public String getComments_sea()
  {
    return comments_sea;
  }

  public void setComments_sea(String comments_sea)
  {
    this.comments_sea = comments_sea;
  }

  public Byte getEkth_ektim()
  {
    return ekth_ektim;
  }

  public void setEkth_ektim(Byte ekth_ektim)
  {
    this.ekth_ektim = ekth_ektim;
  }

  public Byte getTechn_fakel()
  {
    return techn_fakel;
  }

  public void setTechn_fakel(Byte techn_fakel)
  {
    this.techn_fakel = techn_fakel;
  }

  public Byte getTeaser()
  {
    return teaser;
  }

  public void setTeaser(Byte teaser)
  {
    this.teaser = teaser;
  }

  public String getSite()
  {
    return site;
  }

  public void setSite(String site)
  {
    this.site = site;
  }

  public String getBroker_site()
  {
    return broker_site;
  }

  public void setBroker_site(String broker_site)
  {
    this.broker_site = broker_site;
  }

  public String getSubbroker_name()
  {
    return subbroker_name;
  }

  public void setSubbroker_name(String subbroker_name)
  {
    this.subbroker_name = subbroker_name;
  }

  public Integer getVisitors_count()
  {
    return visitors_count;
  }

  public void setVisitors_count(Integer visitors_count)
  {
    this.visitors_count = visitors_count;
  }

  public Byte getBegin_endiaferon()
  {
    return begin_endiaferon;
  }

  public void setBegin_endiaferon(Byte begin_endiaferon)
  {
    this.begin_endiaferon = begin_endiaferon;
  }

  public Integer getLeads()
  {
    return leads;
  }

  public void setLeads(Integer leads)
  {
    this.leads = leads;
  }

  public String getEndiaferomenos_info()
  {
    return endiaferomenos_info;
  }

  public void setEndiaferomenos_info(String endiaferomenos_info)
  {
    this.endiaferomenos_info = endiaferomenos_info;
  }

  public String getEndiaferomenos_info1()
  {
    return endiaferomenos_info1;
  }

  public void setEndiaferomenos_info1(String endiaferomenos_info1)
  {
    this.endiaferomenos_info1 = endiaferomenos_info1;
  }

  public String getEndiaferomenos_info2()
  {
    return endiaferomenos_info2;
  }

  public void setEndiaferomenos_info2(String endiaferomenos_info2)
  {
    this.endiaferomenos_info2 = endiaferomenos_info2;
  }

  public String getEndiaferomenos_info3()
  {
    return endiaferomenos_info3;
  }

  public void setEndiaferomenos_info3(String endiaferomenos_info3)
  {
    this.endiaferomenos_info3 = endiaferomenos_info3;
  }

  public String getEndiaferomenos_info4()
  {
    return endiaferomenos_info4;
  }

  public void setEndiaferomenos_info4(String endiaferomenos_info4)
  {
    this.endiaferomenos_info4 = endiaferomenos_info4;
  }

  public String getEndiaferomenos_info5()
  {
    return endiaferomenos_info5;
  }

  public void setEndiaferomenos_info5(String endiaferomenos_info5)
  {
    this.endiaferomenos_info5 = endiaferomenos_info5;
  }

  public String getComments1()
  {
    return comments1;
  }

  public void setComments1(String comments1)
  {
    this.comments1 = comments1;
  }

  public String getComments2()
  {
    return comments2;
  }

  public void setComments2(String comments2)
  {
    this.comments2 = comments2;
  }

  public Integer getMarketability_name()
  {
    return marketability_name;
  }

  public void setMarketability_name(Integer marketability_name)
  {
    this.marketability_name = marketability_name;
  }

  public String getLandea_leads()
  {
    return landea_leads;
  }

  public void setLandea_leads(String landea_leads)
  {
    this.landea_leads = landea_leads;
  }

  public String getLandea_comments()
  {
    return landea_comments;
  }

  public void setLandea_comments(String landea_comments)
  {
    this.landea_comments = landea_comments;
  }

  public String getUpdate_auction()
  {
    return update_auction;
  }

  public void setUpdate_auction(String update_auction)
  {
    this.update_auction = update_auction;
  }

  public String getHigh_interest()
  {
    return high_interest;
  }

  public void setHigh_interest(String high_interest)
  {
    this.high_interest = high_interest;
  }

//  public String getSymb_name()
//  {
//    return symb_name;
//  }
//
//  public void setSymb_name(String symb_name)
//  {
//    this.symb_name = symb_name;
//  }
//
//  public String getSymb_surename()
//  {
//    return symb_surename;
//  }
//
//  public void setSymb_surename(String symb_surename)
//  {
//    this.symb_surename = symb_surename;
//  }
//
//  public String getSymb_tele()
//  {
//    return symb_tele;
//  }
//
//  public void setSymb_tele(String symb_tele)
//  {
//    this.symb_tele = symb_tele;
//  }
//
//  public String getSymb_mail()
//  {
//    return symb_mail;
//  }
//
//  public void setSymb_mail(String symb_mail)
//  {
//    this.symb_mail = symb_mail;
//  }

  public List<Assets00flRec01> getAssets00flrec()
  {
    return assets00flrec;
  }

  public void setAssets00flrec(List<Assets00flRec01> assets00flrec)
  {
    this.assets00flrec = assets00flrec;
  }

  public String getUser_create()
  {
    return user_create;
  }

  public void setUser_create(String user_create)
  {
    this.user_create = user_create;
  }

  public Calendar getDate_create()
  {
    return date_create;
  }

  public void setDate_create(Calendar date_create)
  {
    this.date_create = date_create;
  }

  public String getUser_modify()
  {
    return user_modify;
  }

  public void setUser_modify(String user_modify)
  {
    this.user_modify = user_modify;
  }

  public Calendar getDate_modify()
  {
    return date_modify;
  }

  public void setDate_modify(Calendar date_modify)
  {
    this.date_modify = date_modify;
  }

  public static void Assets00Rec02ToAssets00_01(Assets00Rec02 iFrom, Assets00 iTo) throws CatException
  {
    String[] ss = {
      "DATE_CREATE", "DATE_MODIFY", "USER_CREATE", "USER_MODIFY", "SYMB_ID",
      "AAUCI", "ASSFILE", "INTRNLKEY"
    };
    OpswReflection.OpswReflectionCopyObjectFields(iFrom, iTo, Assets00Rec02.class, ss);
    iTo.setAuction_date(OpswDateUtils.DateToCalendarElseNow(iFrom.getAuction_datedate()));
  }

  public static void Assets00ToAssets00Rec02_01(Assets00 iFrom, Assets00Rec02 iTo) throws CatException
  {
    OpswReflection.OpswReflectionCopyObjectFields(iFrom, iTo, Assets00.class);
    iTo.setAuction_datedate(OpswDateUtils.CalendarToDateElseNow(iFrom.getAuction_date()));
    iTo.setAauci_rec(iFrom.getAauci());
    iTo.setAssfile_rec(OpswDateUtils.CalendarToDateElseNow(iFrom.getAssfile()));
    iTo.setIntrnlkey_rec(iFrom.getIntrnlkey());
  }

}
