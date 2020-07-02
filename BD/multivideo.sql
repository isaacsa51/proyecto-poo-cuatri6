-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-07-2020 a las 05:18:12
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `multivideo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `INE` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `idproducto_comp` varchar(20) NOT NULL,
  `idpelicula_comp` varchar(20) NOT NULL,
  `cantidad` float NOT NULL,
  `fecha` date NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `idpelicula_inv` varchar(20) NOT NULL,
  `idproducto_inv` varchar(20) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `idpelicula` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idproducto` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `renta`
--

CREATE TABLE `renta` (
  `ine_cliente` varchar(20) NOT NULL,
  `idpelicula_renta` varchar(20) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `usuario`, `password`) VALUES
(1, 'root', 'root'),
(2, 'admin', 'test123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_ventas` int(11) NOT NULL,
  `INE` varchar(20) NOT NULL,
  `idproducto` varchar(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`INE`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`idproducto_comp`),
  ADD KEY `idproducto_comp` (`idproducto_comp`),
  ADD KEY `idpelicula_comp` (`idpelicula_comp`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`idpelicula_inv`),
  ADD KEY `idpelicula_inv` (`idpelicula_inv`),
  ADD KEY `idproducto_inv` (`idproducto_inv`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`idpelicula`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idproducto`);

--
-- Indices de la tabla `renta`
--
ALTER TABLE `renta`
  ADD PRIMARY KEY (`ine_cliente`),
  ADD KEY `ine_cliente` (`ine_cliente`),
  ADD KEY `idpelicula_renta` (`idpelicula_renta`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuario`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_ventas`),
  ADD KEY `id_clientes` (`INE`),
  ADD KEY `id_productos` (`idproducto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_ventas` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`INE`) REFERENCES `renta` (`ine_cliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`idproducto_comp`) REFERENCES `productos` (`idproducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compras_ibfk_2` FOREIGN KEY (`idpelicula_comp`) REFERENCES `peliculas` (`idpelicula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`idpelicula_inv`) REFERENCES `peliculas` (`idpelicula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inventario_ibfk_2` FOREIGN KEY (`idproducto_inv`) REFERENCES `productos` (`idproducto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `renta`
--
ALTER TABLE `renta`
  ADD CONSTRAINT `renta_ibfk_1` FOREIGN KEY (`idpelicula_renta`) REFERENCES `peliculas` (`idpelicula`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
