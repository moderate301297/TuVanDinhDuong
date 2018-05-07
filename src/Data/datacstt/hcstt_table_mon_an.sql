-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: hcstt
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `table_mon_an`
--

DROP TABLE IF EXISTS `table_mon_an`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_mon_an` (
  `id` int(11) NOT NULL,
  `ten_mon_an` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `don_vi` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tong_calo` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `bua_an` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_mon_an`
--

LOCK TABLES `table_mon_an` WRITE;
/*!40000 ALTER TABLE `table_mon_an` DISABLE KEYS */;
INSERT INTO `table_mon_an` VALUES (1,'Bún bò huế','1 tô','603.8','bua sang','2018/05/07','2018/05/07'),(2,'Cơm Trắng','1 chén','200.0','bua sang','2018/05/07','2018/05/07'),(3,'Cơm Trắng','1 chén','200.0','bua trua','2018/05/07','2018/05/07'),(4,'Cơm Trắng','1 chén','200.0','bua toi','2018/05/07','2018/05/07'),(5,'Cơm Trắng','2 chén','400.0','bua trua','2018/05/07','2018/05/07'),(6,'Cơm Trắng','2 chén','400.0','bua toi','2018/05/07','2018/05/07'),(7,'Cá bạc má chiên','1 con','135.0','bua trua','2018/05/07','2018/05/07'),(8,'Cá bạc má chiên','1 con','135.0','bua toi','2018/05/07','2018/05/07'),(9,'Bò cuốn lá lốt','4 cuốn','406.8','bua trua','2018/05/07','2018/05/07'),(10,'Bò cuốn là lốt','4 cuốn','406.8','bua toi','2018/05/07','2018/05/07'),(11,'Bò cuốn là lốt','2 cuốn','203.4','bua trua','2018/05/07','2018/05/07'),(12,'Bò cuốn lá lốt','2 cuốn','203.4','bua toi','2018/05/07','2018/05/07'),(13,'Bún bò huế (chay)','1 tô','465.8','bua sang','2018/05/07','2018/05/07'),(14,'Bún bò huế (chay)','1 tô','465.8','bua toi','2018/05/07','2018/05/07'),(15,'Bò bía','3 cuốn','93.0','bua trua','2018/05/07','2018/05/07'),(16,'Bò bía','4 cuốn','124.0','bua trua','2018/05/07','2018/05/07'),(17,'Bò bía','5 cuốn','155.0','bua trua','2018/05/07','2018/05/07'),(18,'Bò bía','3 cuốn','93.0','bua toi','2018/05/07','2018/05/07'),(19,'Bò bía','4 cuốn','124.0','bua toi','2018/05/07','2018/05/07'),(20,'Cá bạc má kho','1 con','167.0','bua trua','2018/05/07','2018/05/07'),(21,'Cá bạc má kho','1 con','167.0','bua trua','2018/05/07','2018/05/07'),(22,'Cá cơm lăn bột chiên','1 đĩa','195.0','bua trua','2018/05/07','2018/05/07'),(23,'Cá cơm lăn bột chiên','1 đĩa','195.0','bua toi','2018/05/07','2018/05/07'),(24,'Bún riêu','1 tô','468.4','bua sang','2018/05/07','2018/05/07'),(25,'Bún riêu','1 tô','468.4','bua toi','2018/05/07','2018/05/07'),(26,'Hủ tíu bò kho','1 tô','397.2','bua sang','2018/05/07','2018/05/07'),(27,'Cơm tấm bì','1 đĩa','627.0','bua trua','2018/05/07','2018/05/07'),(28,'Cơm tấm bì','1 đĩa ','627.0','bua toi','2018/05/07','2018/05/07'),(29,'Bún riêu ốc','1 tô','520.1','bua sang','2018/05/07','2018/05/07'),(30,'Bún thịt nướng chả giò','1 tô','587.1','bua sang','2018/05/07','2018/05/07');
/*!40000 ALTER TABLE `table_mon_an` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-07 16:53:44
