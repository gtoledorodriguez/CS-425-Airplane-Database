/* Create Database Tables */
/*Omesh*/
/*Customer*/

/*CustAddress*/

/*CardInfo*/

/*Airport*/


/*Gladys*/
/*Airline*/
CREATE TABLE Airline(
  airline_id CHAR(2),
  name varchar(256),
  country varchar(256),
  PRIMARY KEY (airline_id)
);
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
  num_fc_seats INT NOT NULL,
  PRIMARY KEY (airline_id, flight_num, f_date),
  FOREIGN KEY (airline_id) REFERENCES Airline(airline_id)
);
/*Price*/
CREATE TABLE Price (
  airline_id CHAR(2),
  flight_num INT,
  f_date DATE,
  ec_price INT NOT NULL,
  fc_price INT NOT NULL,
  CHECK (fc_price>ec_price),
  PRIMARY KEY (airline_id, flight_num, f_date,ec_price,fc_price),
  FOREIGN KEY (airline_id, flight_num, f_date) REFERENCES Flight(airline_id, flight_num, f_date)

);

/*Nasna*/
/*Booking*/
CREATE TABLE Booking(
  Email_id CHAR(20), /*Varchar*/
  flight_num INT,
  seat_type char(5),
  /*Flights_ID char(5) NOT NULL airline_id, flight_num, f_date*/
);

/*BookedFlights*/
CREATE TABLE Booked_Flights(
  Email_id CHAR(20), /*Varchar*/
  airline_ID CHAR(10),
  Flight_No char(10),
  f_date DATE
);
/*MilageProgram*/
CREATE TABLE MilageProgram(
  Email_id CHAR(20), /*Varchar*/
  airline_ID CHAR(10), 
  /*duration INT(50),*/
  bonus_miles int
);