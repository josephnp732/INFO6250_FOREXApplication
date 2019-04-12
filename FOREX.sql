create schema FOREX;

use FOREX;

drop schema FOREX;

create table `Users` (
`userId` INTEGER NOT NULL AUTO_INCREMENT,
`userName` VARCHAR(20) NOT NULL,
`password` VARCHAR(20) NOT NULL, 
`name` VARCHAR(20) NOT NULL,
`phoneNumber` BIGINT NOT NULL,
`address` VARCHAR(100) NOT NULL,
`dateOfBirth` VARCHAR(10) NOT NULL,
`email` varchar(35) NOT NULL,
PRIMARY KEY(`userId`)
);

#create table `Login` (
#`loginId` INTEGER NOT NULL AUTO_INCREMENT,
#`userName` VARCHAR(20) NOT NULL,
#`password` VARCHAR(20) NOT NULL,
#`userId` INTEGER NOT NULL,
#PRIMARY KEY(`loginId`),
#FOREIGN KEY (`userId`) REFERENCES Users(`userId`)
#);


create table `Payment` (
`cardId` INTEGER NOT NULL AUTO_INCREMENT,
`nameOnCard` VARCHAR(30) NOT NULL,
`cardNumber` BIGINT NOT NULL,
`cvv` INTEGER(4) NOT NULL,
`month` INTEGER(2) NOT NULL,
`year` INTEGER(4) NOT NULL,
`zipCode` INTEGER(4) NOT NULL,
`user_id` INTEGER NOT NULL,
PRIMARY KEY(`cardId`),
FOREIGN KEY (`user_id`) REFERENCES Users(`userId`)
);

create table `Recipient` (
`recipientId` INTEGER NOT NULL AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL,
`accountNumber` BIGINT NOT NULL,
`routingNumber` BIGINT NOT NULL,
`emailAddress` varchar(35) NOT NULL,
`user_id` INTEGER NOT NULL,
PRIMARY KEY(`recipientId`),
FOREIGN KEY (`user_id`) REFERENCES Users(`userId`)
);

create table `Transaction` (
`transactionId` INTEGER NOT NULL AUTO_INCREMENT,
`cardNumber` BIGINT NOT NULL,
`recipient` VARCHAR(20) NOT NULL,
`transactionDateTime` DATE NOT NULL,
`user_id` INTEGER NOT NULL,
PRIMARY KEY(`transactionId`),
FOREIGN KEY (`user_id`) REFERENCES Users(`userId`)
);