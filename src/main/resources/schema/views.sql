---------------------------------------------------
-- View `OPSWDB`.`OPSWCONSTSV`
-- -----------------------------------------------------
CREATE OR REPLACE VIEW OPSWCONSTSV AS
SELECT
CODE, VALUE, DESCR 
FROM
(
SELECT 'FIELD_TYPE' CODE, 0 VALUE, 'Floating Point' DESCR FROM DUAL
UNION ALL
SELECT 'FIELD_TYPE' CODE, 1 VALUE, 'String' DESCR FROM DUAL
UNION ALL
SELECT 'FIELD_TYPE' CODE, 2 VALUE, 'Date' DESCR FROM DUAL
UNION ALL
SELECT 'FIELD_TYPE' CODE, 3 VALUE, 'Integer' DESCR FROM DUAL
UNION ALL
SELECT 'FIELD_TYPE' CODE, 4 VALUE, 'Y Or N Value' DESCR FROM DUAL
UNION ALL
SELECT 'ASSETS00_FLDS' CODE, 'EXTRA_FLD1' VALUE, 'An Extra Field' DESCR FROM DUAL
UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'AAUCI'                    VALUE,  'A/A UCI' DESCR FROM DUAL UNION ALL     
SELECT  'ASSETS_VALUE' CODE, 'ASSFILE'                 VALUE,  'Assignment File' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'INTRNLKEY'     VALUE,  'Internal Key' DESCR FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'STATUSDEFF'                 VALUE,  'Auction Status / Κατάσταση' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'UNIQCODE'                 VALUE,  'Mοναδικός Kωδικός' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'AUCTIONURL'             VALUE,  'Auction URL' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SYMB_NAME'               VALUE,  'Συμβολαιογράφος' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SYMB_TEL'              VALUE,  'Συμβολαιογράφος Τηλέφωνο' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'BUYER'               VALUE,  'Buyer' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'PRODUCER'   VALUE,  'Producer' DESCR FROM DUAL UNION ALL     
SELECT  'ASSETS_VALUE' CODE, 'COUNTASS'         VALUE,  'Count Assets' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'BORRNAME'                 VALUE,  'Borrower Name' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'PROPERTY_ID'              VALUE,  'Property ID' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'CALLATERAL'                VALUE,  'Collateral Use 1' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'CALLATERAL_SUB_TYPE'                 VALUE,  'Collateral Sub type' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'MUNICIPALITY'              VALUE,  'Municipality' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'CITY'      VALUE,  'City' DESCR FROM DUAL UNION ALL  
SELECT  'ASSETS_VALUE' CODE, 'ADDRESS'                 VALUE,  'Address' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ZIPCODE'                VALUE,  'Zipcode' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'GPSCORDS'                VALUE,  'GPSCoordinates' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'DESCRIPTION'             VALUE,  'Description' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'LANDAREA'         VALUE,  'Land Area' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'BUILDAREA'                 VALUE,  'Built Area' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'MAINSUREFACEAREA'              VALUE,  'Main Surface Area (sqm)' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'AUXILLIARYSUREFACEAREA'               VALUE,  'Auxiliary Surface Area (sqm)' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ARBITARYSUREFACEAREA'      VALUE,  'Arbitrary Surface Area (sqm)' DESCR FROM DUAL UNION ALL  
SELECT  'ASSETS_VALUE' CODE, 'FULLOWNERSHIP'     VALUE,  'Full Ownership Flag' DESCR FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'CONSTRUCTIONYEAR'     VALUE,  'Construction Year' DESCR FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'FLOOR'     VALUE,  'Floor' DESCR FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'AUCTION_ID'     VALUE,  'Auction_ID' DESCR FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'UNIQAUCTION_CODE'     VALUE,  'Unique Auction Code' DESCR FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'AUCTION_DATE'                 VALUE,  'Auction date' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'STARTINGPRICE'            VALUE,  'Starting Price' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'LANDEALINK'                 VALUE,  'Landea link' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'REGION'            VALUE,  'Region' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'PREFECTURE'                 VALUE,  'Prefecture' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'OWNERSHIP_TYPE'                 VALUE,  'Ownership Type' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'AUCTIONDATE'                 VALUE,  'Auction Date (Month & YEAR)' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'IMAGE1'                VALUE,  'Image01' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'IMAGE2'                 VALUE,  'Image02' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'IMAGE3'          VALUE,  'Image03' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'COMMENTS_SEA'             VALUE,  'Άλλα σχόλια επί του ακινήτου ή της προώθησης' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'EKTH_EKTIM'               VALUE,  'ΕΚΘΕΣΗ ΕΚΤΙΜΗΣΗΣ' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'TECHN_FAKEL'                 VALUE,  'ΤΕΧΝΙΚΟΣ ΦΑΚΕΛΟΣ' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'TEASER'         VALUE,  'TEASER' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SITE'       VALUE,  'SPITOGATOS ή XE LINK' DESCR FROM DUAL UNION ALL 
SELECT  'ASSETS_VALUE' CODE, 'BROKER_SITE'             VALUE,  'BROKER WEBSITE LINK(UCI)' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'SUBBROKER_NAME'           VALUE,  'SUB BROKERS (Name)' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'VISITORS_COUNT'               VALUE,  'ΠΛΗΘΟΣ ΠΡΟΒΟΛΩΝ- ΕΠΙΣΚΕΨΕΩΝ ΚΑΤΑΧΩΡΗΣΗΣ' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'BEGIN_ENDIAFERON'                 VALUE,  'ΑΡΧΙΚΟ ΕΝΔΙΑΦΕΡΟΝ' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'LEADS'                 VALUE,  'LEADS' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ENDIAFEROMENOS_INFO1'              VALUE,  'ΣΤΟΙΧΕΙΑ ΕΝΔΙΑΦΕΡΟΜΕΝΟΥ No1' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ENDIAFEROMENOS_INFO2'                 VALUE,  'ΣΤΟΙΧΕΙΑ ΕΝΔΙΑΦΕΡΟΜΕΝΟΥ No2' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ENDIAFEROMENOS_INFO3'                 VALUE,  'ΣΤΟΙΧΕΙΑ ΕΝΔΙΑΦΕΡΟΜΕΝΟΥ No3' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ENDIAFEROMENOS_INFO4'            VALUE,  'ΣΤΟΙΧΕΙΑ ΕΝΔΙΑΦΕΡΟΜΕΝΟΥ No4' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'ENDIAFEROMENOS_INFO5'                 VALUE,  'ΣΤΟΙΧΕΙΑ ΕΝΔΙΑΦΕΡΟΜΕΝΟΥ No5' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'COMMENTS1'           VALUE,  'ΣΧΟΛΙΑ Ι' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'COMMENTS2'                 VALUE,  'ΣΧΟΛΙΑ ΙΙ' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'MARKETABILITY_RATE'                 VALUE,  'Marketability rate' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'LANDEA_LEADS'              VALUE,  'Landea Leads' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'LANDEA_COMMENTS'         VALUE,  'Landea Comments' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'UPDATE_AUCTION'                 VALUE,  'Update Auction' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'HIGH_INTEREST'                 VALUE,  'HIGH INTEREST' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'EXTRA_FLD1'                 VALUE,  'EXTRA FLD1' DESCR FROM DUAL
) consts;

