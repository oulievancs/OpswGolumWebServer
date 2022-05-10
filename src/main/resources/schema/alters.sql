


ALTER TABLE `GRAM01` ADD COLUMN `DATE_FORMAT` VARCHAR(30);
ALTER TABLE `SYMB` ADD COLUMN `EMAIL` VARCHAR(60);

ALTER TABLE `SYMB` ADD COLUMN `DATE_CREATE` DATETIME NULL;
ALTER TABLE `SYMB` ADD COLUMN `USER_CREATE` VARCHAR(45) NULL;
ALTER TABLE `SYMB` ADD COLUMN `DATE_MODIFY` DATETIME NULL;
ALTER TABLE `SYMB` ADD COLUMN `USER_MODIFY` VARCHAR(45) NULL;

ALTER TABLE `GRAM01` ADD COLUMN `CONCATORDER` INT(4) NULL;

DROP INDEX `GRAM_UN1` ON `GRAM01`;
CREATE UNIQUE INDEX `GRAM_UN1` ON `GRAM01` (`GRAM` ASC, `FIELD_NAME` ASC, `CONCATORDER` ASC);

ALTER TABLE `ASSETS00` ADD COLUMN `DATE_CREATE` DATETIME NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `USER_CREATE` VARCHAR(45) NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `DATE_MODIFY` DATETIME NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `USER_MODIFY` VARCHAR(45) NULL;

ALTER TABLE `ASSETS00` ADD COLUMN `STATUSDEFF` VARCHAR(60) NULL;

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

ALTER TABLE `GRAM00` ADD COLUMN `INTERNALKEY_FLDS` VARCHAR(150) NULL;


CREATE TABLE IF NOT EXISTS `UCIREMSERVREQ` (
  `ID` INT(15) NOT NULL,
  `URLREQ` VARCHAR(300) NULL DEFAULT NULL,
  `REMA` VARCHAR(200) NULL DEFAULT NULL,
  `RESPBODY` BLOB NULL DEFAULT NULL,
  `DATE_CREATE` DATETIME NULL DEFAULT NULL,
  `USER_CREATE` VARCHAR(45) NULL DEFAULT NULL,
  `DATE_MODIFY` DATETIME NULL DEFAULT NULL,
  `USER_MODIFY` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;

ALTER TABLE `GRAM01` MODIFY COLUMN DATE_FORMAT varchar(20);

ALTER TABLE `UCIREMSERVREQ` MODIFY COLUMN `RESPBODY` MEDIUMBLOB;

ALTER TABLE `GRAM00` ADD COLUMN `SHEETS` VARCHAR(50) NULL;

ALTER TABLE `ASSETS00` MODIFY COLUMN `ENDIAFEROMENOS_INFO1` VARCHAR(300) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` MODIFY COLUMN `ENDIAFEROMENOS_INFO2` VARCHAR(300) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` MODIFY COLUMN `ENDIAFEROMENOS_INFO3` VARCHAR(300) NULL DEFAULT NULL;

ALTER TABLE ASSETS00 MODIFY COLUMN `ENDIAFEROMENOS_INFO4` VARCHAR(300) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` MODIFY COLUMN `ENDIAFEROMENOS_INFO5` VARCHAR(300) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` DROP COLUMN `MARKETABILITY_NAME`;
ALTER TABLE `ASSETS00` ADD COLUMN `MARKETABILITY_RATE` INT(5) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` MODIFY COLUMN `DESCRIPTION` VARCHAR(2000) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` MODIFY COLUMN `ADDRESS` VARCHAR(100) NULL DEFAULT NULL;


ALTER TABLE `ASSETS00` MODIFY COLUMN `HIGH_INTEREST` VARCHAR(100) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` MODIFY COLUMN `SUBBROKER_NAME` VARCHAR(100) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` MODIFY COLUMN `BORRNAME` VARCHAR(400) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` MODIFY COLUMN `IMAGE1` VARCHAR(250) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` MODIFY COLUMN `IMAGE2` VARCHAR(250) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` MODIFY COLUMN `IMAGE3` VARCHAR(250) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` MODIFY COLUMN `BROKER_SITE` VARCHAR(250) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` MODIFY COLUMN `AUCTIONURL` VARCHAR(250) NULL DEFAULT NULL;


ALTER TABLE `ASSETS00` DROP COLUMN `SPITOGATOSURL`;
ALTER TABLE `ASSETS00` DROP COLUMN `XEURL`;

ALTER TABLE `ASSETS00` ADD COLUMN `SPITOGATOS_URL` VARCHAR(250) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `XE_URL` VARCHAR(250) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` MODIFY COLUMN `AUCTION_ID` VARCHAR(150) NULL DEFAULT NULL;


ALTER TABLE `ASSETS00` ADD COLUMN `SOURCE` VARCHAR(100) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `SALE_FORECAST` VARCHAR(100) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `BROKER_COMM` VARCHAR(100) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `PROMOTION_STATUS` VARCHAR(100) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `BUYER_CEPAL` INT(1) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `OPINION_ONVALUE` VARCHAR(100) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `SEND_INVESTORS` INT(1) NULL DEFAULT NULL;

ALTER TABLE `ASSETS00` ADD COLUMN `CUSTOMER_FILE` VARCHAR(100) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `REMARKS` VARCHAR(100) NULL DEFAULT NULL;
ALTER TABLE `ASSETS00` ADD COLUMN `OPPORTUNITY` INT(5) NULL DEFAULT NULL;
    