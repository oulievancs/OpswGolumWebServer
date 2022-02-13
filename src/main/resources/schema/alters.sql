


ALTER TABLE `OPSWDB`.`GRAM01` ADD COLUMN `DATE_FORMAT` VARCHAR(30);
ALTER TABLE `OPSWDB`.`SYMB` ADD COLUMN `EMAIL` VARCHAR(60);

ALTER TABLE `OPSWDB`.`SYMB` ADD COLUMN `DATE_CREATE` DATETIME NULL;
ALTER TABLE `OPSWDB`.`SYMB` ADD COLUMN `USER_CREATE` VARCHAR(45) NULL;
ALTER TABLE `OPSWDB`.`SYMB` ADD COLUMN `DATE_MODIFY` DATETIME NULL;
ALTER TABLE `OPSWDB`.`SYMB` ADD COLUMN `USER_MODIFY` VARCHAR(45) NULL;

ALTER TABLE `OPSWDB`.`GRAM01` ADD COLUMN `CONCATORDER` INT(4) NULL;

DROP INDEX `GRAM_UN1` ON `OPSWDB`.`GRAM01`;
CREATE UNIQUE INDEX `GRAM_UN1` ON `OPSWDB`.`GRAM01` (`GRAM` ASC, `FIELD_NAME` ASC, `CONCATORDER` ASC);

ALTER TABLE `OPSWDB`.`ASSETS00` ADD COLUMN `DATE_CREATE` DATETIME NULL;
ALTER TABLE `OPSWDB`.`ASSETS00` ADD COLUMN `USER_CREATE` VARCHAR(45) NULL;
ALTER TABLE `OPSWDB`.`ASSETS00` ADD COLUMN `DATE_MODIFY` DATETIME NULL;
ALTER TABLE `OPSWDB`.`ASSETS00` ADD COLUMN `USER_MODIFY` VARCHAR(45) NULL;

ALTER TABLE `OPSWDB`.`ASSETS00` ADD COLUMN `STATUSDEFF` VARCHAR(60) NULL;

CREATE TABLE IF NOT EXISTS `OPSWDB`.`ASSETS00FL` (
  `ASSET` INT(15) NOT NULL,
  `FLD` VARCHAR(50) NOT NULL,
  `VALSTR` VARCHAR(100) NULL,
  `VALNUM` DOUBLE NULL,
  `FLDESCR` VARCHAR(60) NULL,
  `TYPE` INT(1) NULL,
  PRIMARY KEY (`ASSET`, `FLD`),
  CONSTRAINT `fk_ASSETS00FL_1`
    FOREIGN KEY (`ASSET`)
    REFERENCES `OPSWDB`.`ASSETS00` (`ASSET`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

ALTER TABLE `OPSWDB`.`GRAM00` ADD COLUMN `INTERNALKEY_FLDS` VARCHAR(150) NULL;