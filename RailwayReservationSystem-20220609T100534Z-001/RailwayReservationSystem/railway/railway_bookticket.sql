-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: localhost    Database: railway
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `bookticket`
--

DROP TABLE IF EXISTS `bookticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookticket` (
  `pnr` int NOT NULL AUTO_INCREMENT,
  `train_name` varchar(30) DEFAULT NULL,
  `train_no` varchar(30) DEFAULT NULL,
  `t_from` varchar(30) DEFAULT NULL,
  `t_to` varchar(30) DEFAULT NULL,
  `t_categery` varchar(30) DEFAULT NULL,
  `p_name` varchar(30) DEFAULT NULL,
  `p_phone` varchar(30) DEFAULT NULL,
  `age` varchar(30) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `travling_date` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pnr`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookticket`
--

LOCK TABLES `bookticket` WRITE;
/*!40000 ALTER TABLE `bookticket` DISABLE KEYS */;
INSERT INTO `bookticket` VALUES (1,'Satabdi Express','12009','Mumbai Central','Borivali','FirstAC','Anil Kumar','9899460695','32','Male','31/12/2018'),(2,'Satabdi Express','12009','Mumbai Central','Borivali','FirstAC','Sumitra Yadav','9899460667','28','Female','31/12/2018'),(3,'Satabdi Express','12009','Surat','Bharuch Junction','FirstAC','Ram','1234567890','22','Male','31/12/2018'),(4,'Satabdi Express','12009','Mumbai Central','Bharuch Junction','FirstAC','Dinesh','9876543210','18','Male','1/1/2019'),(6,'Satabdi Express','12009','Mumbai Central','Vapi','FirstAC','Ram','43535','32','Male','1/1/2019'),(7,'Amaravati Express','18047','Jajpur K Road','Balasore','ThirdAC','xxx','4567891232','33','Male','1/1/2019'),(8,'Amaravati Express','18047','Kharagpur Junction','Kharagpur Junction','SecondAC','Monica','7895638275','24','Female','1/1/2019'),(9,'Satabdi Express','12009','Mumbai Central','Vadodara Junction','SecondAC','Ruchita','8447091636','17','Female','3/1/2019'),(12,'Satabdi Express','12009','Mumbai Central','Borivali','FirstAC','Shantanu','9621265088','28','Male','2/04/19');
/*!40000 ALTER TABLE `bookticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-08 11:00:28
