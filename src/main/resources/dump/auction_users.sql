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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idusers` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `surname` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `login` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `birth_date` date NOT NULL,
  `role` enum('ADMIN','SELLER','BUYER') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` enum('ACTIVE','BLOCK') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Матвей','Марусик','cemetry','159753','2004-02-03','ADMIN','ACTIVE'),(39,'выа','выа','ыва','авы','2001-06-02','BUYER','ACTIVE'),(40,'ds','fsd','dsf','sdf','2001-06-02','BUYER','ACTIVE'),(42,'ewf','few','f','f','2001-06-02','SELLER','ACTIVE'),(44,'ds','qwd','g','g','2001-06-02','SELLER','ACTIVE'),(45,'sd','cds','cds','ff','2000-10-07','SELLER','ACTIVE'),(46,'ацу','ауц','ацу','ауц','2000-06-02','BUYER','ACTIVE'),(47,'efw','fwe','b','b','2001-06-01','BUYER','ACTIVE'),(48,'ewf','few','s','s','2001-06-02','SELLER','ACTIVE'),(49,'unknown','unknown','unknown','unknown','2001-06-02','BUYER','ACTIVE'),(50,'ваы','авы','543','534','2000-06-04','SELLER','ACTIVE'),(51,'adf','fa','sf','fs','2000-06-03','SELLER','ACTIVE'),(52,'wee','w','i','i','2001-06-02','SELLER','ACTIVE'),(53,'rferf','efr','er','fer','2001-06-09','SELLER','ACTIVE'),(54,'ferrfe','erfe','rf','e','2002-05-31','SELLER','ACTIVE'),(55,'fer','ref',';op','o;p','2001-06-08','SELLER','ACTIVE'),(56,'укп','укп','ывмывфывм','ымфывм','2000-06-03','SELLER','ACTIVE'),(57,'ret','ter','iuyu','ouy','2001-06-02','SELLER','ACTIVE'),(58,'erg','ger','ger','gre','2000-06-02','SELLER','ACTIVE'),(59,'fssdf','fsd','sdf','sdf','2002-06-01','SELLER','ACTIVE'),(60,'ка','купку','щщ','щщ','1999-06-06','SELLER','ACTIVE'),(61,'sdff','sdf','tt','tt','2001-06-09','SELLER','ACTIVE'),(62,'dsfsd','sdf','popo','sdf','2000-06-02','SELLER','ACTIVE'),(63,'sad','asdplpplp','lolop',';\'l[p','2000-06-09','SELLER','ACTIVE'),(64,'чсыввыаываыв','лотото','зз','зз','2000-06-02','SELLER','ACTIVE');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 17:26:45
