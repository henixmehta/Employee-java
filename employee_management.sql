CREATE DATABASE  IF NOT EXISTS `employee_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `employee_management`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: employee_management
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `assets_details`
--

DROP TABLE IF EXISTS `assets_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assets_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `asset_id` int DEFAULT NULL,
  `asset_number` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `assign_date` datetime DEFAULT NULL,
  `return_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `asset_id` (`asset_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `assets_details_ibfk_1` FOREIGN KEY (`asset_id`) REFERENCES `assets_master` (`asset_id`),
  CONSTRAINT `assets_details_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assets_details`
--

LOCK TABLES `assets_details` WRITE;
/*!40000 ALTER TABLE `assets_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `assets_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assets_master`
--

DROP TABLE IF EXISTS `assets_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assets_master` (
  `asset_id` int NOT NULL AUTO_INCREMENT,
  `asset_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`asset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assets_master`
--

LOCK TABLES `assets_master` WRITE;
/*!40000 ALTER TABLE `assets_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `assets_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance_details`
--

DROP TABLE IF EXISTS `attendance_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance_details` (
  `attendance_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `check_in` datetime DEFAULT NULL,
  `check_out` datetime DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `attendance_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance_details`
--

LOCK TABLES `attendance_details` WRITE;
/*!40000 ALTER TABLE `attendance_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_master`
--

DROP TABLE IF EXISTS `department_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department_master` (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `manager_id` int DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  KEY `manager_id` (`manager_id`),
  CONSTRAINT `department_master_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_master`
--

LOCK TABLES `department_master` WRITE;
/*!40000 ALTER TABLE `department_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `department_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `designation_master`
--

DROP TABLE IF EXISTS `designation_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `designation_master` (
  `designation_id` int NOT NULL AUTO_INCREMENT,
  `Designation` varchar(50) DEFAULT NULL,
  `responsibility` varchar(50) DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  PRIMARY KEY (`designation_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `designation_master_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department_master` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `designation_master`
--

LOCK TABLES `designation_master` WRITE;
/*!40000 ALTER TABLE `designation_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `designation_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_details`
--

DROP TABLE IF EXISTS `document_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `doc_id` int DEFAULT NULL,
  `document_number` varchar(50) DEFAULT NULL,
  `document_path` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `doc_id` (`doc_id`),
  CONSTRAINT `document_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`),
  CONSTRAINT `document_details_ibfk_2` FOREIGN KEY (`doc_id`) REFERENCES `document_master` (`doc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_details`
--

LOCK TABLES `document_details` WRITE;
/*!40000 ALTER TABLE `document_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_master`
--

DROP TABLE IF EXISTS `document_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_master` (
  `doc_id` int NOT NULL AUTO_INCREMENT,
  `doc_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_master`
--

LOCK TABLES `document_master` WRITE;
/*!40000 ALTER TABLE `document_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_master`
--

DROP TABLE IF EXISTS `group_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_master` (
  `group_id` int NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_master`
--

LOCK TABLES `group_master` WRITE;
/*!40000 ALTER TABLE `group_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holiday_master`
--

DROP TABLE IF EXISTS `holiday_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `holiday_master` (
  `holiday_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  `holiday_date` date DEFAULT NULL,
  PRIMARY KEY (`holiday_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday_master`
--

LOCK TABLES `holiday_master` WRITE;
/*!40000 ALTER TABLE `holiday_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `holiday_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_details`
--

DROP TABLE IF EXISTS `leave_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `leave_type_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `reason` varchar(50) DEFAULT NULL,
  `status` enum('Requested','Approved','Rejected') DEFAULT NULL,
  `reject_reason` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `leave_type_id` (`leave_type_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `leave_details_ibfk_1` FOREIGN KEY (`leave_type_id`) REFERENCES `leave_master` (`leave_type_id`),
  CONSTRAINT `leave_details_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_details`
--

LOCK TABLES `leave_details` WRITE;
/*!40000 ALTER TABLE `leave_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_master`
--

DROP TABLE IF EXISTS `leave_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_master` (
  `leave_type_id` int NOT NULL AUTO_INCREMENT,
  `leave_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`leave_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_master`
--

LOCK TABLES `leave_master` WRITE;
/*!40000 ALTER TABLE `leave_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performance_details`
--

DROP TABLE IF EXISTS `performance_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performance_details` (
  `performance_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `review_date` date DEFAULT NULL,
  `review_by` int DEFAULT NULL,
  `rating` int DEFAULT NULL,
  PRIMARY KEY (`performance_id`),
  KEY `user_id` (`user_id`),
  KEY `review_by` (`review_by`),
  CONSTRAINT `performance_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`),
  CONSTRAINT `performance_details_ibfk_2` FOREIGN KEY (`review_by`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performance_details`
--

LOCK TABLES `performance_details` WRITE;
/*!40000 ALTER TABLE `performance_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `performance_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_details`
--

DROP TABLE IF EXISTS `project_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_details` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` enum('Submitted','In Progress','Onhold','Completed') DEFAULT NULL,
  `on_hold_days` int DEFAULT NULL,
  `on_hold_reason` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_details`
--

LOCK TABLES `project_details` WRITE;
/*!40000 ALTER TABLE `project_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills_master`
--

DROP TABLE IF EXISTS `skills_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skills_master` (
  `skill_id` int NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills_master`
--

LOCK TABLES `skills_master` WRITE;
/*!40000 ALTER TABLE `skills_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `skills_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_details`
--

DROP TABLE IF EXISTS `task_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `task_id` int DEFAULT NULL,
  `assign_by` int DEFAULT NULL,
  `assign_to` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `on_hold_days` int DEFAULT NULL,
  `on_hold_reason` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `task_id` (`task_id`),
  KEY `assign_by` (`assign_by`),
  KEY `assign_to` (`assign_to`),
  CONSTRAINT `task_details_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `task_master` (`task_id`),
  CONSTRAINT `task_details_ibfk_2` FOREIGN KEY (`assign_by`) REFERENCES `user_master` (`user_id`),
  CONSTRAINT `task_details_ibfk_3` FOREIGN KEY (`assign_to`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_details`
--

LOCK TABLES `task_details` WRITE;
/*!40000 ALTER TABLE `task_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_master`
--

DROP TABLE IF EXISTS `task_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_master` (
  `task_id` int NOT NULL AUTO_INCREMENT,
  `task_title` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `priority` enum('Low','Medium','High','Highest','Urgent') DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `project_id` int DEFAULT NULL,
  `task_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `task_master_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project_details` (`project_id`),
  CONSTRAINT `task_master_chk_1` CHECK ((`task_status` in (_utf8mb4'Created',_utf8mb4'Ready for development',_utf8mb4'In-development',_utf8mb4'On hold',_utf8mb4'Completed')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_master`
--

LOCK TABLES `task_master` WRITE;
/*!40000 ALTER TABLE `task_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `group_id` int DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `skill_id` int DEFAULT NULL,
  `designation_id` int DEFAULT NULL,
  `active` enum('YES','NO') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `group_id` (`group_id`),
  KEY `dept_id` (`dept_id`),
  KEY `skill_id` (`skill_id`),
  KEY `designation_id` (`designation_id`),
  CONSTRAINT `user_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`),
  CONSTRAINT `user_details_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `group_master` (`group_id`),
  CONSTRAINT `user_details_ibfk_3` FOREIGN KEY (`dept_id`) REFERENCES `department_master` (`dept_id`),
  CONSTRAINT `user_details_ibfk_4` FOREIGN KEY (`skill_id`) REFERENCES `skills_master` (`skill_id`),
  CONSTRAINT `user_details_ibfk_5` FOREIGN KEY (`designation_id`) REFERENCES `designation_master` (`designation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_master`
--

DROP TABLE IF EXISTS `user_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_master` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `phone_no` bigint DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `emergency_contact` bigint DEFAULT NULL,
  `profile_image` varchar(100) DEFAULT NULL,
  `company_email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `reporting_to` int DEFAULT NULL,
  `salary` bigint DEFAULT NULL,
  `qualification` varchar(100) DEFAULT NULL,
  `current_experience` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `company_email` (`company_email`),
  KEY `reporting_to` (`reporting_to`),
  CONSTRAINT `user_master_ibfk_1` FOREIGN KEY (`reporting_to`) REFERENCES `user_master` (`user_id`) ON DELETE SET NULL,
  CONSTRAINT `user_master_chk_1` CHECK ((`current_experience` in (_utf8mb4'Fresher',_utf8mb4'Internship',_utf8mb4'6 month',_utf8mb4'1 year')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_master`
--

LOCK TABLES `user_master` WRITE;
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-07 14:31:26
