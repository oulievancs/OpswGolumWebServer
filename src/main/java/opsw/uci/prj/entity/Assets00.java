/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import opsw.uci.prj.utils.OpswDateUtils;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author oulis
 */
@Entity
@Table(name = "ASSETS00")
public class Assets00 implements Serializable
{

  public static final byte FIELD_Y_OR_N_YES = 1;
  public static final byte FIELD_Y_OR_N_NO = 0;

  @Id
  private Long asset;
  private Long aauci;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar assfile;
  private String intrnlkey;
  private String borrname;
  private String city;
  private String description;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar auction_date;
  private String statusdeff;
  private String buyer;
  private String opinion_onvalue;
  private Integer marketability_rate;
  private String broker_site;
  private String spitogatos_url;
  private String xe_url;
  private String image1;
  private String image2;
  private String image3;
  private Byte teaser;
  private Byte send_investors;
  private String customer_file;
  private Integer leads;
  private Integer opportunity;
  private String high_interest;
  private String auction_id;
  private String uniqcode;
  private Long symb_id;
  private Double sold_price;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar date_create;
  private String user_create;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar date_modify;
  private String user_modify;
  /*
        Extra Cepal Fields
   */
  private String region;
  private String municipality;
  private String address;
  private String zipcode;
  private String gpscords;
  private Short constructionyear;
  private String floor;
  private Double startingprice;
  private String landealink;
  private String auctionurl;
  private Byte producer;
  private String comments_sea;
  private String remarks;
  private String update_auction;
  private String endiaferomenos_info1;
  private String endiaferomenos_info2;
  private String endiaferomenos_info3;
  private String callateral1;
  private String callateral_sub_type;
  private String prefecture;
  private Byte fullownership;
  private String source;
  private Double landarea;
  private Double buildarea;
  private Double mainsurefacearea;
  private Double auxilliarysurefacearea;
  private Double arbitarysurefacearea;
  private Byte techn_fakel;
  private String subbroker_name;
  private Integer visitors_count;
  private String sale_forecast;
  private String promotion_status;
  private Byte buyer_cepal;
//************************************************
  /*
        Extra Intrum Fields
   */
  private String kodikos_sda;
  private String ownership_type;
  private Double prosfora_a;
  private Double prosfora_a_total;
  private String afm;
  private Integer total_leads;
  private Integer total_high_interest;
  private Integer total_opportunity;
  private Byte presentation;
//************************************************
  /*
        Extra Other Fields
   */
  private Byte status;
  private Integer countass;
  private String property_id;
  private String auctiondate;
  private Byte ekth_ektim;
  private Byte begin_endiaferon;
  private String endiaferomenos_info;
  private String endiaferomenos_info4;
  private String endiaferomenos_info5;
  private String comments1;
  private String comments2;
  private String landea_leads;
  private String landea_comments;
  private String broker_comm;

  @Transient
  private Symb symb;

  @Transient
  private List<Assets00fl> assets00fl;

  public Assets00()
  {
    super();
    this.asset = null;
    this.aauci = null;
    this.assfile = null;
    this.intrnlkey = null;
    this.status = null;
    this.statusdeff = null;
    this.uniqcode = null;
    this.auctionurl = null;
    this.symb_id = null;
    this.sold_price = null;
    this.buyer = null;
    this.producer = null;
    this.countass = null;
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
    this.auction_date = null;
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
    this.marketability_rate = null;
    this.landea_leads = null;
    this.landea_comments = null;
    this.update_auction = null;
    this.high_interest = null;
    this.date_create = null;
    this.user_create = null;
    this.date_modify = null;
    this.user_modify = null;
    this.spitogatos_url = null;
    this.xe_url = null;
    //
    this.symb = null;
    this.assets00fl = null;

    this.source = null;
    this.sale_forecast = null;
    this.broker_comm = null;
    this.promotion_status = null;
    this.buyer_cepal = null;
    this.opinion_onvalue = null;
    this.send_investors = null;
    this.customer_file = null;
    this.remarks = null;
    this.opportunity = null;

    this.total_high_interest = null;
    this.total_leads = null;
    this.total_opportunity = null;

    this.prosfora_a = null;
    this.prosfora_a_total = null;
    this.afm = null;
    this.presentation = null;
    this.kodikos_sda = null;
    this.sold_price = null;
  }

  public Long getAsset()
  {
    return asset;
  }

  public void setAsset(Long asset)
  {
    this.asset = asset;
  }

  public Long getAauci()
  {
    return aauci;
  }

  public void setAauci(Long aauci)
  {
    this.aauci = aauci;
  }

  public Calendar getAssfile()
  {
    return assfile;
  }

  public void setAssfile(Calendar assfile)
  {
    this.assfile = assfile;
  }

  public String getIntrnlkey()
  {
    return intrnlkey;
  }

  public void setIntrnlkey(String intrnlkey)
  {
    this.intrnlkey = intrnlkey;
  }

  public Byte getStatus()
  {
    return status;
  }

  public void setStatus(Byte status)
  {
    this.status = status;
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

  public Double getSold_price()
  {
    return sold_price;
  }

  public void setSold_price(Double sold_price)
  {
    this.sold_price = sold_price;
  }

  public String getBuyer()
  {
    return buyer;
  }

  public void setBuyer(String buyer)
  {
    this.buyer = buyer;
  }

  public Byte getProducer()
  {
    return producer;
  }

  public void setProducer(Byte producer)
  {
    this.producer = producer;
  }

  public Integer getCountass()
  {
    return countass;
  }

  public void setCountass(Integer countass)
  {
    this.countass = countass;
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

  public Calendar getAuction_date()
  {
    return auction_date;
  }

  public void setAuction_date(Calendar auction_date)
  {
    this.auction_date = auction_date;
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

  public String getOwnership_type()
  {
    return ownership_type;
  }

  public void setOwnership_type(String ownership_type)
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

  public Integer getMarketability_rate()
  {
    return marketability_rate;
  }

  public void setMarketability_rate(Integer marketability_rate)
  {
    this.marketability_rate = marketability_rate;
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

  public Symb getSymb()
  {
    return symb;
  }

  public void setSymb(Symb symb)
  {
    this.symb = symb;
  }

  public Calendar getDate_create()
  {
    return date_create;
  }

  public void setDate_create(Calendar date_create)
  {
    this.date_create = date_create;
  }

  public String getUser_create()
  {
    return user_create;
  }

  public void setUser_create(String user_create)
  {
    this.user_create = user_create;
  }

  public Calendar getDate_modify()
  {
    return date_modify;
  }

  public void setDate_modify(Calendar date_modify)
  {
    this.date_modify = date_modify;
  }

  public String getUser_modify()
  {
    return user_modify;
  }

  public void setUser_modify(String user_modify)
  {
    this.user_modify = user_modify;
  }

  public String getSpitogatos_url()
  {
    return spitogatos_url;
  }

  public void setSpitogatos_url(String spitogatos_url)
  {
    this.spitogatos_url = spitogatos_url;
  }

  public String getXe_url()
  {
    return xe_url;
  }

  public void setXe_url(String xe_url)
  {
    this.xe_url = xe_url;
  }

  public List<Assets00fl> getAssets00fl()
  {
    return assets00fl;
  }

  public void setAssets00fl(List<Assets00fl> assets00fl)
  {
    this.assets00fl = assets00fl;
  }

  public String getSource()
  {
    return source;
  }

  public void setSource(String source)
  {
    this.source = source;
  }

  public String getSale_forecast()
  {
    return sale_forecast;
  }

  public void setSale_forecast(String sale_forecast)
  {
    this.sale_forecast = sale_forecast;
  }

  public String getBroker_comm()
  {
    return broker_comm;
  }

  public void setBroker_comm(String broker_comm)
  {
    this.broker_comm = broker_comm;
  }

  public String getPromotion_status()
  {
    return promotion_status;
  }

  public void setPromotion_status(String promotion_status)
  {
    this.promotion_status = promotion_status;
  }

  public Byte getBuyer_cepal()
  {
    return buyer_cepal;
  }

  public void setBuyer_cepal(Byte buyer_cepal)
  {
    this.buyer_cepal = buyer_cepal;
  }

  public String getOpinion_onvalue()
  {
    return opinion_onvalue;
  }

  public void setOpinion_onvalue(String opinion_onvalue)
  {
    this.opinion_onvalue = opinion_onvalue;
  }

  public Byte getSend_investors()
  {
    return send_investors;
  }

  public void setSend_investors(Byte send_investors)
  {
    this.send_investors = send_investors;
  }

  public String getCustomer_file()
  {
    return customer_file;
  }

  public void setCustomer_file(String customer_file)
  {
    this.customer_file = customer_file;
  }

  public String getRemarks()
  {
    return remarks;
  }

  public void setRemarks(String remarks)
  {
    this.remarks = remarks;
  }

  public Integer getOpportunity()
  {
    return opportunity;
  }

  public void setOpportunity(Integer opportunity)
  {
    this.opportunity = opportunity;
  }

  public Integer getTotal_leads()
  {
    return total_leads;
  }

  public void setTotal_leads(Integer total_leads)
  {
    this.total_leads = total_leads;
  }

  public Integer getTotal_high_interest()
  {
    return total_high_interest;
  }

  public void setTotal_high_interest(Integer total_high_interest)
  {
    this.total_high_interest = total_high_interest;
  }

  public Integer getTotal_opportunity()
  {
    return total_opportunity;
  }

  public void setTotal_opportunity(Integer total_opportunity)
  {
    this.total_opportunity = total_opportunity;
  }

  public Double getProsfora_a()
  {
    return prosfora_a;
  }

  public void setProsfora_a(Double prosfora_a)
  {
    this.prosfora_a = prosfora_a;
  }

  public Double getProsfora_a_total()
  {
    return prosfora_a_total;
  }

  public void setProsfora_a_total(Double prosfora_a_total)
  {
    this.prosfora_a_total = prosfora_a_total;
  }

  public String getAfm()
  {
    return afm;
  }

  public void setAfm(String afm)
  {
    this.afm = afm;
  }

  public Byte getPresentation()
  {
    return presentation;
  }

  public void setPresentation(Byte presentation)
  {
    this.presentation = presentation;
  }

  public String getKodikos_sda()
  {
    return kodikos_sda;
  }

  public void setKodikos_sda(String kodikos_sda)
  {
    this.kodikos_sda = kodikos_sda;
  }

  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 37 * hash + Objects.hashCode(this.asset);
    return hash;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    final Assets00 other = (Assets00) obj;
    if (!Objects.equals(this.asset, other.asset))
    {
      return false;
    }
    return true;
  }

}
