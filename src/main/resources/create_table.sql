create database bios;
use bios;

create table Persons (
     Id int NOT NULL auto_increment,
     FirstName varchar(255) not null ,
     LastName varchar(255) not null,
     address varchar(255),
     primary key (Id)
);


