/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.3.17-MariaDB : Database - cine
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cine` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `cine`;

/*Table structure for table `boletos` */

DROP TABLE IF EXISTS `boletos`;

CREATE TABLE `boletos` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Cantidad` int(11) NOT NULL,
  `Salaid` int(11) NOT NULL,
  `Peliculaid` int(11) NOT NULL,
  `horarioid` int(11) NOT NULL,
  `Precio` double NOT NULL,
  `Total` double NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Peliculaid` (`Peliculaid`),
  KEY `Salaid` (`Salaid`),
  KEY `horarioid` (`horarioid`),
  CONSTRAINT `boletos_ibfk_1` FOREIGN KEY (`Peliculaid`) REFERENCES `peliculas` (`Id`),
  CONSTRAINT `boletos_ibfk_2` FOREIGN KEY (`Salaid`) REFERENCES `salas` (`Id`),
  CONSTRAINT `boletos_ibfk_3` FOREIGN KEY (`horarioid`) REFERENCES `horarios` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `boletos` */

/*Table structure for table `horarios` */

DROP TABLE IF EXISTS `horarios`;

CREATE TABLE `horarios` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SalaId` int(11) NOT NULL,
  `PeliculaId` int(11) NOT NULL,
  `HoraInicial` time NOT NULL,
  `HoraFinal` time NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `PeliculaId` (`PeliculaId`),
  KEY `SalaId` (`SalaId`),
  CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`PeliculaId`) REFERENCES `peliculas` (`Id`),
  CONSTRAINT `horarios_ibfk_2` FOREIGN KEY (`SalaId`) REFERENCES `salas` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `horarios` */

/*Table structure for table `peliculas` */

DROP TABLE IF EXISTS `peliculas`;

CREATE TABLE `peliculas` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `peliculas` */

insert  into `peliculas`(`Id`,`Nombre`) values 
(1,'Guerra de Acero'),
(2,'Momias');

/*Table structure for table `salas` */

DROP TABLE IF EXISTS `salas`;

CREATE TABLE `salas` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroSala` varchar(5) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `Ocupados` int(11) NOT NULL DEFAULT 0,
  `Estado` enum('Ocupado','Libre','Disponble') NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `salas` */

/* Trigger structure for table `boletos` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Sala_Ocupados` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'%' */ /*!50003 TRIGGER `Sala_Ocupados` BEFORE INSERT ON `boletos` FOR EACH ROW BEGIN
    DECLARE mensajeError VARCHAR(255);
	if ( ( (SELECT Ocupados FROM salas WHERE Id= new.salaid) + new.cantidad) <= (SELECT Capacidad FROM salas WHERE Id= new.salaid)) then
		update salas set Ocupados = Ocupados + new.cantidad WHERE salas.id = new.Salaid;
		if ( (SELECT Ocupados FROM salas WHERE Id= new.salaid) = (SELECT Capacidad FROM salas WHERE Id= new.salaid) ) then
			update salas set Estado = 1 where salas.id = new.Salaid;
		else if (( SELECT Ocupados FROM salas WHERE Id= new.salaid) < ( SELECT Capacidad FROM salas WHERE Id= new.salaid)) THEN
			UPDATE salas SET Estado = 3 WHERE salas.id = new.salaid;
		end if;
		end if;
	else
		set mensajeError = "La sala esta llena";
		SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT = mensajeError;
	end if;
    END */$$


DELIMITER ;

/* Trigger structure for table `boletos` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Borrar_Boleto` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'%' */ /*!50003 TRIGGER `Borrar_Boleto` BEFORE DELETE ON `boletos` FOR EACH ROW BEGIN
		update salas set Ocupados = Ocupados - old.Cantidad WHERE Id=old.Salaid;
		if (( SELECT Ocupados FROM salas WHERE Id= old.Salaid) = 0) then
			UPDATE salas SET Estado = 2 WHERE salas.Id = old.Salaid;
		end if;

    END */$$


DELIMITER ;

/*!50106 set global event_scheduler = 1*/;

/* Event structure for event `Limpiar_Sala1` */

/*!50106 DROP EVENT IF EXISTS `Limpiar_Sala1`*/;

DELIMITER $$

/*!50106 CREATE DEFINER=`root`@`%` EVENT `Limpiar_Sala1` ON SCHEDULE EVERY 5 SECOND STARTS '2020-07-05 23:07:55' ON COMPLETION PRESERVE ENABLE DO BEGIN
		#delete from boletos where Salaid =(SELECT SalaId FROM horarios WHERE HoraFinal <= NOW() limit 1);
		#DELETE FROM horarios WHERE HoraFinal <= NOW() LIMIT 1;
	END */$$
DELIMITER ;

/* Event structure for event `Limpiar_Sala2` */

/*!50106 DROP EVENT IF EXISTS `Limpiar_Sala2`*/;

DELIMITER $$

/*!50106 CREATE DEFINER=`root`@`%` EVENT `Limpiar_Sala2` ON SCHEDULE EVERY 1 MINUTE STARTS '2020-07-06 00:04:28' ON COMPLETION PRESERVE ENABLE DO BEGIN
	    DECLARE maximo INT;
		DECLARE cont INT;
		SELECT MIN(Id)INTO cont FROM horarios;		
		SELECT MAX(Id) INTO maximo FROM horarios;
		WHILE cont <= maximo do
			IF((SELECT HoraFinal FROM horarios WHERE Id=cont) <= NOW()) THEN
				DELETE FROM boletos WHERE horarioid =(SELECT Id FROM horarios WHERE Id=cont);
			END IF;
		SET cont=cont+1;
		END WHILE;
	END */$$
DELIMITER ;

/* Event structure for event `xd4` */

/*!50106 DROP EVENT IF EXISTS `xd4`*/;

DELIMITER $$

/*!50106 CREATE DEFINER=`root`@`%` EVENT `xd4` ON SCHEDULE EVERY 5 SECOND STARTS '2020-07-06 00:21:19' ON COMPLETION PRESERVE ENABLE DO BEGIN
		#DECLARE maximo INT;
		#DECLARE cont INT;
		#SELECT MIN(Id)INTO cont FROM horarios;		
		#SELECT MAX(Id) INTO maximo FROM horarios;
		#WHILE cont <= maximo DO
		#	IF((SELECT HoraFinal FROM horarios WHERE Id=cont) <= NOW()) THEN
		#		UPDATE salas SET Estado = 2 WHERE Id = (SELECT SalaId FROM horarios WHERE Id=cont);
		#		UPDATE salas SET Ocupados = 0 WHERE Id = (SELECT SalaId FROM horarios WHERE Id=cont);
		#	END IF;
		#set cont = cont + 1;
		#END WHILE;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `Insert_Boletos` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insert_Boletos` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `Insert_Boletos`(
	in Cantidad int,
	in Salaid int,
	in Peliculaid int,
	in horarioid int,
	in Precio double)
BEGIN
		if ( (select Ocupados from salas where NumeroSala=Salaid) = (select Capacidad from salas WHERE Id=Salaid) ) then
			select "La Sala esta llena" as Error;
		else
			INSERT INTO `cine`.`boletos` (Cantidad,Salaid,Peliculaid,horarioid,Precio,Total,Fecha,Hora) VALUES (Cantidad,Salaid,Peliculaid,horarioid,Precio,(select Precio * Cantidad),now(),now());
		end if;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `Insert_Horario` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insert_Horario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `Insert_Horario`(
	IN Sala INT,
	IN Peliculaid INT,
	IN HoraIni TIME,
	IN HoraFin TIME)
BEGIN
	IF(HoraFin > HoraIni) THEN
		
		IF NOT EXISTS(SELECT * FROM horarios WHERE (SalaId = Sala) AND ((HoraFin BETWEEN  HoraInicial AND HoraFinal) OR (HoraIni BETWEEN  HoraInicial AND HoraFinal))) THEN
			INSERT INTO `cine`.`horarios` (SalaId,PeliculaId,HoraInicial,Horafinal) VALUES (Sala,Peliculaid,HoraIni,HoraFin);
		ELSE
			SELECT "Existe";
		END IF;
	ELSE
		SELECT "Hora error";
	END IF;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `Insert_Pelicula` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insert_Pelicula` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `Insert_Pelicula`(
	IN pelicula varchar(50))
BEGIN
		IF NOT EXISTS  (select Nombre from peliculas WHERE Nombre=pelicula) then
			INSERT INTO `cine`.`peliculas` (Nombre) values (pelicula);
		else
			select "Ya existe" as error;
		end if;
	END */$$
DELIMITER ;

/* Procedure structure for procedure `Insert_Sala` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insert_Sala` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `Insert_Sala`(
	in Numero varchar(5),
	in Capacidad int)
BEGIN
		IF NOT EXISTS  (SELECT NumeroSala FROM salas WHERE NumeroSala=Numero) THEN
			if (capacidad !=0) then
				INSERT INTO `cine`.`salas` (NumeroSala,Capacidad,Ocupados,Estado) VALUES (Numero,Capacidad,0,2);
			else
				select "Capacidad Erronea" as Error;
			END IF;
		ELSE
			SELECT "Ya existe esa Sala" AS ERROR;
		END IF;
		
		
	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
