/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.13-MariaDB : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `test`;

/*Table structure for table `clientes` */

DROP TABLE IF EXISTS `clientes`;

CREATE TABLE `clientes` (
  `ine` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  PRIMARY KEY (`ine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `clientes` */

insert  into `clientes`(`ine`,`nombre`,`telefono`) values 
('123456','pedro','6543219875'),
('1234567','david','6543216542'),
('ine34','juan','1234567895');

/*Table structure for table `compras` */

DROP TABLE IF EXISTS `compras`;

CREATE TABLE `compras` (
  `idcompra` int(11) NOT NULL AUTO_INCREMENT,
  `idrenta` int(11) DEFAULT NULL,
  `idproducto` int(11) DEFAULT NULL,
  `idpelicula` int(11) DEFAULT NULL,
  `cantidad_renta` int(11) DEFAULT NULL,
  `cantidad_producto` int(11) DEFAULT NULL,
  `cantidad_pelicula` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`idcompra`),
  KEY `idrenta` (`idrenta`),
  KEY `idproducto` (`idproducto`),
  KEY `idpelicula` (`idpelicula`),
  CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`idpelicula`) REFERENCES `peliculas` (`idpelicula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idproducto` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idrenta` FOREIGN KEY (`idrenta`) REFERENCES `rentas` (`idrenta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `compras` */

insert  into `compras`(`idcompra`,`idrenta`,`idproducto`,`idpelicula`,`cantidad_renta`,`cantidad_producto`,`cantidad_pelicula`,`fecha`,`total`) values 
(2,1,NULL,1,1,NULL,NULL,'2020-08-11',100);

/*Table structure for table `inventario` */

DROP TABLE IF EXISTS `inventario`;

CREATE TABLE `inventario` (
  `idinventario` int(11) NOT NULL AUTO_INCREMENT,
  `idpelicula` int(11) DEFAULT NULL,
  `idproducto` int(11) DEFAULT NULL,
  `cantidad_pelicula` int(11) DEFAULT NULL,
  `cantidad_producto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinventario`),
  KEY `idpelicula` (`idpelicula`),
  KEY `idproducto` (`idproducto`),
  CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`idpelicula`) REFERENCES `peliculas` (`idpelicula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `inventario_ibfk_2` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `inventario` */

insert  into `inventario`(`idinventario`,`idpelicula`,`idproducto`,`cantidad_pelicula`,`cantidad_producto`) values 
(1,1,1,99,99),
(2,2,NULL,99,NULL),
(5,NULL,2,NULL,99);

/*Table structure for table `peliculas` */

DROP TABLE IF EXISTS `peliculas`;

CREATE TABLE `peliculas` (
  `idpelicula` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `genero` varchar(25) NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idpelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `peliculas` */

insert  into `peliculas`(`idpelicula`,`nombre`,`genero`,`precio`,`cantidad`) values 
(1,'nemo','nose',100,99),
(2,'toy story 1','nose',100,99),
(3,'kingsman','accion',45,10);

/*Table structure for table `productos` */

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `productos` */

insert  into `productos`(`idproducto`,`nombre`,`precio`,`cantidad`) values 
(1,'camisa',50,99),
(2,'perro',30,99),
(3,'camisa roja',50,7);

/*Table structure for table `rentas` */

DROP TABLE IF EXISTS `rentas`;

CREATE TABLE `rentas` (
  `idrenta` int(11) NOT NULL AUTO_INCREMENT,
  `ine` varchar(50) NOT NULL,
  `idpelicula` int(11) NOT NULL,
  `fechainicio` date NOT NULL,
  `fechafin` date NOT NULL,
  PRIMARY KEY (`idrenta`),
  KEY `ine` (`ine`),
  KEY `idpelicula` (`idpelicula`),
  CONSTRAINT `idpelicula` FOREIGN KEY (`idpelicula`) REFERENCES `peliculas` (`idpelicula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ine` FOREIGN KEY (`ine`) REFERENCES `clientes` (`ine`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `rentas` */

insert  into `rentas`(`idrenta`,`ine`,`idpelicula`,`fechainicio`,`fechafin`) values 
(1,'123456',1,'2020-08-10','2020-08-10'),
(3,'1234567',2,'2020-08-11','2020-08-11'),
(4,'1234567',1,'2020-08-11','2020-08-11'),
(5,'1234567',1,'2020-08-11','2020-08-11');

/* Procedure structure for procedure `Insertar_Clientes` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insertar_Clientes` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar_Clientes`(
	IN ineIN varchar(50),
	IN nombreIN VARCHAR(50),
	IN telefonoIN VARCHAR(25)
    )
BEGIN

		IF NOT EXISTS (SELECT ine FROM clientes WHERE ine=ineIN) THEN
			INSERT INTO `test`.`clientes` (ine, nombre, telefono)
			VALUES (ineIN, nombreIN, telefonoIN);
		ELSE
			SELECT "USUARIO YA REGISTRADO" AS ERROR;
		END IF;
		
	END */$$
DELIMITER ;

/* Procedure structure for procedure `Insertar_Inventario` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insertar_Inventario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar_Inventario`(
	in idpeliculaIN int,
	in idproductoIN int,
	in cantidad_peliculaIN int,
	in cantidad_productoIN int
    )
BEGIN
		
		if not exists (select idpelicula from inventario where idpelicula=idpeliculaIN) then
		
			insert into `test`.`inventario` (idpelicula, idproducto, cantidad_pelicula, cantidad_producto)
			values (idpeliculaIN, idproductoIN, cantidad_peliculaIN, cantidad_productoIN);
			
		elseif NOT EXISTS (SELECT idproducto FROM inventario WHERE idproducto=idproductoIN) THEN
		
			INSERT INTO `test`.`inventario` (idpelicula, idproducto, cantidad_pelicula, cantidad_producto)
			VALUES (idpeliculaIN, idproductoIN, cantidad_peliculaIN, cantidad_productoIN);
			
		else
		
			select "PRODUCTO YA REGISTRADO" as ERROR;
			
		end if;	
	END */$$
DELIMITER ;

/* Procedure structure for procedure `Insertar_Peliculas` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insertar_Peliculas` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar_Peliculas`(
	IN nombreIN VARCHAR(50),
	in generoIN varchar(25), 
	IN precioIN FLOAT,
	IN cantidadIN INT
    )
BEGIN

		IF NOT EXISTS (SELECT nombre FROM peliculas WHERE nombre=nombreIN) THEN
			INSERT INTO `test`.`peliculas` (nombre,genero, precio, cantidad)
			VALUES (nombreIN,generoIN, precioIN, cantidadIN);
		ELSE
			SELECT "PELICULA YA REGISTRADO" AS ERROR;
		END IF;

	END */$$
DELIMITER ;

/* Procedure structure for procedure `Insertar_Productos` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insertar_Productos` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar_Productos`(
	in nombreIN varchar(50), 
	in precioIN float,
	in cantidadIN int
    )
BEGIN

		IF NOT EXISTS (SELECT nombre FROM productos WHERE nombre=nombreIN) THEN
			INSERT INTO `test`.`productos` (nombre, precio, cantidad)
			VALUES (nombreIN, precioIN, cantidadIN);
		ELSE
			SELECT "PRODUCTO YA REGISTRADO" AS ERROR;
		END IF;

	END */$$
DELIMITER ;

/* Procedure structure for procedure `Insertar_Renta` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insertar_Renta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar_Renta`(
	IN ineIN INT,
	IN idpeliculaIN INT,
	IN fechainicioIN TIME,
	IN fechafinIN TIME
    )
BEGIN

	declare cantidadStockPeli int default 0;
	
	select cantidad into cantidadStockPeli from peliculas
		where idpelicula = idpeliculaIN;
	
	if cantidadStockPeli > 0 then
	
		INSERT INTO `test`.`rentas` (ine,idpelicula,fechainicio,fechafin)
		VALUES (ineIN,idpeliculaIN,fechainicioIN,fechafinIN);
		
	else
		select "NO HAY EN STOCK" as ERROR;
	end if;
	
	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
