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
-- Table structure for table `Item`
--

DROP TABLE IF EXISTS `Item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `sell_price` decimal(10,2) DEFAULT NULL,
  `buy_price` decimal(10,2) DEFAULT NULL,
  `id_supplier` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_deleted` boolean DEFAULT 0,
  `save_quantity` int(11) DEFAULT 0,
  `auto_order` tinyint(1) DEFAULT NULL,
  `min_order_threshold` int(11) DEFAULT NULL,
  `carton_price` decimal(5,2) DEFAULT NULL,
  `wine_year` int(11) DEFAULT NULL,
  `id_category` int(11) DEFAULT NULL,
  `id_subcategory` int(11) DEFAULT NULL,
  `id_house` int(11) DEFAULT NULL,
  `trending` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `id_supplier` (`id_supplier`),
  KEY `fk_item_category` (`id_category`),
  KEY `fk_item_subcategory` (`id_subcategory`),
  KEY `id_house` (`id_house`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `Supplier` (`id`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`id_house`) REFERENCES `House` (`id`),
  CONSTRAINT `fk_item_category` FOREIGN KEY (`id_category`) REFERENCES `Category` (`id`),
  CONSTRAINT `fk_item_subcategory` FOREIGN KEY (`id_subcategory`) REFERENCES `SubCategory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Item`
--

LOCK TABLES `Item` WRITE;
/*!40000 ALTER TABLE `Item` DISABLE KEYS */;
INSERT INTO `Item` VALUES
(24,'JP-Chenet','Vin blanc fruité d\'Alsace.',35.00,11.00,1,NULL,NULL,1,150,1,10,210.00,2021,2,4,3,0),
(25,'Gascogne','Vin rouge de gascogne sec',29.00,8.00,1,NULL,NULL,1,67,1,20,174.00,2023,1,5,4,0),
(26,'Saint Emillion','Vin Rosé de Bretagne léger',40.00,14.00,2,NULL,NULL,1,54,1,8,240.00,2019,3,2,1,0),
(27,'Lumbrasco','Vin rouge d\'été aux fines herbes',67.00,19.00,1,NULL,NULL,1,51,1,10,670.00,2016,1,4,2,1),
(28,'Lambrosco','Vsdqfsdfdsfs',50.00,10.00,1,NULL,NULL,0,56,1,10,500.00,2018,4,6,1,0),
(29,'sqd','sdq',444.00,44.00,1,NULL,NULL,0,2343,0,44,444.00,44,3,NULL,1,0);
/*!40000 ALTER TABLE `Item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CustomerOrderItem`
--

DROP TABLE IF EXISTS `CustomerOrderItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CustomerOrderItem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_customer_order` int(11) DEFAULT NULL,
  `id_item` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_customer_order` (`id_customer_order`),
  KEY `id_item` (`id_item`),
  CONSTRAINT `customer_order_item_ibfk_1` FOREIGN KEY (`id_customer_order`) REFERENCES `CustomerOrder` (`id`),
  CONSTRAINT `customer_order_item_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `Item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CustomerOrderItem`
--

LOCK TABLES `CustomerOrderItem` WRITE;
/*!40000 ALTER TABLE `CustomerOrderItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `CustomerOrderItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_deleted` boolean DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES
(1,'Rouge','2023-10-03 18:05:55','2023-10-03 18:05:55',0),
(2,'Blanc','2023-10-03 18:05:55','2023-10-03 18:05:55',0),
(3,'Rosé','2023-10-03 18:05:55','2023-10-03 18:05:55',0),
(4,'Champagne','2023-10-03 18:05:55','2023-10-03 18:05:55',0),
(7,'Pétillant',NULL,NULL,0);
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CustomerOrder`
--

DROP TABLE IF EXISTS `CustomerOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CustomerOrder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_customer` int(11) DEFAULT NULL,
  `id_status` int(11) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_customer` (`id_customer`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `customer_order_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `Customer` (`id`),
  CONSTRAINT `customer_order_ibfk_2` FOREIGN KEY (`id_status`) REFERENCES `Status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CustomerOrder`
--

LOCK TABLES `CustomerOrder` WRITE;
/*!40000 ALTER TABLE `CustomerOrder` DISABLE KEYS */;
/*!40000 ALTER TABLE `CustomerOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SupplierOrder`
--

DROP TABLE IF EXISTS `SupplierOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SupplierOrder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_supplier` int(11) DEFAULT NULL,
  `id_item` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `buy_price` decimal(10,2) DEFAULT NULL,
  `id_status` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_supplier` (`id_supplier`),
  KEY `id_item` (`id_item`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `supplier_order_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `Supplier` (`id`),
  CONSTRAINT `supplier_order_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `Item` (`id`),
  CONSTRAINT `supplier_order_ibfk_3` FOREIGN KEY (`id_status`) REFERENCES `Status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SupplierOrder`
--

LOCK TABLES `SupplierOrder` WRITE;
/*!40000 ALTER TABLE `SupplierOrder` DISABLE KEYS */;
INSERT INTO `SupplierOrder` VALUES
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
/*!40000 ALTER TABLE `SupplierOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Supplier`
--

DROP TABLE IF EXISTS `Supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_deleted` boolean DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Supplier`
--

LOCK TABLES `Supplier` WRITE;
/*!40000 ALTER TABLE `Supplier` DISABLE KEYS */;
INSERT INTO `Supplier` VALUES
(1,'VinDeFrance Ltd.','François','francois@vindefrance.com','+33 123456789','2023-10-03 18:06:02','2023-10-03 18:06:02',0),
(2,'VinoItalia S.p.A.','Giovanni','giovanni@vinoitalia.it','+39 987654321','2023-10-03 18:06:02','2023-10-03 18:06:02',0),
(3,'HandDeutsch SV','Hanse','hans@weindeutsch.de','+49 567891234','2023-10-03 18:06:02','2023-10-03 18:06:02',0),
(4,'Dartalia SMG','Diego','dartialiagmail.offsmg@gmail.com','0606797839',NULL,NULL,1),
(5,'sdf','sf','sfd','sfd',NULL,NULL,1),
(6,'hfdsfd','hfdssfdfds','hfdsfds@gmail.com','6666',NULL,NULL,1),
(7,'s','s','s','s',NULL,NULL,1),
(8,'h','h','herterter','h',NULL,NULL,1);
/*!40000 ALTER TABLE `Supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `InventoryItem`
--

DROP TABLE IF EXISTS `InventoryItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `InventoryItem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_global_inventory` int(11) DEFAULT NULL,
  `id_item` int(11) DEFAULT NULL,
  `saved_quantity` int(11) DEFAULT NULL,
  `real_quantity` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_global_inventory` (`id_global_inventory`),
  KEY `id_item` (`id_item`),
  CONSTRAINT `inventory_item_ibfk_1` FOREIGN KEY (`id_global_inventory`) REFERENCES `GlobalInventory` (`id`),
  CONSTRAINT `inventory_item_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `Item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `InventoryItem`
--

LOCK TABLES `InventoryItem` WRITE;
/*!40000 ALTER TABLE `InventoryItem` DISABLE KEYS */;
INSERT INTO `InventoryItem` VALUES
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
/*!40000 ALTER TABLE `InventoryItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GlobalInventory`
--

DROP TABLE IF EXISTS `GlobalInventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GlobalInventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_saved_items` int(11) DEFAULT NULL,
  `total_real_items` int(11) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GlobalInventory`
--

LOCK TABLES `GlobalInventory` WRITE;
/*!40000 ALTER TABLE `GlobalInventory` DISABLE KEYS */;
INSERT INTO `GlobalInventory` VALUES
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
/*!40000 ALTER TABLE `GlobalInventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ActionLog`
--

DROP TABLE IF EXISTS `ActionLog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ActionLog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_admin` int(11) DEFAULT NULL,
  `action_type` varchar(50) DEFAULT NULL,
  `related_table` varchar(50) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `action_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_admin` (`id_admin`),
  CONSTRAINT `action_log_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `Admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ActionLog`
--

LOCK TABLES `ActionLog` WRITE;
/*!40000 ALTER TABLE `ActionLog` DISABLE KEYS */;
/*!40000 ALTER TABLE `ActionLog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `House`
--

DROP TABLE IF EXISTS `House`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `House` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `creation_date` datetime DEFAULT current_timestamp(),
  `update_date` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `is_deleted` boolean DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `House`
--

LOCK TABLES `House` WRITE;
/*!40000 ALTER TABLE `House` DISABLE KEYS */;
INSERT INTO `House` VALUES
(1,'Maison Dupont','2023-10-10 18:02:10','2023-10-11 20:28:43',0),
(2,'Château de la Vallée','2023-10-10 18:02:10','2023-10-10 18:02:10',0),
(3,'Domaine des Vignes','2023-10-10 18:02:10','2023-10-10 18:02:10',0),
(4,'Cave Saint-Pierre','2023-10-10 18:02:14','2023-10-10 18:02:14',0);
/*!40000 ALTER TABLE `House` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SubCategory`
--

DROP TABLE IF EXISTS `SubCategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SubCategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `creation_date` datetime DEFAULT current_timestamp(),
  `update_date` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `is_deleted` boolean DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubCategory`
--

LOCK TABLES `SubCategory` WRITE;
/*!40000 ALTER TABLE `SubCategory` DISABLE KEYS */;
INSERT INTO `SubCategory` VALUES
(1,'Pétillant','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(2,'Léger','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(3,'Corsé','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(4,'Fruité','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(5,'Sec','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(6,'Moelleux','2023-10-07 13:45:04','2023-11-15 09:21:14',0),
(7,'Brut','2023-10-07 13:45:04','2023-10-07 13:45:04',0),
(8,'Demi-sec','2023-10-07 13:45:04','2023-10-07 13:45:04',0);
/*!40000 ALTER TABLE `SubCategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Status`
--

DROP TABLE IF EXISTS `Status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Status`
--

LOCK TABLES `Status` WRITE;
/*!40000 ALTER TABLE `Status` DISABLE KEYS */;
INSERT INTO `Status` VALUES
(1,'En attente'),
(2,'Confirmé'),
(3,'Livré'),
(4,'Annulé');
/*!40000 ALTER TABLE `Status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StockTracking`
--

DROP TABLE IF EXISTS `StockTracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StockTracking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_item` int(11) DEFAULT NULL,
  `quantity_before_transaction` int(11) DEFAULT NULL,
  `transaction_quantity` int(11) DEFAULT NULL,
  `quantity_after_transaction` int(11) DEFAULT NULL,
  `id_transaction_type` int(11) DEFAULT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `note` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_item` (`id_item`),
  KEY `id_transaction_type` (`id_transaction_type`),
  CONSTRAINT `stock_tracking_ibfk_1` FOREIGN KEY (`id_item`) REFERENCES `Item` (`id`),
  CONSTRAINT `stock_tracking_ibfk_2` FOREIGN KEY (`id_transaction_type`) REFERENCES `TransactionType` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StockTracking`
--

LOCK TABLES `StockTracking` WRITE;
/*!40000 ALTER TABLE `StockTracking` DISABLE KEYS */;
INSERT INTO `StockTracking` VALUES
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
/*!40000 ALTER TABLE `StockTracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TransactionType`
--

DROP TABLE IF EXISTS `TransactionType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TransactionType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TransactionType`
--

LOCK TABLES `TransactionType` WRITE;
/*!40000 ALTER TABLE `TransactionType` DISABLE KEYS */;
INSERT INTO `TransactionType` VALUES
(1,'Achat'),
(2,'Vente'),
(3,'Retour'),
(4,'Ajustement'),
(5,'Creation Article');
/*!40000 ALTER TABLE `TransactionType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Admin`
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(512) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `deletion_date` datetime DEFAULT NULL,
  `is_deleted` boolean DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
INSERT INTO `Admin` VALUES
(1,'admin','admin','2023-10-03 18:07:16','2023-10-03 18:07:16',NULL,0);
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_deleted` boolean DEFAULT 0,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES
(1,'MartinDupont','martin.dupont@example.com','password123','2023-10-03 18:06:11','2023-10-03 18:06:11', 0),
(2,'ClaireMoreau','claire.moreau@example.com','securePass456','2023-10-03 18:06:11','2023-10-03 18:06:11', 0);
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
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
