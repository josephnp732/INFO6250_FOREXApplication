use FOREX;

select * from users;

select * from recipient;

select * from payment;

select * from `Transaction`;


delete from users where userId = 3;

insert into users(userId,address,dateOfBirth,email,`name`,`password`,phoneNumber,userName) values(1,'Boston','07/08/1996','anoop.c@husky.neu.edu','CJ','hello',8572069003,'anoop.c');

insert into recipient(recipientId,routingNumber,emailAddress,`name`,purpose,accountNumber,user_id) values(1,090928349840,'recipient1@outlook.com','Thomas Simmers','family member',8572069002343,1);
insert into recipient(recipientId,routingNumber,emailAddress,`name`,purpose,accountNumber,user_id) values(2,090345334980,'recipient2@live.com','Samuel Casey','work place',8572069002343,1);
insert into recipient(recipientId,routingNumber,emailAddress,`name`,purpose,accountNumber,user_id) values(3,090928344534,'recipient3@hotmail.com','Priyanka Chopra','Actor',8572069002343,1);

insert into payment(cardId,cardNumber,cardType,cvv,`month`,nameOnCard,`year`,zipCode,user_id) value(1,893584933495,'VISA',872,12,'Christy Anoop',2019,02115,1);
insert into payment(cardId,cardNumber,cardType,cvv,`month`,nameOnCard,`year`,zipCode,user_id) value(2,928340924093,'AMERICAN EXPRESS',3242,02,'Christy Anoop',2022,34531,1);
insert into payment(cardId,cardNumber,cardType,cvv,`month`,nameOnCard,`year`,zipCode,user_id) value(3,094860388535,'DISCOVER',452,09,'Christy Anoop',2023,23122,1);
