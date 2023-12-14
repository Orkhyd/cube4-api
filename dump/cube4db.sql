-- MariaDB dump 10.19-11.1.2-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: cube4dbv2
-- ------------------------------------------------------
-- Server version	11.1.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `sell_price` decimal(10,2) DEFAULT NULL,
  `buy_price` decimal(10,2) DEFAULT NULL,
  `id_supplier` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  `delete` boolean DEFAULT 0,
  `save_quantity` int(11) DEFAULT 0,
  `auto_order` tinyint(1) DEFAULT NULL,
  `min_order_threshold` int(11) DEFAULT NULL,
  `carton_price` decimal(5,2) DEFAULT NULL,
  `wine_year` int(11) DEFAULT NULL,
  `id_categorie` int(11) DEFAULT NULL,
  `id_subcategorie` int(11) DEFAULT NULL,
  `id_house` int(11) DEFAULT NULL,
  `tendance` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `id_supplier` (`id_supplier`),
  KEY `fk_items_categorie` (`id_categorie`),
  KEY `fk_items_souscategorie` (`id_subcategorie`),
  KEY `id_house` (`id_house`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `suppliers` (`id`),
  CONSTRAINT `items_ibfk_2` FOREIGN KEY (`id_house`) REFERENCES `houses` (`id`),
  CONSTRAINT `fk_items_categorie` FOREIGN KEY (`id_categorie`) REFERENCES `categories` (`id`),
  CONSTRAINT `fk_items_subcategorie` FOREIGN KEY (`id_subcategorie`) REFERENCES `subcategories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES
(24,'JP-Chenet','Vin blanc fruité d\'Alsace.',35.00,11.00,1,NULL,NULL,1,150,1,10,210.00,2021,2,4,3,0),
(25,'Gascogne','Vin rouge de gascogne sec',29.00,8.00,1,NULL,NULL,1,67,1,20,174.00,2023,1,5,4,0),
(26,'Saint Emillion','Vin Rosé de Bretagne léger',40.00,14.00,2,NULL,NULL,1,54,1,8,240.00,2019,3,2,1,0),
(27,'Lumbrasco','Vin rouge d\'été aux fines herbes',67.00,19.00,1,NULL,NULL,1,51,1,10,670.00,2016,1,4,2,1),
(28,'Lambrosco','Vsdqfsdfdsfs',50.00,10.00,1,NULL,NULL,0,56,1,10,500.00,2018,4,6,1,0),
(29,'sqd','sdq',444.00,44.00,1,NULL,NULL,0,2343,0,44,444.00,44,3,NULL,1,0);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemsorders`
--

DROP TABLE IF EXISTS `itemsorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsorders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_order` int(11) DEFAULT NULL,
  `id_item` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_order` (`id_order`),
  KEY `id_item` (`id_item`),
  CONSTRAINT `itemsorders_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `customersorders` (`id`),
  CONSTRAINT `itemsorders_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemsorders`
--

LOCK TABLES `itemsorders` WRITE;
/*!40000 ALTER TABLE `itemsorders` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemsorders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  `delete` boolean DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES
(1,'Rouge','2023-10-03 18:05:55','2023-10-03 18:05:55',0),
(2,'Blanc','2023-10-03 18:05:55','2023-10-03 18:05:55',0),
(3,'Rosé','2023-10-03 18:05:55','2023-10-03 18:05:55',0),
(4,'Champagne','2023-10-03 18:05:55','2023-10-03 18:05:55',0),
(7,'Pétillant',NULL,NULL,0);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customersorders`
--

DROP TABLE IF EXISTS `customersorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customersorders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_status` int(11) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `customersorders_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `userscustomers` (`id`),
  CONSTRAINT `customersorders_ibfk_2` FOREIGN KEY (`id_status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customersorders`
--

LOCK TABLES `customersorders` WRITE;
/*!40000 ALTER TABLE `customersorders` DISABLE KEYS */;
/*!40000 ALTER TABLE `customersorders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderssuppliers`
--

DROP TABLE IF EXISTS `orderssuppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderssuppliers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_supplier` int(11) DEFAULT NULL,
  `id_item` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `buy_price` decimal(10,2) DEFAULT NULL,
  `id_status` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_supplier` (`id_supplier`),
  KEY `id_item` (`id_item`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `orderssuppliers_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `suppliers` (`id`),
  CONSTRAINT `orderssuppliers_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `items` (`id`),
  CONSTRAINT `orderssuppliers_ibfk_3` FOREIGN KEY (`id_status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderssuppliers`
--

LOCK TABLES `orderssuppliers` WRITE;
/*!40000 ALTER TABLE `orderssuppliers` DISABLE KEYS */;
INSERT INTO `orderssuppliers` VALUES
(78,1,24,30,330.00,3,'2023-10-16 15:39:02','2023-10-16 15:39:02'),
(79,1,24,15,165.00,3,'2023-10-16 15:40:30','2023-10-16 15:40:30'),
(80,1,24,30,330.00,3,'2023-10-17 10:19:11','2023-10-17 10:19:11'),
(81,1,24,5,55.00,3,'2023-10-17 12:58:09','2023-10-17 12:58:09'),
(82,1,25,40,320.00,3,'2023-10-17 13:48:47','2023-10-17 13:48:47'),
(83,2,26,25,350.00,3,'2023-10-17 14:05:40','2023-10-17 14:05:40'),
(84,1,24,5,55.00,3,'2023-10-17 14:38:58','2023-10-17 14:38:58'),
(85,1,24,5,55.00,3,'2023-10-17 14:42:25','2023-10-17 14:42:25'),
(86,1,24,5,55.00,3,'2023-10-17 14:42:31','2023-10-17 14:42:31'),
(87,1,24,5,55.00,3,'2023-10-17 14:42:32','2023-10-17 14:42:32'),
(88,1,24,5,55.00,3,'2023-10-17 14:42:33','2023-10-17 14:42:33'),
(89,1,24,5,55.00,3,'2023-10-17 14:42:33','2023-10-17 14:42:33'),
(90,2,26,30,420.00,3,'2023-10-17 14:45:00','2023-10-17 14:45:00'),
(91,1,24,40,440.00,3,'2023-11-13 14:46:29','2023-11-13 14:46:29'),
(92,1,27,60,1140.00,3,'2023-11-16 14:54:13','2023-11-16 14:54:13'),
(93,1,28,30,300.00,3,'2023-11-16 15:09:31','2023-11-16 15:09:31');
/*!40000 ALTER TABLE `orderssuppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppliers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_entreprise` varchar(100) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  `delete` boolean DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES
(1,'VinDeFrance Ltd.','François','francois@vindefrance.com','+33 123456789','2023-10-03 18:06:02','2023-10-03 18:06:02',0),
(2,'VinoItalia S.p.A.','Giovanni','giovanni@vinoitalia.it','+39 987654321','2023-10-03 18:06:02','2023-10-03 18:06:02',0),
(3,'HandDeutsch SV','Hanse','hans@weindeutsch.de','+49 567891234','2023-10-03 18:06:02','2023-10-03 18:06:02',0),
(4,'Dartalia SMG','Diego','dartialiagmail.offsmg@gmail.com','0606797839',NULL,NULL,1),
(5,'sdf','sf','sfd','sfd',NULL,NULL,1),
(6,'hfdsfd','hfdssfdfds','hfdsfds@gmail.com','6666',NULL,NULL,1),
(7,'s','s','s','s',NULL,NULL,1),
(8,'h','h','herterter','h',NULL,NULL,1);
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventoriesitems`
--

DROP TABLE IF EXISTS `inventoriesitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventoriesitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_inventory_global` int(11) DEFAULT NULL,
  `id_item` int(11) DEFAULT NULL,
  `quantity_save` int(11) DEFAULT NULL,
  `quantity_real` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_inventory_global` (`id_inventory_global`),
  KEY `id_item` (`id_item`),
  CONSTRAINT `inventoriesitems_ibfk_1` FOREIGN KEY (`id_inventory_global`) REFERENCES `globalinventories` (`id`),
  CONSTRAINT `inventoriesitems_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `items` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventoriesitems`
--

LOCK TABLES `inventoriesitems` WRITE;
/*!40000 ALTER TABLE `inventoriesitems` DISABLE KEYS */;
INSERT INTO `inventoriesitems` VALUES
(1,6,24,150,150,'2023-11-16 14:27:09','2023-11-16 14:27:09'),
(2,6,25,40,37,'2023-11-16 14:27:09','2023-11-16 14:27:09'),
(3,7,24,150,149,'2023-11-16 14:27:41','2023-11-16 14:27:41'),
(4,7,25,37,37,'2023-11-16 14:27:41','2023-11-16 14:27:41'),
(5,7,26,55,55,'2023-11-16 14:27:41','2023-11-16 14:27:41'),
(6,8,24,150,149,'2023-11-16 14:31:44','2023-11-16 14:31:44'),
(7,8,25,37,37,'2023-11-16 14:31:44','2023-11-16 14:31:44'),
(8,8,26,55,55,'2023-11-16 14:31:44','2023-11-16 14:31:44'),
(9,9,24,150,149,'2023-11-16 14:31:49','2023-11-16 14:31:49'),
(10,9,25,37,37,'2023-11-16 14:31:49','2023-11-16 14:31:49'),
(11,9,26,55,55,'2023-11-16 14:31:49','2023-11-16 14:31:49'),
(12,10,24,150,140,'2023-11-16 14:32:01','2023-11-16 14:32:01'),
(13,10,25,37,37,'2023-11-16 14:32:01','2023-11-16 14:32:01'),
(14,10,26,55,55,'2023-11-16 14:32:01','2023-11-16 14:32:01'),
(15,11,24,150,140,'2023-11-16 14:32:03','2023-11-16 14:32:03'),
(16,11,25,37,37,'2023-11-16 14:32:03','2023-11-16 14:32:03'),
(17,11,26,55,55,'2023-11-16 14:32:03','2023-11-16 14:32:03'),
(18,12,24,140,140,'2023-11-16 14:33:28','2023-11-16 14:33:28'),
(19,12,25,37,37,'2023-11-16 14:33:28','2023-11-16 14:33:28'),
(20,12,26,55,55,'2023-11-16 14:33:28','2023-11-16 14:33:28'),
(21,13,24,140,140,'2023-11-16 14:37:02','2023-11-16 14:37:02'),
(22,13,25,37,37,'2023-11-16 14:37:02','2023-11-16 14:37:02'),
(23,13,26,55,55,'2023-11-16 14:37:02','2023-11-16 14:37:02'),
(24,14,24,140,140,'2023-11-16 14:37:05','2023-11-16 14:37:05'),
(25,14,25,37,37,'2023-11-16 14:37:05','2023-11-16 14:37:05'),
(26,14,26,55,54,'2023-11-16 14:37:05','2023-11-16 14:37:05'),
(27,15,24,140,25,'2023-11-16 14:38:30','2023-11-16 14:38:30'),
(28,16,24,25,56,'2023-11-16 14:43:15','2023-11-16 14:43:15'),
(29,16,25,37,30,'2023-11-16 14:43:15','2023-11-16 14:43:15'),
(30,17,24,25,150,'2023-11-16 14:48:08','2023-11-16 14:48:08'),
(31,18,24,25,150,'2023-11-16 14:49:06','2023-11-16 14:49:06'),
(32,19,24,25,150,'2023-11-16 14:50:57','2023-11-16 14:50:57'),
(33,19,25,37,67,'2023-11-16 14:50:57','2023-11-16 14:50:57'),
(34,20,27,60,60,'2023-11-16 14:54:28','2023-11-16 14:54:28'),
(35,21,27,60,56,'2023-11-16 14:54:47','2023-11-16 14:54:47'),
(36,22,27,56,51,'2023-11-16 14:57:52','2023-11-16 14:57:52'),
(37,23,28,30,29,'2023-11-16 15:09:57','2023-11-16 15:09:57'),
(38,24,28,29,48,'2023-11-16 15:22:49','2023-11-16 15:22:49'),
(39,25,28,48,45,'2023-11-16 15:24:23','2023-11-16 15:24:23'),
(40,26,28,45,45,'2023-11-16 15:32:05','2023-11-16 15:32:05'),
(41,27,28,45,45,'2023-11-16 15:32:28','2023-11-16 15:32:28'),
(42,28,28,45,45,'2023-11-16 15:37:39','2023-11-16 15:37:39'),
(43,29,28,45,45,'2023-11-16 15:40:08','2023-11-16 15:40:08'),
(44,30,28,45,45,'2023-11-16 15:44:29','2023-11-16 15:44:29'),
(45,31,28,45,45,'2023-11-16 15:45:25','2023-11-16 15:45:25'),
(46,32,28,45,45,'2023-11-16 15:45:33','2023-11-16 15:45:33'),
(47,33,28,45,45,'2023-11-16 15:46:28','2023-11-16 15:46:28'),
(48,34,28,45,36,'2023-11-16 15:47:18','2023-11-16 15:47:18'),
(49,35,28,36,46,'2023-11-16 15:49:35','2023-11-16 15:49:35'),
(50,35,29,0,78,'2023-11-16 15:49:35','2023-11-16 15:49:35'),
(51,36,28,46,10,'2023-11-16 15:52:54','2023-11-16 15:52:54'),
(52,37,29,78,2343,'2023-11-16 15:53:14','2023-11-16 15:53:14'),
(53,38,28,10,56,'2023-11-16 15:55:37','2023-11-16 15:55:37');
/*!40000 ALTER TABLE `inventoriesitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `globalinventories`
--

DROP TABLE IF EXISTS `globalinventories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `globalinventories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_items_save` int(11) DEFAULT NULL,
  `total_items_reals` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `globalinventories`
--

LOCK TABLES `globalinventories` WRITE;
/*!40000 ALTER TABLE `globalinventories` DISABLE KEYS */;
INSERT INTO `globalinventories` VALUES
(1,245,NULL,'2023-11-16 14:06:55','2023-11-16 14:06:55'),
(2,245,NULL,'2023-11-16 14:18:34','2023-11-16 14:18:34'),
(3,245,NULL,'2023-11-16 14:20:58','2023-11-16 14:20:58'),
(4,245,NULL,'2023-11-16 14:23:47','2023-11-16 14:23:47'),
(5,245,NULL,'2023-11-16 14:24:38','2023-11-16 14:24:38'),
(6,245,NULL,'2023-11-16 14:27:09','2023-11-16 14:27:09'),
(7,242,NULL,'2023-11-16 14:27:41','2023-11-16 14:27:41'),
(8,241,NULL,'2023-11-16 14:31:44','2023-11-16 14:31:44'),
(9,241,NULL,'2023-11-16 14:31:49','2023-11-16 14:31:49'),
(10,241,NULL,'2023-11-16 14:32:01','2023-11-16 14:32:01'),
(11,232,NULL,'2023-11-16 14:32:03','2023-11-16 14:32:03'),
(12,232,NULL,'2023-11-16 14:33:28','2023-11-16 14:33:28'),
(13,232,NULL,'2023-11-16 14:37:02','2023-11-16 14:37:02'),
(14,232,NULL,'2023-11-16 14:37:05','2023-11-16 14:37:05'),
(15,231,NULL,'2023-11-16 14:38:30','2023-11-16 14:38:30'),
(16,62,86,'2023-11-16 14:43:15','2023-11-16 14:43:15'),
(17,86,150,'2023-11-16 14:48:08','2023-11-16 14:48:08'),
(18,180,150,'2023-11-16 14:49:06','2023-11-16 14:49:06'),
(19,180,217,'2023-11-16 14:50:57','2023-11-16 14:50:57'),
(20,60,60,'2023-11-16 14:54:28','2023-11-16 14:54:28'),
(21,60,56,'2023-11-16 14:54:47','2023-11-16 14:54:47'),
(22,56,51,'2023-11-16 14:57:52','2023-11-16 14:57:52'),
(23,30,29,'2023-11-16 15:09:57','2023-11-16 15:09:57'),
(24,29,48,'2023-11-16 15:22:49','2023-11-16 15:22:49'),
(25,48,45,'2023-11-16 15:24:23','2023-11-16 15:24:23'),
(26,45,45,'2023-11-16 15:32:05','2023-11-16 15:32:05'),
(27,45,45,'2023-11-16 15:32:28','2023-11-16 15:32:28'),
(28,45,45,'2023-11-16 15:37:39','2023-11-16 15:37:39'),
(29,45,45,'2023-11-16 15:40:08','2023-11-16 15:40:08'),
(30,45,45,'2023-11-16 15:44:29','2023-11-16 15:44:29'),
(31,45,45,'2023-11-16 15:45:25','2023-11-16 15:45:25'),
(32,45,45,'2023-11-16 15:45:33','2023-11-16 15:45:33'),
(33,45,45,'2023-11-16 15:46:28','2023-11-16 15:46:28'),
(34,45,36,'2023-11-16 15:47:18','2023-11-16 15:47:18'),
(35,36,124,'2023-11-16 15:49:35','2023-11-16 15:49:35'),
(36,46,10,'2023-11-16 15:52:54','2023-11-16 15:52:54'),
(37,78,2343,'2023-11-16 15:53:14','2023-11-16 15:53:14'),
(38,10,56,'2023-11-16 15:55:37','2023-11-16 15:55:37');
/*!40000 ALTER TABLE `globalinventories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logsactions`
--

DROP TABLE IF EXISTS `logsactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logsactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user_admin` int(11) DEFAULT NULL,
  `table_affect` varchar(50) DEFAULT NULL,
  `id_line_affect` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `date_action` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user_admin` (`id_user_admin`),
  CONSTRAINT `logsactions_ibfk_1` FOREIGN KEY (`id_user_admin`) REFERENCES `adminusers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logsactions`
--

LOCK TABLES `logsactions` WRITE;
/*!40000 ALTER TABLE `logsactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `logsactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `houses`
--

DROP TABLE IF EXISTS `houses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `houses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `creation_date` datetime DEFAULT current_timestamp(),
  `modification_date` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `delete` boolean DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `houses`
--

LOCK TABLES `houses` WRITE;
/*!40000 ALTER TABLE `houses` DISABLE KEYS */;
INSERT INTO `houses` VALUES
(1,'Maison Dupont','2023-10-10 18:02:10','2023-10-11 20:28:43',0),
(2,'Château de la Vallée','2023-10-10 18:02:10','2023-10-10 18:02:10',0),
(3,'Domaine des Vignes','2023-10-10 18:02:10','2023-10-10 18:02:10',0),
(4,'Cave Saint-Pierre','2023-10-10 18:02:14','2023-10-10 18:02:14',0);
/*!40000 ALTER TABLE `houses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcategories`
--

DROP TABLE IF EXISTS `subcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcategories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `creation_date` datetime DEFAULT current_timestamp(),
  `modification_date` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `delete` boolean DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategories`
--

LOCK TABLES `subcategories` WRITE;
/*!40000 ALTER TABLE `subcategories` DISABLE KEYS */;
INSERT INTO `subcategories` VALUES
(1,'Pétillant','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(2,'Léger','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(3,'Corsé','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(4,'Fruité','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(5,'Sec','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(6,'Moelleux','2023-10-07 13:45:04','2023-11-15 09:21:14',0),
(7,'Brut','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(8,'Demi-sec','2023-10-07 13:45:04','2023-10-07 13:45:04',0);
/*!40000 ALTER TABLE `subcategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES
(1,'En attente'),
(2,'Confirmé'),
(3,'Livré'),
(4,'Annulé');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stocktracking`
--

DROP TABLE IF EXISTS `stocktracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stocktracking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_item` int(11) DEFAULT NULL,
  `quantity_before_transaction` int(11) DEFAULT NULL,
  `quantity_transaction` int(11) DEFAULT NULL,
  `quantity_after_transaction` int(11) DEFAULT NULL,
  `id_type_transaction` int(11) DEFAULT NULL,
  `date_transaction` datetime DEFAULT NULL,
  `note` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_item` (`id_item`),
  KEY `id_type_transaction` (`id_type_transaction`),
  CONSTRAINT `stocktracking_ibfk_1` FOREIGN KEY (`id_item`) REFERENCES `items` (`id`),
  CONSTRAINT `stocktracking_ibfk_2` FOREIGN KEY (`id_type_transaction`) REFERENCES `typetransaction` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stocktracking`
--

LOCK TABLES `stocktracking` WRITE;
/*!40000 ALTER TABLE `stocktracking` DISABLE KEYS */;
INSERT INTO `stocktracking` VALUES
(74,24,0,0,0,5,'2023-10-16 15:38:52',NULL),
(75,24,0,30,30,1,'2023-10-16 15:39:02',NULL),
(76,24,30,15,45,1,'2023-10-16 15:40:30',NULL),
(77,24,45,30,75,1,'2023-10-17 10:19:11',NULL),
(78,24,75,5,80,1,'2023-10-17 12:58:09',NULL),
(79,25,0,0,0,5,'2023-10-17 13:48:32',NULL),
(80,25,0,40,40,1,'2023-10-17 13:48:47',NULL),
(81,26,0,0,0,5,'2023-10-17 14:05:25',NULL),
(82,26,0,25,25,1,'2023-10-17 14:05:40',NULL),
(83,24,80,5,85,1,'2023-10-17 14:38:58',NULL),
(84,24,85,5,90,1,'2023-10-17 14:42:25',NULL),
(85,24,90,5,95,1,'2023-10-17 14:42:31',NULL),
(86,24,95,5,100,1,'2023-10-17 14:42:32',NULL),
(87,24,100,5,105,1,'2023-10-17 14:42:33',NULL),
(88,24,105,5,110,1,'2023-10-17 14:42:33',NULL),
(89,26,25,30,55,1,'2023-10-17 14:45:00',NULL),
(90,24,110,40,150,1,'2023-11-13 14:46:29',NULL),
(91,24,25,125,150,4,'2023-11-16 14:50:57','Ajustement lors de l\'inventory'),
(92,25,37,30,67,4,'2023-11-16 14:50:57','Ajustement lors de l\'inventory'),
(93,27,0,0,0,5,'2023-11-16 14:54:00',NULL),
(94,27,0,60,60,1,'2023-11-16 14:54:13',NULL),
(95,27,60,0,60,4,'2023-11-16 14:54:28','Ajustement lors de l\'inventory'),
(96,27,60,-4,56,4,'2023-11-16 14:54:47','Ajustement lors de l\'inventory'),
(97,27,56,-5,51,4,'2023-11-16 14:57:52','Ajustement lors de l\'inventory'),
(98,28,0,0,0,5,'2023-11-16 15:09:13',NULL),
(99,28,0,30,30,1,'2023-11-16 15:09:31',NULL),
(100,28,30,-1,29,4,'2023-11-16 15:09:57','Ajustement lors de l\'inventory'),
(101,28,29,19,48,4,'2023-11-16 15:22:49','Ajustement lors de l\'inventory'),
(102,28,48,-3,45,4,'2023-11-16 15:24:23','Ajustement lors de l\'inventory'),
(103,28,45,0,45,4,'2023-11-16 15:32:05','Ajustement lors de l\'inventory'),
(104,28,45,0,45,4,'2023-11-16 15:32:28','Ajustement lors de l\'inventory'),
(105,28,45,0,45,4,'2023-11-16 15:37:39','Ajustement lors de l\'inventory'),
(106,28,45,0,45,4,'2023-11-16 15:40:08','Ajustement lors de l\'inventory'),
(107,28,45,0,45,4,'2023-11-16 15:44:29','Ajustement lors de l\'inventory'),
(108,28,45,0,45,4,'2023-11-16 15:45:26','Ajustement lors de l\'inventory'),
(109,28,45,0,45,4,'2023-11-16 15:45:33','Ajustement lors de l\'inventory'),
(110,28,45,0,45,4,'2023-11-16 15:46:28','Ajustement lors de l\'inventory'),
(111,28,45,-9,36,4,'2023-11-16 15:47:18','Ajustement lors de l\'inventory'),
(112,29,0,0,0,5,'2023-11-16 15:49:29',NULL),
(113,28,36,10,46,4,'2023-11-16 15:49:35','Ajustement lors de l\'inventory'),
(114,29,0,78,78,4,'2023-11-16 15:49:35','Ajustement lors de l\'inventory'),
(115,28,46,-36,10,4,'2023-11-16 15:52:54','Ajustement lors de l\'inventory'),
(116,29,78,2265,2343,4,'2023-11-16 15:53:14','Ajustement lors de l\'inventory'),
(117,28,10,46,56,4,'2023-11-16 15:55:37','Ajustement lors de l\'inventory');
/*!40000 ALTER TABLE `stocktracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typetransaction`
--

DROP TABLE IF EXISTS `typetransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typetransaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typetransaction`
--

LOCK TABLES `typetransaction` WRITE;
/*!40000 ALTER TABLE `typetransaction` DISABLE KEYS */;
INSERT INTO `typetransaction` VALUES
(1,'Achat'),
(2,'Vente'),
(3,'Retour'),
(4,'Ajustement'),
(5,'Creation Article');
/*!40000 ALTER TABLE `typetransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adminusers`
--

DROP TABLE IF EXISTS `adminusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminusers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `delete` boolean DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminusers`
--

LOCK TABLES `adminusers` WRITE;
/*!40000 ALTER TABLE `adminusers` DISABLE KEYS */;
INSERT INTO `adminusers` VALUES
(1,'admin','admin','2023-10-03 18:07:16','2023-10-03 18:07:16',NULL,0);
/*!40000 ALTER TABLE `adminusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userscustomers`
--

DROP TABLE IF EXISTS `userscustomers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userscustomers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `modification_date` datetime DEFAULT NULL,
  `delete` boolean DEFAULT 0,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userscustomers`
--

LOCK TABLES `userscustomers` WRITE;
/*!40000 ALTER TABLE `userscustomers` DISABLE KEYS */;
INSERT INTO `userscustomers` VALUES
(1,'MartinDupont','martin.dupont@example.com','password123','2023-10-03 18:06:11','2023-10-03 18:06:11', 0),
(2,'ClaireMoreau','claire.moreau@example.com','securePass456','2023-10-03 18:06:11','2023-10-03 18:06:11', 0);
/*!40000 ALTER TABLE `userscustomers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-04 17:59:00
