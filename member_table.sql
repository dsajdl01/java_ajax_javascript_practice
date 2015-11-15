/* database and data are created and inserted  into mysql by 
 * using terminal commands in Linux (Ubuntu) 
 *
 * author: David Sajdl
 */

mysql> CREATE DATABASE my_first_database; 

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| my_first_database  |
| mysql              |
| performance_schema |
+--------------------+
4 rows in set (0.03 sec)


mysql> use my_first_database;

mysql> show create database my_first_database;
+-------------------+------------------------------------------------------------------------------+
| Database          | Create Database                                                              |
+-------------------+------------------------------------------------------------------------------+
| my_first_database | CREATE DATABASE `my_first_database` /*!40100 DEFAULT CHARACTER SET latin1 */ |
+-------------------+------------------------------------------------------------------------------+
1 row in set (0.00 sec)


mysql> CREATE TABLE members(
    -> member_id int(5) NOT NULL AUTO_INCREMENT, 
    -> first_name VARCHAR(30) NOT NULL,
    -> last_name VARCHAR(30),
    -> email VARCHAR(50) NOT NULL, 
    -> username VARCHAR(30) NOT NULL,
    -> date_birthday DATE,
    -> gender char(1),
    -> location VARCHAR(40),
    -> PRIMARY KEY (member_id))
    -> ENGINE=InnoDB;

mysql> show tables;
+-----------------------------+
| Tables_in_my_first_database |
+-----------------------------+
| members                     |
+-----------------------------+
1 row in set (0.00 sec)

mysql> INSERT INTO members(first_name, last_name, email, username, date_birthday, gender, location)
       VALUES('Flimstone', 'Fred', 'flfred@example.con', 'flfred24' '1980-01-01', 'M', 'London');
mysql> INSERT INTO members(first_namelast_name, email, username, date_birthday, gender, location)
       VALUES('David', 'Sajdl', 'dsajdl@example.com', 'dsajdl01', '1989-11-09', 'M', 'Bishops Stortford');


mysql> select * from members;
+-----------+------------+-----------+--------------------+----------+---------------+--------+-------------------+
| member_id | first_name | last_name | email              | username | date_birthday | gender | location          |
+-----------+------------+-----------+--------------------+----------+---------------+--------+-------------------+
|         1 | Fred       | Flimstone | flfred@example.com | flfred24 | 1980-01-01    | M      | London            |
|         2 | David      | Sajdl     | dsajdl@example.com | dsajdl01 | 1989-11-09    | M      | Bishops Storfford |
+-----------+------------+-----------+--------------------+----------+---------------+--------+-------------------+
2 rows in set (0.00 sec)

mysql> show create table members;
+---------+---------------------------------------------+
| Table   | Create Table                                |
+---------+---------------------------------------------+
| members | CREATE TABLE `members` (
  `member_id` int(5) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(30) NOT NULL,
  `date_birthday` date DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `location` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 |
+---------+---------------------------------------------+
1 row in set (0.02 sec)
