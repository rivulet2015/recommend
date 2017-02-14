CREATE TABLE `recommend_record` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`recommendation_id` VARCHAR(50) NOT NULL,
	`group_id` INT(11) NOT NULL,
	`created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3;
