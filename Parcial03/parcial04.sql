-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: parcial04
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

create database parcial04;
use parcial04;

--
-- Table structure for table `clientes`
--
DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idcliente` int(11) NOT NULL,
  `nombrecliente` varchar(255) NOT NULL,
  `apellidocliente` varchar(255) NOT NULL,
  `duicliente` varchar(10) NOT NULL,
  `telefonocliente` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Lorem','Ipsum','0000000-1','2233-4455');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idproducto` int(11) NOT NULL,
  `nombreproducto` varchar(255) NOT NULL,
  `codigoproducto` varchar(40) NOT NULL,
  `marcaproducto` varchar(255) NOT NULL,
  `categoriaproducto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Queso Duro Blanco','QDB-VQ','La Vaquita','Lacteos');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedores`
--

DROP TABLE IF EXISTS `vendedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedores` (
  `idvendedor` int(11) NOT NULL,
  `nombresvendedor` varchar(255) NOT NULL,
  `apellidosvendedor` varchar(255) NOT NULL,
  `codigovendedor` varchar(40) NOT NULL,
  `telefonovendedor` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedores`
--

LOCK TABLES `vendedores` WRITE;
/*!40000 ALTER TABLE `vendedores` DISABLE KEYS */;
INSERT INTO `vendedores` VALUES (1,'Dolor','Percent','DoLRPR-01','2233-4444');
/*!40000 ALTER TABLE `vendedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vista_listadoclientes`
--

DROP TABLE IF EXISTS `vista_listadoclientes`;
/*!50001 DROP VIEW IF EXISTS `vista_listadoclientes`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_listadoclientes` AS SELECT 
 1 AS `idcliente`,
 1 AS `nombrecliente`,
 1 AS `apellidocliente`,
 1 AS `duicliente`,
 1 AS `telefonocliente`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_listadoproductos`
--

DROP TABLE IF EXISTS `vista_listadoproductos`;
/*!50001 DROP VIEW IF EXISTS `vista_listadoproductos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_listadoproductos` AS SELECT 
 1 AS `idproducto`,
 1 AS `nombreproducto`,
 1 AS `codigoproducto`,
 1 AS `marcaproducto`,
 1 AS `categoriaproducto`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_listadovendedores`
--

DROP TABLE IF EXISTS `vista_listadovendedores`;
/*!50001 DROP VIEW IF EXISTS `vista_listadovendedores`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_listadovendedores` AS SELECT 
 1 AS `idvendedor`,
 1 AS `nombresvendedor`,
 1 AS `apellidosvendedor`,
 1 AS `codigovendedor`,
 1 AS `telefonovendedor`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'parcial04'
--

--
-- Dumping routines for database 'parcial04'
--
/*!50003 DROP PROCEDURE IF EXISTS `ConsultarListados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ConsultarListados`(IN `_tipolistado` INT)
BEGIN

-- PRODUCTOS

IF _tipolistado = 1 THEN

SELECT * FROM vista_listadoproductos;

END IF;

-- CLIENTES

IF _tipolistado = 2 THEN

SELECT * FROM vista_listadoclientes;

END IF;

-- VENDEDORES

IF _tipolistado = 3 THEN

SELECT * FROM vista_listadovendedores;

END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vista_listadoclientes`
--

/*!50001 DROP VIEW IF EXISTS `vista_listadoclientes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_listadoclientes` AS select `clientes`.`idcliente` AS `idcliente`,`clientes`.`nombrecliente` AS `nombrecliente`,`clientes`.`apellidocliente` AS `apellidocliente`,`clientes`.`duicliente` AS `duicliente`,`clientes`.`telefonocliente` AS `telefonocliente` from `clientes` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_listadoproductos`
--

/*!50001 DROP VIEW IF EXISTS `vista_listadoproductos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_listadoproductos` AS select `productos`.`idproducto` AS `idproducto`,`productos`.`nombreproducto` AS `nombreproducto`,`productos`.`codigoproducto` AS `codigoproducto`,`productos`.`marcaproducto` AS `marcaproducto`,`productos`.`categoriaproducto` AS `categoriaproducto` from `productos` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_listadovendedores`
--

/*!50001 DROP VIEW IF EXISTS `vista_listadovendedores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_listadovendedores` AS select `vendedores`.`idvendedor` AS `idvendedor`,`vendedores`.`nombresvendedor` AS `nombresvendedor`,`vendedores`.`apellidosvendedor` AS `apellidosvendedor`,`vendedores`.`codigovendedor` AS `codigovendedor`,`vendedores`.`telefonovendedor` AS `telefonovendedor` from `vendedores` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-17 16:36:26
