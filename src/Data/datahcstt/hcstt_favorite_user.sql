-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: hcstt
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu18.04.1

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
  `nhom` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
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
INSERT INTO `table_mon_an` VALUES (1,'Bún bò huế','1 tô','603.8','bua sang','Món ăn huế','2018/05/07','2018/05/07'),(2,'Cơm Trắng','1 chén','200.0','bua sang',NULL,'2018/05/07','2018/05/07'),(3,'Cơm Trắng','1 chén','200.0','bua trua',NULL,'2018/05/07','2018/05/07'),(4,'Cơm Trắng','1 chén','200.0','bua toi',NULL,'2018/05/07','2018/05/07'),(5,'Cơm Trắng','2 chén','400.0','bua trua',NULL,'2018/05/07','2018/05/07'),(6,'Cơm Trắng','2 chén','400.0','bua toi',NULL,'2018/05/07','2018/05/07'),(7,'Cá bạc má chiên','1 con','135.0','bua trua',NULL,'2018/05/07','2018/05/07'),(8,'Cá bạc má chiên','1 con','135.0','bua toi',NULL,'2018/05/07','2018/05/07'),(9,'Bò cuốn lá lốt','4 cuốn','406.8','bua trua',NULL,'2018/05/07','2018/05/07'),(10,'Bò cuốn là lốt','4 cuốn','406.8','bua toi',NULL,'2018/05/07','2018/05/07'),(11,'Bò cuốn là lốt','2 cuốn','203.4','bua trua',NULL,'2018/05/07','2018/05/07'),(12,'Bò cuốn lá lốt','2 cuốn','203.4','bua toi',NULL,'2018/05/07','2018/05/07'),(13,'Bún bò huế (chay)','1 tô','465.8','bua sang','Món ăn huế','2018/05/07','2018/05/07'),(15,'Bò bía','3 cuốn','93.0','bua trua',NULL,'2018/05/07','2018/05/07'),(16,'Bò bía','4 cuốn','124.0','bua trua',NULL,'2018/05/07','2018/05/07'),(17,'Bò bía','5 cuốn','155.0','bua trua',NULL,'2018/05/07','2018/05/07'),(18,'Bò bía','3 cuốn','93.0','bua toi',NULL,'2018/05/07','2018/05/07'),(19,'Bò bía','4 cuốn','124.0','bua toi',NULL,'2018/05/07','2018/05/07'),(20,'Cá bạc má kho','1 con','167.0','bua trua',NULL,'2018/05/07','2018/05/07'),(21,'Cá bạc má kho','1 con','167.0','bua trua',NULL,'2018/05/07','2018/05/07'),(22,'Cá cơm lăn bột chiên','1 đĩa','195.0','bua trua',NULL,'2018/05/07','2018/05/07'),(23,'Cá cơm lăn bột chiên','1 đĩa','195.0','bua toi',NULL,'2018/05/07','2018/05/07'),(24,'Bún riêu','1 tô','468.4','bua sang',NULL,'2018/05/07','2018/05/07'),(26,'Hủ tíu bò kho','1 tô','397.2','bua sang',NULL,'2018/05/07','2018/05/07'),(27,'Cơm tấm bì','1 đĩa','627.0','bua trua',NULL,'2018/05/07','2018/05/07'),(28,'Cơm tấm bì','1 đĩa ','627.0','bua toi',NULL,'2018/05/07','2018/05/07'),(29,'Bún riêu ốc','1 tô','520.1','bua sang',NULL,'2018/05/07','2018/05/07'),(30,'Bún thịt nướng chả giò','1 tô','587.1','bua sang',NULL,'2018/05/07','2018/05/07'),(31,'Bò cuốn mỡ chài','8 cuốn','1156.6','bua trua',NULL,'2018/05/07','2018/05/07'),(32,'Bò cuốn mỡ chài','8 cuốn','1156.6','bua toi',NULL,'2018/05/07','2018/05/07'),(33,'Bò cuốn mỡ chài','4 cuốn','578.3','bua trua',NULL,'2018/05/07','2018/05/07'),(34,'Bò cuốn mỡ chài','4 cuốn','578.3','bua toi',NULL,'2018/05/07','2018/05/07'),(35,'Cá bạc má kho','1 con','167.0','bua trua',NULL,'2018/05/07','2018/05/07'),(36,'Cá bạc má kho','1 con','167.0','bua toi',NULL,'2018/05/07','2018/05/07'),(37,'Cá bạc má kho','2 con','334.0','bua trua',NULL,'2018/05/07','2018/05/07'),(38,'Cá bạc má kho','2 con','334.0','bua toi',NULL,'2018/05/07','2018/05/07'),(39,'Cá chép chưng tương','1 con','156.0','bua trua',NULL,'2018/05/07','2018/05/07'),(40,'Cá chép chưng tương','1 con','156.0','bua toi',NULL,'2018/05/07','2018/05/07'),(41,'Cá chép chưng tương','2 con','312.0','bua trua',NULL,'2018/05/07','2018/05/07'),(42,'Cá chép chưng tương','2 con','312.0','bua toi',NULL,'2018/05/07','2018/05/07'),(43,'Cá chim chiên','1 con','111.0','bua trua',NULL,'2018/05/07','2018/05/07'),(44,'Cá chin chiên','1 con','111.0','bua toi',NULL,'',''),(45,'Cá chin chiên','2 con','222.0','bua trua',NULL,'',''),(46,'Cá chin chiên','2 con','222.0','bua toi',NULL,'',''),(47,'Cá đối chiên','1 con','108.0','bua trua',NULL,'',''),(48,'Cá đối chiên','1 con','108.0','bua toi',NULL,'',''),(49,'Cá đối chiên','2 con','216.0','bua trua',NULL,'',''),(50,'Cá đối chiên','2 con','216.0','bua trua',NULL,'',''),(51,'Cơm hến','1 đĩa','389.0','bua sang','Món ăn huế','',''),(52,'canh cải ngọt','1 chén ','30','bua trua',NULL,NULL,NULL),(53,'Khổ qua xào trứng','1 đĩa','114	','bua trua ',NULL,NULL,NULL),(54,'Mực xào thập cẩm','1 đĩa','136','bua trua ',NULL,NULL,NULL),(55,'Sườn nướng','1 miếng	','111	','bua trua ',NULL,NULL,NULL),(56,'Thịt bò xào nấm rơm	','1 đĩa','153','bua trua ',NULL,NULL,NULL),(57,'Thịt heo xào đậu que','1 đĩa ','240','bua trua ',NULL,NULL,NULL),(58,'Bánh bao chay	','2 cái ','220	 ','bua trua ',NULL,NULL,NULL),(59,'Bông cải xào thập cẩm	','1 đĩa ','142 ','bua trua ',NULL,NULL,NULL),(60,'Cà ri ','1 tô ','278','bua trua ',NULL,NULL,NULL),(61,'Cơm chiên dương châu	','1 đĩa ','530','bua trua ',NULL,NULL,NULL),(62,'Đậu hủ chiên xả ','1 miếng ','148','bua trua ',NULL,NULL,NULL),(63,'Bánh chuối chiên	','1 cái lớn	','139	','bua trua ',NULL,NULL,NULL),(64,'Bánh chuối chiên	','1 cái lớn	','139	','bua sang ',NULL,NULL,NULL),(65,'Bánh chuối chiên	','1 cái lớn	','139	','bua toi ',NULL,NULL,NULL),(66,'Bánh Flan	','1 cái ','66','bau sang ',NULL,NULL,NULL),(67,'Bánh Flan	','1 cái ','66','bau toi ',NULL,NULL,NULL),(68,'Bánh Flan	','1 cai ','66','bua trua ',NULL,NULL,NULL),(69,'Cà ri ','1 tô ','278','bua sang ',NULL,NULL,NULL),(70,'Cà ri ','1 tô ','278 ','bua toi ',NULL,NULL,NULL),(71,'Hủ tíu thịt heo	','1 tô ','361','bua sang ',NULL,NULL,NULL),(72,'Hủ tíu thịt heo	','1 tô ','361','bua toi ',NULL,NULL,NULL),(73,'Hủ tíu thịt heo	','1 tô ','361 ','bua trua ',NULL,NULL,NULL),(74,'Mì vịt tiềm	','1 tô ','776','bua trua ',NULL,NULL,NULL),(75,'Mì vịt tiềm	','1 tô ','776','bua toi ',NULL,NULL,NULL),(76,'Mì vịt tiềm	','1 tô ','776','bua sang ',NULL,NULL,NULL),(77,'Phở bò tái	','1 tô ','431','bua sang ',NULL,NULL,NULL),(78,'Phở bò tái	','1 tô ','431','bua toi ',NULL,NULL,NULL),(79,'Phở bò tái	','1 tô ','431','bua trua ',NULL,NULL,NULL),(80,'Miến gà	','1 tô ','635 ','bua trua ',NULL,NULL,NULL),(81,'Miến gà	','1 tô ','635 ','bua toi ',NULL,NULL,NULL),(82,'Miến gà	','1 tô ','635 ','bua sang ',NULL,NULL,NULL),(83,'Nấm rơm kho	',' 1 tô ','154','bua sang ',NULL,NULL,NULL),(84,'Nấm rơm kho	','1 tô ','154','bua toi ',NULL,NULL,NULL),(85,'Nấm rơm kho	','1 tô ','154','bua trua ',NULL,NULL,NULL),(86,'Tôm lăn bột chiên	','1 đĩa ','247','bua trua ',NULL,NULL,NULL),(87,'Tôm lăn bột chiên	','1 đĩa ','247','bua toi ',NULL,NULL,NULL),(88,'Tôm lăn bột chiên	 ','1 đĩa ','247 ','bua sang ',NULL,NULL,NULL),(89,'Măng kho thập cẩm	','1 đĩa ','141 ','bua sang ',NULL,NULL,NULL),(90,'Măng kho thập cẩm	','1 đĩa ','141','bua toi ',NULL,NULL,NULL),(91,'Măng kho thập cẩm	','1 đĩa ','141 ','bua trua ',NULL,NULL,NULL),(92,'Đùi gà chiên	','1 cái ','142','bua sang ',NULL,NULL,NULL),(93,'Đùi gà chiên	','1 cái ','142','bua toi ',NULL,NULL,NULL),(94,'Đùi gà chiên	','1 cái ','143','bua trua ',NULL,NULL,NULL),(95,'Bún thịt nướng chả giò	','1  suất ','598 ','bua sang ',NULL,NULL,NULL),(96,'Bún mộc	','1 tô ','514','bua sang',NULL,NULL,NULL),(98,'Cháo đậu đỏ	','1 tô  ','322','bua sang ',NULL,NULL,NULL),(99,'Phở bò viên	','1 tô ','431','bua sang',NULL,NULL,NULL),(100,'Bánh bao nhân thịt	','1 cái ','328','bua sang ',NULL,NULL,NULL);
/*!40000 ALTER TABLE `table_mon_an` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hcstt'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-16  9:33:58
