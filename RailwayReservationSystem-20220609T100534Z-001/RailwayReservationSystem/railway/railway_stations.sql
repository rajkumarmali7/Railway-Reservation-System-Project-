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
-- Table structure for table `stations`
--

DROP TABLE IF EXISTS `stations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stations` (
  `tname` varchar(30) DEFAULT NULL,
  `station` varchar(30) DEFAULT NULL,
  `distance_Travlled` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stations`
--

LOCK TABLES `stations` WRITE;
/*!40000 ALTER TABLE `stations` DISABLE KEYS */;
INSERT INTO `stations` VALUES ('Satabdi Express','Mumbai Central',0),('Satabdi Express','Borivali',30),('Satabdi Express','Vapi',170),('Satabdi Express','Surat',263),('Satabdi Express','Bharuch Junction',322),('Satabdi Express','Vadodara Junction',392),('Satabdi Express','Anand Junction',427),('Satabdi Express','Nadiad Junction',446),('Satabdi Express','Ahmedabad Junction',491),('Amaravati Express','Howrah Junction',0),('Amaravati Express','Kharagpur Junction',116),('Amaravati Express','Balasore',234),('Amaravati Express','Bhadrakh',296),('Amaravati Express','Jajpur K Road',340),('Amaravati Express','Bhubaneswar',439),('Amaravati Express','Vijayawada Junction',1219),('Amaravati Express','Dharwar',1931),('Amaravati Express','Kulem',2085),('Amaravati Express','Vasco Da Gama',2147),('Ajanta Express','Manmad Junction',0),('Ajanta Express','Nagarsol',25),('Ajanta Express','Aurangabad',114),('Ajanta Express','Parbhani Junction',291),('Ajanta Express','Umri',392),('Ajanta Express','Kamareddi',513),('Ajanta Express','Medchal',593),('Ajanta Express','Bolarum',607),('Ajanta Express','Malkajgiri',617),('Ajanta Express','Secunderabad Junction',621);
/*!40000 ALTER TABLE `stations` ENABLE KEYS */;
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
