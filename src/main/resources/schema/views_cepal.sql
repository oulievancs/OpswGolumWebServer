/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  oulis
 * Created: Apr 20, 2022
 */


---------------------------------------------------
-- View `OPSWDB`.`OPSWFLDSV`
-- -----------------------------------------------------
CREATE OR REPLACE VIEW OPSWFLDSV AS
SELECT
CODE, TYPE, DESCR 
FROM
(
SELECT 'EXTRA_FLD1' CODE, 1 TYPE, 'A/A ΚΩΔΙΚΟΣ ΟΜΑΔΟΠΟΙΗΣΗΣ ΚΑΤΑΣΧΕΤΗΡΙΑ' DESCR FROM DUAL
UNION ALL
SELECT 'EXTRA_FLD2' CODE, 2 TYPE, 'An Extra Field Number' DESCR FROM DUAL
UNION ALL
SELECT 'EXTRA_FLD3' CODE, 1 TYPE, 'An Extra Field String' DESCR FROM DUAL
) consts;

DROP VIEW OPSWCONSTSV;

---------------------------------------------------
-- View `OPSWDB`.`OPSWCONSTSV`
-- -----------------------------------------------------
CREATE OR REPLACE VIEW OPSWCONSTSV AS
SELECT
CODE, FIELD, VALUE 
FROM
(
SELECT 'FIELD_TYPE' CODE, 0 FIELD, 'Floating Point' VALUE FROM DUAL
UNION ALL
SELECT 'FIELD_TYPE' CODE, 1 FIELD, 'String' VALUE FROM DUAL
UNION ALL
SELECT 'FIELD_TYPE' CODE, 2 FIELD, 'Date' VALUE FROM DUAL
UNION ALL
SELECT 'FIELD_TYPE' CODE, 3 FIELD, 'Integer' VALUE FROM DUAL
UNION ALL
SELECT 'FIELD_TYPE' CODE, 4 FIELD, 'Y Or N Value' VALUE FROM DUAL
UNION ALL
SELECT 'ASSETS00_INTERNALKEY' CODE, 'AAUCI' FIELD, 'A/A' VALUE FROM DUAL
UNION ALL
SELECT 'ASSETS00_INTERNALKEY' CODE, 'ASSFILE' FIELD, 'Assignement File' VALUE FROM DUAL
UNION ALL
SELECT 'ASSETS00_INTERNALKEY' CODE, 'UNIQCODE' FIELD, 'Unique Code' VALUE FROM DUAL
UNION ALL
SELECT 'ASSETS00_INTERNALKEY' CODE, 'EXTRA_FLD1' FIELD, 'A/A ΚΩΔΙΚΟΣ ΟΜΑΔΟΠΟΙΗΣΗΣ ΚΑΤΑΣΧΕΤΗΡΙΑ' VALUE FROM DUAL
UNION ALL
SELECT 'ASSETS00_INTERNALKEY' CODE, 'CEPNEP0122' FIELD, 'Cepal Neptune Code' VALUE FROM DUAL
UNION ALL
SELECT 'ASSETS00_INTERNALKEY' CODE, 'CEPGAL' FIELD, 'Cepal Galaxy Code' VALUE FROM DUAL
UNION ALL
SELECT 'ASSETS00_INTERNALKEY' CODE, 'CEP0921' FIELD, 'Cepal Symbol Code' VALUE FROM DUAL
UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'AAUCI'                    FIELD,  'A/A UCI' VALUE FROM DUAL UNION ALL     
SELECT  'ASSETS_VALUE' CODE, 'ASSFILE'                 FIELD,  'Assignment File' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'INTRNLKEY'     FIELD,  'Internal Key' VALUE FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'STATUSDEFF'                 FIELD,  'Auction Status / Κατάσταση' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'UNIQCODE'                 FIELD,  'Mοναδικός Kωδικός' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'AUCTIONURL'             FIELD,  'Auction URL' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SYMB_NAME'               FIELD,  'Συμβολαιογράφος' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SYMB_TEL'              FIELD,  'Συμβολαιογράφος Τηλέφωνο' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SYMB_EMAIL'              FIELD,  'Συμβολαιογράφος Email' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'BUYER'               FIELD,  'Buyer' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'PRODUCER'   FIELD,  'Producer' VALUE FROM DUAL UNION ALL     
SELECT  'ASSETS_VALUE' CODE, 'COUNTASS'         FIELD,  'Count Assets' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'BORRNAME'                 FIELD,  'Borrower Name' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'PROPERTY_ID'              FIELD,  'Property ID' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'CALLATERAL1'                FIELD,  'Collateral Use 1' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'CALLATERAL_SUB_TYPE'                 FIELD,  'Collateral Sub type' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'MUNICIPALITY'              FIELD,  'Municipality' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'CITY'      FIELD,  'City' VALUE FROM DUAL UNION ALL  
SELECT  'ASSETS_VALUE' CODE, 'ADDRESS'                 FIELD,  'Address' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ZIPCODE'                FIELD,  'Zipcode' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'GPSCORDS'                FIELD,  'GPSCoordinates' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'DESCRIPTION'             FIELD,  'Description' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'LANDAREA'         FIELD,  'Land Area' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'BUILDAREA'                 FIELD,  'Built Area' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'MAINSUREFACEAREA'              FIELD,  'Main Surface Area (sqm)' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'AUXILLIARYSUREFACEAREA'               FIELD,  'Auxiliary Surface Area (sqm)' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ARBITARYSUREFACEAREA'      FIELD,  'Arbitrary Surface Area (sqm)' VALUE FROM DUAL UNION ALL  
SELECT  'ASSETS_VALUE' CODE, 'FULLOWNERSHIP'     FIELD,  'Full Ownership Flag' VALUE FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'CONSTRUCTIONYEAR'     FIELD,  'Construction Year' VALUE FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'FLOOR'     FIELD,  'Floor' VALUE FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'AUCTION_ID'     FIELD,  'Auction_ID' VALUE FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'UNIQAUCTION_CODE'     FIELD,  'Unique Auction Code' VALUE FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'AUCTION_DATE'                 FIELD,  'Auction date' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'STARTINGPRICE'            FIELD,  'Starting Price' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'LANDEALINK'                 FIELD,  'Landea link' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'REGION'            FIELD,  'Region' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'PREFECTURE'                 FIELD,  'Prefecture' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'OWNERSHIP_TYPE'                 FIELD,  'Ownership Type' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'AUCTIONDATE'                 FIELD,  'Auction Date (Month & YEAR)' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'IMAGE1'                FIELD,  'Image01' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'IMAGE2'                 FIELD,  'Image02' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'IMAGE3'          FIELD,  'Image03' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'COMMENTS_SEA'             FIELD,  'Άλλα σχόλια επί του ακινήτου ή της προώθησης' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'EKTH_EKTIM'               FIELD,  'ΕΚΘΕΣΗ ΕΚΤΙΜΗΣΗΣ' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'TECHN_FAKEL'                 FIELD,  'ΤΕΧΝΙΚΟΣ ΦΑΚΕΛΟΣ' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'TEASER'         FIELD,  'TEASER' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SITE'       FIELD,  'SPITOGATOS ή XE LINK' VALUE FROM DUAL UNION ALL 
SELECT  'ASSETS_VALUE' CODE, 'BROKER_SITE'             FIELD,  'BROKER WEBSITE LINK(UCI)' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SUBBROKER_NAME'           FIELD,  'SUB BROKERS (Name)' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'VISITORS_COUNT'               FIELD,  'ΠΛΗΘΟΣ ΠΡΟΒΟΛΩΝ- ΕΠΙΣΚΕΨΕΩΝ ΚΑΤΑΧΩΡΗΣΗΣ' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'BEGIN_ENDIAFERON'                 FIELD,  'ΑΡΧΙΚΟ ΕΝΔΙΑΦΕΡΟΝ' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'LEADS'                 FIELD,  'LEADS' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ENDIAFEROMENOS_INFO1'              FIELD,  'ΣΤΟΙΧΕΙΑ ΕΝΔΙΑΦΕΡΟΜΕΝΟΥ No1' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ENDIAFEROMENOS_INFO2'                 FIELD,  'ΣΤΟΙΧΕΙΑ ΕΝΔΙΑΦΕΡΟΜΕΝΟΥ No2' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ENDIAFEROMENOS_INFO3'                 FIELD,  'ΣΤΟΙΧΕΙΑ ΕΝΔΙΑΦΕΡΟΜΕΝΟΥ No3' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ENDIAFEROMENOS_INFO4'            FIELD,  'ΣΤΟΙΧΕΙΑ ΕΝΔΙΑΦΕΡΟΜΕΝΟΥ No4' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ENDIAFEROMENOS_INFO5'                 FIELD,  'ΣΤΟΙΧΕΙΑ ΕΝΔΙΑΦΕΡΟΜΕΝΟΥ No5' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'COMMENTS1'           FIELD,  'ΣΧΟΛΙΑ Ι' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'COMMENTS2'                 FIELD,  'ΣΧΟΛΙΑ ΙΙ' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'MARKETABILITY_RATE'                 FIELD,  'Marketability rate' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'LANDEA_LEADS'              FIELD,  'Landea Leads' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'LANDEA_COMMENTS'         FIELD,  'Landea Comments' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'UPDATE_AUCTION'                 FIELD,  'Update Auction' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'HIGH_INTEREST'                 FIELD,  'HIGH INTEREST' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'EXTRA_FLD1'                 FIELD,  'EXTRA FLD1' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'EXTRA_FLD2'                 FIELD,  'EXTRA FLD2' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'EXTRA_FLD3'                 FIELD,  'EXTRA FLD3' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SPITOGATOS_URL'                 FIELD,  'Property URL On Spitogatos' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'XE_URL'                 FIELD,  'Property URL On X.E.' VALUE FROM DUAL UNION ALL
--************************************************************************************************************
SELECT  'ASSETS_VALUE' CODE, 'SOURCE'                 FIELD,  'Source' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SALE_FORECAST'                 FIELD,  'Sale Forecast' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'BROKER_COMM'                 FIELD,  'Broker Comments' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'PROMOTION_STATUS'                 FIELD,  'Promotion Status' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'BUYER_CEPAL'                 FIELD,  'Buyer Cepal' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'OPINION_ONVALUE'                 FIELD,  'Opinion on Value' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SEND_INVESTORS'                 FIELD,  'Send to investors' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'CUSTOMER_FILE'                 FIELD,  'File with customer details' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'REMARKS'                 FIELD,  'Remarks' VALUE FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'OPPORTUNITY'                 FIELD,  'Opportunity' VALUE FROM DUAL UNION ALL
SELECT 'ASSETS_VALUE'  CODE, 'SOLD_PRICE'               FIELD, 'Sold Price' VALUE FROM DUAL UNION ALL
--*********************************************************************************************************
SELECT  'ASSETS00_FLDS' CODE, V1.CODE                 FIELD,  V1.DESCR VALUE FROM OPSWFLDSV V1 UNION ALL
--*********************************************************************************************************
--SELECT  'CRM_SERVER_URL' CODE, 'CRM_SERVER_URL_1' FIELD, 'http://ucitest.ddns.net:8081/OPSWTESTWEBSERV/uci/propertiesxml' VALUE FROM DUAL
SELECT  'CRM_SERVER_URL' CODE, 'CRM_SERVER_URL_1' FIELD, 'http://panel.e-agents.gr/propertiesxml.aspx' VALUE FROM DUAL
) consts;

