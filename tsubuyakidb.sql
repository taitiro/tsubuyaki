-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- ホスト: 127.0.0.1
-- 生成日時: 2013 年 12 月 17 日 04:18
-- サーバのバージョン: 5.5.32
-- PHP のバージョン: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- データベース: `tsubuyakidb`
--
CREATE DATABASE IF NOT EXISTS `tsubuyakidb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `tsubuyakidb`;

-- --------------------------------------------------------

--
-- テーブルの構造 `profile`
--

CREATE TABLE IF NOT EXISTS `profile` (
  `name` varchar(255) NOT NULL,
  `userdesc` varchar(140) NOT NULL,
  `icon` varchar(255) NOT NULL DEFAULT 'http://localhost:8080/tsubuyaki/css/img/ic_item.gif',
  `address` varchar(140) NOT NULL,
  `homepage` varchar(255) NOT NULL,
  `realname` varchar(140) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `profile`
--

INSERT INTO `profile` (`name`, `userdesc`, `icon`, `address`, `homepage`, `realname`) VALUES
('root', '管理人だよ', 'http://www.darakeru.com/files/cache/2b9da81a4bbeeea8a9f0ac2305b09c6e_f10.png', '東京都', 'http://www.darakeru.com/', '小杉太一郎'),
('suzuki', 'てすと', '', 'しちてし', '', '鈴木さんだよ'),
('user', '一般ユーザーかな', 'http://www.darakeru.com/files/cache/e3ee11b3c7cf833e1ed945405f2f15f4_f11.jpg', 'ネット上だと思う', 'http://localhost/tsubuyaki/', '一般ユーザーです');

-- --------------------------------------------------------

--
-- テーブルの構造 `tsubuyaki`
--

CREATE TABLE IF NOT EXISTS `tsubuyaki` (
  `name` varchar(255) NOT NULL,
  `value` varchar(140) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `tsubuyaki`
--

INSERT INTO `tsubuyaki` (`name`, `value`, `date`) VALUES
('root', 'test', '2013-12-16 01:16:07'),
('root', 'test', '2013-12-16 01:45:52'),
('user', 'testtest', '2013-12-16 02:14:00'),
('user', '2013/12/17のテスト', '2013-12-17 00:35:53'),
('suzuki', '鈴木参上', '2013-12-17 01:03:20'),
('user', '午前10時59分のテスト', '2013-12-17 01:59:42'),
('user', 'test', '2013-12-17 02:17:31'),
('user', 'test', '2013-12-17 02:52:44');

-- --------------------------------------------------------

--
-- テーブルの構造 `userauth`
--

CREATE TABLE IF NOT EXISTS `userauth` (
  `name` varchar(255) NOT NULL,
  `password` char(32) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `userauth`
--

INSERT INTO `userauth` (`name`, `password`) VALUES
('root', '5f4dcc3b5aa765d61d8327deb882cf99'),
('suzuki', '1a1dc91c907325c69271ddf0c944bc72'),
('user', '1a1dc91c907325c69271ddf0c944bc72');

-- --------------------------------------------------------

--
-- テーブルの構造 `userrole`
--

CREATE TABLE IF NOT EXISTS `userrole` (
  `name` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `userrole`
--

INSERT INTO `userrole` (`name`, `role`) VALUES
('root', 'admin'),
('suzuki', 'user'),
('user', 'user');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
