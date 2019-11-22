/* Create Database Tables */
/*Omesh*/
/*Customer*/
CREATE TABLE Customer (
	email_id VARCHAR(25),
	password VARCHAR(16) NOT NULL,
	age INT NOT NULL CHECK (age >=0),
	first_name VARCHAR(15) NOT NULL,
	middle_name VARCHAR(15),
	last_name VARCHAR(25) NOT NULL,
	airport_id CHAR(3) NOT NULL,
	PRIMARY KEY (email_id),
	FOREIGN KEY (airport_id) REFERENCES Airport(airport_id)
);

CREATE INDEX Customer_index ON Customer(email_id);

/*CustAddress*/
CREATE TABLE Address (
	address_ID SERIAL, /*Serial is postgreSQL equivalent of AUTOINCREMENT, it does not need INT*/
	email_id VARCHAR(25),
	street_number VARCHAR(10) NOT NULL,
	street_name VARCHAR(35) NOT NULL,
	apt_number VARCHAR(5),
	city VARCHAR(30) NOT NULL,
	state VARCHAR(20) NOT NULL,
	zipcode VARCHAR(9) NOT NULL,
	PRIMARY KEY (email_id, address_id),
	FOREIGN KEY (email_id)  REFERENCES Customer(email_id)
);

CREATE INDEX Address_index ON Address(street_number, street_name);

/*CardInfo*/
CREATE TABLE CreditCard (
	cc_number BIGINT,
	email_id VARCHAR(25),
	address_id INT NOT NULL,
	cvv INT NOT NULL,
	exp_month INT NOT NULL CHECK (exp_month BETWEEN 1 AND 12),
	exp_year INT NOT NULL CHECK (exp_year BETWEEN 2019 AND 2030),
	first_name VARCHAR(15) NOT NULL,
	middle_name VARCHAR(15),
	last_name VARCHAR(25) NOT NULL,
	PRIMARY KEY (email_id, cc_number),
	FOREIGN KEY (email_id)  REFERENCES Customer(email_id),
	FOREIGN KEY (email_id, address_id) REFERENCES Address(email_id, address_id) ON DELETE CASCADE
); /*Had to have email_id reference address as well or we got an no unique constrain matching error*/

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

+CREATE TABLE Billing (
	cc_number BIGINT,
	address_id INT NOT NULL,
	PRIMARY KEY (cc_number),
	FOREIGN KEY (cc_number) REFERENCES CreditCard,
	FOREIGN KEY (address_id) REFERENCES Address
);

CREATE TABLE Lives (
	email_id VARCHAR(25),
	address_id INT NOT NULL,
	PRIMARY KEY (email_id),
	FOREIGN KEY (email_id) REFERENCES Customer,
	FOREIGN KEY (address_id) REFERENCES Address
);

CREATE TABLE HasCC (
	email_id VARCHAR(25),
	address_id INT NOT NULL,
	PRIMARY KEY (email_id),
	FOREIGN KEY (email_id) REFERENCES Customer,
	FOREIGN KEY (address_id) REFERENCES Address
);

CREATE TABLE HomeAirport (
	email_id VARCHAR(25),
	airport_id CHAR(3) NOT NULL,
	PRIMARY KEY (email_id),
	FOREIGN KEY (email_id) REFERENCES Customer,
	FOREIGN KEY (airport_id) REFERENCES Airport
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
/*Ask about Flight Airline*/

CREATE TABLE Departing_Airport (
	airport_id CHAR(3) NOT NULL,
  depart_airport CHAR(3) NOT NULL,
  PRIMARY KEY (airport_id,depart_airport),
  FOREIGN KEY (airport_id) REFERENCES Airport(airport_id),
	FOREIGN KEY (depart_airport) REFERENCES Flight(depart_airport)
);

CREATE TABLE Destination_Airport (
	airport_id CHAR(3) NOT NULL,
  dest_airport CHAR(3) NOT NULL,
  PRIMARY KEY (airport_id,dest_airport),
  FOREIGN KEY (airport_id) REFERENCES Airport(airport_id),
	FOREIGN KEY (depart_airport) REFERENCES Flight(depart_airport)
);
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
  PRIMARY KEY (email_id),
  FOREIGN KEY (cc_number,email_id) REFERENCES CreditCard(cc_number,email_id),
  FOREIGN KEY (airline_id) REFERENCES Airline(airline_id),
  FOREIGN KEY (flight_num,airline_id,f_date) REFERENCES Flight(flight_num,airline_id,f_date)

  /*Flights_ID char(5) NOT NULL airline_id, flight_num, f_date*/
);
CREATE INDEX Booking_index ON Booking (depart_airport,dest_airport,airline_id);

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
  PRIMARY KEY (email_id),
  FOREIGN KEY (airline_id) REFERENCES Airline(airline_id),
  FOREIGN KEY (flight_num, f_date) REFERENCES Flight (flight_num, f_date)
);

CREATE INDEX Booked_Flights_index ON Booked_Flights (airline_id, flight_num, f_date);

/*MilageProgram*/
CREATE TABLE MilageProgram(
  email_id CHAR(20), /*Varchar*/
	airline_id CHAR(2),
  flight_num INT,
  f_date DATE,
  /*duration INT(50),*/
  bonus_miles int,
  bonus_id char(10),
  PRIMARY KEY (bonus_id),
  FOREIGN KEY (email_id) REFERENCES Customer(email_id),
  FOREIGN KEY (airline_id, flight_num, f_date) REFERENCES Flight(airline_id, flight_num, f_date)
);
CREATE INDEX MileageProgram_index ON MilageProgram (email_id);
