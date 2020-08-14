/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.13-MariaDB : Database - multivideo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`multivideo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `multivideo`;

/*Table structure for table `clientes` */

DROP TABLE IF EXISTS `clientes`;

CREATE TABLE `clientes` (
  `ine` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  PRIMARY KEY (`ine`),
  KEY `telefono` (`telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `clientes` */

insert  into `clientes`(`ine`,`nombre`,`telefono`) values 
('ine01','david','6543219875'),
('ine02','juan','1234567895'),
('ine03','pedro','1231231235');

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
  PRIMARY KEY (`idcompra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `compras` */

/*Table structure for table `inventario` */

DROP TABLE IF EXISTS `inventario`;

CREATE TABLE `inventario` (
  `idinventario` int(11) NOT NULL AUTO_INCREMENT,
  `idpelicula` int(11) DEFAULT NULL,
  `idproducto` int(11) DEFAULT NULL,
  `cantidad_pelicula` int(11) DEFAULT NULL,
  `cantidad_producto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinventario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `inventario` */

/*Table structure for table `peliculas` */

DROP TABLE IF EXISTS `peliculas`;

CREATE TABLE `peliculas` (
  `idpelicula` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `genero` varchar(25) NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idpelicula`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `peliculas` */

insert  into `peliculas`(`idpelicula`,`nombre`,`genero`,`precio`,`cantidad`) values 
('1','nemo','infantilxd',50,10),
('2','kingsman','accion',60,15),
('3','nose','nose',10,50);

/*Table structure for table `productos` */

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `idproducto` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `productos` */

insert  into `productos`(`idproducto`,`nombre`,`precio`,`cantidad`) values 
('1','camisa',40,99),
('2','historieta',25,99);

/*Table structure for table `rentas` */

DROP TABLE IF EXISTS `rentas`;

CREATE TABLE `rentas` (
  `idrenta` int(11) NOT NULL AUTO_INCREMENT,
  `ine` varchar(50) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `nombre_peli` varchar(50) NOT NULL,
  `fechainicio` varchar(11) NOT NULL,
  `fechafin` varchar(11) NOT NULL,
  PRIMARY KEY (`idrenta`),
  KEY `ine` (`ine`),
  KEY `nombre_peli` (`nombre_peli`),
  KEY `telefono` (`telefono`),
  CONSTRAINT `ine` FOREIGN KEY (`ine`) REFERENCES `clientes` (`ine`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rentas_ibfk_1` FOREIGN KEY (`nombre_peli`) REFERENCES `peliculas` (`nombre`),
  CONSTRAINT `rentas_ibfk_2` FOREIGN KEY (`telefono`) REFERENCES `clientes` (`telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `rentas` */

insert  into `rentas`(`idrenta`,`ine`,`telefono`,`nombre_peli`,`fechainicio`,`fechafin`) values 
(1,'ine01','6543219875','kingsman','2020-08-10','2020-08-15');

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
			INSERT INTO `multivideo`.`clientes` (ine, nombre, telefono)
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
		
			insert into `multivideo`.`inventario` (idpelicula, idproducto, cantidad_pelicula, cantidad_producto)
			values (idpeliculaIN, idproductoIN, cantidad_peliculaIN, cantidad_productoIN);
			
		elseif NOT EXISTS (SELECT idproducto FROM inventario WHERE idproducto=idproductoIN) THEN
		
			INSERT INTO `multivideo`.`inventario` (idpelicula, idproducto, cantidad_pelicula, cantidad_producto)
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
	in idpeliculaIN varchar(50),
	IN nombreIN VARCHAR(50),
	in generoIN varchar(25), 
	IN precioIN FLOAT,
	IN cantidadIN INT
    )
BEGIN

		IF NOT EXISTS (SELECT nombre FROM peliculas WHERE nombre=nombreIN) THEN
			INSERT INTO `multivideo`.`peliculas` (idpelicula,nombre,genero, precio, cantidad)
			VALUES (idpeliculaIN,nombreIN,generoIN, precioIN, cantidadIN);
		ELSE
			SELECT "PELICULA YA REGISTRADO" AS ERROR;
		END IF;

	END */$$
DELIMITER ;

/* Procedure structure for procedure `Insertar_Productos` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insertar_Productos` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar_Productos`(
	in idproductoIN varchar(50),
	in nombreIN varchar(50), 
	in precioIN float,
	in cantidadIN int
    )
BEGIN

		IF NOT EXISTS (SELECT nombre FROM productos WHERE nombre=nombreIN) THEN
			INSERT INTO `multivideo`.`productos` (idproducto, nombre, precio, cantidad)
			VALUES (idproductoIN, nombreIN, precioIN, cantidadIN);
		ELSE
			SELECT "PRODUCTO YA REGISTRADO" AS ERROR;
		END IF;

	END */$$
DELIMITER ;

/* Procedure structure for procedure `Insertar_Renta` */

/*!50003 DROP PROCEDURE IF EXISTS  `Insertar_Renta` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar_Renta`(
	IN ineIN VARCHAR(50),
	in telefonoIN varchar(25),
	IN nombre_peliIN varchar(50),
	IN fechainicioIN varchar(11),
	IN fechafinIN varchar(11)
    )
BEGIN

	declare cantidadStockPeli int default 0;
	
	select cantidad into cantidadStockPeli from peliculas
		where nombre = nombre_peliIN;
	
	if cantidadStockPeli > 0 then

		INSERT INTO `multivideo`.`rentas` (ine, telefono,nombre_peli,fechainicio,fechafin)
		VALUES (ineIN, telefonoIN,nombre_peliIN,fechainicioIN,fechafinIN);	
		
	else
		select "NO HAY EN STOCK" as ERROR;
	end if;
	
	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
