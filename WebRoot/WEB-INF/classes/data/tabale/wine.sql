
DROP TABLE IF EXISTS `wine`;
CREATE TABLE `wine` (
	`id` int(11),
	`name` varchar(100),
	`content` varchar(2000),
	`price` float DEFAULT '1000',
	`dis_price` float DEFAULT '1000',
	`birthday` int(11) DEFAULT '0',
	`feel` tinyint(4) DEFAULT '1',
	`flavor` tinyint(4) DEFAULT '1',
	`degree` tinyint(4) DEFAULT '50',
	`uses` tinyint(4) DEFAULT '1',
	`meat` tinyint(4) DEFAULT '1',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;