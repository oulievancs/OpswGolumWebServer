-- MySQL Script generated by MySQL Workbench
-- Τετ 09 Φεβ 2022 10:22:05 μμ EET
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
DROP TABLE IF EXISTS `ASSETS00` ;

CREATE TABLE IF NOT EXISTS `ASSETS00` (
  `ASSET` INT(15) NOT NULL,
  `AAUCI` INT(15) NULL DEFAULT NULL,
  `ASSFILE` DATETIME NULL DEFAULT NULL,
  `INTRNLKEY` VARCHAR(100) NULL DEFAULT NULL,
  `STATUS` INT(2) NULL DEFAULT NULL,
  `UNIQCODE` VARCHAR(50) NULL DEFAULT NULL,
  `AUCTIONURL` VARCHAR(250) NULL DEFAULT NULL,
  `SYMB_ID` INT(15) NULL DEFAULT NULL,
  `BUYER` VARCHAR(50) NULL DEFAULT NULL,
  `PRODUCER` INT(1) NULL DEFAULT NULL,
  `COUNTASS` INT(5) NULL DEFAULT NULL,
  `BORRNAME` VARCHAR(400) NULL DEFAULT NULL,
  `PROPERTY_ID` VARCHAR(50) NULL DEFAULT NULL,
  `CALLATERAL1` VARCHAR(50) NULL DEFAULT NULL,
  `CALLATERAL_SUB_TYPE` VARCHAR(50) NULL DEFAULT NULL,
  `MUNICIPALITY` VARCHAR(50) NULL DEFAULT NULL,
  `CITY` VARCHAR(50) NULL DEFAULT NULL,
  `ADDRESS` VARCHAR(100) NULL DEFAULT NULL,
  `ZIPCODE` VARCHAR(15) NULL DEFAULT NULL,
  `GPSCORDS` VARCHAR(100) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(2000) NULL DEFAULT NULL,
  `LANDAREA` DOUBLE NULL DEFAULT NULL,
  `BUILDAREA` DOUBLE NULL DEFAULT NULL,
  `MAINSUREFACEAREA` DOUBLE NULL DEFAULT NULL,
  `AUXILLIARYSUREFACEAREA` DOUBLE NULL DEFAULT NULL,
  `ARBITARYSUREFACEAREA` DOUBLE NULL DEFAULT NULL,
  `FULLOWNERSHIP` INT(1) NULL DEFAULT NULL,
  `CONSTRUCTIONYEAR` INT(4) NULL DEFAULT NULL,
  `FLOOR` VARCHAR(30) NULL DEFAULT NULL,
  `AUCTION_ID` VARCHAR(150) NULL DEFAULT NULL,
  `AUCTION_DATE` DATETIME NULL DEFAULT NULL,
  `STARTINGPRICE` DOUBLE NULL DEFAULT NULL,
  `LANDEALINK` VARCHAR(100) NULL DEFAULT NULL,
  `REGION` VARCHAR(50) NULL DEFAULT NULL,
  `PREFECTURE` VARCHAR(50) NULL DEFAULT NULL,
  `OWNERSHIP_TYPE` VARCHAR(50) NULL DEFAULT NULL,
  `AUCTIONDATE` VARCHAR(10) NULL DEFAULT NULL,
  `IMAGE1` VARCHAR(250) NULL DEFAULT NULL,
  `IMAGE2` VARCHAR(250) NULL DEFAULT NULL,
  `IMAGE3` VARCHAR(250) NULL DEFAULT NULL,
  `COMMENTS_SEA` VARCHAR(300) NULL DEFAULT NULL,
  `EKTH_EKTIM` INT(1) NULL DEFAULT NULL,
  `TECHN_FAKEL` INT(1) NULL DEFAULT NULL,
  `TEASER` INT(1) NULL DEFAULT NULL,
  `BROKER_SITE` VARCHAR(250) NULL DEFAULT NULL,
  `SUBBROKER_NAME` VARCHAR(100) NULL DEFAULT NULL,
  `VISITORS_COUNT` INT(10) NULL DEFAULT NULL,
  `BEGIN_ENDIAFERON` INT(1) NULL DEFAULT NULL,
  `LEADS` INT(10) NULL DEFAULT NULL,
  `ENDIAFEROMENOS_INFO` VARCHAR(300) NULL DEFAULT NULL,
  `ENDIAFEROMENOS_INFO1` VARCHAR(300) NULL DEFAULT NULL,
  `ENDIAFEROMENOS_INFO2` VARCHAR(300) NULL DEFAULT NULL,
  `ENDIAFEROMENOS_INFO3` VARCHAR(300) NULL DEFAULT NULL,
  `ENDIAFEROMENOS_INFO4` VARCHAR(300) NULL DEFAULT NULL,
  `ENDIAFEROMENOS_INFO5` VARCHAR(300) NULL DEFAULT NULL,
  `COMMENTS1` VARCHAR(200) NULL DEFAULT NULL,
  `COMMENTS2` VARCHAR(200) NULL DEFAULT NULL,
  `MARKETABILITY_RATE` INT(5) NULL DEFAULT NULL,
  `LANDEA_LEADS` VARCHAR(60) NULL DEFAULT NULL,
  `LANDEA_COMMENTS` VARCHAR(200) NULL DEFAULT NULL,
  `UPDATE_AUCTION` VARCHAR(60) NULL DEFAULT NULL,
  `HIGH_INTEREST` VARCHAR(100) NULL DEFAULT NULL,
  `DATE_CREATE` DATETIME NULL DEFAULT NULL,
  `USER_CREATE` VARCHAR(45) NULL DEFAULT NULL,
  `DATE_MODIFY` DATETIME NULL DEFAULT NULL,
  `USER_MODIFY` VARCHAR(45) NULL DEFAULT NULL,
  `STATUSDEFF` VARCHAR(60) NULL DEFAULT NULL,
  `SPITOGATOS_URL` VARCHAR(250) NULL DEFAULT NULL,
  `XE_URL` VARCHAR(250) NULL DEFAULT NULL,
  `SOURCE` VARCHAR(100) NULL DEFAULT NULL,
  `SALE_FORECAST` VARCHAR(100) NULL DEFAULT NULL,
  `BROKER_COMM` VARCHAR(100) NULL DEFAULT NULL,
  `PROMOTION_STATUS` VARCHAR(100) NULL DEFAULT NULL,
  `BUYER_CEPAL` INT(1) NULL DEFAULT NULL,
  `OPINION_ONVALUE` VARCHAR(100) NULL DEFAULT NULL,
  `SEND_INVESTORS` INT(1) NULL DEFAULT NULL,
  `CUSTOMER_FILE` VARCHAR(100) NULL DEFAULT NULL,
  `REMARKS` VARCHAR(100) NULL DEFAULT NULL,
  `OPPORTUNITY` INT(5) NULL DEFAULT NULL,
  `SOLD_PRICE`  DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`ASSET`),
  CONSTRAINT `fk_ASSETS00_SYMB_1`
    FOREIGN KEY (`SYMB_ID`)
    REFERENCES `SYMB` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_ASSETS00_SYMB_1_idx` ON `ASSETS00` (`SYMB_ID` ASC);

CREATE INDEX `fk_ASSETS00_SYMB_1` ON `ASSETS00` (`SYMB_ID` ASC);


-- -----------------------------------------------------
-- Table `OPSWDB`.`ASSETS00FL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ASSETS00FL` ;

CREATE TABLE IF NOT EXISTS `ASSETS00FL` (
  `ASSET` INT(15) NOT NULL,
  `FLD` VARCHAR(50) NOT NULL,
  `VALSTR` VARCHAR(100) NULL,
  `VALNUM` DOUBLE NULL,
  `FLDESCR` VARCHAR(60) NULL,
  `TYPE` INT(1) NULL,
  PRIMARY KEY (`ASSET`, `FLD`),
  CONSTRAINT `fk_ASSETS00FL_1`
    FOREIGN KEY (`ASSET`)
    REFERENCES `ASSETS00` (`ASSET`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OPSWDB`.`GRAM00`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GRAM00` ;

CREATE TABLE IF NOT EXISTS `GRAM00` (
  `GRAM` INT(15) NOT NULL,
  `DESCR` VARCHAR(60) NOT NULL,
  `DESCR_SEA` VARCHAR(200) NULL DEFAULT NULL,
  `START_LINE` INT(4) NULL DEFAULT NULL,
  `DATE_CREATE` DATETIME NULL DEFAULT NULL,
  `USER_CREATE` VARCHAR(45) NULL DEFAULT NULL,
  `DATE_MODIFY` DATETIME NULL DEFAULT NULL,
  `USER_MODIFY` VARCHAR(45) NULL DEFAULT NULL,
  `INTERNALKEY_FLDS` VARCHAR(150) NULL DEFAULT NULL,
  `SHEETS` VARCHAR(50) NULL,
  PRIMARY KEY (`GRAM`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OPSWDB`.`GRAM01`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `GRAM01` ;

CREATE TABLE IF NOT EXISTS `GRAM01` (
  `GRAM` INT(15) NOT NULL,
  `SENU` INT(10) NOT NULL,
  `FIELD_TYPE` INT(4) NULL DEFAULT NULL,
  `FIELD_NAME` VARCHAR(45) NULL DEFAULT NULL,
  `VALUE_STR` VARCHAR(200) NULL DEFAULT NULL,
  `VALUE_NUM` DOUBLE NULL DEFAULT NULL,
  `EXCEL_INDEX` INT(10) NULL DEFAULT NULL,
  `DATE_FORMAT` VARCHAR(20) NULL DEFAULT NULL,
  `CONCATORDER` INT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`GRAM`, `SENU`),
  CONSTRAINT `fk_GRAM01_1`
    FOREIGN KEY (`GRAM`)
    REFERENCES `GRAM00` (`GRAM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `GRAM_UN1` ON `GRAM01` (`GRAM` ASC, `FIELD_NAME` ASC, `CONCATORDER` ASC);


-- -----------------------------------------------------
-- Table `OPSWDB`.`SEQUENCES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SEQUENCES` ;

CREATE TABLE IF NOT EXISTS `SEQUENCES` (
  `SEQ_GEN` VARCHAR(35) NOT NULL,
  `SEQ_COUNT` INT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`SEQ_GEN`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OPSWDB`.`SYMB`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SYMB` ;

CREATE TABLE IF NOT EXISTS `SYMB` (
  `ID` INT(15) NOT NULL,
  `NAME` VARCHAR(60) NULL DEFAULT NULL,
  `SURENAME` VARCHAR(50) NULL DEFAULT NULL,
  `TELE` VARCHAR(45) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(60) NULL DEFAULT NULL,
  `DATE_CREATE` DATETIME NULL DEFAULT NULL,
  `USER_CREATE` VARCHAR(45) NULL DEFAULT NULL,
  `DATE_MODIFY` DATETIME NULL DEFAULT NULL,
  `USER_MODIFY` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OPSWDB`.`UCIREMSERVREQ`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `UCIREMSERVREQ` ;

CREATE TABLE IF NOT EXISTS `UCIREMSERVREQ` (
  `ID` INT(15) NOT NULL,
  `URLREQ` VARCHAR(300) NULL DEFAULT NULL,
  `REMA` VARCHAR(200) NULL DEFAULT NULL,
  `RESPBODY` MEDIUMBLOB NULL DEFAULT NULL,
  `DATE_CREATE` DATETIME NULL DEFAULT NULL,
  `USER_CREATE` VARCHAR(45) NULL DEFAULT NULL,
  `DATE_MODIFY` DATETIME NULL DEFAULT NULL,
  `USER_MODIFY` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
