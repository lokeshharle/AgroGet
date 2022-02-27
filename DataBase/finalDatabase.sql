CREATE DATABASE  IF NOT EXISTS `agroget` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agroget`;
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
-- Table structure for table `equipment_info_tbl`
--

DROP TABLE IF EXISTS `equipment_info_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment_info_tbl` (
  `equipment_id` int NOT NULL AUTO_INCREMENT,
  `equipment_name` varchar(20) NOT NULL,
  `equipment_type` varchar(20) NOT NULL,
  `equipment_rate_type` varchar(10) NOT NULL,
  `equipment_rate` varchar(20) NOT NULL,
  `equipment_deacription` varchar(255) DEFAULT NULL,
  `equipment_status` tinyint(1) NOT NULL,
  `renter_id` int DEFAULT NULL,
  PRIMARY KEY (`equipment_id`),
  KEY `renter_id` (`renter_id`),
  CONSTRAINT `equipment_info_tbl_ibfk_1` FOREIGN KEY (`renter_id`) REFERENCES `renter_info_tbl` (`renter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `farmer_info_tbl`
--

DROP TABLE IF EXISTS `farmer_info_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farmer_info_tbl` (
  `farmer_id` int NOT NULL AUTO_INCREMENT,
  `farmer_fname` varchar(20) NOT NULL,
  `farmer_lname` varchar(20) NOT NULL,
  `farmer_mobile` varchar(10) NOT NULL,
  `farmer_email` varchar(50) NOT NULL,
  `farmer_username` varchar(50) NOT NULL,
  `farmer_password` varchar(50) NOT NULL,
  `farmer_address` varchar(100) NOT NULL,
  `farmer_pincode` varchar(6) NOT NULL,
  `farmer_kissan_card_id` int DEFAULT NULL,
  PRIMARY KEY (`farmer_id`),
  UNIQUE KEY `farmer_email` (`farmer_email`),
  UNIQUE KEY `farmer_mobile` (`farmer_mobile`),
  KEY `farmer_kissan_card_id` (`farmer_kissan_card_id`),
  CONSTRAINT `farmer_info_tbl_ibfk_1` FOREIGN KEY (`farmer_kissan_card_id`) REFERENCES `image_info_tbl` (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `feedback_info_tbl`
--

DROP TABLE IF EXISTS `feedback_info_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback_info_tbl` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `farmer_id` int NOT NULL,
  `equipment_id` int NOT NULL,
  `feedback_rating` int DEFAULT NULL,
  `feedback_comments` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `farmer_id` (`farmer_id`),
  KEY `equipment_id` (`equipment_id`),
  CONSTRAINT `feedback_info_tbl_ibfk_1` FOREIGN KEY (`farmer_id`) REFERENCES `farmer_info_tbl` (`farmer_id`),
  CONSTRAINT `feedback_info_tbl_ibfk_2` FOREIGN KEY (`equipment_id`) REFERENCES `equipment_info_tbl` (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `image_info_tbl`
--

DROP TABLE IF EXISTS `image_info_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_info_tbl` (
  `image_id` int NOT NULL AUTO_INCREMENT,
  `image_type` varchar(255) DEFAULT NULL,
  `image_reference_id` int DEFAULT NULL,
  `image_data` longblob,
  `image_description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `image_reference_id` (`image_reference_id`),
  CONSTRAINT `image_info_tbl_ibfk_1` FOREIGN KEY (`image_reference_id`) REFERENCES `farmer_info_tbl` (`farmer_id`),
  CONSTRAINT `image_info_tbl_ibfk_2` FOREIGN KEY (`image_reference_id`) REFERENCES `equipment_info_tbl` (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_equipment_tbl`
--

DROP TABLE IF EXISTS `order_equipment_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_equipment_tbl` (
  `order_equipment_id` int NOT NULL AUTO_INCREMENT,
  `orderid` int NOT NULL,
  `equipment_id` int NOT NULL,
  `from_date` date NOT NULL,
  `from_time` time DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `to_time` time DEFAULT NULL,
  `order_equipment_status` tinyint(1) NOT NULL,
  `service_address` varchar(100) NOT NULL,
  `order_id` int DEFAULT NULL,
  PRIMARY KEY (`order_equipment_id`),
  KEY `order_id` (`order_id`),
  KEY `equipment_id` (`equipment_id`),
  CONSTRAINT `order_equipment_tbl_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_info_tbl` (`order_id`),
  CONSTRAINT `order_equipment_tbl_ibfk_2` FOREIGN KEY (`equipment_id`) REFERENCES `equipment_info_tbl` (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_info_tbl`
--

DROP TABLE IF EXISTS `order_info_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_info_tbl` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `farmer_id` int NOT NULL,
  `order_total_cost` double DEFAULT NULL,
  `order_status` tinyint(1) DEFAULT NULL,
  `order_date` date NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `farmer_id` (`farmer_id`),
  CONSTRAINT `order_info_tbl_ibfk_1` FOREIGN KEY (`farmer_id`) REFERENCES `farmer_info_tbl` (`farmer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `renter_shop_image_id` int NOT NULL,
  `renter_is_approved` tinyint(1) NOT NULL,
  PRIMARY KEY (`renter_id`),
  UNIQUE KEY `renter_email` (`renter_email`),
  UNIQUE KEY `renter_mobile` (`renter_mobile`),
  KEY `renter_shop_image_id` (`renter_shop_image_id`),
  CONSTRAINT `renter_info_tbl_ibfk_1` FOREIGN KEY (`renter_shop_image_id`) REFERENCES `image_info_tbl` (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-27 23:57:39
