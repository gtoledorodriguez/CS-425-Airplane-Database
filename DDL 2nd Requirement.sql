/* Create Database Tables */
/*Omesh*/
/*Customer*/
CREATE TABLE Customer (
	email_id VARCHAR(25),
	password VARCHAR(16),
	age INT NOT NULL CHECK (age >=0),
	first_name VARCHAR(15) NOT NULL,
	middle_name VARCHAR(15),
	last_name VARCHAR(25) NOT NULL,
	PRIMARY KEY (email_id)
);

CREATE INDEX Customer_index ON Customer(email_id, last_name, first_name);

/*CustAddress*/
CREATE TABLE Address (
	street_number VARCHAR(10),
	street_name VARCHAR(35),
	apt_number VARCHAR(5),
	city VARCHAR(30),
	state VARCHAR(20),
	zipcode VARCHAR(9) NOT NULL,
	PRIMARY KEY (street_number, street_name, city, state, zipcode)
);

CREATE INDEX Address_index ON Address(street_number, street_name);

/*CardInfo*/
CREATE TABLE CreditCard (
	cc_number BIGINT,
	cvv INT NOT NULL,
	exp_month INT NOT NULL CHECK (exp_month BETWEEN 1 AND 12),
	exp_year INT NOT NULL CHECK (exp_year BETWEEN 2019 AND 2030),
	PRIMARY KEY (cc_number)
);

CREATE INDEX CreditCard_index ON CreditCard(cc_number);

/*Airport*/
CREATE TABLE Airport (
	airport_id CHAR(3),
	name VARCHAR(55),
	country VARCHAR(22),
	state CHAR(2),
	PRIMARY KEY (airport_id)
);

CREATE INDEX Airport_index ON Airport(airport_id);

CREATE TABLE Billing (
	cc_number BIGINT,
	street_number VARCHAR(10) NOT NULL,
	street_name VARCHAR(35)NOT NULL,
	apt_number VARCHAR(5),
	city VARCHAR(30) NOT NULL,
	state VARCHAR(20) NOT NULL,
	zipcode VARCHAR(9) NOT NULL,
	PRIMARY KEY (cc_number),
	FOREIGN KEY (cc_number) REFERENCES CreditCard ON DELETE CASCADE,
	FOREIGN KEY (street_number, street_name, city, state, zipcode) REFERENCES Address
);

CREATE TABLE Lives (
	email_id VARCHAR(25),
	street_number VARCHAR(10) NOT NULL,
	street_name VARCHAR(35)NOT NULL,
	apt_number VARCHAR(5),
	city VARCHAR(30) NOT NULL,
	state VARCHAR(20) NOT NULL,
	zipcode VARCHAR(9) NOT NULL,
	PRIMARY KEY (email_id, street_number, street_name, city, state, zipcode),
	FOREIGN KEY (email_id) REFERENCES Customer ON DELETE CASCADE,
	FOREIGN KEY (street_number, street_name, city, state, zipcode) REFERENCES Address
);

CREATE TABLE HasCC (
	email_id VARCHAR(25),
	cc_number BIGINT,
	PRIMARY KEY (email_id, cc_number),
	FOREIGN KEY (email_id) REFERENCES Customer ON DELETE CASCADE,
	FOREIGN KEY (cc_number) REFERENCES CreditCard ON DELETE CASCADE
);

CREATE TABLE HomeAirport (
	email_id VARCHAR(25),
	airport_id CHAR(3) NOT NULL,
	PRIMARY KEY (email_id),
	FOREIGN KEY (email_id) REFERENCES Customer ON DELETE CASCADE,
	FOREIGN KEY (airport_id) REFERENCES Airport ON DELETE CASCADE
);

/*Gladys*/
/*Airline*/
CREATE TABLE Airline(
  airline_id CHAR(2),
  name varchar(256),
  country varchar(256),
  PRIMARY KEY (airline_id)
);

CREATE INDEX airline_index ON Airline (airline_id);

/*Flight*/
CREATE TABLE Flight (
  airline_id CHAR(2),
  flight_num INT,
  f_date DATE,
  depart_airport CHAR(3) NOT NULL, /*Departing Airport*/
  dest_airport CHAR(3) NOT NULL, /*Destination Airport*/
  depart_time TIME(0) NOT NULL,
  arrival_time TIME(0) NOT NULL,
  num_ec_seats INT DEFAULT 180 CHECK (num_ec_seats>=0),
  num_fc_seats INT DEFAULT 80 CHECK (num_fc_seats>=0),
  PRIMARY KEY (airline_id, flight_num, f_date),
  FOREIGN KEY (airline_id) REFERENCES Airline(airline_id)
);

CREATE INDEX flight_index ON Flight (airline_id, flight_num, f_date);

/*Price*/
CREATE TABLE Price (
  airline_id CHAR(2),
  flight_num INT,
  f_date DATE,
  ec_price INT DEFAULT 50 CHECK (ec_price>=0),
  fc_price INT DEFAULT 100 CHECK (fc_price>ec_price),
  PRIMARY KEY (airline_id, flight_num, f_date,ec_price,fc_price),
  FOREIGN KEY (airline_id, flight_num, f_date) REFERENCES Flight(airline_id, flight_num, f_date)

);

/*Nasna*/
/*Booking*/
CREATE TABLE Booking(
  email_id CHAR(20), /*Varchar*/
  flight_num INT,
  f_date DATE,
  seat_type char(5),
  cc_number INT,
  airline_id CHAR(2),
	ec_seats INT,
	fc_seats INT,
  PRIMARY KEY (email_id),
	FOREIGN KEY (email_id) REFERENCES Customer(email_id),
  FOREIGN KEY (cc_number) REFERENCES CreditCard(cc_number),
  FOREIGN KEY (airline_id) REFERENCES Airline(airline_id),
  FOREIGN KEY (flight_num,airline_id,f_date) REFERENCES Flight(flight_num,airline_id,f_date)

  /*Flights_ID char(5) NOT NULL airline_id, flight_num, f_date*/
);
CREATE INDEX Booking_index ON Booking (flight_num,f_date,airline_id);

/*BookedFlights
CREATE TABLE Booked_Flights(
  email_id CHAR(20), Varchar
  airline_id CHAR(10),
  flight_Num char(10),
  f_date DATE
  PRIMARY KEY (email_id),
  FOREIGN KEY (flight_num, f_date) REFERENCES Flight(flight_num, f_date)
);
CREATE INDEX Booked_Flights_index ON Booked_Flights (email_id);
*/

CREATE TABLE Booked_Flights (
  airline_id CHAR(2),
  email_id CHAR(20),
  flight_num INT,
  f_date DATE,
	ec_seats INT,
	fc_seats INT,
  PRIMARY KEY (email_id,flight_num, f_date, airline_id),
  FOREIGN KEY (airline_id) REFERENCES Airline(airline_id),
  FOREIGN KEY (flight_num, f_date, airline_id) REFERENCES Flight (flight_num, f_date, airline_id)
);

CREATE INDEX Booked_Flights_index ON Booked_Flights (airline_id, flight_num, f_date);

/*MilageProgram*/
CREATE TABLE MilageProgram(
  email_id CHAR(20), /*Varchar*/
	airline_id CHAR(2),
  /*duration INT(50),*/
  bonus_miles int DEFAULT 1029,
  bonus_id Serial,
  PRIMARY KEY (bonus_id),
  FOREIGN KEY (email_id) REFERENCES Customer(email_id),
  FOREIGN KEY (airline_id) REFERENCES Airline(airline_id)
);
CREATE INDEX MileageProgram_index ON MilageProgram (email_id);
