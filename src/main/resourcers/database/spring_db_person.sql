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
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `person` (
  `dtype` varchar(31) NOT NULL,
  `person_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `driver_status` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `id_car` bigint(20) DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_car_UNIQUE` (`id_car`),
  CONSTRAINT `FKmh7pctk4jwnjkbllfjbn2psac` FOREIGN KEY (`id_car`) REFERENCES `car` (`id_car`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('Driver',1,'Андрій','qwerty','+380983445123','Карпенко',NULL,'free','Олександрович',1,'DRIVER',_binary ''),('Driver',2,'Олена','asdfgh','+380923454352','Пацевко',NULL,'free','Ігорівна',2,'DRIVER',_binary ''),('Client',3,'Орест','rootroot','+380976970365','Шемелюк','orestshemelyuk@gmail.com',NULL,NULL,NULL,'CLIENT',_binary ''),('Client',4,'Назар','nazar12','+380953523320','Щур','nazar34shcher@gmail.com',NULL,NULL,NULL,'CLIENT',_binary ''),('Client',14,'Захар','berkut','+3809645678','Беркут','berkut@dssa.com',NULL,NULL,NULL,'CLIENT',_binary ''),('Client',16,'wqe','qwerty','+380435345342','qwe','birdmawnblackme@gmail.com',NULL,NULL,NULL,'CLIENT',_binary '');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-19 10:57:43
