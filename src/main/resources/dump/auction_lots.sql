-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: auction
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `lots`
--

DROP TABLE IF EXISTS `lots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lots` (
  `idlots` int NOT NULL AUTO_INCREMENT,
  `name_lots` varchar(45) NOT NULL,
  `description_lots` varchar(100) NOT NULL,
  `start_price` double NOT NULL,
  `current_price` double NOT NULL,
  `step_price` double NOT NULL,
  `publication_date` date NOT NULL,
  `closing_date` date NOT NULL,
  `condition_lots` varchar(45) NOT NULL,
  `status_lots` enum('Ожидает подтверждения','Активный','Завершен') NOT NULL,
  `category_id` int NOT NULL,
  `seller_id` int NOT NULL,
  `current_buyer_id` int NOT NULL,
  PRIMARY KEY (`idlots`),
  KEY `fk_category_id_idx` (`category_id`),
  KEY `fk_seller_id_idx` (`seller_id`),
  KEY `fk_current_buyer_id_idx` (`current_buyer_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`idcategory`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_current_buyer_id` FOREIGN KEY (`current_buyer_id`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_seller_id` FOREIGN KEY (`seller_id`) REFERENCES `users` (`idusers`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lots`
--

LOCK TABLES `lots` WRITE;
/*!40000 ALTER TABLE `lots` DISABLE KEYS */;
INSERT INTO `lots` VALUES (77,'fwe','fwe\n',234,234,432,'2023-06-08','2023-06-10','243','Ожидает подтверждения',2,48,49),(79,'fsd','dsf\n',342,342,324,'2023-06-08','2023-06-17','vsd','Ожидает подтверждения',2,48,49),(81,'kjjn','lknoin',98,98,97,'2023-06-08','2023-06-14','loknpi','Ожидает подтверждения',2,63,49),(82,'лшоло','щштщш',78,78,50,'2023-06-07','2023-06-10','зщо','Ожидает подтверждения',2,64,49),(84,'fwe','ewfwef',32,32,432,'2023-06-08','2023-06-10','fsdfsd','Ожидает подтверждения',2,48,49),(85,'asd','asdasd',12,12,2,'2023-06-09','2023-06-15','cs','Ожидает подтверждения',2,48,49);
/*!40000 ALTER TABLE `lots` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 17:26:44
