/* Create Database Tables */
/*Omesh*/
/*Customer*/
CREATE TABLE Customer (
	email_id VARCHAR(25),
	password VARCHAR(16) NOT NULL,
	age int NOT NULL,
	first_name VARCHAR(15) NOT NULL,
	middle_name VARCHAR(15),
	last_name VARCHAR(25) NOT NULL,
	airport_id CHAR(3) NOT NULL,
	PRIMARY KEY (email_id),
	FOREIGN KEY (airport_id),
	CHECK (age >=0)
);

/*CustAddress*/
CREATE TABLE Address (
	address_ID INT AUTO_INCREMENT,
	email_id VARCHAR(25),
	street_number VARCHAR(10) NOT NULL,
	street_name VARCHAR(35) NOT NULL,
	apt_number VARCHAR(5),
	city VARCHAR(30) NOT NULL,
	state VARCHAR(20) NOT NULL,
	zipcode VARCHAR(9) NOT NULL,
	PRIMARY KEY (email_id, address_id),
	FOREIGN KEY (email_id)  REFERENCES Customer
);

/*CardInfo*/
CREATE TABLE CreditCard (
	cc_number BIGINT,
	email_id VARCHAR(25),
	address_id INT NOT NULL,
	cvv INT NOT NULL,
	exp_month INT NOT NULL,
	exp_year INT NOT NULL,
	first_name VARCHAR(15) NOT NULL,
	middle_name VARCHAR(15),
	last_name VARCHAR(25) NOT NULL,
	PRIMARY KEY (email_id, cc_number),
	FOREIGN KEY (email_id)  REFERENCES Customer,
	FOREIGN KEY (address_ID)  REFERENCES Address ON DELETE CASCADE,
	CHECK (exp_month BETWEEN 1 AND 12),
	CHECK (exp_year BETWEEN 2019 AND 2030)
);

/*Airport*/
CREATE TABLE Airport (
	airport_id CHAR(3),
	name VARCHAR(55),
	country VARCHAR(22),
	state CHAR(2),
	PRIMARY KEY (address_id),
);


/*Gladys*/
/*Flight*/
CREATE TABLE Flight (
  airline_id CHAR(2),
  flight_num INT,
  f_date DATE,
  depart_airport CHAR(3) NOT NULL, /*Departing Airport*/
  dest_airport CHAR(3) NOT NULL, /*Destination Airport*/
  depart_time TIME(0) NOT NULL,
  arrival_time TIME(0) NOT NULL,
  num_ec_seats INT NOT NULL,
  num_fc_seats INT NOT NULL
);
/*Price*/
CREATE TABLE Price (
  airline_id CHAR(2),
  flight_num INT,
  f_date DATE,
  ec_price INT NOT NULL,
  fc_price INT NOT NULL,
  CHECK (fc_price>ec_price)
);
/*Nasna*/
/*Airline*/

/*Booking*/

/*BookedFlights*/

/*MilageProgram*/
