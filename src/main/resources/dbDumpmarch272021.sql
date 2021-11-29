CREATE DATABASE  IF NOT EXISTS `eventadministrationdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `eventadministrationdb`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: eventadministrationdb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `actiontype`
--

DROP TABLE IF EXISTS `actiontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actiontype` (
  `actiontype_id` int NOT NULL AUTO_INCREMENT,
  `actiontype_uuid` varchar(45) NOT NULL,
  `actiontype_lookup_id` varchar(45) DEFAULT NULL,
  `actiontype_Lookup_description` varchar(45) DEFAULT NULL,
  `actiontype_supply_category_level1_code` varchar(45) DEFAULT NULL,
  `actiontype_supply_category_level2_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`actiontype_id`,`actiontype_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actiontype`
--

LOCK TABLES `actiontype` WRITE;
/*!40000 ALTER TABLE `actiontype` DISABLE KEYS */;
/*!40000 ALTER TABLE `actiontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `address_uuid` varchar(45) NOT NULL,
  `address_line1` varchar(45) DEFAULT NULL,
  `address_line2` varchar(45) DEFAULT NULL,
  `address_state` varchar(45) DEFAULT NULL,
  `address_city` varchar(45) DEFAULT NULL,
  `address_country` varchar(45) DEFAULT NULL,
  `address_zip` varchar(45) DEFAULT NULL,
  `address_zipplus4` varchar(45) DEFAULT NULL,
  `address_countrycode` varchar(45) DEFAULT NULL,
  `address_statecode` varchar(45) DEFAULT NULL,
  `address_line3` varchar(45) DEFAULT NULL,
  `address_line4` varchar(45) DEFAULT NULL,
  `address_type_uuid` varchar(45) DEFAULT NULL,
  `address_source_type` varchar(45) DEFAULT NULL,
  `address_source_ssytem` varchar(45) DEFAULT NULL,
  `address_etl_load_nbr` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`address_id`,`address_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `address_BEFORE_INSERT` BEFORE INSERT ON `address` FOR EACH ROW BEGIN


if new.address_uuid is null  then 
set new.address_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `address_type`
--

DROP TABLE IF EXISTS `address_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_type` (
  `address_type_id` int NOT NULL AUTO_INCREMENT,
  `address_type_uuid` varchar(45) NOT NULL,
  `address_type_name` varchar(45) DEFAULT NULL,
  `address_type_short_description` varchar(45) DEFAULT NULL,
  `address_type_lond description` varchar(45) DEFAULT NULL,
  `address_type_code` varchar(45) DEFAULT 'USER',
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`address_type_id`,`address_type_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_type`
--

LOCK TABLES `address_type` WRITE;
/*!40000 ALTER TABLE `address_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `address_type_BEFORE_INSERT` BEFORE INSERT ON `address_type` FOR EACH ROW BEGIN

if new.address_type_uuid is null  then 
set new.address_type_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `address_user`
--

DROP TABLE IF EXISTS `address_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_user` (
  `address_user_id` int NOT NULL AUTO_INCREMENT,
  `address_user_uuid` varchar(45) NOT NULL,
  `address_uuid` varchar(45) NOT NULL,
  `user_uuid` varchar(45) NOT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`address_user_id`,`address_user_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_user`
--

LOCK TABLES `address_user` WRITE;
/*!40000 ALTER TABLE `address_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `address_user_BIT` BEFORE INSERT ON `address_user` FOR EACH ROW BEGIN
if new.address_user_uuid is null  then 
set new.address_user_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `application_id` int NOT NULL AUTO_INCREMENT,
  `application_uuid` varchar(45) NOT NULL,
  `application_applno` varchar(45) DEFAULT NULL,
  `application_appl_type` varchar(45) DEFAULT NULL,
  `application_public_notes` varchar(45) DEFAULT NULL,
  `application_sponsor_name` varchar(4000) DEFAULT NULL,
  `create_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`application_id`,`application_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=24234 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_doc`
--

DROP TABLE IF EXISTS `application_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application_doc` (
  `application_doc_id` int NOT NULL AUTO_INCREMENT,
  `application_doc_uuid` varchar(45) NOT NULL,
  `application_doc_docid` varchar(45) DEFAULT NULL,
  `application_doc_doctype_id` varchar(45) DEFAULT NULL,
  `application_doc_applno` varchar(45) DEFAULT NULL,
  `application_doc_submission_type` varchar(45) DEFAULT NULL,
  `application_doc_submission_number` varchar(45) DEFAULT NULL,
  `application_doc_doc_title` varchar(45) DEFAULT NULL,
  `application_doc_url` varchar(4000) DEFAULT NULL,
  `application_doc_doc_date` datetime DEFAULT NULL,
  `create_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`application_doc_id`,`application_doc_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4483 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_doc`
--

LOCK TABLES `application_doc` WRITE;
/*!40000 ALTER TABLE `application_doc` DISABLE KEYS */;
/*!40000 ALTER TABLE `application_doc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_doctype_lookup`
--

DROP TABLE IF EXISTS `application_doctype_lookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application_doctype_lookup` (
  `application_doctype_lookup_id` int NOT NULL AUTO_INCREMENT,
  `application_doctype_lookup_uuid` varchar(45) NOT NULL,
  `application_doctype_lookup_lookup_id` varchar(45) DEFAULT NULL,
  `application_doctype_lookup_description` varchar(500) DEFAULT NULL,
  `create_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`application_doctype_lookup_id`,`application_doctype_lookup_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_doctype_lookup`
--

LOCK TABLES `application_doctype_lookup` WRITE;
/*!40000 ALTER TABLE `application_doctype_lookup` DISABLE KEYS */;
/*!40000 ALTER TABLE `application_doctype_lookup` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `application_doctype_lookup_BiT` BEFORE INSERT ON `application_doctype_lookup` FOR EACH ROW BEGIN
if (new.application_doctype_lookup_uuid is null) ||  (new.application_doctype_lookup_uuid = '') then  
set new.application_doctype_lookup_uuid = uuid();

end if;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cities` (
  `cities_id` int NOT NULL AUTO_INCREMENT,
  `cities_uuid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `id` int unsigned NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `state_id` int unsigned NOT NULL,
  `state_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `country_id` int unsigned NOT NULL,
  `country_code` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `latitude` decimal(10,8) NOT NULL,
  `longitude` decimal(11,8) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '2014-01-01 01:01:01',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flag` int NOT NULL DEFAULT '1',
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'script',
  `updated_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'data load',
  `active_status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'Y',
  `wikiDataId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cities_id`,`cities_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=144275 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_details`
--

DROP TABLE IF EXISTS `contact_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_details` (
  `contact_details_id` int NOT NULL,
  `contact_details_uuid` varchar(45) DEFAULT NULL,
  `contact_details_name` varchar(45) DEFAULT NULL,
  `contact_details_details` varchar(45) DEFAULT NULL,
  `contact_details_description` varchar(45) DEFAULT NULL,
  `contact_type_uuid` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'Y',
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`contact_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_details`
--

LOCK TABLES `contact_details` WRITE;
/*!40000 ALTER TABLE `contact_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_type`
--

DROP TABLE IF EXISTS `contact_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_type` (
  `contact_type_id` int NOT NULL AUTO_INCREMENT,
  `contact_type_uuid` varchar(45) NOT NULL,
  `contact_type_name` varchar(45) DEFAULT NULL,
  `contact_type_short_description` varchar(45) DEFAULT NULL,
  `contact_type_description` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`contact_type_id`,`contact_type_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_type`
--

LOCK TABLES `contact_type` WRITE;
/*!40000 ALTER TABLE `contact_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `countries_id` int NOT NULL AUTO_INCREMENT,
  `countries_uuid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `id` int unsigned NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `iso3` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `iso2` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phonecode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `capital` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `currency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `native` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `emoji` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `emojiU` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flag` int NOT NULL DEFAULT '1',
  `wikiDataId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'Y',
  `created_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'script',
  `updated_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'data load',
  PRIMARY KEY (`countries_id`,`countries_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_contact_user`
--

DROP TABLE IF EXISTS `event_contact_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_contact_user` (
  `event_contact_id` int NOT NULL,
  `event_contact_uuid` varchar(45) DEFAULT NULL,
  `event_contact_type_uuid` varchar(45) DEFAULT NULL,
  `contact_type_uuid` varchar(45) DEFAULT NULL,
  `contact_type_name` varchar(45) DEFAULT NULL,
  `user_uuid` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `contact_details_uuid` varchar(45) DEFAULT NULL,
  `contact_details_name` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'Y',
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`event_contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_contact_user`
--

LOCK TABLES `event_contact_user` WRITE;
/*!40000 ALTER TABLE `event_contact_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_contact_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_schedule`
--

DROP TABLE IF EXISTS `event_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_schedule` (
  `event_schedule_id` int NOT NULL AUTO_INCREMENT,
  `event_schedule_uuid` varchar(45) NOT NULL,
  `event_schedule_name` varchar(45) NOT NULL,
  `event_schedule_description` varchar(45) DEFAULT NULL,
  `event_schedule_details` varchar(45) DEFAULT NULL,
  `event_schedule_time` datetime DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'Y',
  `event_schedule_Json` blob,
  PRIMARY KEY (`event_schedule_id`,`event_schedule_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_schedule`
--

LOCK TABLES `event_schedule` WRITE;
/*!40000 ALTER TABLE `event_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_schedule_status_type`
--

DROP TABLE IF EXISTS `event_schedule_status_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_schedule_status_type` (
  `event_schedule_status_type_id` int NOT NULL AUTO_INCREMENT,
  `event_schedule_status_type_uuid` varchar(45) NOT NULL,
  `event_schedule_status_type_name` varchar(45) DEFAULT NULL,
  `event_schedule_status_type_description` varchar(45) DEFAULT NULL,
  `event_schedule_status_type_short_description` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`event_schedule_status_type_id`,`event_schedule_status_type_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_schedule_status_type`
--

LOCK TABLES `event_schedule_status_type` WRITE;
/*!40000 ALTER TABLE `event_schedule_status_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_schedule_status_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_schedule_type_user`
--

DROP TABLE IF EXISTS `event_schedule_type_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_schedule_type_user` (
  `event_schedule_type_user_id` int NOT NULL AUTO_INCREMENT,
  `event_schedule_type_user_uuid` varchar(45) NOT NULL,
  `user_uuid` varchar(45) DEFAULT NULL,
  `event_schedule_uuid` varchar(45) DEFAULT NULL,
  `event_type_uuid` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`event_schedule_type_user_id`,`event_schedule_type_user_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_schedule_type_user`
--

LOCK TABLES `event_schedule_type_user` WRITE;
/*!40000 ALTER TABLE `event_schedule_type_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_schedule_type_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_type`
--

DROP TABLE IF EXISTS `event_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_type` (
  `event_type_id` int NOT NULL AUTO_INCREMENT,
  `event_type_uuid` varchar(45) NOT NULL,
  `event_type_name` varchar(45) DEFAULT NULL,
  `event_type_short_description` varchar(45) DEFAULT NULL,
  `event_type_description` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`event_type_id`,`event_type_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_type`
--

LOCK TABLES `event_type` WRITE;
/*!40000 ALTER TABLE `event_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group` (
  `group_id` int NOT NULL AUTO_INCREMENT,
  `group_uuid` varchar(45) NOT NULL,
  `group_short_name` varchar(45) DEFAULT NULL,
  `group_name` varchar(45) DEFAULT NULL,
  `group_desc` varchar(200) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `upated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) DEFAULT 'N',
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`group_id`,`group_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groups` (
  `group_id` int NOT NULL AUTO_INCREMENT,
  `group_uuid` varchar(45) NOT NULL,
  `group_short_name` varchar(45) DEFAULT NULL,
  `group_name` varchar(45) DEFAULT NULL,
  `group_desc` varchar(200) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `upated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) DEFAULT 'N',
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`group_id`,`group_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'8539f428-4442-11eb-82e8-1d452938ef37','Test','Narayan','Check','2020-12-22 16:13:25','2020-12-22 16:13:25','Y',NULL,NULL),(2,'5204ad5c-45fe-11eb-bc64-61508000d620','Test','TestGroups','hah','2020-12-24 21:10:16','2020-12-24 21:10:16','Y',NULL,NULL);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `int_cmd`
--

DROP TABLE IF EXISTS `int_cmd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `int_cmd` (
  `int_cmd_id` int NOT NULL,
  `int_cmd_uuid` varchar(45) NOT NULL,
  `int_cmd_int_type_id` varchar(45) DEFAULT NULL,
  `int_cmd_int_type_uuid` varchar(45) DEFAULT NULL,
  `int_cmd_cmd` mediumtext,
  `int_cmd_cmd_userfriendlyname` varchar(45) NOT NULL,
  `int_cmd_blog` blob,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT NULL,
  `int_cmd_zebra_id` int DEFAULT NULL,
  `int_cmd_zebra_uuid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_cmd_id`,`int_cmd_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `int_cmd`
--

LOCK TABLES `int_cmd` WRITE;
/*!40000 ALTER TABLE `int_cmd` DISABLE KEYS */;
INSERT INTO `int_cmd` VALUES (1,'5ecb46d7-883f-11eb-989f-00ffbd5152a7','1','82b19811-7c4e-11eb-9c64-00ffbd5152a7','Java {Param1}  {Param2}','java command',_binary 'Java {Param1}  {Param2}','2021-03-18 19:12:11','2021-03-22 15:26:14',NULL,NULL,'Y',1,'36588a5c-8b44-11eb-91f1-00e04c68025a'),(2,'dc9c4e55-8b25-11eb-91f1-00e04c68025a','1','82b19811-7c4e-11eb-9c64-00ffbd5152a7','ls {Param1}','list services',_binary 'ls {Param1}','2021-03-22 11:47:09','2021-03-22 15:26:14',NULL,NULL,'Y',2,'365e3f69-8b44-11eb-91f1-00e04c68025a'),(3,'91cae481-8b37-11eb-91f1-00e04c68025a','4','14600802-8b37-11eb-91f1-00e04c68025a','This is to Ack {Param1} that is valid user and represent the {Param2}. I hear forth represent the {Param3} the group to address forther issues.','General Form 1',_binary 'This is to Ack {Param1} that is valid user and represent the {Param2}. I hear forth represent the {Param3} the group to address forther issues.\n','2021-03-22 13:53:55','2021-03-22 15:26:14',NULL,NULL,'Y',3,'36453f69-8b44-11eb-91f1-00e04c68025a'),(4,'708e6472-8b40-11eb-91f1-00e04c68025a','5','53924d2a-8b40-11eb-91f1-00e04c68025a','This is to notfy that {Param1} is terminated from his service on {Param2}. His/Her services will be utilitzed by OrganizationSearch {param3}.','HR temination form',_binary 'This is to notfy that {Param1} is terminated from his service on {Param2}. His/Her services will be utilitzed by OrganizationSearch {param3}.\nBy HR department ','2021-03-22 14:57:24','2021-03-22 15:26:14',NULL,NULL,'Y',4,'365e3f69-8b44-11eb-9df1-00e04c68025a');
/*!40000 ALTER TABLE `int_cmd` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `int_cmd_BIT` BEFORE INSERT ON `int_cmd` FOR EACH ROW BEGIN

if new.int_cmd_uuid is null  then 
set new.int_cmd_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;

if new.int_cmd_zebra_id is null  then 
set new.int_cmd_zebra_id = (Select max(int_cmd_zebra_id) from int_cmd )+ 1;
end if; 

if new.int_cmd_zebra_uuid is null  then 
set new.int_cmd_zebra_uuid = uuid();
end if;


END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `int_cmd_imp`
--

DROP TABLE IF EXISTS `int_cmd_imp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `int_cmd_imp` (
  `int_cmd_imp_id` int NOT NULL AUTO_INCREMENT,
  `int_cmd_imp_uuid` varchar(45) NOT NULL,
  `int_cmd_imp_int_cmd_id` varchar(45) DEFAULT NULL,
  `int_cmd_imp_int_cmd_uuid` varchar(45) DEFAULT NULL,
  `int_cmd_imp_int_cmd_param_id` varchar(45) NOT NULL,
  `int_cmd_imp_int_cmd_param_uuid` varchar(45) NOT NULL,
  `int_cmd_imp_int_cmd_param_value` varchar(5000) NOT NULL,
  `int_cmd_imp_user_uuid` varchar(45) NOT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_cmd_imp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `int_cmd_imp`
--

LOCK TABLES `int_cmd_imp` WRITE;
/*!40000 ALTER TABLE `int_cmd_imp` DISABLE KEYS */;
INSERT INTO `int_cmd_imp` VALUES (1,'8ea10f3f-8c26-11eb-91f1-00e04c68025a','3','91cae481-8b37-11eb-91f1-00e04c68025a','3','cbf3656b-8b37-11eb-91f1-00e04c68025a','NameSK','1bc00ca8-4443-11eb-a086-3df61ba5e799','2021-03-23 18:24:39','2021-03-23 18:41:14',NULL,NULL,'Y'),(2,'09206c9c-8c27-11eb-91f1-00e04c68025a','3','91cae481-8b37-11eb-91f1-00e04c68025a','4','cbf3df3d-8b37-11eb-91f1-00e04c68025a','RestOrg','1bc00ca8-4443-11eb-a086-3df61ba5e799','2021-03-23 18:28:04','2021-03-23 18:41:14',NULL,NULL,'Y'),(3,'0920c421-8c27-11eb-91f1-00e04c68025a','3','91cae481-8b37-11eb-91f1-00e04c68025a','5','cbf3f6c7-8b37-11eb-91f1-00e04c68025a','RestD1','1bc00ca8-4443-11eb-a086-3df61ba5e799','2021-03-23 18:28:04','2021-03-23 18:41:14',NULL,NULL,'Y'),(4,'45b3a496-8c27-11eb-91f1-00e04c68025a','3','91cae481-8b37-11eb-91f1-00e04c68025a','3','cbf3656b-8b37-11eb-91f1-00e04c68025a','rupesh1','0597302e-44fb-11eb-a086-3df61ba5e799','2021-03-23 18:29:46','2021-03-23 18:41:14',NULL,NULL,'Y'),(5,'45b53647-8c27-11eb-91f1-00e04c68025a','3','91cae481-8b37-11eb-91f1-00e04c68025a','4','cbf3df3d-8b37-11eb-91f1-00e04c68025a','oRG2','0597302e-44fb-11eb-a086-3df61ba5e799','2021-03-23 18:29:46','2021-03-23 18:41:14',NULL,NULL,'Y'),(6,'45b555b4-8c27-11eb-91f1-00e04c68025a','3','91cae481-8b37-11eb-91f1-00e04c68025a','5','cbf3f6c7-8b37-11eb-91f1-00e04c68025a','orgdata','0597302e-44fb-11eb-a086-3df61ba5e799','2021-03-23 18:29:46','2021-03-23 18:41:14',NULL,NULL,'Y'),(7,'dfcf5bc0-8c28-11eb-91f1-00e04c68025a','4','708e6472-8b40-11eb-91f1-00e04c68025a','6','75b699f5-8c28-11eb-91f1-00e04c68025a','Rupeshj','1bc00ca8-4443-11eb-a086-3df61ba5e799','2021-03-23 18:41:14','2021-03-23 18:41:33',NULL,NULL,'Y'),(8,'dfd0eac0-8c28-11eb-91f1-00e04c68025a','4','708e6472-8b40-11eb-91f1-00e04c68025a','7','75b842b1-8c28-11eb-91f1-00e04c68025a','test','1bc00ca8-4443-11eb-a086-3df61ba5e799','2021-03-23 18:41:14','2021-03-23 18:41:33',NULL,NULL,'Y'),(9,'dfd0fb4d-8c28-11eb-91f1-00e04c68025a','4','708e6472-8b40-11eb-91f1-00e04c68025a','8','75b859f8-8c28-11eb-91f1-00e04c68025a','testparam2','1bc00ca8-4443-11eb-a086-3df61ba5e799','2021-03-23 18:41:14','2021-03-23 18:41:33',NULL,NULL,'Y');
/*!40000 ALTER TABLE `int_cmd_imp` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `int_cmd_imp_BiT` BEFORE INSERT ON `int_cmd_imp` FOR EACH ROW BEGIN
if new.int_cmd_imp_uuid is null  then 
set new.int_cmd_imp_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `int_cmd_param`
--

DROP TABLE IF EXISTS `int_cmd_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `int_cmd_param` (
  `int_cmd_param_id` int NOT NULL AUTO_INCREMENT,
  `int_cmd_param_uuid` varchar(45) NOT NULL,
  `int_cmd_param_int_cmd_uuid` varchar(45) NOT NULL,
  `int_cmd_param_int_cmd_id` varchar(45) NOT NULL,
  `int_cmd_param_name` varchar(45) DEFAULT NULL,
  `int_cmd_param_defaultvalue` varchar(45) DEFAULT NULL,
  `int_cmd_param_description` varchar(45) DEFAULT NULL,
  `int_cmd_param_shortdescription` varchar(45) DEFAULT NULL,
  `int_cmd_param_position` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`int_cmd_param_id`,`int_cmd_param_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `int_cmd_param`
--

LOCK TABLES `int_cmd_param` WRITE;
/*!40000 ALTER TABLE `int_cmd_param` DISABLE KEYS */;
INSERT INTO `int_cmd_param` VALUES (1,'4b3fc8c3-8b28-11eb-91f1-00e04c68025a','5ecb46d7-883f-11eb-989f-00ffbd5152a7','1','Param1',NULL,NULL,NULL,NULL,'2021-03-22 12:04:34','2021-03-22 13:55:54',NULL,NULL,'Y'),(2,'4b415b4d-8b28-11eb-91f1-00e04c68025a','5ecb46d7-883f-11eb-989f-00ffbd5152a7','1','Param2',NULL,NULL,NULL,NULL,'2021-03-22 12:04:34','2021-03-22 13:55:54',NULL,NULL,'Y'),(3,'cbf3656b-8b37-11eb-91f1-00e04c68025a','91cae481-8b37-11eb-91f1-00e04c68025a','3','Param1','','name',NULL,NULL,'2021-03-22 13:55:32','2021-03-23 18:38:56',NULL,NULL,'Y'),(4,'cbf3df3d-8b37-11eb-91f1-00e04c68025a','91cae481-8b37-11eb-91f1-00e04c68025a','3','Param2',NULL,'Org1',NULL,NULL,'2021-03-22 13:55:32','2021-03-23 18:38:56',NULL,NULL,'Y'),(5,'cbf3f6c7-8b37-11eb-91f1-00e04c68025a','91cae481-8b37-11eb-91f1-00e04c68025a','3','Param3',NULL,'Org1',NULL,NULL,'2021-03-22 13:55:32','2021-03-23 18:38:56',NULL,NULL,'Y'),(6,'75b699f5-8c28-11eb-91f1-00e04c68025a','708e6472-8b40-11eb-91f1-00e04c68025a','4','Param1',NULL,'name',NULL,NULL,'2021-03-23 18:38:16','2021-03-23 18:38:56',NULL,NULL,'Y'),(7,'75b842b1-8c28-11eb-91f1-00e04c68025a','708e6472-8b40-11eb-91f1-00e04c68025a','4','Param2',NULL,'Org1',NULL,NULL,'2021-03-23 18:38:16','2021-03-23 18:38:56',NULL,NULL,'Y'),(8,'75b859f8-8c28-11eb-91f1-00e04c68025a','708e6472-8b40-11eb-91f1-00e04c68025a','4','Param3',NULL,'Org2',NULL,NULL,'2021-03-23 18:38:16','2021-03-23 18:38:56',NULL,NULL,'Y');
/*!40000 ALTER TABLE `int_cmd_param` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `int_cmd_param_BIT` BEFORE INSERT ON `int_cmd_param` FOR EACH ROW BEGIN
if new.int_cmd_param_uuid is null  then 
set new.int_cmd_param_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `int_params`
--

DROP TABLE IF EXISTS `int_params`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `int_params` (
  `int_params_id` int NOT NULL AUTO_INCREMENT,
  `int_params_uuid` varchar(45) NOT NULL,
  `int_params_name` varchar(45) DEFAULT NULL,
  `int_params_value` varchar(45) DEFAULT NULL,
  `int_params_typeid` varchar(45) DEFAULT NULL,
  `int_params_typeuuid` varchar(45) NOT NULL,
  `int_params_label` varchar(45) DEFAULT NULL,
  `int_params_paramtypeid` varchar(45) DEFAULT NULL,
  `int_params_paramtypeuuid` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`int_params_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `int_params`
--

LOCK TABLES `int_params` WRITE;
/*!40000 ALTER TABLE `int_params` DISABLE KEYS */;
/*!40000 ALTER TABLE `int_params` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `int_params_BEFORE_INSERT` BEFORE INSERT ON `int_params` FOR EACH ROW BEGIN

if new.int_params_uuid is null  then 
set new.int_params_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `int_type`
--

DROP TABLE IF EXISTS `int_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `int_type` (
  `Int_type_id` int NOT NULL AUTO_INCREMENT,
  `int_type_uuid` varchar(45) NOT NULL,
  `int_type_name` varchar(45) DEFAULT NULL,
  `int_type_short_description` varchar(45) DEFAULT NULL,
  `int_type_description` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Int_type_id`),
  UNIQUE KEY `int_type_name_UNIQUE` (`int_type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `int_type`
--

LOCK TABLES `int_type` WRITE;
/*!40000 ALTER TABLE `int_type` DISABLE KEYS */;
INSERT INTO `int_type` VALUES (1,'82b19811-7c4e-11eb-9c64-00ffbd5152a7','CFTPCmd','CftpComands','Cftp','2021-03-03 13:30:20','2021-03-22 14:56:36',NULL,NULL,'Y'),(2,'ad813666-7c4e-11eb-9c64-00ffbd5152a7','JSql','Jsql','JSql Queries','2021-03-03 13:31:32','2021-03-22 14:56:36',NULL,NULL,'Y'),(3,'d465aa35-7c4e-11eb-9c64-00ffbd5152a7','ARestAPI','AAPI','AAPI Rest','2021-03-03 13:32:37','2021-03-22 14:56:36',NULL,NULL,'Y'),(4,'14600802-8b37-11eb-91f1-00e04c68025a','GeneralForm','Forms for General usage','Froms','2021-03-22 13:50:24','2021-03-22 14:56:36',NULL,NULL,'Y'),(5,'53924d2a-8b40-11eb-91f1-00e04c68025a','HumarResource','Human Resources ','Forms for HR Department','2021-03-22 14:56:36','2021-03-22 14:56:36',NULL,NULL,'Y');
/*!40000 ALTER TABLE `int_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `int_type_BEFORE_INSERT` BEFORE INSERT ON `int_type` FOR EACH ROW BEGIN

if new.int_type_uuid is null  then 
set new.int_type_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `marketing_status`
--

DROP TABLE IF EXISTS `marketing_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marketing_status` (
  `marketing_status_id` int NOT NULL AUTO_INCREMENT,
  `marketing_status_uuid` varchar(45) DEFAULT NULL,
  `marketing_status_status_id` varchar(45) DEFAULT NULL,
  `marketing_status_applno` varchar(45) DEFAULT NULL,
  `marketing_status_product_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`marketing_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41580 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marketing_status`
--

LOCK TABLES `marketing_status` WRITE;
/*!40000 ALTER TABLE `marketing_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `marketing_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marketing_status_lookup`
--

DROP TABLE IF EXISTS `marketing_status_lookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marketing_status_lookup` (
  `marketing_status_lookup_id` int NOT NULL AUTO_INCREMENT,
  `marketing_status_lookup_uuid` varchar(45) NOT NULL,
  `marketing_status_lookup_status_id` varchar(45) DEFAULT NULL,
  `marketing_status_lookup_status_description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`marketing_status_lookup_id`,`marketing_status_lookup_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marketing_status_lookup`
--

LOCK TABLES `marketing_status_lookup` WRITE;
/*!40000 ALTER TABLE `marketing_status_lookup` DISABLE KEYS */;
/*!40000 ALTER TABLE `marketing_status_lookup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modules_lookup`
--

DROP TABLE IF EXISTS `modules_lookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modules_lookup` (
  `modules_lookup_id` int NOT NULL AUTO_INCREMENT,
  `modules_lookup_uuid` varchar(45) NOT NULL,
  `modules_lookup_number` varchar(45) DEFAULT NULL,
  `modules_lookup_short_description` varchar(45) DEFAULT NULL,
  `modules_lookup_name` varchar(45) NOT NULL,
  `modules_lookup_description` varchar(5000) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`modules_lookup_id`,`modules_lookup_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modules_lookup`
--

LOCK TABLES `modules_lookup` WRITE;
/*!40000 ALTER TABLE `modules_lookup` DISABLE KEYS */;
INSERT INTO `modules_lookup` VALUES (9,'0f058355-8050-11eb-bedd-00e04c68025a','1','Runner','Runner','Runner ','auto',NULL,'2021-03-08 15:51:30','2021-03-08 15:51:30','Y'),(10,'4f3ecd1d-8050-11eb-bedd-00e04c68025a','2','Logging services','Logging','Logging services  module','auto',NULL,'2021-03-08 15:53:18','2021-03-08 15:53:18','Y'),(11,'04d84037-80ef-11eb-bedd-00e04c68025a','2','Monitoring','Monitoring','Montioring ELK',NULL,NULL,'2021-03-09 10:49:23','2021-03-09 10:49:23','N'),(12,'3425b721-80ef-11eb-bedd-00e04c68025a','2','Intergration','Integrations','Integrations',NULL,NULL,'2021-03-09 10:50:42','2021-03-09 10:50:52','N');
/*!40000 ALTER TABLE `modules_lookup` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `modules_lookup_BEFORE_INSERT` BEFORE INSERT ON `modules_lookup` FOR EACH ROW BEGIN
declare tmp_uuid varchar(45);
declare tmp_org_uuid varchar(45);
set tmp_uuid= uuid();

if new.modules_lookup_uuid is null  then 
set new.modules_lookup_uuid = tmp_uuid;
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;

if ((select organization_uuid from organization where upper(organization_name) = 'DEFAULT') is null) ||  ((select organization_uuid from organization where upper(organization_name) = 'DEFAULT') = '') then
insert into organization (organization_name, organization_shortDescription, organization_description, created_by) values ('default', 'Default Short', 'default description', 'auto');
set tmp_org_uuid = (select organization_uuid from organization where upper(organization_name) = 'DEFAULT');
else 
set tmp_org_uuid = (select organization_uuid from organization where upper(organization_name) = 'DEFAULT');
end if;


Insert into organization_module (module_lookup_uuid, Organization_uuid, active_status, created_by) values (tmp_uuid, 
(select organization_uuid from organization where upper(organization_name) = 'DEFAULT'), 'Y', 'auto');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `notificaion_type`
--

DROP TABLE IF EXISTS `notificaion_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificaion_type` (
  `notificaion_type_id` int NOT NULL AUTO_INCREMENT,
  `notificaion_type_uuid` varchar(45) DEFAULT NULL,
  `notificaion_type_name` varchar(45) DEFAULT NULL,
  `notificaion_type_short_description` varchar(45) DEFAULT NULL,
  `notificaion_type_description` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) DEFAULT 'N',
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`notificaion_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificaion_type`
--

LOCK TABLES `notificaion_type` WRITE;
/*!40000 ALTER TABLE `notificaion_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificaion_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `organisation_id` int NOT NULL AUTO_INCREMENT,
  `organization_uuid` varchar(45) NOT NULL,
  `organization_name` varchar(45) DEFAULT NULL,
  `organization_shortdescription` varchar(45) DEFAULT NULL,
  `organization_description` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) DEFAULT 'N',
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`organisation_id`,`organization_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES
(3,'62fe4459-5b64-11eb-9d2a-b7b58d77f3be','Default','Default Organisation','Default Organisation','2021-01-20 16:13:48',
'2021-03-08 15:52:26','Y','ec9eddee-32dd-11eb-8551-f84a89d27f07','ec9eddee-32dd-11eb-8551-f84a89d27f07'),
(4,'6416b38a-64a6-11eb-be50-df1a5e55f328','org1','org1','org1','2021-02-01 10:58:57','2021-02-01 10:58:57','Y','ec9eddee-32dd-11eb-8551-f84a89d27f07','ec9eddee-32dd-11eb-8551-f84a89d27f07'),(5,'6416b88x-67a6-11eb-bj50-d1a5de55f328','Org2','Org2','Org2','2021-03-08 14:58:02','2021-03-08 15:05:04','Y',NULL,NULL),(6,'92c640d9-8049-11eb-bedd-00e04c68025a','Org3','Org3 ','Org3','2021-03-08 15:05:04','2021-03-08 15:05:04','Y',NULL,NULL),(9,'77e16235-811b-11eb-bedd-00e04c68025a','Org4','org4','org4','2021-03-09 16:07:34','2021-03-09 16:07:34','Y',NULL,NULL);
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `organization_BEFORE_INSERT` BEFORE INSERT ON `organization` FOR EACH ROW BEGIN

set new.organization_uuid = uuid();

if new.organization_uuid is null  then 
set new.organization_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `organization_module`
--

DROP TABLE IF EXISTS `organization_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization_module` (
  `Organization_Module_id` int NOT NULL AUTO_INCREMENT,
  `Organization_Module_uuid` varchar(45) NOT NULL,
  `Organization_uuid` varchar(45) NOT NULL,
  `module_lookup_uuid` varchar(45) NOT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Organization_Module_id`,`Organization_Module_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_module`
--

LOCK TABLES `organization_module` WRITE;
/*!40000 ALTER TABLE `organization_module` DISABLE KEYS */;
INSERT INTO `organization_module` VALUES (8,'0f05ae62-8050-11eb-bedd-00e04c68025a','0f058aa7-8050-11eb-bedd-00e04c68025a','0f058355-8050-11eb-bedd-00e04c68025a','Y','2021-03-08 15:51:30','2021-03-08 15:51:30','auto',NULL),(9,'4f3f1ed6-8050-11eb-bedd-00e04c68025a','62fe4459-5b64-11eb-9d2a-b7b58d77f3be','4f3ecd1d-8050-11eb-bedd-00e04c68025a','Y','2021-03-08 15:53:18','2021-03-08 15:53:18','auto',NULL),(10,'04d8b36d-80ef-11eb-bedd-00e04c68025a','62fe4459-5b64-11eb-9d2a-b7b58d77f3be','04d84037-80ef-11eb-bedd-00e04c68025a','Y','2021-03-09 10:49:23','2021-03-09 10:49:23','auto',NULL),(11,'3425c3ef-80ef-11eb-bedd-00e04c68025a','62fe4459-5b64-11eb-9d2a-b7b58d77f3be','3425b721-80ef-11eb-bedd-00e04c68025a','Y','2021-03-09 10:50:42','2021-03-09 10:50:42','auto',NULL),(12,'eb8e2674-80f4-11eb-bedd-00e04c68025a','6416b38a-64a6-11eb-be50-df1a5e55f328','0f058355-8050-11eb-bedd-00e04c68025a','Y','2021-03-09 11:31:37','2021-03-09 12:43:00','auto',NULL),(13,'eb8e8ab3-80f4-11eb-bedd-00e04c68025a','6416b38a-64a6-11eb-be50-df1a5e55f328','4f3ecd1d-8050-11eb-bedd-00e04c68025a','Y','2021-03-09 11:31:37','2021-03-09 12:43:00','auto',NULL),(14,'eb8ea1f3-80f4-11eb-bedd-00e04c68025a','6416b38a-64a6-11eb-be50-df1a5e55f328','04d84037-80ef-11eb-bedd-00e04c68025a','Y','2021-03-09 11:31:37','2021-03-09 12:43:00','auto',NULL),(15,'eb8eb527-80f4-11eb-bedd-00e04c68025a','6416b38a-64a6-11eb-be50-df1a5e55f328','3425b721-80ef-11eb-bedd-00e04c68025a','Y','2021-03-09 11:31:37','2021-03-09 12:43:00','auto',NULL),(16,'1b960abe-80f5-11eb-bedd-00e04c68025a','92c640d9-8049-11eb-bedd-00e04c68025a','04d84037-80ef-11eb-bedd-00e04c68025a','Y','2021-03-09 11:32:58','2021-03-09 12:43:00','auto',NULL),(17,'1b96410f-80f5-11eb-bedd-00e04c68025a','92c640d9-8049-11eb-bedd-00e04c68025a','3425b721-80ef-11eb-bedd-00e04c68025a','Y','2021-03-09 11:32:58','2021-03-09 12:43:00','auto',NULL),(18,'e4216a46-80fe-11eb-bedd-00e04c68025a','62fe4459-5b64-11eb-9d2a-b7b58d77f3be','0f058355-8050-11eb-bedd-00e04c68025a','Y','2021-03-09 12:43:00','2021-03-09 12:43:00','auto',NULL),(19,'a4e70e1e-811b-11eb-bedd-00e04c68025a','77e16235-811b-11eb-bedd-00e04c68025a','0f058355-8050-11eb-bedd-00e04c68025a','Y','2021-03-09 16:08:49','2021-03-09 16:08:49','auto',NULL);
/*!40000 ALTER TABLE `organization_module` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `organization_module_BEFORE_INSERT` BEFORE INSERT ON `organization_module` FOR EACH ROW BEGIN
if new.Organization_Module_uuid is null  then 
set new.Organization_Module_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `permission_id` int NOT NULL AUTO_INCREMENT,
  `permission_uuid` varchar(45) NOT NULL,
  `permission_name` varchar(45) DEFAULT NULL,
  `permission_desc` varchar(45) DEFAULT NULL,
  `permission_resource_id` varchar(45) DEFAULT NULL,
  `permission_resource_uuid` varchar(45) DEFAULT NULL,
  `permission_available_indicator` varchar(45) DEFAULT 'N',
  `permission_create` varchar(45) DEFAULT 'N',
  `permission_create_permission_type_id` varchar(45) DEFAULT NULL,
  `permission_delete` varchar(45) DEFAULT 'N',
  `permission_delete_permission_type_⁯id` varchar(45) DEFAULT NULL,
  `permission_update` varchar(45) DEFAULT 'N',
  `permission_update_permission_type_⁯id` varchar(45) DEFAULT NULL,
  `permission_read` varchar(45) DEFAULT 'Y',
  `permission_read_permission_type_⁯id` varchar(45) DEFAULT NULL,
  `permission_softdelete` varchar(45) DEFAULT 'N',
  `permission_softdelete_permission_type_⁯id` varchar(45) DEFAULT NULL,
  `permission_operater_id` varchar(45) DEFAULT NULL,
  `permission_authorize_user_id` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) DEFAULT 'N',
  `crated_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`permission_id`,`permission_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'1','USER_VIEW',NULL,NULL,NULL,'N','N',NULL,'N',NULL,'N',NULL,'Y',NULL,'N',NULL,NULL,NULL,'2020-11-30 13:05:48','2020-11-30 13:06:04','Y',NULL,NULL),(2,'2','USER_EDIT',NULL,NULL,NULL,'N','N',NULL,'N',NULL,'N',NULL,'Y',NULL,'N',NULL,NULL,NULL,'2020-11-30 13:05:48','2020-11-30 13:06:04','Y',NULL,NULL),(3,'3','USER_DELETE',NULL,NULL,NULL,'N','N',NULL,'N',NULL,'N',NULL,'Y',NULL,'N',NULL,NULL,NULL,'2020-11-30 13:05:48','2020-11-30 13:06:04','Y',NULL,NULL),(4,'4','USER_CREATE',NULL,NULL,NULL,'N','N',NULL,'N',NULL,'N',NULL,'Y',NULL,'N',NULL,NULL,NULL,'2020-11-30 13:05:48','2020-11-30 13:06:04','Y',NULL,NULL),(5,'5','ADMIN',NULL,NULL,NULL,'N','N',NULL,'N',NULL,'N',NULL,'Y',NULL,'N',NULL,NULL,NULL,'2020-11-30 13:05:48','2020-11-30 13:06:04','Y',NULL,NULL),(6,'6','USER_EVENT_VIEW',NULL,NULL,NULL,'N','N',NULL,'N',NULL,'N',NULL,'Y',NULL,'N',NULL,NULL,NULL,'2020-12-18 12:39:40','2020-12-18 12:39:40','Y',NULL,NULL),(7,'7','USER_EVENT_CREATE',NULL,NULL,NULL,'N','N',NULL,'N',NULL,'N',NULL,'Y',NULL,'N',NULL,NULL,NULL,'2020-12-18 12:39:40','2020-12-18 12:39:40','Y',NULL,NULL),(8,'8','GROUP_CREATE',NULL,NULL,NULL,'N','N',NULL,'N',NULL,'N',NULL,'Y',NULL,'N',NULL,NULL,NULL,'2020-12-18 12:39:40','2020-12-18 12:39:40','Y',NULL,NULL);
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `permission_BIT` BEFORE INSERT ON `permission` FOR EACH ROW BEGIN

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `permission_resource_module`
--

DROP TABLE IF EXISTS `permission_resource_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission_resource_module` (
  `permission_resource_module_id` int NOT NULL AUTO_INCREMENT,
  `permission_resource_module_uuid` varchar(45) NOT NULL,
  `permission_resource_module_name` varchar(45) DEFAULT NULL,
  `permission_resource_module_desc` varchar(45) DEFAULT NULL,
  `permission_resource_module_resource_id` varchar(45) DEFAULT NULL,
  `permission_resource_module_resource_uuid` varchar(45) DEFAULT NULL,
  `permission_resource_module_available_indicator` varchar(45) DEFAULT 'N',
  `permission_resource_module_create` varchar(45) DEFAULT 'N',
  `permission_resource_module_create_permission_type_id` varchar(45) DEFAULT NULL,
  `permission_resource_module_delete` varchar(45) DEFAULT 'N',
  `permission_resource_module_delete_permission_type_⁯id` varchar(45) DEFAULT NULL,
  `permission_resource_module_update` varchar(45) DEFAULT 'N',
  `permission_resource_module_update_permission_type_⁯id` varchar(45) DEFAULT NULL,
  `permission_resource_module_read` varchar(45) DEFAULT 'Y',
  `permission_resource_module_read_permission_type_⁯id` varchar(45) DEFAULT NULL,
  `permission_resource_module_softdelete` varchar(45) DEFAULT 'N',
  `permission_resource_module_softdelete_permission_type_⁯id` varchar(45) DEFAULT NULL,
  `permission_resource_module_operater_id` varchar(45) DEFAULT NULL,
  `permission_resource_module_authorize_user_id` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) DEFAULT 'N',
  `crated_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`permission_resource_module_id`,`permission_resource_module_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_resource_module`
--

LOCK TABLES `permission_resource_module` WRITE;
/*!40000 ALTER TABLE `permission_resource_module` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission_resource_module` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `permission_resource_module_BIT` BEFORE INSERT ON `permission_resource_module` FOR EACH ROW BEGIN
if new.permission_resource_module_uuid is null  then 
set new.permission_resource_module_uuid = uuid();
end if;


END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `permission_type`
--

DROP TABLE IF EXISTS `permission_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission_type` (
  `permission_type_id` int NOT NULL AUTO_INCREMENT,
  `permission_type_uuid` varchar(45) NOT NULL,
  `permission_type_name` varchar(45) DEFAULT NULL,
  `permission_type_short_description` varchar(45) DEFAULT NULL,
  `permission_type_description` varchar(4500) DEFAULT NULL,
  `created_dts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `udated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`permission_type_id`,`permission_type_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_type`
--

LOCK TABLES `permission_type` WRITE;
/*!40000 ALTER TABLE `permission_type` DISABLE KEYS */;
INSERT INTO `permission_type` VALUES (8,'dd4467a6-8068-11eb-bedd-00e04c68025a','create','Add','Add or Create','2021-03-08 18:49:04','2021-03-08 18:49:04',NULL,NULL,'N'),(9,'dd44ca7d-8068-11eb-bedd-00e04c68025a','read','Read only','Read or View only','2021-03-08 18:49:04','2021-03-08 18:49:04',NULL,NULL,'N'),(10,'dd44daa0-8068-11eb-bedd-00e04c68025a','update','Edit Update','Edit or update','2021-03-08 18:49:04','2021-03-08 18:49:04',NULL,NULL,'N'),(11,'dd44f874-8068-11eb-bedd-00e04c68025a','delete','Remove','Remove from table','2021-03-08 18:49:04','2021-03-08 18:49:04',NULL,NULL,'N'),(12,'dd450bcf-8068-11eb-bedd-00e04c68025a','softDelete','display off','Soft delete or Active status in not Y','2021-03-08 18:49:04','2021-03-08 18:49:04',NULL,NULL,'N');
/*!40000 ALTER TABLE `permission_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `permission_type_BiT` BEFORE INSERT ON `permission_type` FOR EACH ROW BEGIN
if new.permission_type_uuid is null  then 
set new.permission_type_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `product_repo`
--

DROP TABLE IF EXISTS `product_repo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_repo` (
  `product_repo_id` int NOT NULL AUTO_INCREMENT,
  `product_repo_uuid` varchar(45) NOT NULL,
  `product_repo_name` varchar(100) DEFAULT NULL,
  `product_repo_ingradients` varchar(100) DEFAULT NULL,
  `product_repo_reference_standard` varchar(100) DEFAULT NULL,
  `product_repo_number` varchar(100) DEFAULT NULL,
  `product_repo_reference_products` varchar(500) DEFAULT NULL,
  `product_repo_strength` varchar(100) DEFAULT NULL,
  `product_repo_productform` varchar(100) DEFAULT NULL,
  `product_repo_applno` varchar(45) DEFAULT NULL,
  `create_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`product_repo_id`,`product_repo_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=23114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_repo`
--

LOCK TABLES `product_repo` WRITE;
/*!40000 ALTER TABLE `product_repo` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_repo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_blob_triggers`
--

DROP TABLE IF EXISTS `qrtz_blob_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_blob_triggers`
--

LOCK TABLES `qrtz_blob_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_blob_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_blob_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_calendars`
--

DROP TABLE IF EXISTS `qrtz_calendars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(190) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_calendars`
--

LOCK TABLES `qrtz_calendars` WRITE;
/*!40000 ALTER TABLE `qrtz_calendars` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_calendars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_cron_triggers`
--

DROP TABLE IF EXISTS `qrtz_cron_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_cron_triggers`
--

LOCK TABLES `qrtz_cron_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_cron_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_cron_triggers` VALUES ('quartzScheduler','UserEventScheduler','Schedule-UserEvent-Trigger','0 0/30 * * * ?','America/New_York');
/*!40000 ALTER TABLE `qrtz_cron_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_fired_triggers`
--

DROP TABLE IF EXISTS `qrtz_fired_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `INSTANCE_NAME` varchar(190) NOT NULL,
  `FIRED_TIME` bigint NOT NULL,
  `SCHED_TIME` bigint NOT NULL,
  `PRIORITY` int NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(190) DEFAULT NULL,
  `JOB_GROUP` varchar(190) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_fired_triggers`
--

LOCK TABLES `qrtz_fired_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_fired_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_fired_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_job_details`
--

DROP TABLE IF EXISTS `qrtz_job_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(190) NOT NULL,
  `JOB_GROUP` varchar(190) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_job_details`
--

LOCK TABLES `qrtz_job_details` WRITE;
/*!40000 ALTER TABLE `qrtz_job_details` DISABLE KEYS */;
INSERT INTO `qrtz_job_details` VALUES ('quartzScheduler','UserEventScheduler','Schedule-UserEvent-Job','Schedule-UserEvent-Job','com.care.user.events.quartz.job.UserEventCreateJob','1','0','0','0',_binary '�\�\0sr\0org.quartz.JobDataMap���迩�\�\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�\�\��\�](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\�.�(v\n\�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xp\0sr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0\0x\0');
/*!40000 ALTER TABLE `qrtz_job_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_locks`
--

DROP TABLE IF EXISTS `qrtz_locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_locks`
--

LOCK TABLES `qrtz_locks` WRITE;
/*!40000 ALTER TABLE `qrtz_locks` DISABLE KEYS */;
INSERT INTO `qrtz_locks` VALUES ('quartzScheduler','TRIGGER_ACCESS');
/*!40000 ALTER TABLE `qrtz_locks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_paused_trigger_grps`
--

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_paused_trigger_grps`
--

LOCK TABLES `qrtz_paused_trigger_grps` WRITE;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_scheduler_state`
--

DROP TABLE IF EXISTS `qrtz_scheduler_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(190) NOT NULL,
  `LAST_CHECKIN_TIME` bigint NOT NULL,
  `CHECKIN_INTERVAL` bigint NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_scheduler_state`
--

LOCK TABLES `qrtz_scheduler_state` WRITE;
/*!40000 ALTER TABLE `qrtz_scheduler_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_scheduler_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simple_triggers`
--

DROP TABLE IF EXISTS `qrtz_simple_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `REPEAT_COUNT` bigint NOT NULL,
  `REPEAT_INTERVAL` bigint NOT NULL,
  `TIMES_TRIGGERED` bigint NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simple_triggers`
--

LOCK TABLES `qrtz_simple_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simple_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simple_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simprop_triggers`
--

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int DEFAULT NULL,
  `INT_PROP_2` int DEFAULT NULL,
  `LONG_PROP_1` bigint DEFAULT NULL,
  `LONG_PROP_2` bigint DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simprop_triggers`
--

LOCK TABLES `qrtz_simprop_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_triggers`
--

DROP TABLE IF EXISTS `qrtz_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(190) NOT NULL,
  `TRIGGER_GROUP` varchar(190) NOT NULL,
  `JOB_NAME` varchar(190) NOT NULL,
  `JOB_GROUP` varchar(190) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint DEFAULT NULL,
  `PREV_FIRE_TIME` bigint DEFAULT NULL,
  `PRIORITY` int DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint NOT NULL,
  `END_TIME` bigint DEFAULT NULL,
  `CALENDAR_NAME` varchar(190) DEFAULT NULL,
  `MISFIRE_INSTR` smallint DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_triggers`
--

LOCK TABLES `qrtz_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_triggers` VALUES ('quartzScheduler','UserEventScheduler','Schedule-UserEvent-Trigger','UserEventScheduler','Schedule-UserEvent-Job','Schedule-UserEvent-Trigger',1616826600000,1616824800000,5,'WAITING','CRON',1616618880000,0,NULL,2,'');
/*!40000 ALTER TABLE `qrtz_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource` (
  `resource_id` int NOT NULL AUTO_INCREMENT,
  `resource_uuid` varchar(45) NOT NULL,
  `resource_name` varchar(45) DEFAULT NULL,
  `resource_type` varchar(45) DEFAULT 'auto',
  `resource_desc` varchar(45) DEFAULT NULL,
  `resource_type_desc` varchar(45) DEFAULT NULL,
  `resource_version_number` varchar(45) DEFAULT '1',
  `resource_available_indicator` varchar(45) DEFAULT 'N',
  `resource_parent_id` varchar(45) DEFAULT NULL,
  `resource_auth_user_id` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`resource_id`,`resource_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,'20b1v1ae-8125-11eb-bedd-00e04456025a','resource1','auto','resource desc','resource desc','1','Y',NULL,NULL,'2021-03-09 17:11:13','2021-03-09 17:31:49',NULL,NULL,'Y'),(2,'20b171ae-8125-11eb-bedd-00e04c68025a','resource2','auto','resource desc','resource desc','1','Y',NULL,NULL,'2021-03-09 17:16:42','2021-03-09 17:31:49',NULL,NULL,'Y'),(3,'3d62867f-8127-11eb-bedd-00e04c68025a','resource3','auto','resource desc','resource desc','1','Y',NULL,NULL,'2021-03-09 17:31:49','2021-03-09 17:31:49',NULL,NULL,'Y');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `resource_BIT` BEFORE INSERT ON `resource` FOR EACH ROW BEGIN
if new.resource_uuid is null  then 
set new.resource_uuid = uuid();
end if;




END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `resource_module`
--

DROP TABLE IF EXISTS `resource_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource_module` (
  `resource_module_id` int NOT NULL AUTO_INCREMENT,
  `resource_module_uuid` varchar(45) NOT NULL,
  `resource_id` varchar(45) DEFAULT NULL,
  `resource_uuid` varchar(45) NOT NULL,
  `module_id` varchar(45) DEFAULT NULL,
  `module_uuid` varchar(45) NOT NULL,
  `active_status` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT NULL,
  `updated_dts` datetime DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`resource_module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_module`
--

LOCK TABLES `resource_module` WRITE;
/*!40000 ALTER TABLE `resource_module` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_module` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `resource_module_BEFORE_INSERT` BEFORE INSERT ON `resource_module` FOR EACH ROW BEGIN
if new.resource_module_uuid is null  then 
set new.resource_module_uuid = uuid();
end if;

if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'N';
else 
set new.active_status = upper(new.active_status);
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `resource_type`
--

DROP TABLE IF EXISTS `resource_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource_type` (
  `resource_type_id` int NOT NULL AUTO_INCREMENT,
  `resource_type_uuid` varchar(45) NOT NULL,
  `resource_type_name` varchar(45) DEFAULT NULL,
  `resource_type_desc` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` varchar(45) DEFAULT 'N',
  `crated_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`resource_type_id`,`resource_type_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_type`
--

LOCK TABLES `resource_type` WRITE;
/*!40000 ALTER TABLE `resource_type` DISABLE KEYS */;
INSERT INTO `resource_type` VALUES (1,'auto','auto','auto','2021-03-15 22:43:07','2021-03-15 22:44:07','Y',NULL,NULL),(2,'72963875-8601-11eb-989f-00ffbd5152a7','UI','UI','0000-00-00 00:00:00','2021-03-15 22:44:07','Y',NULL,NULL);
/*!40000 ALTER TABLE `resource_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `resource_type_BiT` BEFORE INSERT ON `resource_type` FOR EACH ROW BEGIN
if new.resource_type_uuid is null  then 
set new.resource_type_uuid = uuid();
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_uuid` varchar(50) NOT NULL,
  `role_type` varchar(50) DEFAULT NULL,
  `role_label` varchar(50) DEFAULT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `role_indicator` varchar(50) DEFAULT NULL,
  `role_auth_user_id` varchar(50) DEFAULT NULL,
  `role_created_by` varchar(50) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `role_comments` varchar(5000) DEFAULT NULL,
  `role_group` varchar(45) DEFAULT 'Org_Default',
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`role_id`,`role_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'78fb491e-32d2-11eb-8551-f84a89d27f07','default ro',NULL,'DefaultRole',NULL,NULL,NULL,'2020-11-30 11:38:31','2020-12-17 15:35:30',NULL,'Org_Default',NULL,NULL,'Y'),(2,'e06a21f8-404a-11eb-a086-3df61ba5e799','sdf','sf','ss',NULL,NULL,NULL,'2020-12-17 15:03:10','2020-12-17 15:03:10','sfwd','Org_Default',NULL,NULL,'Y'),(3,'1d97ea9c-410e-11eb-a086-3df61ba5e799','Test','Test','TestRole',NULL,NULL,NULL,'2020-12-18 14:20:44','2020-12-18 14:20:44','checking','Org_Default',NULL,NULL,'Y'),(4,'ad651d24-4119-11eb-a086-3df61ba5e799','New','Test','TestRoleBegin',NULL,NULL,NULL,'2020-12-18 15:43:30','2020-12-18 15:43:30','','Org_Default',NULL,NULL,'Y'),(5,'72dfd36c-4441-11eb-a086-3df61ba5e799','Test','New','Narayan',NULL,NULL,NULL,'2020-12-22 16:05:45','2020-12-22 16:05:45','','Org_Default',NULL,NULL,'Y'),(6,'79947942-45fe-11eb-a086-3df61ba5e799','Test','Test','TestRoleCreateView',NULL,NULL,NULL,'2020-12-24 21:11:22','2020-12-24 21:11:22','','Org_Default',NULL,NULL,'Y');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permission` (
  `role_permission_id` int NOT NULL AUTO_INCREMENT,
  `role_permission_uuid` varchar(45) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  `permission_id` varchar(45) DEFAULT NULL,
  `role_permission_expiration_date` datetime DEFAULT NULL,
  `role_permission_available_indicator` varchar(45) DEFAULT 'Y',
  `role_permission_authorization_user_id` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`role_permission_id`,`role_permission_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES (1,'e63bbb88-32de-11eb-8551-f84a89d27f07','78fb491e-32d2-11eb-8551-f84a89d27f07','1',NULL,'Y',NULL,'2020-11-30 13:07:29','2020-11-30 13:07:43',NULL,NULL,'Y'),(2,'e63c082c-32de-11eb-8551-f84a89d27f07','78fb491e-32d2-11eb-8551-f84a89d27f07','2',NULL,'Y',NULL,'2020-11-30 13:07:29','2020-11-30 13:07:43',NULL,NULL,'Y'),(3,'e63c3982-32de-11eb-8551-f84a89d27f07','78fb491e-32d2-11eb-8551-f84a89d27f07','3',NULL,'Y',NULL,'2020-11-30 13:07:29','2020-11-30 13:55:32',NULL,NULL,'Y'),(4,'e63c85cc-32de-11eb-8551-f84a89d27f07','78fb491e-32d2-11eb-8551-f84a89d27f07','4',NULL,'Y',NULL,'2020-11-30 13:07:29','2020-11-30 13:07:43',NULL,NULL,'Y'),(5,'e63c9cc4-32de-11eb-8551-f84a89d27f07','78fb491e-32d2-11eb-8551-f84a89d27f07','5',NULL,'Y',NULL,'2020-11-30 13:07:29','2020-12-17 17:23:08',NULL,NULL,'Y'),(6,'2efb8c20-4100-11eb-a086-3df61ba5e799','78fb491e-32d2-11eb-8551-f84a89d27f07','6',NULL,'Y',NULL,'2020-12-18 12:41:00','2020-12-18 12:41:00',NULL,NULL,'Y'),(7,'2efc4bb0-4100-11eb-a086-3df61ba5e799','78fb491e-32d2-11eb-8551-f84a89d27f07','7',NULL,'Y',NULL,'2020-12-18 12:41:00','2020-12-18 12:41:00',NULL,NULL,'Y'),(8,'2efebb0c-4100-11eb-a086-3df61ba5e799','78fb491e-32d2-11eb-8551-f84a89d27f07','8',NULL,'Y',NULL,'2020-12-18 12:41:00','2020-12-18 12:41:00',NULL,NULL,'Y'),(9,'1da2289a-410e-11eb-a086-3df61ba5e799','1d97ea9c-410e-11eb-a086-3df61ba5e799','4',NULL,'Y',NULL,'2020-12-18 14:20:44','2020-12-18 14:20:44',NULL,NULL,'Y'),(10,'1da2fbc6-410e-11eb-a086-3df61ba5e799','1d97ea9c-410e-11eb-a086-3df61ba5e799','null',NULL,'Y',NULL,'2020-12-18 14:20:44','2020-12-18 14:20:44',NULL,NULL,'Y'),(11,'1da38c08-410e-11eb-a086-3df61ba5e799','1d97ea9c-410e-11eb-a086-3df61ba5e799','1',NULL,'Y',NULL,'2020-12-18 14:20:44','2020-12-18 14:20:44',NULL,NULL,'Y'),(12,'ad67efcc-4119-11eb-a086-3df61ba5e799','ad651d24-4119-11eb-a086-3df61ba5e799','4',NULL,'Y',NULL,'2020-12-18 15:43:30','2020-12-18 15:43:30',NULL,NULL,'Y'),(13,'ad689b0c-4119-11eb-a086-3df61ba5e799','ad651d24-4119-11eb-a086-3df61ba5e799','null',NULL,'Y',NULL,'2020-12-18 15:43:30','2020-12-18 15:43:30',NULL,NULL,'Y'),(14,'ad694610-4119-11eb-a086-3df61ba5e799','ad651d24-4119-11eb-a086-3df61ba5e799','1',NULL,'Y',NULL,'2020-12-18 15:43:30','2020-12-18 15:43:30',NULL,NULL,'Y'),(15,'ad6a09ce-4119-11eb-a086-3df61ba5e799','ad651d24-4119-11eb-a086-3df61ba5e799','6',NULL,'Y',NULL,'2020-12-18 15:43:30','2020-12-18 15:43:30',NULL,NULL,'Y'),(16,'72f1fc2c-4441-11eb-a086-3df61ba5e799','72dfd36c-4441-11eb-a086-3df61ba5e799','4',NULL,'Y',NULL,'2020-12-22 16:05:45','2020-12-22 16:05:45',NULL,NULL,'Y'),(17,'72f3bd1e-4441-11eb-a086-3df61ba5e799','72dfd36c-4441-11eb-a086-3df61ba5e799','1',NULL,'Y',NULL,'2020-12-22 16:05:45','2020-12-22 16:05:45',NULL,NULL,'Y'),(18,'72f728e6-4441-11eb-a086-3df61ba5e799','72dfd36c-4441-11eb-a086-3df61ba5e799','7',NULL,'Y',NULL,'2020-12-22 16:05:45','2020-12-22 16:05:45',NULL,NULL,'Y'),(19,'72f8735e-4441-11eb-a086-3df61ba5e799','72dfd36c-4441-11eb-a086-3df61ba5e799','6',NULL,'Y',NULL,'2020-12-22 16:05:45','2020-12-22 16:05:45',NULL,NULL,'Y'),(20,'7997f022-45fe-11eb-a086-3df61ba5e799','79947942-45fe-11eb-a086-3df61ba5e799','4',NULL,'Y',NULL,'2020-12-24 21:11:22','2020-12-24 21:11:22',NULL,NULL,'Y'),(21,'799900de-45fe-11eb-a086-3df61ba5e799','79947942-45fe-11eb-a086-3df61ba5e799','1',NULL,'Y',NULL,'2020-12-24 21:11:22','2020-12-24 21:11:22',NULL,NULL,'Y'),(22,'79997c4e-45fe-11eb-a086-3df61ba5e799','79947942-45fe-11eb-a086-3df61ba5e799','6',NULL,'Y',NULL,'2020-12-24 21:11:22','2020-12-24 21:11:22',NULL,NULL,'Y');
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sii`
--

DROP TABLE IF EXISTS `sii`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sii` (
  `submission_applno` varchar(45) DEFAULT NULL,
  `submission_class_code_id` varchar(45) DEFAULT NULL,
  `submission_type` varchar(45) DEFAULT NULL,
  `submission_number` varchar(45) DEFAULT NULL,
  `submission_status` varchar(45) DEFAULT NULL,
  `submission_status_date` datetime DEFAULT NULL,
  `submission_public_notes` varchar(45) DEFAULT NULL,
  `submission_review_priority` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'Y',
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sii`
--

LOCK TABLES `sii` WRITE;
/*!40000 ALTER TABLE `sii` DISABLE KEYS */;
/*!40000 ALTER TABLE `sii` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `states` (
  `states_id` int NOT NULL AUTO_INCREMENT,
  `states_uuid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `id` int DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `country_id` int unsigned NOT NULL,
  `country_code` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `fips_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `iso2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flag` int NOT NULL DEFAULT '1',
  `wikiDataId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'script',
  `updated_by` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'data load',
  `active_status` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'Y',
  PRIMARY KEY (`states_id`,`states_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4873 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submission`
--

DROP TABLE IF EXISTS `submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submission` (
  `submission_id` int NOT NULL AUTO_INCREMENT,
  `submission_uuid` varchar(45) DEFAULT NULL,
  `submission_applno` varchar(45) DEFAULT NULL,
  `submission_class_code_id` varchar(45) DEFAULT NULL,
  `submission_type` varchar(45) DEFAULT NULL,
  `submission_number` varchar(45) DEFAULT NULL,
  `submission_status` varchar(45) DEFAULT NULL,
  `submission_status_date` datetime DEFAULT NULL,
  `submission_public_notes` varchar(45) DEFAULT NULL,
  `submission_review_priority` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'Y',
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`submission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28135 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submission`
--

LOCK TABLES `submission` WRITE;
/*!40000 ALTER TABLE `submission` DISABLE KEYS */;
/*!40000 ALTER TABLE `submission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submission_class_lookup`
--

DROP TABLE IF EXISTS `submission_class_lookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submission_class_lookup` (
  `submission_class_lookup_id` int NOT NULL AUTO_INCREMENT,
  `submission_class_lookup_uuid` varchar(45) NOT NULL,
  `submission_class_lookup_codeid` varchar(45) DEFAULT NULL,
  `submission_class_lookup_code` varchar(45) DEFAULT NULL,
  `submission_class_lookup_code_description` varchar(5000) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`submission_class_lookup_id`,`submission_class_lookup_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submission_class_lookup`
--

LOCK TABLES `submission_class_lookup` WRITE;
/*!40000 ALTER TABLE `submission_class_lookup` DISABLE KEYS */;
/*!40000 ALTER TABLE `submission_class_lookup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submission_property_type`
--

DROP TABLE IF EXISTS `submission_property_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submission_property_type` (
  `submission_property_type_id` int NOT NULL AUTO_INCREMENT,
  `submission_property_type_uuid` varchar(45) NOT NULL,
  `submission_property_type_applno` varchar(45) DEFAULT NULL,
  `submission_property_type_Submission_type` varchar(45) DEFAULT NULL,
  `submission_property_type_code` varchar(45) DEFAULT NULL,
  `submission_property_type_property_type_id` varchar(45) DEFAULT NULL,
  `submission_property_type_number` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`submission_property_type_id`,`submission_property_type_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=9212 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submission_property_type`
--

LOCK TABLES `submission_property_type` WRITE;
/*!40000 ALTER TABLE `submission_property_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `submission_property_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_master_functionality`
--

DROP TABLE IF EXISTS `sys_master_functionality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_master_functionality` (
  `sys_master_functionality_id` int NOT NULL AUTO_INCREMENT,
  `sys_master_functionality_uuid` varchar(45) NOT NULL,
  `sys_master_functionality_name` varchar(45) NOT NULL,
  `sys_master_functionality_desc` varchar(45) DEFAULT NULL,
  `sys_master_functionality_description` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'Y',
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sys_master_functionality_id`,`sys_master_functionality_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_master_functionality`
--

LOCK TABLES `sys_master_functionality` WRITE;
/*!40000 ALTER TABLE `sys_master_functionality` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_master_functionality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_master_ref`
--

DROP TABLE IF EXISTS `sys_master_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_master_ref` (
  `sys_master_ref_id` int NOT NULL AUTO_INCREMENT,
  `sys_master_ref_uuid` varchar(45) NOT NULL,
  `sys_master_ref_function_id` varchar(45) DEFAULT NULL,
  `sys_master_seq_number` varchar(45) DEFAULT NULL,
  `sys_master_ref_short_description` varchar(45) DEFAULT NULL,
  `sys_master_ref_description` varchar(45) DEFAULT NULL,
  `sys_master_ref_funtionality_name` varchar(45) NOT NULL,
  `sys_master_ref_sort_order_number` varchar(45) DEFAULT NULL,
  `sys_master_ref_type` varchar(45) DEFAULT NULL,
  `sys_master_ref_external_reference_key` varchar(45) DEFAULT NULL,
  `sys_master_ref_external_ref_value` varchar(45) DEFAULT NULL,
  `sys_master_ref_ticket_id` varchar(45) DEFAULT NULL,
  `sys_master_ref_option1_key` varchar(45) DEFAULT NULL,
  `sys_master_ref_option1_value` varchar(45) DEFAULT NULL,
  `sys_master_ref_option2_key` varchar(45) DEFAULT NULL,
  `sys_master_ref_option2_value` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'Y',
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sys_master_ref_funtionality_uuid` varchar(45) NOT NULL,
  PRIMARY KEY (`sys_master_ref_id`,`sys_master_ref_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_master_ref`
--

LOCK TABLES `sys_master_ref` WRITE;
/*!40000 ALTER TABLE `sys_master_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_master_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_parameter`
--

DROP TABLE IF EXISTS `sys_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_parameter` (
  `system_parameter_id` int NOT NULL AUTO_INCREMENT,
  `sys_parameter_uuid` varchar(45) NOT NULL,
  `sys_parameter_name` varchar(45) NOT NULL,
  `sys_parameter_value` varchar(500) NOT NULL,
  `sys_parameter_description` varchar(45) DEFAULT NULL,
  `sys_parameter_data_type` varchar(45) DEFAULT NULL,
  `sys_parameter_begin_date` datetime DEFAULT NULL,
  `sys_parameter_end_date` datetime DEFAULT NULL,
  `sys_parameter_category` varchar(45) DEFAULT NULL,
  `sys_parameter_program` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'Y',
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`system_parameter_id`,`sys_parameter_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_parameter`
--

LOCK TABLES `sys_parameter` WRITE;
/*!40000 ALTER TABLE `sys_parameter` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `te`
--

DROP TABLE IF EXISTS `te`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `te` (
  `te_id` int NOT NULL AUTO_INCREMENT,
  `te_uuid` varchar(45) NOT NULL,
  `te_applno` varchar(45) DEFAULT NULL,
  `te_product_number` varchar(45) DEFAULT NULL,
  `te_marketing_status_id` varchar(45) DEFAULT NULL,
  `te_code` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`te_id`,`te_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=18152 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `te`
--

LOCK TABLES `te` WRITE;
/*!40000 ALTER TABLE `te` DISABLE KEYS */;
/*!40000 ALTER TABLE `te` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temptype`
--

DROP TABLE IF EXISTS `temptype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temptype` (
  `temptype_id` int NOT NULL AUTO_INCREMENT,
  `tempType_uuid` varchar(45) DEFAULT NULL,
  `tempType_name` varchar(45) DEFAULT NULL,
  `tempType_short_description` varchar(45) DEFAULT NULL,
  `tempType_description` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT NULL,
  `updated_dts` datetime DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`temptype_id`),
  UNIQUE KEY `temptype_id_UNIQUE` (`temptype_id`),
  UNIQUE KEY `tempTypeUUID_UNIQUE` (`tempType_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temptype`
--

LOCK TABLES `temptype` WRITE;
/*!40000 ALTER TABLE `temptype` DISABLE KEYS */;
/*!40000 ALTER TABLE `temptype` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`eventDb`@`%`*/ /*!50003 TRIGGER `temptype_BIT` BEFORE INSERT ON `temptype` FOR EACH ROW BEGIN
if new.temptype_uuid is null  then 
set new.temptype_uuid = uuid();
end if;
if (new.active_status is null) ||  (new.active_status = '') then
set new.active_status = 'Y';
else 
set new.active_status = upper(new.active_status);
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_uuid` varchar(50) NOT NULL,
  `user_first_name` varchar(50) DEFAULT NULL,
  `user_last_name` varchar(50) DEFAULT NULL,
  `user_middle_name` varchar(50) DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_password` varchar(150) DEFAULT NULL,
  `user_contactnumber` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `user_group_id` varchar(50) DEFAULT NULL,
  `user_roleId` varchar(50) DEFAULT NULL,
  `user_user_id` varchar(50) DEFAULT NULL,
  `user_role_id` varchar(50) DEFAULT NULL,
  `user_org_id` varchar(50) DEFAULT NULL,
  `user_expiration_date` datetime DEFAULT NULL,
  `user_activated_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `user_lastactivity_date` datetime DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_auth_user_id` varchar(45) DEFAULT NULL,
  `user_job_id` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`user_id`,`user_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ec9eddee-32dd-11eb-8551-f84a89d27f07','Admin','test','user','admin@suresh.com','YWRtaW4=','12345',NULL,NULL,'78fb491e-32d2-11eb-8551-f84a89d27f07',NULL,'78fb491e-32d2-11eb-8551-f84a89d27f07',NULL,NULL,'2020-11-30 13:00:30',NULL,'2020-11-30 13:00:30','2020-12-17 16:41:55',NULL,NULL,NULL,NULL,'Y'),
(2,'1bc00ca8-4443-11eb-a086-3df61ba5e799','Narayan','Janga','Reddy','narayan@care.com','MTIzNDU2','34343','blgr','8539f428-4442-11eb-82e8-1d452938ef37',NULL,NULL,'72dfd36c-4441-11eb-a086-3df61ba5e799',NULL,NULL,'2020-12-22 16:17:38',NULL,'2020-12-22 16:17:38','2020-12-23 17:13:05',NULL,NULL,'ec9eddee-32dd-11eb-8551-f84a89d27f07','ec9eddee-32dd-11eb-8551-f84a89d27f07','N'),
(3,'0597302e-44fb-11eb-a086-3df61ba5e799','Raju','Check','Middle','raju@abc.com','MTIz','5758','bbb','8539f428-4442-11eb-82e8-1d452938ef37',NULL,NULL,'72dfd36c-4441-11eb-a086-3df61ba5e799',NULL,NULL,'2020-12-23 14:14:08',NULL,'2020-12-23 14:14:08','2020-12-23 14:14:08',NULL,NULL,'ec9eddee-32dd-11eb-8551-f84a89d27f07','ec9eddee-32dd-11eb-8551-f84a89d27f07','Y'),
(4,'07bad1b6-4600-11eb-a086-3df61ba5e799','adf','fdf','aef','srikantn@ga.com','MQ==','erewr',NULL,'5204ad5c-45fe-11eb-bc64-61508000d620',NULL,NULL,'72dfd36c-4441-11eb-a086-3df61ba5e799',NULL,NULL,'2020-12-24 21:22:30',NULL,'2020-12-24 21:22:30','2020-12-24 21:22:30',NULL,NULL,'ec9eddee-32dd-11eb-8551-f84a89d27f07','ec9eddee-32dd-11eb-8551-f84a89d27f07','Y'),
(5,'3bb5d7e0-4600-11eb-a086-3df61ba5e799','test','user','role','tes@az.com','MTIzNA==','637',NULL,'8539f428-4442-11eb-82e8-1d452938ef37',NULL,NULL,'79947942-45fe-11eb-a086-3df61ba5e799',NULL,NULL,'2020-12-24 21:23:58',NULL,'2020-12-24 21:23:58','2020-12-24 21:23:58',NULL,NULL,'ec9eddee-32dd-11eb-8551-f84a89d27f07','ec9eddee-32dd-11eb-8551-f84a89d27f07','Y');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_role_id` int NOT NULL AUTO_INCREMENT,
  `user_role_uuid` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `permission_id` varchar(45) DEFAULT NULL,
  `user_role_expiration_date` datetime DEFAULT NULL,
  `user_role_available_indicator` varchar(45) DEFAULT 'Y',
  `user_role_authorization_user_id` varchar(45) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `active_status` varchar(45) DEFAULT 'N',
  PRIMARY KEY (`user_role_id`,`user_role_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usereventgroupmapping`
--

DROP TABLE IF EXISTS `usereventgroupmapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usereventgroupmapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `groupId` char(36) NOT NULL,
  `userEventId` char(36) NOT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `IDX_UGM_GID_STATUS` (`groupId`,`active_status`),
  KEY `IDX_UGM_UID_STATUS` (`userEventId`,`active_status`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usereventgroupmapping`
--

LOCK TABLES `usereventgroupmapping` WRITE;
/*!40000 ALTER TABLE `usereventgroupmapping` DISABLE KEYS */;
INSERT INTO `usereventgroupmapping` VALUES (1,'8539f428-4442-11eb-82e8-1d452938ef37','469d841d-44fb-11eb-825a-d1882c546d05','2020-12-23 14:15:57','2020-12-23 14:15:57',0),(2,'8539f428-4442-11eb-82e8-1d452938ef37','e676d154-4601-11eb-a835-c768c4d979f3','2020-12-24 21:35:54','2020-12-24 21:35:54',0);
/*!40000 ALTER TABLE `usereventgroupmapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usereventrolemapping`
--

DROP TABLE IF EXISTS `usereventrolemapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usereventrolemapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roleId` char(36) NOT NULL,
  `userEventId` char(36) NOT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `IDX_URM_RID_STATUS` (`roleId`,`active_status`),
  KEY `IDX_URM_UID_STATUS` (`userEventId`,`active_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usereventrolemapping`
--

LOCK TABLES `usereventrolemapping` WRITE;
/*!40000 ALTER TABLE `usereventrolemapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `usereventrolemapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usereventscheduler`
--

DROP TABLE IF EXISTS `usereventscheduler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usereventscheduler` (
  `user_event_id` int NOT NULL AUTO_INCREMENT,
  `user_event_uuid` varchar(50) NOT NULL,
  `eventName` varchar(100) DEFAULT NULL,
  `emailReceiver` text,
  `cronExpression` varchar(100) DEFAULT NULL,
  `rangeStart` int unsigned NOT NULL,
  `rangeEnd` int unsigned NOT NULL,
  `active` tinyint NOT NULL DEFAULT '1',
  `expireTime` datetime NOT NULL,
  `onDay` smallint NOT NULL DEFAULT '0',
  `scheduled` smallint NOT NULL DEFAULT '0',
  `lastRunTime` datetime DEFAULT NULL,
  `nextRunTime` datetime DEFAULT NULL,
  `user_org_id` varchar(50) DEFAULT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_event_id`,`user_event_uuid`),
  KEY `IDX_EVENT_DCHLD_ACTV_ET` (`user_event_uuid`,`active`,`expireTime`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usereventscheduler`
--

LOCK TABLES `usereventscheduler` WRITE;
/*!40000 ALTER TABLE `usereventscheduler` DISABLE KEYS */;
INSERT INTO `usereventscheduler` VALUES (1,'469d841d-44fb-11eb-825a-d1882c546d05','Narayan','narayanareddy654@gmail.com','0 21 14 ? * * *',1440,0,1,'2021-01-23 14:15:58',0,1,NULL,NULL,NULL,'2020-12-23 14:15:57','2020-12-23 17:10:00',NULL,NULL),(2,'e676d154-4601-11eb-a835-c768c4d979f3','TestNewEvent','narayanareddy654@gmail.com','0 41 21 ? * * *',1440,0,1,'2021-01-24 21:35:54',0,1,NULL,NULL,NULL,'2020-12-24 21:35:54','2020-12-24 21:40:00',NULL,NULL);
/*!40000 ALTER TABLE `usereventscheduler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usereventusermapping`
--

DROP TABLE IF EXISTS `usereventusermapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usereventusermapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` char(36) NOT NULL,
  `userEventId` char(36) NOT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `IDX_UUM_UID_STATUS` (`userId`,`active_status`),
  KEY `IDX_UUM_STATUS` (`userEventId`,`active_status`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usereventusermapping`
--

LOCK TABLES `usereventusermapping` WRITE;
/*!40000 ALTER TABLE `usereventusermapping` DISABLE KEYS */;
INSERT INTO `usereventusermapping` VALUES (1,'0597302e-44fb-11eb-a086-3df61ba5e799','469d841d-44fb-11eb-825a-d1882c546d05','2020-12-23 14:15:57','2020-12-23 14:15:57',0),(2,'ec9eddee-32dd-11eb-8551-f84a89d27f07','e676d154-4601-11eb-a835-c768c4d979f3','2020-12-24 21:35:54','2020-12-24 21:35:54',0);
/*!40000 ALTER TABLE `usereventusermapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usergroupmapping`
--

DROP TABLE IF EXISTS `usergroupmapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usergroupmapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `groupId` char(36) NOT NULL,
  `userId` char(36) NOT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `IDX_UGM_GID_DEL_IA` (`groupId`,`active_status`),
  KEY `IDX_UGM_UID_DEL` (`userId`,`active_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usergroupmapping`
--

LOCK TABLES `usergroupmapping` WRITE;
/*!40000 ALTER TABLE `usergroupmapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `usergroupmapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userorganizationmapping`
--

DROP TABLE IF EXISTS `userorganizationmapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userorganizationmapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orgId` char(36) NOT NULL,
  `userId` char(36) NOT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `IDX_RID_DEL` (`orgId`,`active_status`),
  KEY `IDX_UID_DEL` (`userId`,`active_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userorganizationmapping`
--

LOCK TABLES `userorganizationmapping` WRITE;
/*!40000 ALTER TABLE `userorganizationmapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `userorganizationmapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrolemapping`
--

DROP TABLE IF EXISTS `userrolemapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userrolemapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roleId` char(36) NOT NULL,
  `userId` char(36) NOT NULL,
  `created_dts` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_dts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `active_status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `IDX_UGM_RID_DEL` (`roleId`,`active_status`),
  KEY `IDX_UGM_UID_DEL` (`userId`,`active_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrolemapping`
--

LOCK TABLES `userrolemapping` WRITE;
/*!40000 ALTER TABLE `userrolemapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `userrolemapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertoken`
--

DROP TABLE IF EXISTS `usertoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertoken` (
  `userTokenId` char(36) NOT NULL,
  `userId` char(36) NOT NULL,
  `token` char(64) DEFAULT NULL,
  `inactive` tinyint(1) NOT NULL DEFAULT '0',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastActivity` timestamp NOT NULL,
  PRIMARY KEY (`userTokenId`),
  KEY `IDX_TOKEN` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertoken`
--

LOCK TABLES `usertoken` WRITE;
/*!40000 ALTER TABLE `usertoken` DISABLE KEYS */;
INSERT INTO `usertoken` VALUES ('206f6a6d-5610-11eb-9c4d-63685265460c','ec9eddee-32dd-11eb-8551-f84a89d27f07','$2a$12$aP4gty7GDxyLCOpV75I2deAEQM.ADdjF6h1LFEQXNbXJzz8oczeH.',0,'2021-01-14 02:28:02','2021-01-14 02:28:02'),('31b4860e-560d-11eb-9cdf-490587facf9e','ec9eddee-32dd-11eb-8551-f84a89d27f07','$2a$12$FXJ7edxerBGdijfyGpNw8u5XQVOxdOieMejdLuGM5vtx6EHSyNUVa',0,'2021-01-14 02:07:03','2021-01-14 02:07:24'),('486d2af9-7c94-11eb-b17c-2d3e9f378904','ec9eddee-32dd-11eb-8551-f84a89d27f07','$2a$12$g4V05aVOx8wa1yVWo0deGOZMRLJ3WICpsp.kGWSFpM3gcpTPdXF.a',0,'2021-03-04 02:49:47','2021-03-04 02:49:47'),('5413a69a-7c94-11eb-b17c-7d42f4a12c04','ec9eddee-32dd-11eb-8551-f84a89d27f07','$2a$12$piWdnwGgZz5PQziI8zyog.ciwxb38c69L7PmJ105iJsEsHqA2nSDG',0,'2021-03-04 02:50:07','2021-03-04 02:50:07'),('f1d9ac9b-560d-11eb-b2cd-2f94fb340040','ec9eddee-32dd-11eb-8551-f84a89d27f07','$2a$12$.gw.IAE2WrGOqj9Tl020LuZZykaQ49umhVV6hjkXZofQ6yphmsujC',0,'2021-01-14 02:12:25','2021-01-14 02:28:36');
/*!40000 ALTER TABLE `usertoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'eventadministrationdb'
--

--
-- Dumping routines for database 'eventadministrationdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-27 11:19:27
