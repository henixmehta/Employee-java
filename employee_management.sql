-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 09, 2024 at 07:50 AM
-- Server version: 5.7.44-log
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employee_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `assets_details`
--

DROP TABLE IF EXISTS `assets_details`;
CREATE TABLE IF NOT EXISTS `assets_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `asset_id` int(11) DEFAULT NULL,
  `asset_number` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `assign_date` datetime DEFAULT NULL,
  `return_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `asset_id` (`asset_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=ascii;

--
-- Dumping data for table `assets_details`
--

INSERT INTO `assets_details` (`id`, `asset_id`, `asset_number`, `user_id`, `assign_date`, `return_date`) VALUES
(1, 1, 10, 1, '2023-11-10 23:58:58', '2024-11-08 23:58:58'),
(2, 2, 10, 1, '2023-11-10 23:58:58', '2024-11-08 23:58:58');

-- --------------------------------------------------------

--
-- Table structure for table `assets_master`
--

DROP TABLE IF EXISTS `assets_master`;
CREATE TABLE IF NOT EXISTS `assets_master` (
  `asset_id` int(11) NOT NULL AUTO_INCREMENT,
  `asset_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`asset_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=ascii;

--
-- Dumping data for table `assets_master`
--

INSERT INTO `assets_master` (`asset_id`, `asset_name`) VALUES
(1, 'laptop'),
(2, 'charger');

-- --------------------------------------------------------

--
-- Table structure for table `attendance_details`
--

DROP TABLE IF EXISTS `attendance_details`;
CREATE TABLE IF NOT EXISTS `attendance_details` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `check_in` datetime DEFAULT NULL,
  `check_out` datetime DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `department_master`
--

DROP TABLE IF EXISTS `department_master`;
CREATE TABLE IF NOT EXISTS `department_master` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  KEY `manager_id` (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=ascii;

--
-- Dumping data for table `department_master`
--

INSERT INTO `department_master` (`dept_id`, `dept_name`, `description`, `manager_id`) VALUES
(1, 'Human Resources and Development', 'hr taking interview', 1),
(2, 'Human Resources and Development', 'hr doing development', 1);

-- --------------------------------------------------------

--
-- Table structure for table `designation_master`
--

DROP TABLE IF EXISTS `designation_master`;
CREATE TABLE IF NOT EXISTS `designation_master` (
  `designation_id` int(11) NOT NULL AUTO_INCREMENT,
  `Designation` varchar(50) DEFAULT NULL,
  `responsibility` varchar(50) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`designation_id`),
  KEY `department_id` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=ascii;

--
-- Dumping data for table `designation_master`
--

INSERT INTO `designation_master` (`designation_id`, `Designation`, `responsibility`, `department_id`) VALUES
(1, 'HR', 'hiring recruiter', 1),
(2, 'manager', 'arranging meetings', 2);

-- --------------------------------------------------------

--
-- Table structure for table `document_details`
--

DROP TABLE IF EXISTS `document_details`;
CREATE TABLE IF NOT EXISTS `document_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `doc_id` int(11) DEFAULT NULL,
  `document_number` varchar(50) DEFAULT NULL,
  `document_path` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `doc_id` (`doc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `document_master`
--

DROP TABLE IF EXISTS `document_master`;
CREATE TABLE IF NOT EXISTS `document_master` (
  `doc_id` int(11) NOT NULL AUTO_INCREMENT,
  `doc_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `group_master`
--

DROP TABLE IF EXISTS `group_master`;
CREATE TABLE IF NOT EXISTS `group_master` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `holiday_master`
--

DROP TABLE IF EXISTS `holiday_master`;
CREATE TABLE IF NOT EXISTS `holiday_master` (
  `holiday_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  `holiday_date` date DEFAULT NULL,
  PRIMARY KEY (`holiday_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `leave_details`
--

DROP TABLE IF EXISTS `leave_details`;
CREATE TABLE IF NOT EXISTS `leave_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leave_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `reason` varchar(50) DEFAULT NULL,
  `status` enum('Requested','Approved','Rejected') DEFAULT NULL,
  `reject_reason` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `leave_type_id` (`leave_type_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `leave_master`
--

DROP TABLE IF EXISTS `leave_master`;
CREATE TABLE IF NOT EXISTS `leave_master` (
  `leave_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `leave_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`leave_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `performance_details`
--

DROP TABLE IF EXISTS `performance_details`;
CREATE TABLE IF NOT EXISTS `performance_details` (
  `performance_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `review_date` date DEFAULT NULL,
  `review_by` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`performance_id`),
  KEY `user_id` (`user_id`),
  KEY `review_by` (`review_by`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `project_details`
--

DROP TABLE IF EXISTS `project_details`;
CREATE TABLE IF NOT EXISTS `project_details` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` enum('Submitted','In Progress','Onhold','Completed') DEFAULT NULL,
  `on_hold_days` int(11) DEFAULT NULL,
  `on_hold_reason` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `skills_master`
--

DROP TABLE IF EXISTS `skills_master`;
CREATE TABLE IF NOT EXISTS `skills_master` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=ascii;

--
-- Dumping data for table `skills_master`
--

INSERT INTO `skills_master` (`skill_id`, `skill_name`, `description`) VALUES
(1, 'PHP', 'PHP'),
(2, 'react', 'react'),
(3, 'react', 'react'),
(4, NULL, NULL),
(5, NULL, NULL),
(6, 'bgmnfn', 'KJMHMBMN'),
(7, 'JAVA', 'react'),
(8, 'AOSHDOH', 'AOSHDOIAHSOD'),
(9, 'MBVNMGF', 'HGFHGFHGF'),
(10, 'MHVHJGJB', 'JKNKBKBMB'),
(11, 'java', 'enterprise java');

-- --------------------------------------------------------

--
-- Table structure for table `task_details`
--

DROP TABLE IF EXISTS `task_details`;
CREATE TABLE IF NOT EXISTS `task_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL,
  `assign_by` int(11) DEFAULT NULL,
  `assign_to` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `on_hold_days` int(11) DEFAULT NULL,
  `on_hold_reason` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `task_id` (`task_id`),
  KEY `assign_by` (`assign_by`),
  KEY `assign_to` (`assign_to`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `task_master`
--

DROP TABLE IF EXISTS `task_master`;
CREATE TABLE IF NOT EXISTS `task_master` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_title` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `priority` enum('Low','Medium','High','Highest','Urgent') DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `task_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
CREATE TABLE IF NOT EXISTS `user_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `skill_id` int(11) DEFAULT NULL,
  `designation_id` int(11) DEFAULT NULL,
  `active` enum('YES','NO') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `group_id` (`group_id`),
  KEY `dept_id` (`dept_id`),
  KEY `skill_id` (`skill_id`),
  KEY `designation_id` (`designation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `user_master`
--

DROP TABLE IF EXISTS `user_master`;
CREATE TABLE IF NOT EXISTS `user_master` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `emergency_contact` bigint(20) DEFAULT NULL,
  `profile_image` varchar(100) DEFAULT NULL,
  `company_email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `reporting_to` int(11) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  `qualification` varchar(100) DEFAULT NULL,
  `current_experience` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `company_email` (`company_email`),
  KEY `reporting_to` (`reporting_to`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=ascii;

--
-- Dumping data for table `user_master`
--

INSERT INTO `user_master` (`user_id`, `user_name`, `email_id`, `phone_no`, `date_of_birth`, `age`, `gender`, `joining_date`, `address`, `emergency_contact`, `profile_image`, `company_email`, `password`, `reporting_to`, `salary`, `qualification`, `current_experience`) VALUES
(1, 'manager', 'abc@gmail.com', 9876789876, '2000-11-08', 27, 'Female', '2020-11-01', 'ndjbjkanad', NULL, 'qdnjfhkjndkjdanawd', 'kjjcszzsczs', 'whjabdjh', 9876543, 876543, 'kjhgfg', 'fghjklgh'),
(3, 'manager', 'abc@gmail.com', 9876789876, '2000-11-08', 27, 'Female', '2020-11-01', 'ndjbjkanad', NULL, 'qdnjfhkjndkjdanawd', 'szzsczs', 'whjabdjh', 9876543, 876543, 'kjhgfg', 'fghjklgh');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assets_details`
--
ALTER TABLE `assets_details`
  ADD CONSTRAINT `assets_details_ibfk_1` FOREIGN KEY (`asset_id`) REFERENCES `assets_master` (`asset_id`),
  ADD CONSTRAINT `assets_details_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`);

--
-- Constraints for table `attendance_details`
--
ALTER TABLE `attendance_details`
  ADD CONSTRAINT `attendance_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`);

--
-- Constraints for table `department_master`
--
ALTER TABLE `department_master`
  ADD CONSTRAINT `department_master_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `user_master` (`user_id`);

--
-- Constraints for table `designation_master`
--
ALTER TABLE `designation_master`
  ADD CONSTRAINT `designation_master_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department_master` (`dept_id`);

--
-- Constraints for table `document_details`
--
ALTER TABLE `document_details`
  ADD CONSTRAINT `document_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`),
  ADD CONSTRAINT `document_details_ibfk_2` FOREIGN KEY (`doc_id`) REFERENCES `document_master` (`doc_id`);

--
-- Constraints for table `leave_details`
--
ALTER TABLE `leave_details`
  ADD CONSTRAINT `leave_details_ibfk_1` FOREIGN KEY (`leave_type_id`) REFERENCES `leave_master` (`leave_type_id`),
  ADD CONSTRAINT `leave_details_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`);

--
-- Constraints for table `performance_details`
--
ALTER TABLE `performance_details`
  ADD CONSTRAINT `performance_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`),
  ADD CONSTRAINT `performance_details_ibfk_2` FOREIGN KEY (`review_by`) REFERENCES `user_master` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
