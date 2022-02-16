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
  protected String agencyKey;
  @XmlElement(name = "AgencyEmail", required = true)
  protected String agencyEmail;
  @XmlElement(name = "AgencyPhone")
  protected String agencyPhone;
  @XmlElement(name = "ID")
  protected int id;
  @XmlElement(name = "MLS_Code")
  protected String mlsCode;
  @XmlElement(name = "Status")
  protected int status;
  @XmlElement(name = "SendDate", required = true)
  protected Calendar sendDate;
  @XmlElement(name = "UpdateDate")
  protected Calendar updateDate;
  protected boolean isSync;
  @XmlElement(name = "OwnerID")
  protected int ownerID;
  @XmlElement(name = "OwnerName", required = true)
  protected String ownerName;
  @XmlElement(name = "RealtorID")
  protected int realtorID;
  @XmlElement(name = "RealtorName", required = true)
  protected String realtorName;
  @XmlElement(name = "Office")
  protected String office;
  @XmlElement(name = "Title_GR", required = true)
  protected String titleGR;
  @XmlElement(name = "Title_EN", required = true)
  protected String titleEN;
  @XmlElement(name = "Description_GR", required = true)
  protected String descriptionGR;
  @XmlElement(name = "Description_EN", required = true)
  protected String descriptionEN;
  @XmlElement(name = "HtmlDescriptionBig_GR", required = true)
  protected String htmlDescriptionBigGR;
  @XmlElement(name = "HtmlDescriptionBig_EN", required = true)
  protected String htmlDescriptionBigEN;
  @XmlElement(name = "Aim_ID")
  protected int aimID;
  @XmlElement(name = "Aim_GR")
  protected String aimGR;
  @XmlElement(name = "Aim_EN")
  protected String aimEN;
  @XmlElement(name = "EstateCategory_ID")
  protected int estateCategoryID;
  @XmlElement(name = "EstateCategory_GR")
  protected String estateCategoryGR;
  @XmlElement(name = "EstateCategory_EN")
  protected String estateCategoryEN;
  @XmlElement(name = "EstateSubCategory_ID")
  protected Integer estateSubCategoryID;
  @XmlElement(name = "EstateSubCategory_GR")
  protected String estateSubCategoryGR;
  @XmlElement(name = "EstateSubCategory_EN")
  protected String estateSubCategoryEN;
  @XmlElement(name = "Price")
  protected BigDecimal price;
  @XmlElement(name = "Currency", required = true)
  protected String currency;
  @XmlElement(name = "SqrMeters")
  protected double sqrMeters;
  @XmlElement(name = "PlotSqr")
  protected Double plotSqr;
  @XmlElement(name = "PricePerSqr")
  protected BigDecimal pricePerSqr;
  @XmlElement(name = "SubArea_ID")
  protected Integer subAreaID;
  @XmlElement(name = "SubArea_GR")
  protected String subAreaGR;
  @XmlElement(name = "SubArea_EN")
  protected String subAreaEN;
  @XmlElement(name = "Area_ID")
  protected int areaID;
  @XmlElement(name = "Area_GR")
  protected String areaGR;
  @XmlElement(name = "Area_EN")
  protected String areaEN;
  @XmlElement(name = "Prefecture_ID")
  protected int prefectureID;
  @XmlElement(name = "Prefecture_GR")
  protected String prefectureGR;
  @XmlElement(name = "Prefecture_EN")
  protected String prefectureEN;
  @XmlElement(name = "Region_ID")
  protected int regionID;
  @XmlElement(name = "Region_GR")
  protected String regionGR;
  @XmlElement(name = "Region_EN")
  protected String regionEN;
  @XmlElement(name = "Country_ID")
  protected int countryID;
  @XmlElement(name = "Country_GR")
  protected String countryGR;
  @XmlElement(name = "Country_EN")
  protected String countryEN;
  @XmlElement(name = "EstateStatus_ID")
  protected Integer estateStatusID;
  @XmlElement(name = "EstateStatus_GR")
  protected String estateStatusGR;
  @XmlElement(name = "EstateStatus_EN")
  protected String estateStatusEN;
  @XmlElement(name = "ConstuctYear")
  protected Integer constuctYear;
  @XmlElement(name = "Floor_ID")
  protected Integer floorID;
  @XmlElement(name = "Floor_GR")
  protected String floorGR;
  @XmlElement(name = "Floor_EN")
  protected String floorEN;
  @XmlElement(name = "Levels")
  protected Integer levels;
  @XmlElement(name = "Rooms")
  protected Integer rooms;
  @XmlElement(name = "BedRooms")
  protected Integer bedRooms;
  @XmlElement(name = "WC")
  protected Integer wc;
  @XmlElement(name = "Parkings")
  protected Integer parkings;
  @XmlElement(name = "View_ID")
  protected Integer viewID;
  @XmlElement(name = "View_GR")
  protected String viewGR;
  @XmlElement(name = "View_EN")
  protected String viewEN;
  @XmlElement(name = "StorageRoom")
  protected Boolean storageRoom;
  @XmlElement(name = "Balcony")
  protected Boolean balcony;
  @XmlElement(name = "HeatSystem_ID")
  protected Integer heatSystemID;
  @XmlElement(name = "HeatSystem_GR")
  protected String heatSystemGR;
  @XmlElement(name = "HeatSystem_EN")
  protected String heatSystemEN;
  @XmlElement(name = "AirCondition")
  protected Boolean airCondition;
  @XmlElement(name = "SecureDoor")
  protected Boolean secureDoor;
  @XmlElement(name = "Alarm")
  protected Boolean alarm;
  @XmlElement(name = "InnerStairs")
  protected Boolean innerStairs;
  @XmlElement(name = "Penthouse")
  protected Boolean penthouse;
  @XmlElement(name = "Corner")
  protected Boolean corner;
  @XmlElement(name = "NearTo")
  protected String nearTo;
  @XmlElement(name = "DistanceVilage")
  protected Integer distanceVilage;
  @XmlElement(name = "DistanceTown")
  protected Integer distanceTown;
  @XmlElement(name = "DistanceSea")
  protected Integer distanceSea;
  @XmlElement(name = "DistanceAirport")
  protected Integer distanceAirport;
  @XmlElement(name = "StreetAccess_ID")
  protected Integer streetAccessID;
  @XmlElement(name = "StreetAccess_GR")
  protected String streetAccessGR;
  @XmlElement(name = "StreetAccess_EN")
  protected String streetAccessEN;
  @XmlElement(name = "ObjectivePrice")
  protected BigDecimal objectivePrice;
  @XmlElement(name = "LegalResearch")
  protected Boolean legalResearch;
  @XmlElement(name = "Mortgage")
  protected Boolean mortgage;
  @XmlElement(name = "NewBuild")
  protected Boolean newBuild;
  @XmlElement(name = "InternetLine")
  protected Boolean internetLine;
  @XmlElement(name = "Bathrooms")
  protected Integer bathrooms;
  @XmlElement(name = "Kitchens")
  protected Integer kitchens;
  @XmlElement(name = "Fireplaces")
  protected Integer fireplaces;
  @XmlElement(name = "Pool")
  protected Boolean pool;
  @XmlElement(name = "BBQ")
  protected Boolean bbq;
  @XmlElement(name = "Elevator")
  protected Boolean elevator;
  @XmlElement(name = "Satelite")
  protected Boolean satelite;
  @XmlElement(name = "ReBuild")
  protected Boolean reBuild;
  @XmlElement(name = "SolarSystem")
  protected Boolean solarSystem;
  @XmlElement(name = "CCTV")
  protected Boolean cctv;
  @XmlElement(name = "Playroom")
  protected Boolean playroom;
  @XmlElement(name = "Garden")
  protected Boolean garden;
  @XmlElement(name = "Loft")
  protected Boolean loft;
  @XmlElement(name = "PetsAllow")
  protected Boolean petsAllow;
  @XmlElement(name = "RuralResidence")
  protected Boolean ruralResidence;
  @XmlElement(name = "Furnishing")
  protected Boolean furnishing;
  @XmlElement(name = "Safe")
  protected Boolean safe;
  @XmlElement(name = "Stadium")
  protected Boolean stadium;
  @XmlElement(name = "AutoWatering")
  protected Boolean autoWatering;
  @XmlElement(name = "Grass")
  protected Boolean grass;
  @XmlElement(name = "Trees")
  protected Boolean trees;
  @XmlElement(name = "DoubleGlasses")
  protected Boolean doubleGlasses;
  @XmlElement(name = "SD")
  protected Double sd;
  @XmlElement(name = "SK")
  protected Double sk;
  @XmlElement(name = "LayoutSqr")
  protected Double layoutSqr;
  @XmlElement(name = "LayoutLeft")
  protected Double layoutLeft;
  @XmlElement(name = "ForDevelopment")
  protected Boolean forDevelopment;
  @XmlElement(name = "Fenced")
  protected Boolean fenced;
  @XmlElement(name = "Amphitheatrical")
  protected Boolean amphitheatrical;
  @XmlElement(name = "Borehole")
  protected Boolean borehole;
  @XmlElement(name = "Frontage")
  protected Double frontage;
  @XmlElement(name = "Depth")
  protected Double depth;
  @XmlElement(name = "AOT")
  protected String aot;
  @XmlElement(name = "LandUsage_ID")
  protected Integer landUsageID;
  @XmlElement(name = "LandUsage_GR")
  protected String landUsageGR;
  @XmlElement(name = "LandUsage_EN")
  protected String landUsageEN;
  @XmlElement(name = "CityPlan_ID")
  protected Integer cityPlanID;
  @XmlElement(name = "CityPlan_GR")
  protected String cityPlanGR;
  @XmlElement(name = "CityPlan_EN")
  protected String cityPlanEN;
  @XmlElement(name = "RetrospectionFloors")
  protected Integer retrospectionFloors;
  @XmlElement(name = "RetrospectionSqrMeters")
  protected Double retrospectionSqrMeters;
  @XmlElement(name = "Shops")
  protected Integer shops;
  @XmlElement(name = "Undergrounds")
  protected Integer undergrounds;
  @XmlElement(name = "Ramps")
  protected Boolean ramps;
  @XmlElement(name = "LiftOfCharges")
  protected Boolean liftOfCharges;
  @XmlElement(name = "UsageType")
  protected String usageType;
  @XmlElement(name = "ShopWindowSqr")
  protected Double shopWindowSqr;
  @XmlElement(name = "LoftSqr")
  protected Double loftSqr;
  @XmlElement(name = "UndergroundSqr")
  protected Double undergroundSqr;
  @XmlElement(name = "FakeRoof")
  protected Boolean fakeRoof;
  @XmlElement(name = "PortalID")
  protected int portalID;
  @XmlElement(name = "ProducerID")
  protected Integer producerID;
  @XmlElement(name = "Latidude")
  protected Double latidude;
  @XmlElement(name = "Longitude")
  protected Double longitude;
  @XmlElement(name = "Tents")
  protected Boolean tents;
  @XmlElement(name = "Boiler")
  protected Boolean boiler;
  @XmlElement(name = "FloorType_ID")
  protected Integer floorTypeID;
  @XmlElement(name = "Koufomata_ID")
  protected Integer koufomataID;
  @XmlElement(name = "YouTubeVideo")
  protected String youTubeVideo;
  @XmlElement(name = "ForStudents")
  protected Boolean forStudents;
  @XmlElement(name = "Diamperes")
  protected Boolean diamperes;
  @XmlElement(name = "Prosopseos")
  protected Boolean prosopseos;
  @XmlElement(name = "NearToTransport")
  protected Boolean nearToTransport;
  @XmlElement(name = "NearToBus")
  protected Boolean nearToBus;
  @XmlElement(name = "NearToMetro")
  protected Boolean nearToMetro;
  @XmlElement(name = "NearToTrain")
  protected Boolean nearToTrain;
  @XmlElement(name = "NearToTram")
  protected Boolean nearToTram;
  @XmlElement(name = "MasterBedrooms")
  protected Integer masterBedrooms;
  @XmlElement(name = "Stonehouse")
  protected Boolean stonehouse;
  @XmlElement(name = "Neoclassical")
  protected Boolean neoclassical;
  @XmlElement(name = "HeatMedium_ID")
  protected Integer heatMediumID;
  @XmlElement(name = "HeatMedium_GR")
  protected String heatMediumGR;
  @XmlElement(name = "HeatMedium_EN")
  protected String heatMediumEN;
  @XmlElement(name = "HeatType_ID")
  protected Integer heatTypeID;
  @XmlElement(name = "HeatType_GR")
  protected String heatTypeGR;
  @XmlElement(name = "HeatType_EN")
  protected String heatTypeEN;
  @XmlElement(name = "View360")
  protected String view360;
  @XmlElement(name = "Flag1")
  protected Boolean flag1;
  @XmlElement(name = "Flag2")
  protected Boolean flag2;
  @XmlElement(name = "Flag3")
  protected Boolean flag3;
  @XmlElement(name = "Flag4")
  protected Boolean flag4;
  @XmlElement(name = "EnergyCertificate")
  protected String energyCertificate;
  @XmlElement(name = "SpitogatosLevel2")
  protected Integer spitogatosLevel2;
  @XmlElement(name = "SpitogatosLevel3")
  protected Integer spitogatosLevel3;
  @XmlElement(name = "Orientation")
  protected String orientation;
  @XmlElement(name = "Bright")
  protected Boolean bright;
  @XmlElement(name = "NightStream")
  protected Boolean nightStream;
  @XmlElement(name = "Underfloor")
  protected Boolean underfloor;
  protected Boolean isExclusive;
  @XmlElement(name = "Luxury")
  protected Boolean luxury;
  @XmlElement(name = "NoKoinoxrista")
  protected Boolean noKoinoxrista;
  @XmlElement(name = "Listed")
  protected Boolean listed;
  @XmlElement(name = "Investment")
  protected Boolean investment;
  @XmlElement(name = "Frontaged")
  protected Boolean frontaged;
  @XmlElement(name = "Interior")
  protected Boolean interior;
  @XmlElement(name = "Sieves")
  protected Boolean sieves;
  @XmlElement(name = "RenovationYear")
  protected Integer renovationYear;
  @XmlElement(name = "PostalCode")
  protected String postalCode;
  @XmlElement(name = "Traditional")
  protected Boolean traditional;
  @XmlElement(name = "Mansion")
  protected Boolean mansion;
  @XmlElement(name = "Airy")
  protected Boolean airy;
  @XmlElement(name = "OnHighway")
  protected Boolean onHighway;
  @XmlElement(name = "Painted")
  protected Boolean painted;
  @XmlElement(name = "HmiypaithriosSQR")
  protected BigDecimal hmiypaithriosSQR;
  @XmlElement(name = "HmiypaithriosLegal")
  protected Boolean hmiypaithriosLegal;
  @XmlElement(name = "LivingRooms")
  protected Integer livingRooms;
  @XmlElement(name = "BalconyArea")
  protected Double balconyArea;
  @XmlElement(name = "RooftopPrivate")
  protected Double rooftopPrivate;
  @XmlElement(name = "MaintenanceCharges")
  protected BigDecimal maintenanceCharges;
  @XmlElement(name = "TripleGlasses")
  protected Boolean tripleGlasses;
  @XmlElement(name = "Jacuzzi")
  protected Boolean jacuzzi;
  @XmlElement(name = "CableTV")
  protected Boolean cableTV;
  @XmlElement(name = "ProfessionalUse")
  protected Boolean professionalUse;
  @XmlElement(name = "AvailableAtDate")
  protected Calendar availableAtDate;
  @XmlElement(name = "OnlineOwner")
  protected String onlineOwner;
  @XmlElement(name = "OnlineOwnerEmail")
  protected String onlineOwnerEmail;
  @XmlElement(name = "OnlineOwnerPhone")
  protected String onlineOwnerPhone;
  @XmlElement(name = "Photo1")
  protected String photo1;
  @XmlElement(name = "Photo2")
  protected String photo2;
  @XmlElement(name = "Photo3")
  protected String photo3;
  @XmlElement(name = "Photo4")
  protected String photo4;
  @XmlElement(name = "Photo5")
  protected String photo5;
  @XmlElement(name = "Photo6")
  protected String photo6;
  @XmlElement(name = "Photo7")
  protected String photo7;
  @XmlElement(name = "Photo8")
  protected String photo8;
  @XmlElement(name = "Photo9")
  protected String photo9;
  @XmlElement(name = "Photo10")
  protected String photo10;
  @XmlElement(name = "Photo11")
  protected String photo11;
  @XmlElement(name = "Photo12")
  protected String photo12;
  @XmlElement(name = "Photo13")
  protected String photo13;
  @XmlElement(name = "Photo14")
  protected String photo14;
  @XmlElement(name = "Photo15")
  protected String photo15;
  @XmlElement(name = "Photo16")
  protected String photo16;
  @XmlElement(name = "Photo17")
  protected String photo17;
  @XmlElement(name = "Photo18")
  protected String photo18;
  @XmlElement(name = "Photo19")
  protected String photo19;
  @XmlElement(name = "Photo20")
  protected String photo20;
  @XmlElement(name = "Photo21")
  protected String photo21;
  @XmlElement(name = "Photo22")
  protected String photo22;
  @XmlElement(name = "Photo23")
  protected String photo23;
  @XmlElement(name = "Photo24")
  protected String photo24;
  @XmlElement(name = "Photo25")
  protected String photo25;

  /**
   * Gets the value of the agencyKey property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAgencyKey()
  {
    return agencyKey;
  }

  /**
   * Sets the value of the agencyKey property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAgencyKey(String value)
  {
    this.agencyKey = value;
  }

  /**
   * Gets the value of the agencyEmail property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAgencyEmail()
  {
    return agencyEmail;
  }

  /**
   * Sets the value of the agencyEmail property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAgencyEmail(String value)
  {
    this.agencyEmail = value;
  }

  /**
   * Gets the value of the agencyPhone property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAgencyPhone()
  {
    return agencyPhone;
  }

  /**
   * Sets the value of the agencyPhone property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAgencyPhone(String value)
  {
    this.agencyPhone = value;
  }

  /**
   * Gets the value of the id property.
   *
   */
  public int getID()
  {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   */
  public void setID(int value)
  {
    this.id = value;
  }

  /**
   * Gets the value of the mlsCode property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getMLSCode()
  {
    return mlsCode;
  }

  /**
   * Sets the value of the mlsCode property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setMLSCode(String value)
  {
    this.mlsCode = value;
  }

  /**
   * Gets the value of the status property.
   *
   */
  public int getStatus()
  {
    return status;
  }

  /**
   * Sets the value of the status property.
   *
   */
  public void setStatus(int value)
  {
    this.status = value;
  }

  /**
   * Gets the value of the sendDate property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public Calendar getSendDate()
  {
    return sendDate;
  }

  /**
   * Sets the value of the sendDate property.
   *
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setSendDate(Calendar value)
  {
    this.sendDate = value;
  }

  /**
   * Gets the value of the updateDate property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public Calendar getUpdateDate()
  {
    return updateDate;
  }

  /**
   * Sets the value of the updateDate property.
   *
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setUpdateDate(Calendar value)
  {
    this.updateDate = value;
  }

  /**
   * Gets the value of the isSync property.
   *
   */
  public boolean isIsSync()
  {
    return isSync;
  }

  /**
   * Sets the value of the isSync property.
   *
   */
  public void setIsSync(boolean value)
  {
    this.isSync = value;
  }

  /**
   * Gets the value of the ownerID property.
   *
   */
  public int getOwnerID()
  {
    return ownerID;
  }

  /**
   * Sets the value of the ownerID property.
   *
   */
  public void setOwnerID(int value)
  {
    this.ownerID = value;
  }

  /**
   * Gets the value of the ownerName property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getOwnerName()
  {
    return ownerName;
  }

  /**
   * Sets the value of the ownerName property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setOwnerName(String value)
  {
    this.ownerName = value;
  }

  /**
   * Gets the value of the realtorID property.
   *
   */
  public int getRealtorID()
  {
    return realtorID;
  }

  /**
   * Sets the value of the realtorID property.
   *
   */
  public void setRealtorID(int value)
  {
    this.realtorID = value;
  }

  /**
   * Gets the value of the realtorName property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getRealtorName()
  {
    return realtorName;
  }

  /**
   * Sets the value of the realtorName property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setRealtorName(String value)
  {
    this.realtorName = value;
  }

  /**
   * Gets the value of the office property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getOffice()
  {
    return office;
  }

  /**
   * Sets the value of the office property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setOffice(String value)
  {
    this.office = value;
  }

  /**
   * Gets the value of the titleGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getTitleGR()
  {
    return titleGR;
  }

  /**
   * Sets the value of the titleGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setTitleGR(String value)
  {
    this.titleGR = value;
  }

  /**
   * Gets the value of the titleEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getTitleEN()
  {
    return titleEN;
  }

  /**
   * Sets the value of the titleEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setTitleEN(String value)
  {
    this.titleEN = value;
  }

  /**
   * Gets the value of the descriptionGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getDescriptionGR()
  {
    return descriptionGR;
  }

  /**
   * Sets the value of the descriptionGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setDescriptionGR(String value)
  {
    this.descriptionGR = value;
  }

  /**
   * Gets the value of the descriptionEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getDescriptionEN()
  {
    return descriptionEN;
  }

  /**
   * Sets the value of the descriptionEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setDescriptionEN(String value)
  {
    this.descriptionEN = value;
  }

  /**
   * Gets the value of the htmlDescriptionBigGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getHtmlDescriptionBigGR()
  {
    return htmlDescriptionBigGR;
  }

  /**
   * Sets the value of the htmlDescriptionBigGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setHtmlDescriptionBigGR(String value)
  {
    this.htmlDescriptionBigGR = value;
  }

  /**
   * Gets the value of the htmlDescriptionBigEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getHtmlDescriptionBigEN()
  {
    return htmlDescriptionBigEN;
  }

  /**
   * Sets the value of the htmlDescriptionBigEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setHtmlDescriptionBigEN(String value)
  {
    this.htmlDescriptionBigEN = value;
  }

  /**
   * Gets the value of the aimID property.
   *
   */
  public int getAimID()
  {
    return aimID;
  }

  /**
   * Sets the value of the aimID property.
   *
   */
  public void setAimID(int value)
  {
    this.aimID = value;
  }

  /**
   * Gets the value of the aimGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAimGR()
  {
    return aimGR;
  }

  /**
   * Sets the value of the aimGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAimGR(String value)
  {
    this.aimGR = value;
  }

  /**
   * Gets the value of the aimEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAimEN()
  {
    return aimEN;
  }

  /**
   * Sets the value of the aimEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAimEN(String value)
  {
    this.aimEN = value;
  }

  /**
   * Gets the value of the estateCategoryID property.
   *
   */
  public int getEstateCategoryID()
  {
    return estateCategoryID;
  }

  /**
   * Sets the value of the estateCategoryID property.
   *
   */
  public void setEstateCategoryID(int value)
  {
    this.estateCategoryID = value;
  }

  /**
   * Gets the value of the estateCategoryGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getEstateCategoryGR()
  {
    return estateCategoryGR;
  }

  /**
   * Sets the value of the estateCategoryGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setEstateCategoryGR(String value)
  {
    this.estateCategoryGR = value;
  }

  /**
   * Gets the value of the estateCategoryEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getEstateCategoryEN()
  {
    return estateCategoryEN;
  }

  /**
   * Sets the value of the estateCategoryEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setEstateCategoryEN(String value)
  {
    this.estateCategoryEN = value;
  }

  /**
   * Gets the value of the estateSubCategoryID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getEstateSubCategoryID()
  {
    return estateSubCategoryID;
  }

  /**
   * Sets the value of the estateSubCategoryID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setEstateSubCategoryID(Integer value)
  {
    this.estateSubCategoryID = value;
  }

  /**
   * Gets the value of the estateSubCategoryGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getEstateSubCategoryGR()
  {
    return estateSubCategoryGR;
  }

  /**
   * Sets the value of the estateSubCategoryGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setEstateSubCategoryGR(String value)
  {
    this.estateSubCategoryGR = value;
  }

  /**
   * Gets the value of the estateSubCategoryEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getEstateSubCategoryEN()
  {
    return estateSubCategoryEN;
  }

  /**
   * Sets the value of the estateSubCategoryEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setEstateSubCategoryEN(String value)
  {
    this.estateSubCategoryEN = value;
  }

  /**
   * Gets the value of the price property.
   *
   * @return possible object is {@link BigDecimal }
   *
   */
  public BigDecimal getPrice()
  {
    return price;
  }

  /**
   * Sets the value of the price property.
   *
   * @param value allowed object is {@link BigDecimal }
   *
   */
  public void setPrice(BigDecimal value)
  {
    this.price = value;
  }

  /**
   * Gets the value of the currency property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getCurrency()
  {
    return currency;
  }

  /**
   * Sets the value of the currency property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setCurrency(String value)
  {
    this.currency = value;
  }

  /**
   * Gets the value of the sqrMeters property.
   *
   */
  public double getSqrMeters()
  {
    return sqrMeters;
  }

  /**
   * Sets the value of the sqrMeters property.
   *
   */
  public void setSqrMeters(double value)
  {
    this.sqrMeters = value;
  }

  /**
   * Gets the value of the plotSqr property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getPlotSqr()
  {
    return plotSqr;
  }

  /**
   * Sets the value of the plotSqr property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setPlotSqr(Double value)
  {
    this.plotSqr = value;
  }

  /**
   * Gets the value of the pricePerSqr property.
   *
   * @return possible object is {@link BigDecimal }
   *
   */
  public BigDecimal getPricePerSqr()
  {
    return pricePerSqr;
  }

  /**
   * Sets the value of the pricePerSqr property.
   *
   * @param value allowed object is {@link BigDecimal }
   *
   */
  public void setPricePerSqr(BigDecimal value)
  {
    this.pricePerSqr = value;
  }

  /**
   * Gets the value of the subAreaID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getSubAreaID()
  {
    return subAreaID;
  }

  /**
   * Sets the value of the subAreaID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setSubAreaID(Integer value)
  {
    this.subAreaID = value;
  }

  /**
   * Gets the value of the subAreaGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getSubAreaGR()
  {
    return subAreaGR;
  }

  /**
   * Sets the value of the subAreaGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setSubAreaGR(String value)
  {
    this.subAreaGR = value;
  }

  /**
   * Gets the value of the subAreaEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getSubAreaEN()
  {
    return subAreaEN;
  }

  /**
   * Sets the value of the subAreaEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setSubAreaEN(String value)
  {
    this.subAreaEN = value;
  }

  /**
   * Gets the value of the areaID property.
   *
   */
  public int getAreaID()
  {
    return areaID;
  }

  /**
   * Sets the value of the areaID property.
   *
   */
  public void setAreaID(int value)
  {
    this.areaID = value;
  }

  /**
   * Gets the value of the areaGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAreaGR()
  {
    return areaGR;
  }

  /**
   * Sets the value of the areaGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAreaGR(String value)
  {
    this.areaGR = value;
  }

  /**
   * Gets the value of the areaEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAreaEN()
  {
    return areaEN;
  }

  /**
   * Sets the value of the areaEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAreaEN(String value)
  {
    this.areaEN = value;
  }

  /**
   * Gets the value of the prefectureID property.
   *
   */
  public int getPrefectureID()
  {
    return prefectureID;
  }

  /**
   * Sets the value of the prefectureID property.
   *
   */
  public void setPrefectureID(int value)
  {
    this.prefectureID = value;
  }

  /**
   * Gets the value of the prefectureGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPrefectureGR()
  {
    return prefectureGR;
  }

  /**
   * Sets the value of the prefectureGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPrefectureGR(String value)
  {
    this.prefectureGR = value;
  }

  /**
   * Gets the value of the prefectureEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPrefectureEN()
  {
    return prefectureEN;
  }

  /**
   * Sets the value of the prefectureEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPrefectureEN(String value)
  {
    this.prefectureEN = value;
  }

  /**
   * Gets the value of the regionID property.
   *
   */
  public int getRegionID()
  {
    return regionID;
  }

  /**
   * Sets the value of the regionID property.
   *
   */
  public void setRegionID(int value)
  {
    this.regionID = value;
  }

  /**
   * Gets the value of the regionGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getRegionGR()
  {
    return regionGR;
  }

  /**
   * Sets the value of the regionGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setRegionGR(String value)
  {
    this.regionGR = value;
  }

  /**
   * Gets the value of the regionEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getRegionEN()
  {
    return regionEN;
  }

  /**
   * Sets the value of the regionEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setRegionEN(String value)
  {
    this.regionEN = value;
  }

  /**
   * Gets the value of the countryID property.
   *
   */
  public int getCountryID()
  {
    return countryID;
  }

  /**
   * Sets the value of the countryID property.
   *
   */
  public void setCountryID(int value)
  {
    this.countryID = value;
  }

  /**
   * Gets the value of the countryGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getCountryGR()
  {
    return countryGR;
  }

  /**
   * Sets the value of the countryGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setCountryGR(String value)
  {
    this.countryGR = value;
  }

  /**
   * Gets the value of the countryEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getCountryEN()
  {
    return countryEN;
  }

  /**
   * Sets the value of the countryEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setCountryEN(String value)
  {
    this.countryEN = value;
  }

  /**
   * Gets the value of the estateStatusID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getEstateStatusID()
  {
    return estateStatusID;
  }

  /**
   * Sets the value of the estateStatusID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setEstateStatusID(Integer value)
  {
    this.estateStatusID = value;
  }

  /**
   * Gets the value of the estateStatusGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getEstateStatusGR()
  {
    return estateStatusGR;
  }

  /**
   * Sets the value of the estateStatusGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setEstateStatusGR(String value)
  {
    this.estateStatusGR = value;
  }

  /**
   * Gets the value of the estateStatusEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getEstateStatusEN()
  {
    return estateStatusEN;
  }

  /**
   * Sets the value of the estateStatusEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setEstateStatusEN(String value)
  {
    this.estateStatusEN = value;
  }

  /**
   * Gets the value of the constuctYear property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getConstuctYear()
  {
    return constuctYear;
  }

  /**
   * Sets the value of the constuctYear property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setConstuctYear(Integer value)
  {
    this.constuctYear = value;
  }

  /**
   * Gets the value of the floorID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getFloorID()
  {
    return floorID;
  }

  /**
   * Sets the value of the floorID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setFloorID(Integer value)
  {
    this.floorID = value;
  }

  /**
   * Gets the value of the floorGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getFloorGR()
  {
    return floorGR;
  }

  /**
   * Sets the value of the floorGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setFloorGR(String value)
  {
    this.floorGR = value;
  }

  /**
   * Gets the value of the floorEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getFloorEN()
  {
    return floorEN;
  }

  /**
   * Sets the value of the floorEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setFloorEN(String value)
  {
    this.floorEN = value;
  }

  /**
   * Gets the value of the levels property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getLevels()
  {
    return levels;
  }

  /**
   * Sets the value of the levels property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setLevels(Integer value)
  {
    this.levels = value;
  }

  /**
   * Gets the value of the rooms property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getRooms()
  {
    return rooms;
  }

  /**
   * Sets the value of the rooms property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setRooms(Integer value)
  {
    this.rooms = value;
  }

  /**
   * Gets the value of the bedRooms property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getBedRooms()
  {
    return bedRooms;
  }

  /**
   * Sets the value of the bedRooms property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setBedRooms(Integer value)
  {
    this.bedRooms = value;
  }

  /**
   * Gets the value of the wc property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getWC()
  {
    return wc;
  }

  /**
   * Sets the value of the wc property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setWC(Integer value)
  {
    this.wc = value;
  }

  /**
   * Gets the value of the parkings property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getParkings()
  {
    return parkings;
  }

  /**
   * Sets the value of the parkings property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setParkings(Integer value)
  {
    this.parkings = value;
  }

  /**
   * Gets the value of the viewID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getViewID()
  {
    return viewID;
  }

  /**
   * Sets the value of the viewID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setViewID(Integer value)
  {
    this.viewID = value;
  }

  /**
   * Gets the value of the viewGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getViewGR()
  {
    return viewGR;
  }

  /**
   * Sets the value of the viewGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setViewGR(String value)
  {
    this.viewGR = value;
  }

  /**
   * Gets the value of the viewEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getViewEN()
  {
    return viewEN;
  }

  /**
   * Sets the value of the viewEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setViewEN(String value)
  {
    this.viewEN = value;
  }

  /**
   * Gets the value of the storageRoom property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isStorageRoom()
  {
    return storageRoom;
  }

  /**
   * Sets the value of the storageRoom property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setStorageRoom(Boolean value)
  {
    this.storageRoom = value;
  }

  /**
   * Gets the value of the balcony property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isBalcony()
  {
    return balcony;
  }

  /**
   * Sets the value of the balcony property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setBalcony(Boolean value)
  {
    this.balcony = value;
  }

  /**
   * Gets the value of the heatSystemID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getHeatSystemID()
  {
    return heatSystemID;
  }

  /**
   * Sets the value of the heatSystemID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setHeatSystemID(Integer value)
  {
    this.heatSystemID = value;
  }

  /**
   * Gets the value of the heatSystemGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getHeatSystemGR()
  {
    return heatSystemGR;
  }

  /**
   * Sets the value of the heatSystemGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setHeatSystemGR(String value)
  {
    this.heatSystemGR = value;
  }

  /**
   * Gets the value of the heatSystemEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getHeatSystemEN()
  {
    return heatSystemEN;
  }

  /**
   * Sets the value of the heatSystemEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setHeatSystemEN(String value)
  {
    this.heatSystemEN = value;
  }

  /**
   * Gets the value of the airCondition property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isAirCondition()
  {
    return airCondition;
  }

  /**
   * Sets the value of the airCondition property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setAirCondition(Boolean value)
  {
    this.airCondition = value;
  }

  /**
   * Gets the value of the secureDoor property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isSecureDoor()
  {
    return secureDoor;
  }

  /**
   * Sets the value of the secureDoor property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setSecureDoor(Boolean value)
  {
    this.secureDoor = value;
  }

  /**
   * Gets the value of the alarm property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isAlarm()
  {
    return alarm;
  }

  /**
   * Sets the value of the alarm property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setAlarm(Boolean value)
  {
    this.alarm = value;
  }

  /**
   * Gets the value of the innerStairs property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isInnerStairs()
  {
    return innerStairs;
  }

  /**
   * Sets the value of the innerStairs property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setInnerStairs(Boolean value)
  {
    this.innerStairs = value;
  }

  /**
   * Gets the value of the penthouse property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isPenthouse()
  {
    return penthouse;
  }

  /**
   * Sets the value of the penthouse property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setPenthouse(Boolean value)
  {
    this.penthouse = value;
  }

  /**
   * Gets the value of the corner property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isCorner()
  {
    return corner;
  }

  /**
   * Sets the value of the corner property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setCorner(Boolean value)
  {
    this.corner = value;
  }

  /**
   * Gets the value of the nearTo property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getNearTo()
  {
    return nearTo;
  }

  /**
   * Sets the value of the nearTo property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setNearTo(String value)
  {
    this.nearTo = value;
  }

  /**
   * Gets the value of the distanceVilage property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getDistanceVilage()
  {
    return distanceVilage;
  }

  /**
   * Sets the value of the distanceVilage property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setDistanceVilage(Integer value)
  {
    this.distanceVilage = value;
  }

  /**
   * Gets the value of the distanceTown property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getDistanceTown()
  {
    return distanceTown;
  }

  /**
   * Sets the value of the distanceTown property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setDistanceTown(Integer value)
  {
    this.distanceTown = value;
  }

  /**
   * Gets the value of the distanceSea property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getDistanceSea()
  {
    return distanceSea;
  }

  /**
   * Sets the value of the distanceSea property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setDistanceSea(Integer value)
  {
    this.distanceSea = value;
  }

  /**
   * Gets the value of the distanceAirport property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getDistanceAirport()
  {
    return distanceAirport;
  }

  /**
   * Sets the value of the distanceAirport property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setDistanceAirport(Integer value)
  {
    this.distanceAirport = value;
  }

  /**
   * Gets the value of the streetAccessID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getStreetAccessID()
  {
    return streetAccessID;
  }

  /**
   * Sets the value of the streetAccessID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setStreetAccessID(Integer value)
  {
    this.streetAccessID = value;
  }

  /**
   * Gets the value of the streetAccessGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getStreetAccessGR()
  {
    return streetAccessGR;
  }

  /**
   * Sets the value of the streetAccessGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setStreetAccessGR(String value)
  {
    this.streetAccessGR = value;
  }

  /**
   * Gets the value of the streetAccessEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getStreetAccessEN()
  {
    return streetAccessEN;
  }

  /**
   * Sets the value of the streetAccessEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setStreetAccessEN(String value)
  {
    this.streetAccessEN = value;
  }

  /**
   * Gets the value of the objectivePrice property.
   *
   * @return possible object is {@link BigDecimal }
   *
   */
  public BigDecimal getObjectivePrice()
  {
    return objectivePrice;
  }

  /**
   * Sets the value of the objectivePrice property.
   *
   * @param value allowed object is {@link BigDecimal }
   *
   */
  public void setObjectivePrice(BigDecimal value)
  {
    this.objectivePrice = value;
  }

  /**
   * Gets the value of the legalResearch property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isLegalResearch()
  {
    return legalResearch;
  }

  /**
   * Sets the value of the legalResearch property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setLegalResearch(Boolean value)
  {
    this.legalResearch = value;
  }

  /**
   * Gets the value of the mortgage property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isMortgage()
  {
    return mortgage;
  }

  /**
   * Sets the value of the mortgage property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setMortgage(Boolean value)
  {
    this.mortgage = value;
  }

  /**
   * Gets the value of the newBuild property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isNewBuild()
  {
    return newBuild;
  }

  /**
   * Sets the value of the newBuild property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setNewBuild(Boolean value)
  {
    this.newBuild = value;
  }

  /**
   * Gets the value of the internetLine property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isInternetLine()
  {
    return internetLine;
  }

  /**
   * Sets the value of the internetLine property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setInternetLine(Boolean value)
  {
    this.internetLine = value;
  }

  /**
   * Gets the value of the bathrooms property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getBathrooms()
  {
    return bathrooms;
  }

  /**
   * Sets the value of the bathrooms property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setBathrooms(Integer value)
  {
    this.bathrooms = value;
  }

  /**
   * Gets the value of the kitchens property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getKitchens()
  {
    return kitchens;
  }

  /**
   * Sets the value of the kitchens property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setKitchens(Integer value)
  {
    this.kitchens = value;
  }

  /**
   * Gets the value of the fireplaces property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getFireplaces()
  {
    return fireplaces;
  }

  /**
   * Sets the value of the fireplaces property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setFireplaces(Integer value)
  {
    this.fireplaces = value;
  }

  /**
   * Gets the value of the pool property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isPool()
  {
    return pool;
  }

  /**
   * Sets the value of the pool property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setPool(Boolean value)
  {
    this.pool = value;
  }

  /**
   * Gets the value of the bbq property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isBBQ()
  {
    return bbq;
  }

  /**
   * Sets the value of the bbq property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setBBQ(Boolean value)
  {
    this.bbq = value;
  }

  /**
   * Gets the value of the elevator property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isElevator()
  {
    return elevator;
  }

  /**
   * Sets the value of the elevator property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setElevator(Boolean value)
  {
    this.elevator = value;
  }

  /**
   * Gets the value of the satelite property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isSatelite()
  {
    return satelite;
  }

  /**
   * Sets the value of the satelite property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setSatelite(Boolean value)
  {
    this.satelite = value;
  }

  /**
   * Gets the value of the reBuild property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isReBuild()
  {
    return reBuild;
  }

  /**
   * Sets the value of the reBuild property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setReBuild(Boolean value)
  {
    this.reBuild = value;
  }

  /**
   * Gets the value of the solarSystem property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isSolarSystem()
  {
    return solarSystem;
  }

  /**
   * Sets the value of the solarSystem property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setSolarSystem(Boolean value)
  {
    this.solarSystem = value;
  }

  /**
   * Gets the value of the cctv property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isCCTV()
  {
    return cctv;
  }

  /**
   * Sets the value of the cctv property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setCCTV(Boolean value)
  {
    this.cctv = value;
  }

  /**
   * Gets the value of the playroom property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isPlayroom()
  {
    return playroom;
  }

  /**
   * Sets the value of the playroom property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setPlayroom(Boolean value)
  {
    this.playroom = value;
  }

  /**
   * Gets the value of the garden property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isGarden()
  {
    return garden;
  }

  /**
   * Sets the value of the garden property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setGarden(Boolean value)
  {
    this.garden = value;
  }

  /**
   * Gets the value of the loft property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isLoft()
  {
    return loft;
  }

  /**
   * Sets the value of the loft property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setLoft(Boolean value)
  {
    this.loft = value;
  }

  /**
   * Gets the value of the petsAllow property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isPetsAllow()
  {
    return petsAllow;
  }

  /**
   * Sets the value of the petsAllow property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setPetsAllow(Boolean value)
  {
    this.petsAllow = value;
  }

  /**
   * Gets the value of the ruralResidence property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isRuralResidence()
  {
    return ruralResidence;
  }

  /**
   * Sets the value of the ruralResidence property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setRuralResidence(Boolean value)
  {
    this.ruralResidence = value;
  }

  /**
   * Gets the value of the furnishing property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isFurnishing()
  {
    return furnishing;
  }

  /**
   * Sets the value of the furnishing property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setFurnishing(Boolean value)
  {
    this.furnishing = value;
  }

  /**
   * Gets the value of the safe property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isSafe()
  {
    return safe;
  }

  /**
   * Sets the value of the safe property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setSafe(Boolean value)
  {
    this.safe = value;
  }

  /**
   * Gets the value of the stadium property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isStadium()
  {
    return stadium;
  }

  /**
   * Sets the value of the stadium property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setStadium(Boolean value)
  {
    this.stadium = value;
  }

  /**
   * Gets the value of the autoWatering property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isAutoWatering()
  {
    return autoWatering;
  }

  /**
   * Sets the value of the autoWatering property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setAutoWatering(Boolean value)
  {
    this.autoWatering = value;
  }

  /**
   * Gets the value of the grass property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isGrass()
  {
    return grass;
  }

  /**
   * Sets the value of the grass property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setGrass(Boolean value)
  {
    this.grass = value;
  }

  /**
   * Gets the value of the trees property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isTrees()
  {
    return trees;
  }

  /**
   * Sets the value of the trees property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setTrees(Boolean value)
  {
    this.trees = value;
  }

  /**
   * Gets the value of the doubleGlasses property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isDoubleGlasses()
  {
    return doubleGlasses;
  }

  /**
   * Sets the value of the doubleGlasses property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setDoubleGlasses(Boolean value)
  {
    this.doubleGlasses = value;
  }

  /**
   * Gets the value of the sd property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getSD()
  {
    return sd;
  }

  /**
   * Sets the value of the sd property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setSD(Double value)
  {
    this.sd = value;
  }

  /**
   * Gets the value of the sk property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getSK()
  {
    return sk;
  }

  /**
   * Sets the value of the sk property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setSK(Double value)
  {
    this.sk = value;
  }

  /**
   * Gets the value of the layoutSqr property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getLayoutSqr()
  {
    return layoutSqr;
  }

  /**
   * Sets the value of the layoutSqr property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setLayoutSqr(Double value)
  {
    this.layoutSqr = value;
  }

  /**
   * Gets the value of the layoutLeft property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getLayoutLeft()
  {
    return layoutLeft;
  }

  /**
   * Sets the value of the layoutLeft property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setLayoutLeft(Double value)
  {
    this.layoutLeft = value;
  }

  /**
   * Gets the value of the forDevelopment property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isForDevelopment()
  {
    return forDevelopment;
  }

  /**
   * Sets the value of the forDevelopment property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setForDevelopment(Boolean value)
  {
    this.forDevelopment = value;
  }

  /**
   * Gets the value of the fenced property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isFenced()
  {
    return fenced;
  }

  /**
   * Sets the value of the fenced property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setFenced(Boolean value)
  {
    this.fenced = value;
  }

  /**
   * Gets the value of the amphitheatrical property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isAmphitheatrical()
  {
    return amphitheatrical;
  }

  /**
   * Sets the value of the amphitheatrical property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setAmphitheatrical(Boolean value)
  {
    this.amphitheatrical = value;
  }

  /**
   * Gets the value of the borehole property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isBorehole()
  {
    return borehole;
  }

  /**
   * Sets the value of the borehole property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setBorehole(Boolean value)
  {
    this.borehole = value;
  }

  /**
   * Gets the value of the frontage property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getFrontage()
  {
    return frontage;
  }

  /**
   * Sets the value of the frontage property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setFrontage(Double value)
  {
    this.frontage = value;
  }

  /**
   * Gets the value of the depth property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getDepth()
  {
    return depth;
  }

  /**
   * Sets the value of the depth property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setDepth(Double value)
  {
    this.depth = value;
  }

  /**
   * Gets the value of the aot property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getAOT()
  {
    return aot;
  }

  /**
   * Sets the value of the aot property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setAOT(String value)
  {
    this.aot = value;
  }

  /**
   * Gets the value of the landUsageID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getLandUsageID()
  {
    return landUsageID;
  }

  /**
   * Sets the value of the landUsageID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setLandUsageID(Integer value)
  {
    this.landUsageID = value;
  }

  /**
   * Gets the value of the landUsageGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getLandUsageGR()
  {
    return landUsageGR;
  }

  /**
   * Sets the value of the landUsageGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setLandUsageGR(String value)
  {
    this.landUsageGR = value;
  }

  /**
   * Gets the value of the landUsageEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getLandUsageEN()
  {
    return landUsageEN;
  }

  /**
   * Sets the value of the landUsageEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setLandUsageEN(String value)
  {
    this.landUsageEN = value;
  }

  /**
   * Gets the value of the cityPlanID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getCityPlanID()
  {
    return cityPlanID;
  }

  /**
   * Sets the value of the cityPlanID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setCityPlanID(Integer value)
  {
    this.cityPlanID = value;
  }

  /**
   * Gets the value of the cityPlanGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getCityPlanGR()
  {
    return cityPlanGR;
  }

  /**
   * Sets the value of the cityPlanGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setCityPlanGR(String value)
  {
    this.cityPlanGR = value;
  }

  /**
   * Gets the value of the cityPlanEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getCityPlanEN()
  {
    return cityPlanEN;
  }

  /**
   * Sets the value of the cityPlanEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setCityPlanEN(String value)
  {
    this.cityPlanEN = value;
  }

  /**
   * Gets the value of the retrospectionFloors property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getRetrospectionFloors()
  {
    return retrospectionFloors;
  }

  /**
   * Sets the value of the retrospectionFloors property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setRetrospectionFloors(Integer value)
  {
    this.retrospectionFloors = value;
  }

  /**
   * Gets the value of the retrospectionSqrMeters property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getRetrospectionSqrMeters()
  {
    return retrospectionSqrMeters;
  }

  /**
   * Sets the value of the retrospectionSqrMeters property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setRetrospectionSqrMeters(Double value)
  {
    this.retrospectionSqrMeters = value;
  }

  /**
   * Gets the value of the shops property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getShops()
  {
    return shops;
  }

  /**
   * Sets the value of the shops property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setShops(Integer value)
  {
    this.shops = value;
  }

  /**
   * Gets the value of the undergrounds property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getUndergrounds()
  {
    return undergrounds;
  }

  /**
   * Sets the value of the undergrounds property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setUndergrounds(Integer value)
  {
    this.undergrounds = value;
  }

  /**
   * Gets the value of the ramps property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isRamps()
  {
    return ramps;
  }

  /**
   * Sets the value of the ramps property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setRamps(Boolean value)
  {
    this.ramps = value;
  }

  /**
   * Gets the value of the liftOfCharges property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isLiftOfCharges()
  {
    return liftOfCharges;
  }

  /**
   * Sets the value of the liftOfCharges property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setLiftOfCharges(Boolean value)
  {
    this.liftOfCharges = value;
  }

  /**
   * Gets the value of the usageType property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getUsageType()
  {
    return usageType;
  }

  /**
   * Sets the value of the usageType property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setUsageType(String value)
  {
    this.usageType = value;
  }

  /**
   * Gets the value of the shopWindowSqr property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getShopWindowSqr()
  {
    return shopWindowSqr;
  }

  /**
   * Sets the value of the shopWindowSqr property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setShopWindowSqr(Double value)
  {
    this.shopWindowSqr = value;
  }

  /**
   * Gets the value of the loftSqr property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getLoftSqr()
  {
    return loftSqr;
  }

  /**
   * Sets the value of the loftSqr property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setLoftSqr(Double value)
  {
    this.loftSqr = value;
  }

  /**
   * Gets the value of the undergroundSqr property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getUndergroundSqr()
  {
    return undergroundSqr;
  }

  /**
   * Sets the value of the undergroundSqr property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setUndergroundSqr(Double value)
  {
    this.undergroundSqr = value;
  }

  /**
   * Gets the value of the fakeRoof property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isFakeRoof()
  {
    return fakeRoof;
  }

  /**
   * Sets the value of the fakeRoof property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setFakeRoof(Boolean value)
  {
    this.fakeRoof = value;
  }

  /**
   * Gets the value of the portalID property.
   *
   */
  public int getPortalID()
  {
    return portalID;
  }

  /**
   * Sets the value of the portalID property.
   *
   */
  public void setPortalID(int value)
  {
    this.portalID = value;
  }

  /**
   * Gets the value of the producerID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getProducerID()
  {
    return producerID;
  }

  /**
   * Sets the value of the producerID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setProducerID(Integer value)
  {
    this.producerID = value;
  }

  /**
   * Gets the value of the latidude property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getLatidude()
  {
    return latidude;
  }

  /**
   * Sets the value of the latidude property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setLatidude(Double value)
  {
    this.latidude = value;
  }

  /**
   * Gets the value of the longitude property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getLongitude()
  {
    return longitude;
  }

  /**
   * Sets the value of the longitude property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setLongitude(Double value)
  {
    this.longitude = value;
  }

  /**
   * Gets the value of the tents property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isTents()
  {
    return tents;
  }

  /**
   * Sets the value of the tents property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setTents(Boolean value)
  {
    this.tents = value;
  }

  /**
   * Gets the value of the boiler property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isBoiler()
  {
    return boiler;
  }

  /**
   * Sets the value of the boiler property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setBoiler(Boolean value)
  {
    this.boiler = value;
  }

  /**
   * Gets the value of the floorTypeID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getFloorTypeID()
  {
    return floorTypeID;
  }

  /**
   * Sets the value of the floorTypeID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setFloorTypeID(Integer value)
  {
    this.floorTypeID = value;
  }

  /**
   * Gets the value of the koufomataID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getKoufomataID()
  {
    return koufomataID;
  }

  /**
   * Sets the value of the koufomataID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setKoufomataID(Integer value)
  {
    this.koufomataID = value;
  }

  /**
   * Gets the value of the youTubeVideo property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getYouTubeVideo()
  {
    return youTubeVideo;
  }

  /**
   * Sets the value of the youTubeVideo property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setYouTubeVideo(String value)
  {
    this.youTubeVideo = value;
  }

  /**
   * Gets the value of the forStudents property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isForStudents()
  {
    return forStudents;
  }

  /**
   * Sets the value of the forStudents property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setForStudents(Boolean value)
  {
    this.forStudents = value;
  }

  /**
   * Gets the value of the diamperes property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isDiamperes()
  {
    return diamperes;
  }

  /**
   * Sets the value of the diamperes property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setDiamperes(Boolean value)
  {
    this.diamperes = value;
  }

  /**
   * Gets the value of the prosopseos property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isProsopseos()
  {
    return prosopseos;
  }

  /**
   * Sets the value of the prosopseos property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setProsopseos(Boolean value)
  {
    this.prosopseos = value;
  }

  /**
   * Gets the value of the nearToTransport property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isNearToTransport()
  {
    return nearToTransport;
  }

  /**
   * Sets the value of the nearToTransport property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setNearToTransport(Boolean value)
  {
    this.nearToTransport = value;
  }

  /**
   * Gets the value of the nearToBus property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isNearToBus()
  {
    return nearToBus;
  }

  /**
   * Sets the value of the nearToBus property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setNearToBus(Boolean value)
  {
    this.nearToBus = value;
  }

  /**
   * Gets the value of the nearToMetro property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isNearToMetro()
  {
    return nearToMetro;
  }

  /**
   * Sets the value of the nearToMetro property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setNearToMetro(Boolean value)
  {
    this.nearToMetro = value;
  }

  /**
   * Gets the value of the nearToTrain property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isNearToTrain()
  {
    return nearToTrain;
  }

  /**
   * Sets the value of the nearToTrain property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setNearToTrain(Boolean value)
  {
    this.nearToTrain = value;
  }

  /**
   * Gets the value of the nearToTram property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isNearToTram()
  {
    return nearToTram;
  }

  /**
   * Sets the value of the nearToTram property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setNearToTram(Boolean value)
  {
    this.nearToTram = value;
  }

  /**
   * Gets the value of the masterBedrooms property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getMasterBedrooms()
  {
    return masterBedrooms;
  }

  /**
   * Sets the value of the masterBedrooms property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setMasterBedrooms(Integer value)
  {
    this.masterBedrooms = value;
  }

  /**
   * Gets the value of the stonehouse property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isStonehouse()
  {
    return stonehouse;
  }

  /**
   * Sets the value of the stonehouse property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setStonehouse(Boolean value)
  {
    this.stonehouse = value;
  }

  /**
   * Gets the value of the neoclassical property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isNeoclassical()
  {
    return neoclassical;
  }

  /**
   * Sets the value of the neoclassical property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setNeoclassical(Boolean value)
  {
    this.neoclassical = value;
  }

  /**
   * Gets the value of the heatMediumID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getHeatMediumID()
  {
    return heatMediumID;
  }

  /**
   * Sets the value of the heatMediumID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setHeatMediumID(Integer value)
  {
    this.heatMediumID = value;
  }

  /**
   * Gets the value of the heatMediumGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getHeatMediumGR()
  {
    return heatMediumGR;
  }

  /**
   * Sets the value of the heatMediumGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setHeatMediumGR(String value)
  {
    this.heatMediumGR = value;
  }

  /**
   * Gets the value of the heatMediumEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getHeatMediumEN()
  {
    return heatMediumEN;
  }

  /**
   * Sets the value of the heatMediumEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setHeatMediumEN(String value)
  {
    this.heatMediumEN = value;
  }

  /**
   * Gets the value of the heatTypeID property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getHeatTypeID()
  {
    return heatTypeID;
  }

  /**
   * Sets the value of the heatTypeID property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setHeatTypeID(Integer value)
  {
    this.heatTypeID = value;
  }

  /**
   * Gets the value of the heatTypeGR property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getHeatTypeGR()
  {
    return heatTypeGR;
  }

  /**
   * Sets the value of the heatTypeGR property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setHeatTypeGR(String value)
  {
    this.heatTypeGR = value;
  }

  /**
   * Gets the value of the heatTypeEN property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getHeatTypeEN()
  {
    return heatTypeEN;
  }

  /**
   * Sets the value of the heatTypeEN property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setHeatTypeEN(String value)
  {
    this.heatTypeEN = value;
  }

  /**
   * Gets the value of the view360 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getView360()
  {
    return view360;
  }

  /**
   * Sets the value of the view360 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setView360(String value)
  {
    this.view360 = value;
  }

  /**
   * Gets the value of the flag1 property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isFlag1()
  {
    return flag1;
  }

  /**
   * Sets the value of the flag1 property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setFlag1(Boolean value)
  {
    this.flag1 = value;
  }

  /**
   * Gets the value of the flag2 property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isFlag2()
  {
    return flag2;
  }

  /**
   * Sets the value of the flag2 property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setFlag2(Boolean value)
  {
    this.flag2 = value;
  }

  /**
   * Gets the value of the flag3 property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isFlag3()
  {
    return flag3;
  }

  /**
   * Sets the value of the flag3 property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setFlag3(Boolean value)
  {
    this.flag3 = value;
  }

  /**
   * Gets the value of the flag4 property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isFlag4()
  {
    return flag4;
  }

  /**
   * Sets the value of the flag4 property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setFlag4(Boolean value)
  {
    this.flag4 = value;
  }

  /**
   * Gets the value of the energyCertificate property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getEnergyCertificate()
  {
    return energyCertificate;
  }

  /**
   * Sets the value of the energyCertificate property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setEnergyCertificate(String value)
  {
    this.energyCertificate = value;
  }

  /**
   * Gets the value of the spitogatosLevel2 property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getSpitogatosLevel2()
  {
    return spitogatosLevel2;
  }

  /**
   * Sets the value of the spitogatosLevel2 property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setSpitogatosLevel2(Integer value)
  {
    this.spitogatosLevel2 = value;
  }

  /**
   * Gets the value of the spitogatosLevel3 property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getSpitogatosLevel3()
  {
    return spitogatosLevel3;
  }

  /**
   * Sets the value of the spitogatosLevel3 property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setSpitogatosLevel3(Integer value)
  {
    this.spitogatosLevel3 = value;
  }

  /**
   * Gets the value of the orientation property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getOrientation()
  {
    return orientation;
  }

  /**
   * Sets the value of the orientation property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setOrientation(String value)
  {
    this.orientation = value;
  }

  /**
   * Gets the value of the bright property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isBright()
  {
    return bright;
  }

  /**
   * Sets the value of the bright property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setBright(Boolean value)
  {
    this.bright = value;
  }

  /**
   * Gets the value of the nightStream property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isNightStream()
  {
    return nightStream;
  }

  /**
   * Sets the value of the nightStream property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setNightStream(Boolean value)
  {
    this.nightStream = value;
  }

  /**
   * Gets the value of the underfloor property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isUnderfloor()
  {
    return underfloor;
  }

  /**
   * Sets the value of the underfloor property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setUnderfloor(Boolean value)
  {
    this.underfloor = value;
  }

  /**
   * Gets the value of the isExclusive property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isIsExclusive()
  {
    return isExclusive;
  }

  /**
   * Sets the value of the isExclusive property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setIsExclusive(Boolean value)
  {
    this.isExclusive = value;
  }

  /**
   * Gets the value of the luxury property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isLuxury()
  {
    return luxury;
  }

  /**
   * Sets the value of the luxury property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setLuxury(Boolean value)
  {
    this.luxury = value;
  }

  /**
   * Gets the value of the noKoinoxrista property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isNoKoinoxrista()
  {
    return noKoinoxrista;
  }

  /**
   * Sets the value of the noKoinoxrista property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setNoKoinoxrista(Boolean value)
  {
    this.noKoinoxrista = value;
  }

  /**
   * Gets the value of the listed property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isListed()
  {
    return listed;
  }

  /**
   * Sets the value of the listed property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setListed(Boolean value)
  {
    this.listed = value;
  }

  /**
   * Gets the value of the investment property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isInvestment()
  {
    return investment;
  }

  /**
   * Sets the value of the investment property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setInvestment(Boolean value)
  {
    this.investment = value;
  }

  /**
   * Gets the value of the frontaged property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isFrontaged()
  {
    return frontaged;
  }

  /**
   * Sets the value of the frontaged property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setFrontaged(Boolean value)
  {
    this.frontaged = value;
  }

  /**
   * Gets the value of the interior property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isInterior()
  {
    return interior;
  }

  /**
   * Sets the value of the interior property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setInterior(Boolean value)
  {
    this.interior = value;
  }

  /**
   * Gets the value of the sieves property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isSieves()
  {
    return sieves;
  }

  /**
   * Sets the value of the sieves property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setSieves(Boolean value)
  {
    this.sieves = value;
  }

  /**
   * Gets the value of the renovationYear property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getRenovationYear()
  {
    return renovationYear;
  }

  /**
   * Sets the value of the renovationYear property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setRenovationYear(Integer value)
  {
    this.renovationYear = value;
  }

  /**
   * Gets the value of the postalCode property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPostalCode()
  {
    return postalCode;
  }

  /**
   * Sets the value of the postalCode property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPostalCode(String value)
  {
    this.postalCode = value;
  }

  /**
   * Gets the value of the traditional property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isTraditional()
  {
    return traditional;
  }

  /**
   * Sets the value of the traditional property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setTraditional(Boolean value)
  {
    this.traditional = value;
  }

  /**
   * Gets the value of the mansion property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isMansion()
  {
    return mansion;
  }

  /**
   * Sets the value of the mansion property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setMansion(Boolean value)
  {
    this.mansion = value;
  }

  /**
   * Gets the value of the airy property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isAiry()
  {
    return airy;
  }

  /**
   * Sets the value of the airy property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setAiry(Boolean value)
  {
    this.airy = value;
  }

  /**
   * Gets the value of the onHighway property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isOnHighway()
  {
    return onHighway;
  }

  /**
   * Sets the value of the onHighway property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setOnHighway(Boolean value)
  {
    this.onHighway = value;
  }

  /**
   * Gets the value of the painted property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isPainted()
  {
    return painted;
  }

  /**
   * Sets the value of the painted property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setPainted(Boolean value)
  {
    this.painted = value;
  }

  /**
   * Gets the value of the hmiypaithriosSQR property.
   *
   * @return possible object is {@link BigDecimal }
   *
   */
  public BigDecimal getHmiypaithriosSQR()
  {
    return hmiypaithriosSQR;
  }

  /**
   * Sets the value of the hmiypaithriosSQR property.
   *
   * @param value allowed object is {@link BigDecimal }
   *
   */
  public void setHmiypaithriosSQR(BigDecimal value)
  {
    this.hmiypaithriosSQR = value;
  }

  /**
   * Gets the value of the hmiypaithriosLegal property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isHmiypaithriosLegal()
  {
    return hmiypaithriosLegal;
  }

  /**
   * Sets the value of the hmiypaithriosLegal property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setHmiypaithriosLegal(Boolean value)
  {
    this.hmiypaithriosLegal = value;
  }

  /**
   * Gets the value of the livingRooms property.
   *
   * @return possible object is {@link Integer }
   *
   */
  public Integer getLivingRooms()
  {
    return livingRooms;
  }

  /**
   * Sets the value of the livingRooms property.
   *
   * @param value allowed object is {@link Integer }
   *
   */
  public void setLivingRooms(Integer value)
  {
    this.livingRooms = value;
  }

  /**
   * Gets the value of the balconyArea property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getBalconyArea()
  {
    return balconyArea;
  }

  /**
   * Sets the value of the balconyArea property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setBalconyArea(Double value)
  {
    this.balconyArea = value;
  }

  /**
   * Gets the value of the rooftopPrivate property.
   *
   * @return possible object is {@link Double }
   *
   */
  public Double getRooftopPrivate()
  {
    return rooftopPrivate;
  }

  /**
   * Sets the value of the rooftopPrivate property.
   *
   * @param value allowed object is {@link Double }
   *
   */
  public void setRooftopPrivate(Double value)
  {
    this.rooftopPrivate = value;
  }

  /**
   * Gets the value of the maintenanceCharges property.
   *
   * @return possible object is {@link BigDecimal }
   *
   */
  public BigDecimal getMaintenanceCharges()
  {
    return maintenanceCharges;
  }

  /**
   * Sets the value of the maintenanceCharges property.
   *
   * @param value allowed object is {@link BigDecimal }
   *
   */
  public void setMaintenanceCharges(BigDecimal value)
  {
    this.maintenanceCharges = value;
  }

  /**
   * Gets the value of the tripleGlasses property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isTripleGlasses()
  {
    return tripleGlasses;
  }

  /**
   * Sets the value of the tripleGlasses property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setTripleGlasses(Boolean value)
  {
    this.tripleGlasses = value;
  }

  /**
   * Gets the value of the jacuzzi property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isJacuzzi()
  {
    return jacuzzi;
  }

  /**
   * Sets the value of the jacuzzi property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setJacuzzi(Boolean value)
  {
    this.jacuzzi = value;
  }

  /**
   * Gets the value of the cableTV property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isCableTV()
  {
    return cableTV;
  }

  /**
   * Sets the value of the cableTV property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setCableTV(Boolean value)
  {
    this.cableTV = value;
  }

  /**
   * Gets the value of the professionalUse property.
   *
   * @return possible object is {@link Boolean }
   *
   */
  public Boolean isProfessionalUse()
  {
    return professionalUse;
  }

  /**
   * Sets the value of the professionalUse property.
   *
   * @param value allowed object is {@link Boolean }
   *
   */
  public void setProfessionalUse(Boolean value)
  {
    this.professionalUse = value;
  }

  /**
   * Gets the value of the availableAtDate property.
   *
   * @return possible object is {@link XMLGregorianCalendar }
   *
   */
  public Calendar getAvailableAtDate()
  {
    return availableAtDate;
  }

  /**
   * Sets the value of the availableAtDate property.
   *
   * @param value allowed object is {@link XMLGregorianCalendar }
   *
   */
  public void setAvailableAtDate(Calendar value)
  {
    this.availableAtDate = value;
  }

  /**
   * Gets the value of the onlineOwner property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getOnlineOwner()
  {
    return onlineOwner;
  }

  /**
   * Sets the value of the onlineOwner property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setOnlineOwner(String value)
  {
    this.onlineOwner = value;
  }

  /**
   * Gets the value of the onlineOwnerEmail property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getOnlineOwnerEmail()
  {
    return onlineOwnerEmail;
  }

  /**
   * Sets the value of the onlineOwnerEmail property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setOnlineOwnerEmail(String value)
  {
    this.onlineOwnerEmail = value;
  }

  /**
   * Gets the value of the onlineOwnerPhone property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getOnlineOwnerPhone()
  {
    return onlineOwnerPhone;
  }

  /**
   * Sets the value of the onlineOwnerPhone property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setOnlineOwnerPhone(String value)
  {
    this.onlineOwnerPhone = value;
  }

  /**
   * Gets the value of the photo1 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto1()
  {
    return photo1;
  }

  /**
   * Sets the value of the photo1 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto1(String value)
  {
    this.photo1 = value;
  }

  /**
   * Gets the value of the photo2 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto2()
  {
    return photo2;
  }

  /**
   * Sets the value of the photo2 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto2(String value)
  {
    this.photo2 = value;
  }

  /**
   * Gets the value of the photo3 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto3()
  {
    return photo3;
  }

  /**
   * Sets the value of the photo3 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto3(String value)
  {
    this.photo3 = value;
  }

  /**
   * Gets the value of the photo4 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto4()
  {
    return photo4;
  }

  /**
   * Sets the value of the photo4 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto4(String value)
  {
    this.photo4 = value;
  }

  /**
   * Gets the value of the photo5 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto5()
  {
    return photo5;
  }

  /**
   * Sets the value of the photo5 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto5(String value)
  {
    this.photo5 = value;
  }

  /**
   * Gets the value of the photo6 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto6()
  {
    return photo6;
  }

  /**
   * Sets the value of the photo6 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto6(String value)
  {
    this.photo6 = value;
  }

  /**
   * Gets the value of the photo7 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto7()
  {
    return photo7;
  }

  /**
   * Sets the value of the photo7 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto7(String value)
  {
    this.photo7 = value;
  }

  /**
   * Gets the value of the photo8 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto8()
  {
    return photo8;
  }

  /**
   * Sets the value of the photo8 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto8(String value)
  {
    this.photo8 = value;
  }

  /**
   * Gets the value of the photo9 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto9()
  {
    return photo9;
  }

  /**
   * Sets the value of the photo9 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto9(String value)
  {
    this.photo9 = value;
  }

  /**
   * Gets the value of the photo10 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto10()
  {
    return photo10;
  }

  /**
   * Sets the value of the photo10 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto10(String value)
  {
    this.photo10 = value;
  }

  /**
   * Gets the value of the photo11 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto11()
  {
    return photo11;
  }

  /**
   * Sets the value of the photo11 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto11(String value)
  {
    this.photo11 = value;
  }

  /**
   * Gets the value of the photo12 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto12()
  {
    return photo12;
  }

  /**
   * Sets the value of the photo12 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto12(String value)
  {
    this.photo12 = value;
  }

  /**
   * Gets the value of the photo13 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto13()
  {
    return photo13;
  }

  /**
   * Sets the value of the photo13 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto13(String value)
  {
    this.photo13 = value;
  }

  /**
   * Gets the value of the photo14 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto14()
  {
    return photo14;
  }

  /**
   * Sets the value of the photo14 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto14(String value)
  {
    this.photo14 = value;
  }

  /**
   * Gets the value of the photo15 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto15()
  {
    return photo15;
  }

  /**
   * Sets the value of the photo15 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto15(String value)
  {
    this.photo15 = value;
  }

  /**
   * Gets the value of the photo16 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto16()
  {
    return photo16;
  }

  /**
   * Sets the value of the photo16 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto16(String value)
  {
    this.photo16 = value;
  }

  /**
   * Gets the value of the photo17 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto17()
  {
    return photo17;
  }

  /**
   * Sets the value of the photo17 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto17(String value)
  {
    this.photo17 = value;
  }

  /**
   * Gets the value of the photo18 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto18()
  {
    return photo18;
  }

  /**
   * Sets the value of the photo18 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto18(String value)
  {
    this.photo18 = value;
  }

  /**
   * Gets the value of the photo19 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto19()
  {
    return photo19;
  }

  /**
   * Sets the value of the photo19 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto19(String value)
  {
    this.photo19 = value;
  }

  /**
   * Gets the value of the photo20 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto20()
  {
    return photo20;
  }

  /**
   * Sets the value of the photo20 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto20(String value)
  {
    this.photo20 = value;
  }

  /**
   * Gets the value of the photo21 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto21()
  {
    return photo21;
  }

  /**
   * Sets the value of the photo21 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto21(String value)
  {
    this.photo21 = value;
  }

  /**
   * Gets the value of the photo22 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto22()
  {
    return photo22;
  }

  /**
   * Sets the value of the photo22 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto22(String value)
  {
    this.photo22 = value;
  }

  /**
   * Gets the value of the photo23 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto23()
  {
    return photo23;
  }

  /**
   * Sets the value of the photo23 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto23(String value)
  {
    this.photo23 = value;
  }

  /**
   * Gets the value of the photo24 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto24()
  {
    return photo24;
  }

  /**
   * Sets the value of the photo24 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto24(String value)
  {
    this.photo24 = value;
  }

  /**
   * Gets the value of the photo25 property.
   *
   * @return possible object is {@link String }
   *
   */
  public String getPhoto25()
  {
    return photo25;
  }

  /**
   * Sets the value of the photo25 property.
   *
   * @param value allowed object is {@link String }
   *
   */
  public void setPhoto25(String value)
  {
    this.photo25 = value;
  }

}
