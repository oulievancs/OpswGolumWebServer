-- MySQL Script generated by MySQL Workbench
-- Τρι 04 Ιαν 2022 11:46:28 μμ EET
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
  `DECRIPTION` VARCHAR(300) NULL,
  `LANDAREA` DOUBLE NULL,
  `BUILDAREA` DOUBLE NULL,
  `MAINSUREFACEAREA` DOUBLE NULL,
  `AUXILLIARYSUREFACEAREA` DOUBLE NULL,
  `ARBITARYSUREAFACEAREA` DOUBLE NULL,
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
  PRIMARY KEY (`ASSET`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OPSWDB`.`GRAM00`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OPSWDB`.`GRAM00` ;

CREATE TABLE IF NOT EXISTS `OPSWDB`.`GRAM00` (
  `GRAM` INT(15) NOT NULL,
  `DESCR` VARCHAR(60) NOT NULL,
  `DESCR_SEA` VARCHAR(200) NULL,
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
  PRIMARY KEY (`GRAM`, `SENU`),
  CONSTRAINT `fk_GRAM01_1`
    FOREIGN KEY (`GRAM`)
    REFERENCES `OPSWDB`.`GRAM00` (`GRAM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `GRAM_UN1` ON `OPSWDB`.`GRAM01` (`GRAM` ASC, `FIELD_NAME` ASC);


-- -----------------------------------------------------
-- Table `OPSWDB`.`SEQUENES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OPSWDB`.`SEQUENES` ;

CREATE TABLE IF NOT EXISTS `OPSWDB`.`SEQUENES` (
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
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
