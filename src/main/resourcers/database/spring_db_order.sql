-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: spring_db
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order` (
  `id_order` bigint(20) NOT NULL,
  `cost` int(11) NOT NULL,
  `cost_with_discount` int(11) NOT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `id_address_arrive` bigint(20) DEFAULT NULL,
  `id_address_departure` bigint(20) DEFAULT NULL,
  `id_client` bigint(20) DEFAULT NULL,
  `id_coupon` bigint(20) DEFAULT NULL,
  `id_driver` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  KEY `FKaa06vfsqcarl8qgvcr9y5arxr` (`id_address_arrive`),
  KEY `FKipj7qf032eidxcsfgwbpm9mqc` (`id_address_departure`),
  KEY `FK9w0um46gdgfr630tq0ori6e9e` (`id_client`),
  KEY `FKeurrgfpsxoy25wjn3s9ugsp21` (`id_coupon`),
  KEY `FK15bwoayw5cicw8b6q3odqrgdg` (`id_driver`),
  CONSTRAINT `FK15bwoayw5cicw8b6q3odqrgdg` FOREIGN KEY (`id_driver`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FK9w0um46gdgfr630tq0ori6e9e` FOREIGN KEY (`id_client`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKaa06vfsqcarl8qgvcr9y5arxr` FOREIGN KEY (`id_address_arrive`) REFERENCES `address` (`id_address`),
  CONSTRAINT `FKeurrgfpsxoy25wjn3s9ugsp21` FOREIGN KEY (`id_coupon`) REFERENCES `coupon` (`id_coupon`),
  CONSTRAINT `FKipj7qf032eidxcsfgwbpm9mqc` FOREIGN KEY (`id_address_departure`) REFERENCES `address` (`id_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,123,123,'COMPLETE',1,2,3,NULL,1),(2,200,190,'COMPLETE',1,2,3,1,2),(3,423,213,'COMPLETE',3,4,3,1,1),(4,23,23,'COMPLETE',5,3,3,1,2),(5,312,123,'COMPLETE',3,2,3,NULL,1),(6,123,432,'COMPLETE',2,4,3,2,2),(7,234,332,'COMPLETE',4,5,4,NULL,1),(8,123,123,'COMPLETE',5,6,4,NULL,2),(9,131,321,'COMPLETE',2,1,4,NULL,1),(10,333,123,'COMPLETE',1,3,4,NULL,2),(11,543,452,'COMPLETE',1,3,4,NULL,1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-19 10:57:46
