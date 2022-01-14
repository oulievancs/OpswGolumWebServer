/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  oulis
 * Created: Jan 13, 2022
 */

IF NOT EXISTS( SELECT NULL
            FROM `INFORMATION_SCHEMA`.`COLUMNS`
           WHERE `table_name` = 'GRAM01'
             AND `table_schema` = 'OPSWDB'
             AND `column_name` = 'DATE_FORMAT')  THEN
 
  ALTER TABLE `OPSWDB`.`GRAM01` ADD COLUMN `DATE_FORMAT` VARCHAR(30);
 
END IF;
