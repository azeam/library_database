-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Admin`
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Admin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Books`
--

DROP TABLE IF EXISTS `Books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Books` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `pages` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Books`
--

LOCK TABLES `Books` WRITE;
/*!40000 ALTER TABLE `Books` DISABLE KEYS */;
INSERT INTO `Books` VALUES (1,'Vägen till Väterås','Kenny Surströmming','244','Hce'),(2,'Grisarnas julafton','Orvar Satorsson','198','Hce'),(3,'Blomkålsmördaren','Sara Tryffelsten','55','uHce'),(4,'Min faster Ingeborg','Inga Skoghorn','763','Hcf'),(5,'Askorbinsyra utan smör','Tore Tofs','199','Hcf'),(6,'Lastbilens tankar','Oskar Rudenerg','452','uHce'),(7,'Benny Bläcks liv','Benny Bläck','111','Hce'),(9,'Den ensamma katten','Rudolf Ruskprick ','123','Hce');
/*!40000 ALTER TABLE `Books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Borrowers`
--

DROP TABLE IF EXISTS `Borrowers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Borrowers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `cardNr` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Borrowers`
--

LOCK TABLES `Borrowers` WRITE;
/*!40000 ALTER TABLE `Borrowers` DISABLE KEYS */;
INSERT INTO `Borrowers` VALUES (0,'Viggo Filtner','Vägen 1, Nollberga','11111',1234),(1,'Pelle Pälsänger','Vägen 20, Nollberga','2222',4536),(2,'Bosse Baron','Vägen 5, Nollberga','3333',3347),(3,'Explorer Johansson','Vägen 123, Nollberga','44444',NULL),(4,'Elof Öman','Vägen 24, Nollberga','5555',2112);
/*!40000 ALTER TABLE `Borrowers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Borrows`
--

DROP TABLE IF EXISTS `Borrows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Borrows` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bookId` bigint DEFAULT NULL,
  `borrowerId` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5tq2fyag791gv24hlxw9ifh00` (`bookId`),
  KEY `FKkcqc5dumac0dwkf3r1yc94wvi` (`borrowerId`),
  CONSTRAINT `FK5tq2fyag791gv24hlxw9ifh00` FOREIGN KEY (`bookId`) REFERENCES `Books` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKkcqc5dumac0dwkf3r1yc94wvi` FOREIGN KEY (`borrowerId`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Borrows`
--

LOCK TABLES `Borrows` WRITE;
/*!40000 ALTER TABLE `Borrows` DISABLE KEYS */;
INSERT INTO `Borrows` VALUES (2,1,1);
/*!40000 ALTER TABLE `Borrows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employees`
--

DROP TABLE IF EXISTS `Employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employees` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `salary` varchar(10) DEFAULT NULL,
  `vacationDays` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employees`
--

LOCK TABLES `Employees` WRITE;
/*!40000 ALTER TABLE `Employees` DISABLE KEYS */;
INSERT INTO `Employees` VALUES (1,'Asta Kask','Vägen 2, Nollberga','12000',10),(2,'Ebba Grön','Vägen 4, Nollberga','83000',21),(3,'Farbror Blå','Vägen 8 , Nollberga','7000',0);
/*!40000 ALTER TABLE `Employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Magazines`
--

DROP TABLE IF EXISTS `Magazines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Magazines` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Magazines`
--

LOCK TABLES `Magazines` WRITE;
/*!40000 ALTER TABLE `Magazines` DISABLE KEYS */;
INSERT INTO `Magazines` VALUES (0,'Illustrerad Ångest','2020-12-12','Hylla A'),(1,'Illustrerad Ångest','1985-10-20','Hylla A'),(2,'Illustrerad Ångest','1985-10-11','Hylla A'),(3,'Veckans Tråkigaste','1998-01-01','Hylla A'),(4,'Veckans Tråkigaste','2012-11-05','Hylla A'),(5,'Dagens Tidning','2010-11-11','Hylla B'),(6,'Dagens Tidning','2010-11-10','Hylla B'),(7,'Dagens Tidning','2010-11-09','Hylla B'),(8,'Dagens Tidning','2012-04-05','Hylla B'),(9,'Dagens Tidning','2008-10-05','Hylla B'),(10,'Gårdagens Tidning','1988-10-10','Hylla C'),(11,'Gårdagens Tidning','1975-04-05','Hylla C'),(12,'Gårdagens Tidning','1992-10-10','Hylla C'),(13,'Gårdagens Tidning','1944-02-03','Hylla C'),(14,'Gårdagens Tidning','1957-11-24','Hylla C'),(15,'Gårdagens Tidning','1922-12-01','Hylla C'),(16,'Nyheter från Vattenpölen','2001-06-13','Hylla B'),(17,'Nyheter från Vattenpölen','2003-11-04','Hylla B'),(18,'Nyheter från Vattenpölen','2010-04-13','Hylla B'),(19,'Nyheter från Vattenpölen','2000-01-04','Hylla B'),(20,'Nyheter från Vattenpölen','2015-06-26','Hylla B'),(21,'Moderna trasor','2001-01-05','Hylla A'),(22,'Moderna trasor','2005-08-10','Hylla A'),(23,'Moderna trasor','2017-10-17','Hylla A'),(24,'Moderna trasor','2018-02-02','Hylla A'),(25,'Moderna trasor','2005-08-20','Hylla A'),(26,'Burksamlaren','2012-03-05','Hylla C'),(27,'Burksamlaren','2012-03-07','Hylla C'),(28,'Burksamlaren','2012-03-09','Hylla C');
/*!40000 ALTER TABLE `Magazines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `cardNr` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'fdafda','fdsafda','$2a$10$wS4Gd4sluUCpCLmAs0nvKuAJUl9KydjMwGomY4WyHoWukhSAakceW','fdsadfa','test');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (8);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-06 19:02:01
