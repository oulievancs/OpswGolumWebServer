/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opsw.uci.prj.external.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author oulis
 */
public class Estate
{

  @XmlElement(name = "AgencyKey")
  private String agencyKey;
  @XmlElement(name = "AgencyEmail", required = true)
  private String agencyEmail;
  @XmlElement(name = "AgencyPhone")
  private String agencyPhone;
  @XmlElement(name = "ID")
  private int id;
  @XmlElement(name = "MLS_Code")
  private String mlsCode;
  @XmlElement(name = "Status")
  private int status;
  @XmlElement(name = "SendDate", required = true)
  private Calendar sendDate;
  @XmlElement(name = "UpdateDate")
  private Calendar updateDate;
  @XmlElement(name = "isSync")
  private boolean isSync;
  @XmlElement(name = "OwnerID")
  private int ownerID;
  @XmlElement(name = "OwnerName", required = true)
  private String ownerName;
  @XmlElement(name = "RealtorID")
  private int realtorID;
  @XmlElement(name = "RealtorName", required = true)
  private String realtorName;
  @XmlElement(name = "Office")
  private String office;
  @XmlElement(name = "Title_GR", required = true)
  private String titleGR;
  @XmlElement(name = "Title_EN", required = true)
  private String titleEN;
  @XmlElement(name = "Description_GR", required = true)
  private String descriptionGR;
  @XmlElement(name = "Description_EN", required = true)
  private String descriptionEN;
  @XmlElement(name = "HtmlDescriptionBig_GR", required = true)
  private String htmlDescriptionBigGR;
  @XmlElement(name = "HtmlDescriptionBig_EN", required = true)
  private String htmlDescriptionBigEN;
  @XmlElement(name = "Aim_ID")
  private int aimID;
  @XmlElement(name = "Aim_GR")
  private String aimGR;
  @XmlElement(name = "Aim_EN")
  private String aimEN;
  @XmlElement(name = "EstateCategory_ID")
  private int estateCategoryID;
  @XmlElement(name = "EstateCategory_GR")
  private String estateCategoryGR;
  @XmlElement(name = "EstateCategory_EN")
  private String estateCategoryEN;
  @XmlElement(name = "EstateSubCategory_ID")
  private Integer estateSubCategoryID;
  @XmlElement(name = "EstateSubCategory_GR")
  private String estateSubCategoryGR;
  @XmlElement(name = "EstateSubCategory_EN")
  private String estateSubCategoryEN;
  @XmlElement(name = "Price")
  private BigDecimal price;
  @XmlElement(name = "Currency", required = true)
  private String currency;
  @XmlElement(name = "SqrMeters")
  private double sqrMeters;
  @XmlElement(name = "PlotSqr")
  private Double plotSqr;
  @XmlElement(name = "PricePerSqr")
  private BigDecimal pricePerSqr;
  @XmlElement(name = "SubArea_ID")
  private Integer subAreaID;
  @XmlElement(name = "SubArea_GR")
  private String subAreaGR;
  @XmlElement(name = "SubArea_EN")
  private String subAreaEN;
  @XmlElement(name = "Area_ID")
  private int areaID;
  @XmlElement(name = "Area_GR")
  private String areaGR;
  @XmlElement(name = "Area_EN")
  private String areaEN;
  @XmlElement(name = "Prefecture_ID")
  private int prefectureID;
  @XmlElement(name = "Prefecture_GR")
  private String prefectureGR;
  @XmlElement(name = "Prefecture_EN")
  private String prefectureEN;
  @XmlElement(name = "Region_ID")
  private int regionID;
  @XmlElement(name = "Region_GR")
  private String regionGR;
  @XmlElement(name = "Region_EN")
  private String regionEN;
  @XmlElement(name = "Country_ID")
  private int countryID;
  @XmlElement(name = "Country_GR")
  private String countryGR;
  @XmlElement(name = "Country_EN")
  private String countryEN;
  @XmlElement(name = "EstateStatus_ID")
  private Integer estateStatusID;
  @XmlElement(name = "EstateStatus_GR")
  private String estateStatusGR;
  @XmlElement(name = "EstateStatus_EN")
  private String estateStatusEN;
  @XmlElement(name = "ConstuctYear")
  private Integer constuctYear;
  @XmlElement(name = "Floor_ID")
  private Integer floorID;
  @XmlElement(name = "Floor_GR")
  private String floorGR;
  @XmlElement(name = "Floor_EN")
  private String floorEN;
  @XmlElement(name = "Levels")
  private Integer levels;
  @XmlElement(name = "Rooms")
  private Integer rooms;
  @XmlElement(name = "BedRooms")
  private Integer bedRooms;
  @XmlElement(name = "WC")
  private Integer wc;
  @XmlElement(name = "Parkings")
  private Integer parkings;
  @XmlElement(name = "View_ID")
  private Integer viewID;
  @XmlElement(name = "View_GR")
  private String viewGR;
  @XmlElement(name = "View_EN")
  private String viewEN;
  @XmlElement(name = "StorageRoom")
  private Boolean storageRoom;
  @XmlElement(name = "Balcony")
  private Boolean balcony;
  @XmlElement(name = "HeatSystem_ID")
  private Integer heatSystemID;
  @XmlElement(name = "HeatSystem_GR")
  private String heatSystemGR;
  @XmlElement(name = "HeatSystem_EN")
  private String heatSystemEN;
  @XmlElement(name = "AirCondition")
  private Boolean airCondition;
  @XmlElement(name = "SecureDoor")
  private Boolean secureDoor;
  @XmlElement(name = "Alarm")
  private Boolean alarm;
  @XmlElement(name = "InnerStairs")
  private Boolean innerStairs;
  @XmlElement(name = "Penthouse")
  private Boolean penthouse;
  @XmlElement(name = "Corner")
  private Boolean corner;
  @XmlElement(name = "NearTo")
  private String nearTo;
  @XmlElement(name = "DistanceVilage")
  private Integer distanceVilage;
  @XmlElement(name = "DistanceTown")
  private Integer distanceTown;
  @XmlElement(name = "DistanceSea")
  private Integer distanceSea;
  @XmlElement(name = "DistanceAirport")
  private Integer distanceAirport;
  @XmlElement(name = "StreetAccess_ID")
  private Integer streetAccessID;
  @XmlElement(name = "StreetAccess_GR")
  private String streetAccessGR;
  @XmlElement(name = "StreetAccess_EN")
  private String streetAccessEN;
  @XmlElement(name = "ObjectivePrice")
  private BigDecimal objectivePrice;
  @XmlElement(name = "LegalResearch")
  private Boolean legalResearch;
  @XmlElement(name = "Mortgage")
  private Boolean mortgage;
  @XmlElement(name = "NewBuild")
  private Boolean newBuild;
  @XmlElement(name = "InternetLine")
  private Boolean internetLine;
  @XmlElement(name = "Bathrooms")
  private Integer bathrooms;
  @XmlElement(name = "Kitchens")
  private Integer kitchens;
  @XmlElement(name = "Fireplaces")
  private Integer fireplaces;
  @XmlElement(name = "Pool")
  private Boolean pool;
  @XmlElement(name = "BBQ")
  private Boolean bbq;
  @XmlElement(name = "Elevator")
  private Boolean elevator;
  @XmlElement(name = "Satelite")
  private Boolean satelite;
  @XmlElement(name = "ReBuild")
  private Boolean reBuild;
  @XmlElement(name = "SolarSystem")
  private Boolean solarSystem;
  @XmlElement(name = "CCTV")
  private Boolean cctv;
  @XmlElement(name = "Playroom")
  private Boolean playroom;
  @XmlElement(name = "Garden")
  private Boolean garden;
  @XmlElement(name = "Loft")
  private Boolean loft;
  @XmlElement(name = "PetsAllow")
  private Boolean petsAllow;
  @XmlElement(name = "RuralResidence")
  private Boolean ruralResidence;
  @XmlElement(name = "Furnishing")
  private Boolean furnishing;
  @XmlElement(name = "Safe")
  private Boolean safe;
  @XmlElement(name = "Stadium")
  private Boolean stadium;
  @XmlElement(name = "AutoWatering")
  private Boolean autoWatering;
  @XmlElement(name = "Grass")
  private Boolean grass;
  @XmlElement(name = "Trees")
  private Boolean trees;
  @XmlElement(name = "DoubleGlasses")
  private Boolean doubleGlasses;
  @XmlElement(name = "SD")
  private Double sd;
  @XmlElement(name = "SK")
  private Double sk;
  @XmlElement(name = "LayoutSqr")
  private Double layoutSqr;
  @XmlElement(name = "LayoutLeft")
  private Double layoutLeft;
  @XmlElement(name = "ForDevelopment")
  private Boolean forDevelopment;
  @XmlElement(name = "Fenced")
  private Boolean fenced;
  @XmlElement(name = "Amphitheatrical")
  private Boolean amphitheatrical;
  @XmlElement(name = "Borehole")
  private Boolean borehole;
  @XmlElement(name = "Frontage")
  private Double frontage;
  @XmlElement(name = "Depth")
  private Double depth;
  @XmlElement(name = "AOT")
  private String aot;
  @XmlElement(name = "LandUsage_ID")
  private Integer landUsageID;
  @XmlElement(name = "LandUsage_GR")
  private String landUsageGR;
  @XmlElement(name = "LandUsage_EN")
  private String landUsageEN;
  @XmlElement(name = "CityPlan_ID")
  private Integer cityPlanID;
  @XmlElement(name = "CityPlan_GR")
  private String cityPlanGR;
  @XmlElement(name = "CityPlan_EN")
  private String cityPlanEN;
  @XmlElement(name = "RetrospectionFloors")
  private Integer retrospectionFloors;
  @XmlElement(name = "RetrospectionSqrMeters")
  private Double retrospectionSqrMeters;
  @XmlElement(name = "Shops")
  private Integer shops;
  @XmlElement(name = "Undergrounds")
  private Integer undergrounds;
  @XmlElement(name = "Ramps")
  private Boolean ramps;
  @XmlElement(name = "LiftOfCharges")
  private Boolean liftOfCharges;
  @XmlElement(name = "UsageType")
  private String usageType;
  @XmlElement(name = "ShopWindowSqr")
  private Double shopWindowSqr;
  @XmlElement(name = "LoftSqr")
  private Double loftSqr;
  @XmlElement(name = "UndergroundSqr")
  private Double undergroundSqr;
  @XmlElement(name = "FakeRoof")
  private Boolean fakeRoof;
  @XmlElement(name = "PortalID")
  private int portalID;
  @XmlElement(name = "ProducerID")
  private Integer producerID;
  @XmlElement(name = "Latidude")
  private Double latidude;
  @XmlElement(name = "Longitude")
  private Double longitude;
  @XmlElement(name = "Tents")
  private Boolean tents;
  @XmlElement(name = "Boiler")
  private Boolean boiler;
  @XmlElement(name = "FloorType_ID")
  private Integer floorTypeID;
  @XmlElement(name = "Koufomata_ID")
  private Integer koufomataID;
  @XmlElement(name = "YouTubeVideo")
  private String youTubeVideo;
  @XmlElement(name = "ForStudents")
  private Boolean forStudents;
  @XmlElement(name = "Diamperes")
  private Boolean diamperes;
  @XmlElement(name = "Prosopseos")
  private Boolean prosopseos;
  @XmlElement(name = "NearToTransport")
  private Boolean nearToTransport;
  @XmlElement(name = "NearToBus")
  private Boolean nearToBus;
  @XmlElement(name = "NearToMetro")
  private Boolean nearToMetro;
  @XmlElement(name = "NearToTrain")
  private Boolean nearToTrain;
  @XmlElement(name = "NearToTram")
  private Boolean nearToTram;
  @XmlElement(name = "MasterBedrooms")
  private Integer masterBedrooms;
  @XmlElement(name = "Stonehouse")
  private Boolean stonehouse;
  @XmlElement(name = "Neoclassical")
  private Boolean neoclassical;
  @XmlElement(name = "HeatMedium_ID")
  private Integer heatMediumID;
  @XmlElement(name = "HeatMedium_GR")
  private String heatMediumGR;
  @XmlElement(name = "HeatMedium_EN")
  private String heatMediumEN;
  @XmlElement(name = "HeatType_ID")
  private Integer heatTypeID;
  @XmlElement(name = "HeatType_GR")
  private String heatTypeGR;
  @XmlElement(name = "HeatType_EN")
  private String heatTypeEN;
  @XmlElement(name = "View360")
  private String view360;
  @XmlElement(name = "Flag1")
  private Boolean flag1;
  @XmlElement(name = "Flag2")
  private Boolean flag2;
  @XmlElement(name = "Flag3")
  private Boolean flag3;
  @XmlElement(name = "Flag4")
  private Boolean flag4;
  @XmlElement(name = "EnergyCertificate")
  private String energyCertificate;
  @XmlElement(name = "SpitogatosLevel2")
  private Integer spitogatosLevel2;
  @XmlElement(name = "SpitogatosLevel3")
  private Integer spitogatosLevel3;
  @XmlElement(name = "Orientation")
  private String orientation;
  @XmlElement(name = "Bright")
  private Boolean bright;
  @XmlElement(name = "NightStream")
  private Boolean nightStream;
  @XmlElement(name = "Underfloor")
  private Boolean underfloor;
  @XmlElement(name = "isExclusive")
  private Boolean isExclusive;
  @XmlElement(name = "Luxury")
  private Boolean luxury;
  @XmlElement(name = "NoKoinoxrista")
  private Boolean noKoinoxrista;
  @XmlElement(name = "Listed")
  private Boolean listed;
  @XmlElement(name = "Investment")
  private Boolean investment;
  @XmlElement(name = "Frontaged")
  private Boolean frontaged;
  @XmlElement(name = "Interior")
  private Boolean interior;
  @XmlElement(name = "Sieves")
  private Boolean sieves;
  @XmlElement(name = "RenovationYear")
  private Integer renovationYear;
  @XmlElement(name = "PostalCode")
  private String postalCode;
  @XmlElement(name = "Traditional")
  private Boolean traditional;
  @XmlElement(name = "Mansion")
  private Boolean mansion;
  @XmlElement(name = "Airy")
  private Boolean airy;
  @XmlElement(name = "OnHighway")
  private Boolean onHighway;
  @XmlElement(name = "Painted")
  private Boolean painted;
  @XmlElement(name = "HmiypaithriosSQR")
  private BigDecimal hmiypaithriosSQR;
  @XmlElement(name = "HmiypaithriosLegal")
  private Boolean hmiypaithriosLegal;
  @XmlElement(name = "LivingRooms")
  private Integer livingRooms;
  @XmlElement(name = "BalconyArea")
  private Double balconyArea;
  @XmlElement(name = "RooftopPrivate")
  private Double rooftopPrivate;
  @XmlElement(name = "MaintenanceCharges")
  private BigDecimal maintenanceCharges;
  @XmlElement(name = "TripleGlasses")
  private Boolean tripleGlasses;
  @XmlElement(name = "Jacuzzi")
  private Boolean jacuzzi;
  @XmlElement(name = "CableTV")
  private Boolean cableTV;
  @XmlElement(name = "ProfessionalUse")
  private Boolean professionalUse;
  @XmlElement(name = "AvailableAtDate")
  private Calendar availableAtDate;
  @XmlElement(name = "OnlineOwner")
  private String onlineOwner;
  @XmlElement(name = "OnlineOwnerEmail")
  private String onlineOwnerEmail;
  @XmlElement(name = "OnlineOwnerPhone")
  private String onlineOwnerPhone;
  @XmlElement(name = "Photo1")
  private String photo1;
  @XmlElement(name = "Photo2")
  private String photo2;
  @XmlElement(name = "Photo3")
  private String photo3;
  @XmlElement(name = "Photo4")
  private String photo4;
  @XmlElement(name = "Photo5")
  private String photo5;
  @XmlElement(name = "Photo6")
  private String photo6;
  @XmlElement(name = "Photo7")
  private String photo7;
  @XmlElement(name = "Photo8")
  private String photo8;
  @XmlElement(name = "Photo9")
  private String photo9;
  @XmlElement(name = "Photo10")
  private String photo10;
  @XmlElement(name = "Photo11")
  private String photo11;
  @XmlElement(name = "Photo12")
  private String photo12;
  @XmlElement(name = "Photo13")
  private String photo13;
  @XmlElement(name = "Photo14")
  private String photo14;
  @XmlElement(name = "Photo15")
  private String photo15;
  @XmlElement(name = "Photo16")
  private String photo16;
  @XmlElement(name = "Photo17")
  private String photo17;
  @XmlElement(name = "Photo18")
  private String photo18;
  @XmlElement(name = "Photo19")
  private String photo19;
  @XmlElement(name = "Photo20")
  private String photo20;
  @XmlElement(name = "Photo21")
  private String photo21;
  @XmlElement(name = "Photo22")
  private String photo22;
  @XmlElement(name = "Photo23")
  private String photo23;
  @XmlElement(name = "Photo24")
  private String photo24;
  @XmlElement(name = "Photo25")
  private String photo25;

  public String getAgencyKey()
  {
    return agencyKey;
  }

  public void setAgencyKey(String agencyKey)
  {
    this.agencyKey = agencyKey;
  }

  public String getAgencyEmail()
  {
    return agencyEmail;
  }

  public void setAgencyEmail(String agencyEmail)
  {
    this.agencyEmail = agencyEmail;
  }

  public String getAgencyPhone()
  {
    return agencyPhone;
  }

  public void setAgencyPhone(String agencyPhone)
  {
    this.agencyPhone = agencyPhone;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getMlsCode()
  {
    return mlsCode;
  }

  public void setMlsCode(String mlsCode)
  {
    this.mlsCode = mlsCode;
  }

  public int getStatus()
  {
    return status;
  }

  public void setStatus(int status)
  {
    this.status = status;
  }

  public Calendar getSendDate()
  {
    return sendDate;
  }

  public void setSendDate(Calendar sendDate)
  {
    this.sendDate = sendDate;
  }

  public Calendar getUpdateDate()
  {
    return updateDate;
  }

  public void setUpdateDate(Calendar updateDate)
  {
    this.updateDate = updateDate;
  }

  public boolean isIsSync()
  {
    return isSync;
  }

  public void setIsSync(boolean isSync)
  {
    this.isSync = isSync;
  }

  public int getOwnerID()
  {
    return ownerID;
  }

  public void setOwnerID(int ownerID)
  {
    this.ownerID = ownerID;
  }

  public String getOwnerName()
  {
    return ownerName;
  }

  public void setOwnerName(String ownerName)
  {
    this.ownerName = ownerName;
  }

  public int getRealtorID()
  {
    return realtorID;
  }

  public void setRealtorID(int realtorID)
  {
    this.realtorID = realtorID;
  }

  public String getRealtorName()
  {
    return realtorName;
  }

  public void setRealtorName(String realtorName)
  {
    this.realtorName = realtorName;
  }

  public String getOffice()
  {
    return office;
  }

  public void setOffice(String office)
  {
    this.office = office;
  }

  public String getTitleGR()
  {
    return titleGR;
  }

  public void setTitleGR(String titleGR)
  {
    this.titleGR = titleGR;
  }

  public String getTitleEN()
  {
    return titleEN;
  }

  public void setTitleEN(String titleEN)
  {
    this.titleEN = titleEN;
  }

  public String getDescriptionGR()
  {
    return descriptionGR;
  }

  public void setDescriptionGR(String descriptionGR)
  {
    this.descriptionGR = descriptionGR;
  }

  public String getDescriptionEN()
  {
    return descriptionEN;
  }

  public void setDescriptionEN(String descriptionEN)
  {
    this.descriptionEN = descriptionEN;
  }

  public String getHtmlDescriptionBigGR()
  {
    return htmlDescriptionBigGR;
  }

  public void setHtmlDescriptionBigGR(String htmlDescriptionBigGR)
  {
    this.htmlDescriptionBigGR = htmlDescriptionBigGR;
  }

  public String getHtmlDescriptionBigEN()
  {
    return htmlDescriptionBigEN;
  }

  public void setHtmlDescriptionBigEN(String htmlDescriptionBigEN)
  {
    this.htmlDescriptionBigEN = htmlDescriptionBigEN;
  }

  public int getAimID()
  {
    return aimID;
  }

  public void setAimID(int aimID)
  {
    this.aimID = aimID;
  }

  public String getAimGR()
  {
    return aimGR;
  }

  public void setAimGR(String aimGR)
  {
    this.aimGR = aimGR;
  }

  public String getAimEN()
  {
    return aimEN;
  }

  public void setAimEN(String aimEN)
  {
    this.aimEN = aimEN;
  }

  public int getEstateCategoryID()
  {
    return estateCategoryID;
  }

  public void setEstateCategoryID(int estateCategoryID)
  {
    this.estateCategoryID = estateCategoryID;
  }

  public String getEstateCategoryGR()
  {
    return estateCategoryGR;
  }

  public void setEstateCategoryGR(String estateCategoryGR)
  {
    this.estateCategoryGR = estateCategoryGR;
  }

  public String getEstateCategoryEN()
  {
    return estateCategoryEN;
  }

  public void setEstateCategoryEN(String estateCategoryEN)
  {
    this.estateCategoryEN = estateCategoryEN;
  }

  public Integer getEstateSubCategoryID()
  {
    return estateSubCategoryID;
  }

  public void setEstateSubCategoryID(Integer estateSubCategoryID)
  {
    this.estateSubCategoryID = estateSubCategoryID;
  }

  public String getEstateSubCategoryGR()
  {
    return estateSubCategoryGR;
  }

  public void setEstateSubCategoryGR(String estateSubCategoryGR)
  {
    this.estateSubCategoryGR = estateSubCategoryGR;
  }

  public String getEstateSubCategoryEN()
  {
    return estateSubCategoryEN;
  }

  public void setEstateSubCategoryEN(String estateSubCategoryEN)
  {
    this.estateSubCategoryEN = estateSubCategoryEN;
  }

  public BigDecimal getPrice()
  {
    return price;
  }

  public void setPrice(BigDecimal price)
  {
    this.price = price;
  }

  public String getCurrency()
  {
    return currency;
  }

  public void setCurrency(String currency)
  {
    this.currency = currency;
  }

  public double getSqrMeters()
  {
    return sqrMeters;
  }

  public void setSqrMeters(double sqrMeters)
  {
    this.sqrMeters = sqrMeters;
  }

  public Double getPlotSqr()
  {
    return plotSqr;
  }

  public void setPlotSqr(Double plotSqr)
  {
    this.plotSqr = plotSqr;
  }

  public BigDecimal getPricePerSqr()
  {
    return pricePerSqr;
  }

  public void setPricePerSqr(BigDecimal pricePerSqr)
  {
    this.pricePerSqr = pricePerSqr;
  }

  public Integer getSubAreaID()
  {
    return subAreaID;
  }

  public void setSubAreaID(Integer subAreaID)
  {
    this.subAreaID = subAreaID;
  }

  public String getSubAreaGR()
  {
    return subAreaGR;
  }

  public void setSubAreaGR(String subAreaGR)
  {
    this.subAreaGR = subAreaGR;
  }

  public String getSubAreaEN()
  {
    return subAreaEN;
  }

  public void setSubAreaEN(String subAreaEN)
  {
    this.subAreaEN = subAreaEN;
  }

  public int getAreaID()
  {
    return areaID;
  }

  public void setAreaID(int areaID)
  {
    this.areaID = areaID;
  }

  public String getAreaGR()
  {
    return areaGR;
  }

  public void setAreaGR(String areaGR)
  {
    this.areaGR = areaGR;
  }

  public String getAreaEN()
  {
    return areaEN;
  }

  public void setAreaEN(String areaEN)
  {
    this.areaEN = areaEN;
  }

  public int getPrefectureID()
  {
    return prefectureID;
  }

  public void setPrefectureID(int prefectureID)
  {
    this.prefectureID = prefectureID;
  }

  public String getPrefectureGR()
  {
    return prefectureGR;
  }

  public void setPrefectureGR(String prefectureGR)
  {
    this.prefectureGR = prefectureGR;
  }

  public String getPrefectureEN()
  {
    return prefectureEN;
  }

  public void setPrefectureEN(String prefectureEN)
  {
    this.prefectureEN = prefectureEN;
  }

  public int getRegionID()
  {
    return regionID;
  }

  public void setRegionID(int regionID)
  {
    this.regionID = regionID;
  }

  public String getRegionGR()
  {
    return regionGR;
  }

  public void setRegionGR(String regionGR)
  {
    this.regionGR = regionGR;
  }

  public String getRegionEN()
  {
    return regionEN;
  }

  public void setRegionEN(String regionEN)
  {
    this.regionEN = regionEN;
  }

  public int getCountryID()
  {
    return countryID;
  }

  public void setCountryID(int countryID)
  {
    this.countryID = countryID;
  }

  public String getCountryGR()
  {
    return countryGR;
  }

  public void setCountryGR(String countryGR)
  {
    this.countryGR = countryGR;
  }

  public String getCountryEN()
  {
    return countryEN;
  }

  public void setCountryEN(String countryEN)
  {
    this.countryEN = countryEN;
  }

  public Integer getEstateStatusID()
  {
    return estateStatusID;
  }

  public void setEstateStatusID(Integer estateStatusID)
  {
    this.estateStatusID = estateStatusID;
  }

  public String getEstateStatusGR()
  {
    return estateStatusGR;
  }

  public void setEstateStatusGR(String estateStatusGR)
  {
    this.estateStatusGR = estateStatusGR;
  }

  public String getEstateStatusEN()
  {
    return estateStatusEN;
  }

  public void setEstateStatusEN(String estateStatusEN)
  {
    this.estateStatusEN = estateStatusEN;
  }

  public Integer getConstuctYear()
  {
    return constuctYear;
  }

  public void setConstuctYear(Integer constuctYear)
  {
    this.constuctYear = constuctYear;
  }

  public Integer getFloorID()
  {
    return floorID;
  }

  public void setFloorID(Integer floorID)
  {
    this.floorID = floorID;
  }

  public String getFloorGR()
  {
    return floorGR;
  }

  public void setFloorGR(String floorGR)
  {
    this.floorGR = floorGR;
  }

  public String getFloorEN()
  {
    return floorEN;
  }

  public void setFloorEN(String floorEN)
  {
    this.floorEN = floorEN;
  }

  public Integer getLevels()
  {
    return levels;
  }

  public void setLevels(Integer levels)
  {
    this.levels = levels;
  }

  public Integer getRooms()
  {
    return rooms;
  }

  public void setRooms(Integer rooms)
  {
    this.rooms = rooms;
  }

  public Integer getBedRooms()
  {
    return bedRooms;
  }

  public void setBedRooms(Integer bedRooms)
  {
    this.bedRooms = bedRooms;
  }

  public Integer getWc()
  {
    return wc;
  }

  public void setWc(Integer wc)
  {
    this.wc = wc;
  }

  public Integer getParkings()
  {
    return parkings;
  }

  public void setParkings(Integer parkings)
  {
    this.parkings = parkings;
  }

  public Integer getViewID()
  {
    return viewID;
  }

  public void setViewID(Integer viewID)
  {
    this.viewID = viewID;
  }

  public String getViewGR()
  {
    return viewGR;
  }

  public void setViewGR(String viewGR)
  {
    this.viewGR = viewGR;
  }

  public String getViewEN()
  {
    return viewEN;
  }

  public void setViewEN(String viewEN)
  {
    this.viewEN = viewEN;
  }

  public Boolean getStorageRoom()
  {
    return storageRoom;
  }

  public void setStorageRoom(Boolean storageRoom)
  {
    this.storageRoom = storageRoom;
  }

  public Boolean getBalcony()
  {
    return balcony;
  }

  public void setBalcony(Boolean balcony)
  {
    this.balcony = balcony;
  }

  public Integer getHeatSystemID()
  {
    return heatSystemID;
  }

  public void setHeatSystemID(Integer heatSystemID)
  {
    this.heatSystemID = heatSystemID;
  }

  public String getHeatSystemGR()
  {
    return heatSystemGR;
  }

  public void setHeatSystemGR(String heatSystemGR)
  {
    this.heatSystemGR = heatSystemGR;
  }

  public String getHeatSystemEN()
  {
    return heatSystemEN;
  }

  public void setHeatSystemEN(String heatSystemEN)
  {
    this.heatSystemEN = heatSystemEN;
  }

  public Boolean getAirCondition()
  {
    return airCondition;
  }

  public void setAirCondition(Boolean airCondition)
  {
    this.airCondition = airCondition;
  }

  public Boolean getSecureDoor()
  {
    return secureDoor;
  }

  public void setSecureDoor(Boolean secureDoor)
  {
    this.secureDoor = secureDoor;
  }

  public Boolean getAlarm()
  {
    return alarm;
  }

  public void setAlarm(Boolean alarm)
  {
    this.alarm = alarm;
  }

  public Boolean getInnerStairs()
  {
    return innerStairs;
  }

  public void setInnerStairs(Boolean innerStairs)
  {
    this.innerStairs = innerStairs;
  }

  public Boolean getPenthouse()
  {
    return penthouse;
  }

  public void setPenthouse(Boolean penthouse)
  {
    this.penthouse = penthouse;
  }

  public Boolean getCorner()
  {
    return corner;
  }

  public void setCorner(Boolean corner)
  {
    this.corner = corner;
  }

  public String getNearTo()
  {
    return nearTo;
  }

  public void setNearTo(String nearTo)
  {
    this.nearTo = nearTo;
  }

  public Integer getDistanceVilage()
  {
    return distanceVilage;
  }

  public void setDistanceVilage(Integer distanceVilage)
  {
    this.distanceVilage = distanceVilage;
  }

  public Integer getDistanceTown()
  {
    return distanceTown;
  }

  public void setDistanceTown(Integer distanceTown)
  {
    this.distanceTown = distanceTown;
  }

  public Integer getDistanceSea()
  {
    return distanceSea;
  }

  public void setDistanceSea(Integer distanceSea)
  {
    this.distanceSea = distanceSea;
  }

  public Integer getDistanceAirport()
  {
    return distanceAirport;
  }

  public void setDistanceAirport(Integer distanceAirport)
  {
    this.distanceAirport = distanceAirport;
  }

  public Integer getStreetAccessID()
  {
    return streetAccessID;
  }

  public void setStreetAccessID(Integer streetAccessID)
  {
    this.streetAccessID = streetAccessID;
  }

  public String getStreetAccessGR()
  {
    return streetAccessGR;
  }

  public void setStreetAccessGR(String streetAccessGR)
  {
    this.streetAccessGR = streetAccessGR;
  }

  public String getStreetAccessEN()
  {
    return streetAccessEN;
  }

  public void setStreetAccessEN(String streetAccessEN)
  {
    this.streetAccessEN = streetAccessEN;
  }

  public BigDecimal getObjectivePrice()
  {
    return objectivePrice;
  }

  public void setObjectivePrice(BigDecimal objectivePrice)
  {
    this.objectivePrice = objectivePrice;
  }

  public Boolean getLegalResearch()
  {
    return legalResearch;
  }

  public void setLegalResearch(Boolean legalResearch)
  {
    this.legalResearch = legalResearch;
  }

  public Boolean getMortgage()
  {
    return mortgage;
  }

  public void setMortgage(Boolean mortgage)
  {
    this.mortgage = mortgage;
  }

  public Boolean getNewBuild()
  {
    return newBuild;
  }

  public void setNewBuild(Boolean newBuild)
  {
    this.newBuild = newBuild;
  }

  public Boolean getInternetLine()
  {
    return internetLine;
  }

  public void setInternetLine(Boolean internetLine)
  {
    this.internetLine = internetLine;
  }

  public Integer getBathrooms()
  {
    return bathrooms;
  }

  public void setBathrooms(Integer bathrooms)
  {
    this.bathrooms = bathrooms;
  }

  public Integer getKitchens()
  {
    return kitchens;
  }

  public void setKitchens(Integer kitchens)
  {
    this.kitchens = kitchens;
  }

  public Integer getFireplaces()
  {
    return fireplaces;
  }

  public void setFireplaces(Integer fireplaces)
  {
    this.fireplaces = fireplaces;
  }

  public Boolean getPool()
  {
    return pool;
  }

  public void setPool(Boolean pool)
  {
    this.pool = pool;
  }

  public Boolean getBbq()
  {
    return bbq;
  }

  public void setBbq(Boolean bbq)
  {
    this.bbq = bbq;
  }

  public Boolean getElevator()
  {
    return elevator;
  }

  public void setElevator(Boolean elevator)
  {
    this.elevator = elevator;
  }

  public Boolean getSatelite()
  {
    return satelite;
  }

  public void setSatelite(Boolean satelite)
  {
    this.satelite = satelite;
  }

  public Boolean getReBuild()
  {
    return reBuild;
  }

  public void setReBuild(Boolean reBuild)
  {
    this.reBuild = reBuild;
  }

  public Boolean getSolarSystem()
  {
    return solarSystem;
  }

  public void setSolarSystem(Boolean solarSystem)
  {
    this.solarSystem = solarSystem;
  }

  public Boolean getCctv()
  {
    return cctv;
  }

  public void setCctv(Boolean cctv)
  {
    this.cctv = cctv;
  }

  public Boolean getPlayroom()
  {
    return playroom;
  }

  public void setPlayroom(Boolean playroom)
  {
    this.playroom = playroom;
  }

  public Boolean getGarden()
  {
    return garden;
  }

  public void setGarden(Boolean garden)
  {
    this.garden = garden;
  }

  public Boolean getLoft()
  {
    return loft;
  }

  public void setLoft(Boolean loft)
  {
    this.loft = loft;
  }

  public Boolean getPetsAllow()
  {
    return petsAllow;
  }

  public void setPetsAllow(Boolean petsAllow)
  {
    this.petsAllow = petsAllow;
  }

  public Boolean getRuralResidence()
  {
    return ruralResidence;
  }

  public void setRuralResidence(Boolean ruralResidence)
  {
    this.ruralResidence = ruralResidence;
  }

  public Boolean getFurnishing()
  {
    return furnishing;
  }

  public void setFurnishing(Boolean furnishing)
  {
    this.furnishing = furnishing;
  }

  public Boolean getSafe()
  {
    return safe;
  }

  public void setSafe(Boolean safe)
  {
    this.safe = safe;
  }

  public Boolean getStadium()
  {
    return stadium;
  }

  public void setStadium(Boolean stadium)
  {
    this.stadium = stadium;
  }

  public Boolean getAutoWatering()
  {
    return autoWatering;
  }

  public void setAutoWatering(Boolean autoWatering)
  {
    this.autoWatering = autoWatering;
  }

  public Boolean getGrass()
  {
    return grass;
  }

  public void setGrass(Boolean grass)
  {
    this.grass = grass;
  }

  public Boolean getTrees()
  {
    return trees;
  }

  public void setTrees(Boolean trees)
  {
    this.trees = trees;
  }

  public Boolean getDoubleGlasses()
  {
    return doubleGlasses;
  }

  public void setDoubleGlasses(Boolean doubleGlasses)
  {
    this.doubleGlasses = doubleGlasses;
  }

  public Double getSd()
  {
    return sd;
  }

  public void setSd(Double sd)
  {
    this.sd = sd;
  }

  public Double getSk()
  {
    return sk;
  }

  public void setSk(Double sk)
  {
    this.sk = sk;
  }

  public Double getLayoutSqr()
  {
    return layoutSqr;
  }

  public void setLayoutSqr(Double layoutSqr)
  {
    this.layoutSqr = layoutSqr;
  }

  public Double getLayoutLeft()
  {
    return layoutLeft;
  }

  public void setLayoutLeft(Double layoutLeft)
  {
    this.layoutLeft = layoutLeft;
  }

  public Boolean getForDevelopment()
  {
    return forDevelopment;
  }

  public void setForDevelopment(Boolean forDevelopment)
  {
    this.forDevelopment = forDevelopment;
  }

  public Boolean getFenced()
  {
    return fenced;
  }

  public void setFenced(Boolean fenced)
  {
    this.fenced = fenced;
  }

  public Boolean getAmphitheatrical()
  {
    return amphitheatrical;
  }

  public void setAmphitheatrical(Boolean amphitheatrical)
  {
    this.amphitheatrical = amphitheatrical;
  }

  public Boolean getBorehole()
  {
    return borehole;
  }

  public void setBorehole(Boolean borehole)
  {
    this.borehole = borehole;
  }

  public Double getFrontage()
  {
    return frontage;
  }

  public void setFrontage(Double frontage)
  {
    this.frontage = frontage;
  }

  public Double getDepth()
  {
    return depth;
  }

  public void setDepth(Double depth)
  {
    this.depth = depth;
  }

  public String getAot()
  {
    return aot;
  }

  public void setAot(String aot)
  {
    this.aot = aot;
  }

  public Integer getLandUsageID()
  {
    return landUsageID;
  }

  public void setLandUsageID(Integer landUsageID)
  {
    this.landUsageID = landUsageID;
  }

  public String getLandUsageGR()
  {
    return landUsageGR;
  }

  public void setLandUsageGR(String landUsageGR)
  {
    this.landUsageGR = landUsageGR;
  }

  public String getLandUsageEN()
  {
    return landUsageEN;
  }

  public void setLandUsageEN(String landUsageEN)
  {
    this.landUsageEN = landUsageEN;
  }

  public Integer getCityPlanID()
  {
    return cityPlanID;
  }

  public void setCityPlanID(Integer cityPlanID)
  {
    this.cityPlanID = cityPlanID;
  }

  public String getCityPlanGR()
  {
    return cityPlanGR;
  }

  public void setCityPlanGR(String cityPlanGR)
  {
    this.cityPlanGR = cityPlanGR;
  }

  public String getCityPlanEN()
  {
    return cityPlanEN;
  }

  public void setCityPlanEN(String cityPlanEN)
  {
    this.cityPlanEN = cityPlanEN;
  }

  public Integer getRetrospectionFloors()
  {
    return retrospectionFloors;
  }

  public void setRetrospectionFloors(Integer retrospectionFloors)
  {
    this.retrospectionFloors = retrospectionFloors;
  }

  public Double getRetrospectionSqrMeters()
  {
    return retrospectionSqrMeters;
  }

  public void setRetrospectionSqrMeters(Double retrospectionSqrMeters)
  {
    this.retrospectionSqrMeters = retrospectionSqrMeters;
  }

  public Integer getShops()
  {
    return shops;
  }

  public void setShops(Integer shops)
  {
    this.shops = shops;
  }

  public Integer getUndergrounds()
  {
    return undergrounds;
  }

  public void setUndergrounds(Integer undergrounds)
  {
    this.undergrounds = undergrounds;
  }

  public Boolean getRamps()
  {
    return ramps;
  }

  public void setRamps(Boolean ramps)
  {
    this.ramps = ramps;
  }

  public Boolean getLiftOfCharges()
  {
    return liftOfCharges;
  }

  public void setLiftOfCharges(Boolean liftOfCharges)
  {
    this.liftOfCharges = liftOfCharges;
  }

  public String getUsageType()
  {
    return usageType;
  }

  public void setUsageType(String usageType)
  {
    this.usageType = usageType;
  }

  public Double getShopWindowSqr()
  {
    return shopWindowSqr;
  }

  public void setShopWindowSqr(Double shopWindowSqr)
  {
    this.shopWindowSqr = shopWindowSqr;
  }

  public Double getLoftSqr()
  {
    return loftSqr;
  }

  public void setLoftSqr(Double loftSqr)
  {
    this.loftSqr = loftSqr;
  }

  public Double getUndergroundSqr()
  {
    return undergroundSqr;
  }

  public void setUndergroundSqr(Double undergroundSqr)
  {
    this.undergroundSqr = undergroundSqr;
  }

  public Boolean getFakeRoof()
  {
    return fakeRoof;
  }

  public void setFakeRoof(Boolean fakeRoof)
  {
    this.fakeRoof = fakeRoof;
  }

  public int getPortalID()
  {
    return portalID;
  }

  public void setPortalID(int portalID)
  {
    this.portalID = portalID;
  }

  public Integer getProducerID()
  {
    return producerID;
  }

  public void setProducerID(Integer producerID)
  {
    this.producerID = producerID;
  }

  public Double getLatidude()
  {
    return latidude;
  }

  public void setLatidude(Double latidude)
  {
    this.latidude = latidude;
  }

  public Double getLongitude()
  {
    return longitude;
  }

  public void setLongitude(Double longitude)
  {
    this.longitude = longitude;
  }

  public Boolean getTents()
  {
    return tents;
  }

  public void setTents(Boolean tents)
  {
    this.tents = tents;
  }

  public Boolean getBoiler()
  {
    return boiler;
  }

  public void setBoiler(Boolean boiler)
  {
    this.boiler = boiler;
  }

  public Integer getFloorTypeID()
  {
    return floorTypeID;
  }

  public void setFloorTypeID(Integer floorTypeID)
  {
    this.floorTypeID = floorTypeID;
  }

  public Integer getKoufomataID()
  {
    return koufomataID;
  }

  public void setKoufomataID(Integer koufomataID)
  {
    this.koufomataID = koufomataID;
  }

  public String getYouTubeVideo()
  {
    return youTubeVideo;
  }

  public void setYouTubeVideo(String youTubeVideo)
  {
    this.youTubeVideo = youTubeVideo;
  }

  public Boolean getForStudents()
  {
    return forStudents;
  }

  public void setForStudents(Boolean forStudents)
  {
    this.forStudents = forStudents;
  }

  public Boolean getDiamperes()
  {
    return diamperes;
  }

  public void setDiamperes(Boolean diamperes)
  {
    this.diamperes = diamperes;
  }

  public Boolean getProsopseos()
  {
    return prosopseos;
  }

  public void setProsopseos(Boolean prosopseos)
  {
    this.prosopseos = prosopseos;
  }

  public Boolean getNearToTransport()
  {
    return nearToTransport;
  }

  public void setNearToTransport(Boolean nearToTransport)
  {
    this.nearToTransport = nearToTransport;
  }

  public Boolean getNearToBus()
  {
    return nearToBus;
  }

  public void setNearToBus(Boolean nearToBus)
  {
    this.nearToBus = nearToBus;
  }

  public Boolean getNearToMetro()
  {
    return nearToMetro;
  }

  public void setNearToMetro(Boolean nearToMetro)
  {
    this.nearToMetro = nearToMetro;
  }

  public Boolean getNearToTrain()
  {
    return nearToTrain;
  }

  public void setNearToTrain(Boolean nearToTrain)
  {
    this.nearToTrain = nearToTrain;
  }

  public Boolean getNearToTram()
  {
    return nearToTram;
  }

  public void setNearToTram(Boolean nearToTram)
  {
    this.nearToTram = nearToTram;
  }

  public Integer getMasterBedrooms()
  {
    return masterBedrooms;
  }

  public void setMasterBedrooms(Integer masterBedrooms)
  {
    this.masterBedrooms = masterBedrooms;
  }

  public Boolean getStonehouse()
  {
    return stonehouse;
  }

  public void setStonehouse(Boolean stonehouse)
  {
    this.stonehouse = stonehouse;
  }

  public Boolean getNeoclassical()
  {
    return neoclassical;
  }

  public void setNeoclassical(Boolean neoclassical)
  {
    this.neoclassical = neoclassical;
  }

  public Integer getHeatMediumID()
  {
    return heatMediumID;
  }

  public void setHeatMediumID(Integer heatMediumID)
  {
    this.heatMediumID = heatMediumID;
  }

  public String getHeatMediumGR()
  {
    return heatMediumGR;
  }

  public void setHeatMediumGR(String heatMediumGR)
  {
    this.heatMediumGR = heatMediumGR;
  }

  public String getHeatMediumEN()
  {
    return heatMediumEN;
  }

  public void setHeatMediumEN(String heatMediumEN)
  {
    this.heatMediumEN = heatMediumEN;
  }

  public Integer getHeatTypeID()
  {
    return heatTypeID;
  }

  public void setHeatTypeID(Integer heatTypeID)
  {
    this.heatTypeID = heatTypeID;
  }

  public String getHeatTypeGR()
  {
    return heatTypeGR;
  }

  public void setHeatTypeGR(String heatTypeGR)
  {
    this.heatTypeGR = heatTypeGR;
  }

  public String getHeatTypeEN()
  {
    return heatTypeEN;
  }

  public void setHeatTypeEN(String heatTypeEN)
  {
    this.heatTypeEN = heatTypeEN;
  }

  public String getView360()
  {
    return view360;
  }

  public void setView360(String view360)
  {
    this.view360 = view360;
  }

  public Boolean getFlag1()
  {
    return flag1;
  }

  public void setFlag1(Boolean flag1)
  {
    this.flag1 = flag1;
  }

  public Boolean getFlag2()
  {
    return flag2;
  }

  public void setFlag2(Boolean flag2)
  {
    this.flag2 = flag2;
  }

  public Boolean getFlag3()
  {
    return flag3;
  }

  public void setFlag3(Boolean flag3)
  {
    this.flag3 = flag3;
  }

  public Boolean getFlag4()
  {
    return flag4;
  }

  public void setFlag4(Boolean flag4)
  {
    this.flag4 = flag4;
  }

  public String getEnergyCertificate()
  {
    return energyCertificate;
  }

  public void setEnergyCertificate(String energyCertificate)
  {
    this.energyCertificate = energyCertificate;
  }

  public Integer getSpitogatosLevel2()
  {
    return spitogatosLevel2;
  }

  public void setSpitogatosLevel2(Integer spitogatosLevel2)
  {
    this.spitogatosLevel2 = spitogatosLevel2;
  }

  public Integer getSpitogatosLevel3()
  {
    return spitogatosLevel3;
  }

  public void setSpitogatosLevel3(Integer spitogatosLevel3)
  {
    this.spitogatosLevel3 = spitogatosLevel3;
  }

  public String getOrientation()
  {
    return orientation;
  }

  public void setOrientation(String orientation)
  {
    this.orientation = orientation;
  }

  public Boolean getBright()
  {
    return bright;
  }

  public void setBright(Boolean bright)
  {
    this.bright = bright;
  }

  public Boolean getNightStream()
  {
    return nightStream;
  }

  public void setNightStream(Boolean nightStream)
  {
    this.nightStream = nightStream;
  }

  public Boolean getUnderfloor()
  {
    return underfloor;
  }

  public void setUnderfloor(Boolean underfloor)
  {
    this.underfloor = underfloor;
  }

  public Boolean getIsExclusive()
  {
    return isExclusive;
  }

  public void setIsExclusive(Boolean isExclusive)
  {
    this.isExclusive = isExclusive;
  }

  public Boolean getLuxury()
  {
    return luxury;
  }

  public void setLuxury(Boolean luxury)
  {
    this.luxury = luxury;
  }

  public Boolean getNoKoinoxrista()
  {
    return noKoinoxrista;
  }

  public void setNoKoinoxrista(Boolean noKoinoxrista)
  {
    this.noKoinoxrista = noKoinoxrista;
  }

  public Boolean getListed()
  {
    return listed;
  }

  public void setListed(Boolean listed)
  {
    this.listed = listed;
  }

  public Boolean getInvestment()
  {
    return investment;
  }

  public void setInvestment(Boolean investment)
  {
    this.investment = investment;
  }

  public Boolean getFrontaged()
  {
    return frontaged;
  }

  public void setFrontaged(Boolean frontaged)
  {
    this.frontaged = frontaged;
  }

  public Boolean getInterior()
  {
    return interior;
  }

  public void setInterior(Boolean interior)
  {
    this.interior = interior;
  }

  public Boolean getSieves()
  {
    return sieves;
  }

  public void setSieves(Boolean sieves)
  {
    this.sieves = sieves;
  }

  public Integer getRenovationYear()
  {
    return renovationYear;
  }

  public void setRenovationYear(Integer renovationYear)
  {
    this.renovationYear = renovationYear;
  }

  public String getPostalCode()
  {
    return postalCode;
  }

  public void setPostalCode(String postalCode)
  {
    this.postalCode = postalCode;
  }

  public Boolean getTraditional()
  {
    return traditional;
  }

  public void setTraditional(Boolean traditional)
  {
    this.traditional = traditional;
  }

  public Boolean getMansion()
  {
    return mansion;
  }

  public void setMansion(Boolean mansion)
  {
    this.mansion = mansion;
  }

  public Boolean getAiry()
  {
    return airy;
  }

  public void setAiry(Boolean airy)
  {
    this.airy = airy;
  }

  public Boolean getOnHighway()
  {
    return onHighway;
  }

  public void setOnHighway(Boolean onHighway)
  {
    this.onHighway = onHighway;
  }

  public Boolean getPainted()
  {
    return painted;
  }

  public void setPainted(Boolean painted)
  {
    this.painted = painted;
  }

  public BigDecimal getHmiypaithriosSQR()
  {
    return hmiypaithriosSQR;
  }

  public void setHmiypaithriosSQR(BigDecimal hmiypaithriosSQR)
  {
    this.hmiypaithriosSQR = hmiypaithriosSQR;
  }

  public Boolean getHmiypaithriosLegal()
  {
    return hmiypaithriosLegal;
  }

  public void setHmiypaithriosLegal(Boolean hmiypaithriosLegal)
  {
    this.hmiypaithriosLegal = hmiypaithriosLegal;
  }

  public Integer getLivingRooms()
  {
    return livingRooms;
  }

  public void setLivingRooms(Integer livingRooms)
  {
    this.livingRooms = livingRooms;
  }

  public Double getBalconyArea()
  {
    return balconyArea;
  }

  public void setBalconyArea(Double balconyArea)
  {
    this.balconyArea = balconyArea;
  }

  public Double getRooftopPrivate()
  {
    return rooftopPrivate;
  }

  public void setRooftopPrivate(Double rooftopPrivate)
  {
    this.rooftopPrivate = rooftopPrivate;
  }

  public BigDecimal getMaintenanceCharges()
  {
    return maintenanceCharges;
  }

  public void setMaintenanceCharges(BigDecimal maintenanceCharges)
  {
    this.maintenanceCharges = maintenanceCharges;
  }

  public Boolean getTripleGlasses()
  {
    return tripleGlasses;
  }

  public void setTripleGlasses(Boolean tripleGlasses)
  {
    this.tripleGlasses = tripleGlasses;
  }

  public Boolean getJacuzzi()
  {
    return jacuzzi;
  }

  public void setJacuzzi(Boolean jacuzzi)
  {
    this.jacuzzi = jacuzzi;
  }

  public Boolean getCableTV()
  {
    return cableTV;
  }

  public void setCableTV(Boolean cableTV)
  {
    this.cableTV = cableTV;
  }

  public Boolean getProfessionalUse()
  {
    return professionalUse;
  }

  public void setProfessionalUse(Boolean professionalUse)
  {
    this.professionalUse = professionalUse;
  }

  public Calendar getAvailableAtDate()
  {
    return availableAtDate;
  }

  public void setAvailableAtDate(Calendar availableAtDate)
  {
    this.availableAtDate = availableAtDate;
  }

  public String getOnlineOwner()
  {
    return onlineOwner;
  }

  public void setOnlineOwner(String onlineOwner)
  {
    this.onlineOwner = onlineOwner;
  }

  public String getOnlineOwnerEmail()
  {
    return onlineOwnerEmail;
  }

  public void setOnlineOwnerEmail(String onlineOwnerEmail)
  {
    this.onlineOwnerEmail = onlineOwnerEmail;
  }

  public String getOnlineOwnerPhone()
  {
    return onlineOwnerPhone;
  }

  public void setOnlineOwnerPhone(String onlineOwnerPhone)
  {
    this.onlineOwnerPhone = onlineOwnerPhone;
  }

  public String getPhoto1()
  {
    return photo1;
  }

  public void setPhoto1(String photo1)
  {
    this.photo1 = photo1;
  }

  public String getPhoto2()
  {
    return photo2;
  }

  public void setPhoto2(String photo2)
  {
    this.photo2 = photo2;
  }

  public String getPhoto3()
  {
    return photo3;
  }

  public void setPhoto3(String photo3)
  {
    this.photo3 = photo3;
  }

  public String getPhoto4()
  {
    return photo4;
  }

  public void setPhoto4(String photo4)
  {
    this.photo4 = photo4;
  }

  public String getPhoto5()
  {
    return photo5;
  }

  public void setPhoto5(String photo5)
  {
    this.photo5 = photo5;
  }

  public String getPhoto6()
  {
    return photo6;
  }

  public void setPhoto6(String photo6)
  {
    this.photo6 = photo6;
  }

  public String getPhoto7()
  {
    return photo7;
  }

  public void setPhoto7(String photo7)
  {
    this.photo7 = photo7;
  }

  public String getPhoto8()
  {
    return photo8;
  }

  public void setPhoto8(String photo8)
  {
    this.photo8 = photo8;
  }

  public String getPhoto9()
  {
    return photo9;
  }

  public void setPhoto9(String photo9)
  {
    this.photo9 = photo9;
  }

  public String getPhoto10()
  {
    return photo10;
  }

  public void setPhoto10(String photo10)
  {
    this.photo10 = photo10;
  }

  public String getPhoto11()
  {
    return photo11;
  }

  public void setPhoto11(String photo11)
  {
    this.photo11 = photo11;
  }

  public String getPhoto12()
  {
    return photo12;
  }

  public void setPhoto12(String photo12)
  {
    this.photo12 = photo12;
  }

  public String getPhoto13()
  {
    return photo13;
  }

  public void setPhoto13(String photo13)
  {
    this.photo13 = photo13;
  }

  public String getPhoto14()
  {
    return photo14;
  }

  public void setPhoto14(String photo14)
  {
    this.photo14 = photo14;
  }

  public String getPhoto15()
  {
    return photo15;
  }

  public void setPhoto15(String photo15)
  {
    this.photo15 = photo15;
  }

  public String getPhoto16()
  {
    return photo16;
  }

  public void setPhoto16(String photo16)
  {
    this.photo16 = photo16;
  }

  public String getPhoto17()
  {
    return photo17;
  }

  public void setPhoto17(String photo17)
  {
    this.photo17 = photo17;
  }

  public String getPhoto18()
  {
    return photo18;
  }

  public void setPhoto18(String photo18)
  {
    this.photo18 = photo18;
  }

  public String getPhoto19()
  {
    return photo19;
  }

  public void setPhoto19(String photo19)
  {
    this.photo19 = photo19;
  }

  public String getPhoto20()
  {
    return photo20;
  }

  public void setPhoto20(String photo20)
  {
    this.photo20 = photo20;
  }

  public String getPhoto21()
  {
    return photo21;
  }

  public void setPhoto21(String photo21)
  {
    this.photo21 = photo21;
  }

  public String getPhoto22()
  {
    return photo22;
  }

  public void setPhoto22(String photo22)
  {
    this.photo22 = photo22;
  }

  public String getPhoto23()
  {
    return photo23;
  }

  public void setPhoto23(String photo23)
  {
    this.photo23 = photo23;
  }

  public String getPhoto24()
  {
    return photo24;
  }

  public void setPhoto24(String photo24)
  {
    this.photo24 = photo24;
  }

  public String getPhoto25()
  {
    return photo25;
  }

  public void setPhoto25(String photo25)
  {
    this.photo25 = photo25;
  }

}
