


ALTER TABLE `OPSWDB`.`GRAM01` ADD COLUMN `DATE_FORMAT` VARCHAR(30);
ALTER TABLE `OPSWDB`.`SYMB` ADD COLUMN `EMAIL` VARCHAR(60);

ALTER TABLE `OPSWDB`.`SYMB` ADD COLUMN `DATE_CREATE` DATETIME NULL;
ALTER TABLE `OPSWDB`.`SYMB` ADD COLUMN `USER_CREATE` VARCHAR(45) NULL;
ALTER TABLE `OPSWDB`.`SYMB` ADD COLUMN `DATE_MODIFY` DATETIME NULL;
ALTER TABLE `OPSWDB`.`SYMB` ADD COLUMN `USER_MODIFY` VARCHAR(45) NULL;
