-- MySQL Script generated by MySQL Workbench
-- Σαβ 08 Ιαν 2022 12:09:23 πμ EET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema OPSWDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `OPSWDB` ;

-- -----------------------------------------------------
-- Schema OPSWDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `OPSWDB` ;
USE `OPSWDB` ;

-- -----------------------------------------------------
-- Table `OPSWDB`.`ASSETS00`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OPSWDB`.`ASSETS00` ;

CREATE TABLE IF NOT EXISTS `OPSWDB`.`ASSETS00` (
  `ASSET` INT(15) NOT NULL,
  `AAUCI` INT(15) NULL,
  `ASSFILE` DATETIME NULL,
  `INTRNLKEY` VARCHAR(100) NULL,
  `STATUS` INT(2) NULL,
  `UNIQCODE` VARCHAR(50) NULL,
  `AUCTIONURL` VARCHAR(100) NULL,
  `SYMB_ID` INT(15) NULL,
  `BUYER` VARCHAR(50) NULL,
  `PRODUCER` INT(1) NULL,
  `COUNTASS` INT(5) NULL,
  `BORRNAME` VARCHAR(50) NULL,
  `PROPERTY_ID` VARCHAR(50) NULL,
  `CALLATERAL1` VARCHAR(50) NULL,
  `CALLATERAL_SUB_TYPE` VARCHAR(50) NULL,
  `MUNICIPALITY` VARCHAR(50) NULL,
  `CITY` VARCHAR(50) NULL,
  `ADDRESS` VARCHAR(60) NULL,
  `ZIPCODE` VARCHAR(15) NULL,
  `GPSCORDS` VARCHAR(100) NULL,
  `DESCRIPTION` VARCHAR(300) NULL,
  `LANDAREA` DOUBLE NULL,
  `BUILDAREA` DOUBLE NULL,
  `MAINSUREFACEAREA` DOUBLE NULL,
  `AUXILLIARYSUREFACEAREA` DOUBLE NULL,
  `ARBITARYSUREFACEAREA` DOUBLE NULL,
  `FULLOWNERSHIP` INT(1) NULL,
  `CONSTRUCTIONYEAR` INT(4) NULL,
  `FLOOR` VARCHAR(30) NULL,
  `AUCTION_ID` VARCHAR(50) NULL,
  `UNIQAUCTION_CODE` VARCHAR(50) NULL,
  `AUCTION_DATE` DATETIME NULL,
  `STARTINGPRICE` DOUBLE NULL,
  `LANDEALINK` VARCHAR(100) NULL,
  `REGION` VARCHAR(50) NULL,
  `PREFECTURE` VARCHAR(50) NULL,
  `OWNERSHIP_TYPE` INT(1) NULL,
  `AUCTIONDATE` VARCHAR(10) NULL,
  `IMAGE1` VARCHAR(100) NULL,
  `IMAGE2` VARCHAR(100) NULL,
  `IMAGE3` VARCHAR(100) NULL,
  `COMMENTS_SEA` VARCHAR(300) NULL,
  `EKTH_EKTIM` INT(1) NULL,
  `TECHN_FAKEL` INT(1) NULL,
  `TEASER` INT(1) NULL,
  `SITE` VARCHAR(100) NULL,
  `BROKER_SITE` VARCHAR(100) NULL,
  `SUBBROKER_NAME` VARCHAR(60) NULL,
  `VISITORS_COUNT` INT(10) NULL,
  `BEGIN_ENDIAFERON` INT(1) NULL,
  `LEADS` INT(10) NULL,
  `ENDIAFEROMENOS_INFO` VARCHAR(60) NULL,
  `ENDIAFEROMENOS_INFO1` VARCHAR(60) NULL,
  `ENDIAFEROMENOS_INFO2` VARCHAR(60) NULL,
  `ENDIAFEROMENOS_INFO3` VARCHAR(60) NULL,
  `ENDIAFEROMENOS_INFO4` VARCHAR(60) NULL,
  `ENDIAFEROMENOS_INFO5` VARCHAR(60) NULL,
  `COMMENTS1` VARCHAR(200) NULL,
  `COMMENTS2` VARCHAR(200) NULL,
  `MARKETABILITY_NAME` INT(5) NULL,
  `LANDEA_LEADS` VARCHAR(60) NULL,
  `LANDEA_COMMENTS` VARCHAR(200) NULL,
  `UPDATE_AUCTION` VARCHAR(60) NULL,
  `HIGH_INTEREST` VARCHAR(60) NULL,
  PRIMARY KEY (`ASSET`),
  CONSTRAINT `fk_ASSETS00_SYMB_1`
    FOREIGN KEY (`SYMB_ID`)
    REFERENCES `OPSWDB`.`SYMB` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_ASSETS00_SYMB_1_idx` ON `OPSWDB`.`ASSETS00` (`SYMB_ID` ASC);


-- -----------------------------------------------------
-- Table `OPSWDB`.`GRAM00`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OPSWDB`.`GRAM00` ;

CREATE TABLE IF NOT EXISTS `OPSWDB`.`GRAM00` (
  `GRAM` INT(15) NOT NULL,
  `DESCR` VARCHAR(60) NOT NULL,
  `DESCR_SEA` VARCHAR(200) NULL,
  `START_LINE` INT(4) NULL,
  `DATE_CREATE` DATETIME NULL,
  `USER_CREATE` VARCHAR(45) NULL,
  `DATE_MODIFY` DATETIME NULL,
  `USER_MODIFY` VARCHAR(45) NULL,
  PRIMARY KEY (`GRAM`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OPSWDB`.`GRAM01`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OPSWDB`.`GRAM01` ;

CREATE TABLE IF NOT EXISTS `OPSWDB`.`GRAM01` (
  `GRAM` INT(15) NOT NULL,
  `SENU` INT(10) NOT NULL,
  `FIELD_TYPE` INT(4) NULL,
  `FIELD_NAME` VARCHAR(45) NULL,
  `VALUE_STR` VARCHAR(200) NULL,
  `VALUE_NUM` DOUBLE NULL,
  `EXCEL_INDEX` INT(10) NULL,
  `DATE_FORMAT` VARCHAR(3) NULL,
  PRIMARY KEY (`GRAM`, `SENU`),
  CONSTRAINT `fk_GRAM01_1`
    FOREIGN KEY (`GRAM`)
    REFERENCES `OPSWDB`.`GRAM00` (`GRAM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `GRAM_UN1` ON `OPSWDB`.`GRAM01` (`GRAM` ASC, `FIELD_NAME` ASC);


-- -----------------------------------------------------
-- Table `OPSWDB`.`SEQUENCES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OPSWDB`.`SEQUENCES` ;

CREATE TABLE IF NOT EXISTS `OPSWDB`.`SEQUENCES` (
  `SEQ_GEN` VARCHAR(35) NOT NULL,
  `SEQ_COUNT` INT(20) NULL,
  PRIMARY KEY (`SEQ_GEN`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OPSWDB`.`SYMB`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OPSWDB`.`SYMB` ;

CREATE TABLE IF NOT EXISTS `OPSWDB`.`SYMB` (
  `ID` INT(15) NOT NULL,
  `NAME` VARCHAR(60) NULL,
  `SURENAME` VARCHAR(50) NULL,
  `TELE` VARCHAR(45) NULL,
  `EMAIL` VARCHAR(60) NULL,
  `DATE_CREATE` DATETIME NULL,
  `USER_CREATE` VARCHAR(45) NULL,
  `DATE_MODIFY` DATETIME NULL,
  `USER_MODIFY` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- View `OPSWDB`.`OPSWCONSTSV`
-- -----------------------------------------------------
CREATE OR REPLACE VIEW OPSWCONSTSV AS
SELECT
CODE, VALUE, DESCR 
FROM
(
SELECT 'FIELD_TYPE' CODE, 0 VALUE, 'NUMBER' DESCR FROM DUAL
UNION ALL
SELECT 'FIELD_TYPE' CODE, 1 VALUE, 'String' DESCR FROM DUAL
UNION ALL
SELECT 'FIELD_TYPE' CODE, 2 VALUE, 'Date' DESCR FROM DUAL
UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'AAUCI'                    VALUE,  'A/A UCI' DESCR FROM DUAL UNION ALL     
SELECT  'ASSETS_VALUE' CODE, 'ASSFILE'                 VALUE,  'Assignment File' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'INTRNLKEY'     VALUE,  'Internal Key' DESCR FROM DUAL UNION ALL   
SELECT  'ASSETS_VALUE' CODE, 'STATUS'                 VALUE,  'Auction Status / Κατάσταση' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'UNIQCODE'                 VALUE,  'Mοναδικός Kωδικός' DESCR FROM DUAL UNION ALL
SELECT  'ASSETS_VALUE' CODE, 'AUCTION_URL'             VALUE,  'Auction URL' DESCR FROM DUAL UNION ALL
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
SELECT  'ASSETS_VALUE' CODE, 'STARTIGPRICE'            VALUE,  'Starting Price' DESCR FROM DUAL UNION ALL
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
SELECT  'ASSETS_VALUE' CODE, 'HIGH_INTEREST'                 VALUE,  'HIGH INTEREST' DESCR FROM DUAL
) consts