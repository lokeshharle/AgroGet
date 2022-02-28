-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: agroget
-- ------------------------------------------------------
-- Server version	8.0.27

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

--
-- Table structure for table `renter_info_tbl`
--

DROP TABLE IF EXISTS `renter_info_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `renter_info_tbl` (
  `renter_id` int NOT NULL AUTO_INCREMENT,
  `renter_fname` varchar(20) NOT NULL,
  `renter_lname` varchar(20) NOT NULL,
  `renter_mobile` varchar(10) NOT NULL,
  `renter_email` varchar(20) NOT NULL,
  `renter_username` varchar(50) NOT NULL,
  `renter_password` varchar(20) NOT NULL,
  `renter_address` varchar(100) NOT NULL,
  `renter_shop_details` varchar(100) NOT NULL,
  `renter_shop_image_id` int DEFAULT NULL,
  `renter_is_approved` tinyint(1) NOT NULL,
  PRIMARY KEY (`renter_id`),
  UNIQUE KEY `renter_email` (`renter_email`),
  UNIQUE KEY `renter_mobile` (`renter_mobile`),
  KEY `renter_shop_image_id` (`renter_shop_image_id`),
  CONSTRAINT `renter_info_tbl_ibfk_1` FOREIGN KEY (`renter_shop_image_id`) REFERENCES `image_info_tbl` (`image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-28 23:23:31
