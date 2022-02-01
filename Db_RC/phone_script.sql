
DROP database if exists archivio_telefonico;
CREATE database archivio_telefonico;
use archivio_telefonico;
 /*DROP TABLE if exists opsys;*/
 
 create table opsys(
 id int (11) not null auto_increment primary key,
 descrizione varchar(60),
 company varchar (66),
 opensource tinyint (1));
 
 
 create table country(
 cod varchar (2) not null primary key ,
 nome varchar(30));
 
 
 create table brand(
 id int (11) not null AUTO_INCREMENT ,
 nome varchar(20) NOT NULL,
 country varchar (2) NOT NULL,
 constraint pk_id primary key(id),
 constraint fk_country foreign key (country) references country (cod)
 );
 
 
 create table smartphone(
 id int (11) not null  auto_increment,
 nome varchar(64),
 ram varchar(5),
 cpuu  varchar (20),
 displaySize varchar(45),
 displayPpi int(11),
 displayResolution varchar(64),
 size varchar(64),
 opsys_id int (11),
 brand_id int(11),
 constraint pk_id primary key(id),
 constraint fk_opsys foreign key (opsys_id) references opsys (id),
 constraint fk_brand foreign key (brand_id) references brand (id)
 );