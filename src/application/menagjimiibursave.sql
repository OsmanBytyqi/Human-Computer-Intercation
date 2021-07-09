-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2020 at 05:41 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- --------------------------------------------------------
create database menaxhimi_bursave;
use menaxhimi_bursave;

CREATE TABLE Selected (
 idStudentit int(11) not null AUTO_INCREMENT,
 emri varchar(50),
 mbiemri varchar(50),
 ditelindja date,
 mesatarja float(30),
 email varchar(100),
 numri varchar(200),
 qyteti varchar(50),
 adresa varchar(50),
 VitiiStudimeve int(100),
 NiveliiStudimeve varchar (50),
 fakulteti varchar(100),
 drejtimi varchar(150),
 bursa varchar(100),
 PRIMARY KEY(idStudentit)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- INSERTIMI I ANTAREVE NE Selected
CREATE TABLE login(
username varchar(50),
password varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- INSERTIMI I ANTAREVE NE login --

CREATE TABLE aplikuesit(
id int(11) not null AUTO_INCREMENT,
idStudentit int(11),
emri varchar(50) not null,
mbiemri varchar(50) not null,
ditelindja date not null,
mesatarja float(50),
email varchar(100),
numri varchar(50),
qyteti varchar(50),
adresa varchar(50),
VitiiStudimeve int(30),
NiveliiStudimeve varchar(50),
fakulteti varchar(50),
drejtimi varchar(50),
bursa int(30),
PRIMARY KEY(id),
FOREIGN KEY (idStudentit) REFERENCES  Selected(idStudentit)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- INSERTIMI I ANTAREVE NE LOGIN --

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
