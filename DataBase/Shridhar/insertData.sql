use agroget;

insert into renter_info_tbl(renter_fname , renter_lname ,renter_mobile ,renter_email ,renter_username ,renter_password ,
renter_address ,renter_shop_details ,renter_is_approved )
values
('nikhil','naik','9874563210','nikhil@gmail.com','nikhil@gmail.com','nikhil@123','white field bengaluru','NIK',1),
('omkar','oak','8745632109','omkar@gmail.com','oak','omkar@123','rajaji nagar bengaluru','OM',1),
('prasad','phule','7456321098','prasad@gmail.com','phule','prasad@123','mg road  bengaluru','PRASAD',1),
('raj','rawal','7456321097','raj@gmail.com','rawal','raj@123','wilson garden bengaluru','RAJ',1),
('sagar','sarnaik','4563210974','sagar@gmail.com','sarnaik','sagar@123',' global village bengaluru','OM',1);

INSERT INTO farmer_info_tbl(farmer_id,farmer_fname,farmer_lname,farmer_mobile,farmer_email,farmer_username,farmer_password,farmer_address,farmer_pincode) VALUES
(36,'Sumit','Arvikar','7412589630','sumit@gmail.com','sumit@gmail.com','pwd@45Sum','Arvikar Aparatment,Lane 10, Shivanji Nagar, Pune',411002);

INSERT INTO farmer_info_tbl(farmer_fname,farmer_lname,farmer_mobile,farmer_email,farmer_username,farmer_password,farmer_address,farmer_pincode) VALUES
('Ganpat','Avre','8565985290','gavre@gmail.com','gavre@gmail.com',' gavre@8956','near hp petrol pump,amravati,maharashtra',444901),
('Akash','jadhav','9719380950','akashj@gmail.com','akashj@gmail.com',' akash@45Sum','shivaji nagar,latur,maharashtra',413510),
('Manoj','gore','9887277661','manojgore@gmail.com','manojgore@gmail.com','  gorem@8957','gandhi chauk,near bank of baroda,aurangabad,maharashtra',410005),
('kartik','kale','9902617227','kartikkale@gmail.com','kartikkale@gmail.com',' new@45Sum','juhu,near taj hotel,mumbai,maharashtra',400030);


insert into equipment_info_tbl(equipment_id ,equipment_name ,equipment_type ,equipment_rate_type ,equipment_rate ,
equipment_deacription ,equipment_status , renter_id) 
values
(21,'boxdrill','seeding','day',1500,'reliabilty productivity',1,1),
(22,'spraying drone','crop protection','day',2000,'perfect',1,1),
(23,'soil tillage','tillage','day',5000,'easy work',1,2),
(24,'x series combine','harvesting','hr',1000,'harvest',1,3),
(25,'tractors','all type','day',3000,'towing',1,3),
(26,'turmeric grader','post harvesting','hr',400,'budget friendly',1,4),
(27,'trolly','transport','hr',600,'for transport',1,5);


INSERT INTO order_info_tbl (order_id,farmer_id,order_total_cost,order_status,order_date ) VALUES
(101,38,51000,1,'2022-01-12'),
(102,39,2000,1,'2022-01-22'),
(103,40,8000,1,'2022-02-15'),
(104,37,6200,1,'2022-02-22'),
(105,36,6600,1,'2022-02-25');



insert into feedback_info_tbl(feedback_id ,farmer_id ,equipment_id,feedback_rating ,feedback_comments)
values
(41,101,21,4,'good'),
(42,102,22,1,'bad'),
(43,103,23,5,'excllent'),
(44,104,24,4,'good'),
(45,105,25,4,'good');


INSERT INTO order_equipment_tbl(order_equipment_id,order_id,equipment_id,from_date,from_time,to_date,to_time,order_equipment_status,service_address)VALUES  
(1,101,21,'2022-01-13','10:00:00','2022-01-19','10:00:00',1,'Arvikar Aparatment,Lane 10, Shivanji Nagar, Pune'),
(2,101,22,'2022-01-13','10:00:00','2022-01-19','10:00:00',1,'Arvikar Aparatment,Lane 10, Shivanji Nagar,Pune'),
(3,101,23,'2022-01-13','10:00:00','2022-01-19','10:00:00',1,'Arvikar Aparatment,Lane 10, Shivanji Nagar,Pune'),
(4,101,24,'2022-01-23','11:00:00','2022-01-23','18:00:00',1,'near hp petrol pump,amravati,maharashtra'),
(5,102,25,'2022-01-23','11:00:00','2022-01-28','11:00:00',1,'near hp petrol pump,amravati,maharashtra'),
(6,103,22,'2022-02-16','12:00:00','2022-02-20','12:00:00',1,'shivaji nagar,latur,maharashtra'),
(7,104,21,'2022-02-23','08:00:00','2022-02-25','08:00:00',1,'gandhi chauk,near bank of baroda,aurangabad,maharashtra'),
(8,104,26,'2022-02-23','08:00:00','2022-02-23','16:00:00',1,'gandhi chauk,near bank of baroda,aurangabad,maharashtra'),
(9,105,27,'2022-02-26','09:00:00','2022-02-26','20:00:00',1,'juhu,near taj hotel,mumbai,maharashtra');

insert into image_info_tbl(image_id,
farmer_id , image_data ,
image_description)
values(104,36,load_file('d:/kissan1.png'),'farmer'),
(105,37,load_file('d:/kissan2.png'),'farmer'),
(106,38,load_file('d:/kissan3.png'),'farmer');


insert into image_info_tbl(image_id,
renter_id,image_data ,
image_description)
values(92,2,load_file('d:/sl2.jpg'),'shop'),
(93,3,load_file('d:/sl3.jpg'),'shop'),
(94,4,load_file('d:/sl4.jpg'),'shop'),
(95,5,load_file('d:/sl5.jpg'),'shop');



select * from  image_info_tbl;
insert into image_info_tbl(image_id,
equipment_id , image_data ,
image_description)
values (96,21,load_file('d:/boxdrill.png'),'equipment'),
(97,22,load_file('d:/sprayingdrone.png'),'equipment'),
(98,23,load_file('d:/soiltillage.png'),'equipment'),
(99,24,load_file('d:/xseriescombine.png'),'equipment'),
(100,25,load_file('d:/tractor.png'),'equipment'),
(101,25,load_file('d:/trolly.png'),'equipment'),
(102,26,load_file('d:/grader.jpg'),'equipment'),
(103,27,load_file('d:/trolly.jpg'),'equipment');

insert into image_info_tbl (image_id,
equipment_id , image_data ,
image_description) values(98,23,load_file('d:/soiltillage.jpg'),'equipment');


(36,'farmer',36,'C:/Users/abc/Desktop/images/kisan1.png','kisan card'),
(37,'farmer',38,'C:/Users/abc/Desktop/images/kisan2.png','kisan card');


update farmer_info_tbl set farmer_kissan_card_id=38 where farmer_id=36;
update farmer_info_tbl set farmer_kissan_card_id=37 where farmer_id=38;

set foreign_key_checks=0;
set foreign_key_checks=1;
set foreign_key_checks=0;


drop table image_info_tbl;



select * from image_info_tbl;
delete from image_info_tbl where image_id=98;
alter table farmer_info_tbl drop column farmer_kissan_card_id;










































