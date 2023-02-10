create DATABASE if not exists HarardrugDatabase;
create table if not exists HarardrugDatabase.customer(
id int(100) NOT NULL AUTO_INCREMENT,
customerName varchar(50) not null,
ownerName varchar(30) null,
mobileNumber varchar(15) not null,
city varchar(50) null,
typeofOrganization varchar(30) not null,
religion varchar(30) not null,
primary key(mobileNumber),
INDEX(id)                                    

)ENGINE=INNODB;

 
 
 create table if not exists HarardrugDatabase.login(
 id int(10) auto_increment not null,
 uname varchar(8) not null,
 password varchar(8) not null,
 status varchar(4) not null,
 primary key(id),
 index(id)
 )ENGINE=INNODB; 

 
 
create table if not exists HarardrugDatabase.staffaddress(
idsta int(10) AUTO_INCREMENT NOT NULL,
staffId varchar(20) not null,
staffName varchar(40) not null,

staffSex varchar(5) not null,

religion varchar(10) not null,
stafmobileNumber varchar(30) not null,

staffAreaOfWork varchar(50) null,

primary key(stafmobileNumber),
index(idsta) 
 
 )ENGINE=INNODB;
 




create table if not exists HarardrugDatabase.ozekimessagein(
idoz int(100) not null auto_increment,
sender varchar(15)not null,
receiver varchar(30) null,
msg varchar(1024) null,
senttime varchar(100) null,
receivedtime varchar(100) null,
operator varchar(100) null,

index(idoz)


)ENGINE=INNODB;

create table if not exists HarardrugDatabase.ozekimessageout(
id int(100) not null auto_increment,
sender varchar(30) null,
receiver varchar(30) null,
msg varchar(1024) null,

senttime varchar(100) null,
receivedtime varchar(100) null,
msgtype varchar(100) null,
reference varchar(100) null,
status varchar(30) null,
operator varchar(100) null,
primary key(id)

)ENGINE=INNODB;
