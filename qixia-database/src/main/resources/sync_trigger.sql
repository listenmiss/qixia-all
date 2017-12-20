
DROP TABLE IF EXISTS `sync_trigger`;
CREATE TABLE `sync_trigger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sync_name` varchar(255) NOT NULL,
  `sync_key` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;


DROP TRIGGER
IF EXISTS `t_afterinsert_on_approvel_manager`;

CREATE TRIGGER `t_afterinsert_on_approvel_manager` AFTER INSERT ON `approvel_manager` FOR EACH ROW
BEGIN
	INSERT INTO sync_trigger (sync_name, sync_key)
VALUES
	('approvel_manager', new.no);

END;




DROP TRIGGER
IF EXISTS `t_afterinsert_on_approvel_manageritem`;
DELIMITER ;;


CREATE TRIGGER `t_afterinsert_on_approvel_manageritem` AFTER INSERT ON `approvel_manageritem` FOR EACH ROW
BEGIN
	INSERT INTO sync_trigger (sync_name, sync_key)
VALUES
	(
		'approvel_manageritem',
		new. NO
	) ;
END;;



DROP TRIGGER IF EXISTS `t_afterinsert_on_approvel_matter`;
DELIMITER ;;
CREATE TRIGGER `t_afterinsert_on_approvel_matter` AFTER INSERT ON `approvel_matter` FOR EACH ROW BEGIN
	INSERT INTO sync_trigger (sync_name, sync_key)
VALUES
	(
		'approvel_matter',
		new.idx
	);


END
;;

DROP TRIGGER IF EXISTS `t_afterinsert_on_approvel_matter_stats`;
DELIMITER ;;
CREATE TRIGGER `t_afterinsert_on_approvel_matter_stats` AFTER INSERT ON `approvel_matter_stats` FOR EACH ROW BEGIN
	INSERT INTO sync_trigger (sync_name, sync_key)
VALUES
	(
		'approvel_matter_stats',
		new.idx
	);


END
;;

DROP TRIGGER IF EXISTS `t_afterinsert_on_approvel_user`;
DELIMITER ;;
CREATE TRIGGER `t_afterinsert_on_approvel_user` AFTER INSERT ON `approvel_user` FOR EACH ROW BEGIN
	INSERT INTO sync_trigger (sync_name, sync_key)
VALUES
	(
		'approvel_user',
		new.id
	);


END
;;
DELIMITER ;