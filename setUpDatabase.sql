/*CREATE Role*/
CREATE ROLE admin WITH
  LOGIN
  SUPERUSER
  NOINHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION
  PASSWORD 'admin';

  CREATE ROLE jane WITH
    LOGIN
    SUPERUSER
    NOINHERIT
    CREATEDB
    CREATEROLE
    NOREPLICATION
    PASSWORD '123';

/*Add Create database*/
/*Copy and paste DDL*/

/*Insert values*/
Insert into Airport
VALUES
("ORD", "O'Hare International Airport", "USA", "IL"),
("IAD", "Dulles International Airport", "USA", "VA");

Insert into airline
VALUES
('AA', 'American Airlines', 'USA');

Insert into airport
VALUES
( 'ORD', 'OHare International Airport', 'USA', 'IL'),
( 'IAD', 'Dulles International Airport', 'USA', 'VA')
;
Insert into flight
Values
('AA',1,'2011-01-01','ORD','IAD','1:25:51','19:58:32',180,80),
('AA',2,'2011-01-01','ORD','IAD','5:34:13','23:45:43',180,80),
('AA',3,'2011-01-05','IAD','ORD', '5:56:32','23:12:23',180,80),
('AA',4,'2011-01-07','IAD','ORD', '4:43:33','12:34:12',180,80)
;
Insert into Price (airline_id, flight_num, f_date)
VALUES
('AA',1,'2011-01-01'),
('AA',2,'2011-01-01'),
('AA',3,'2011-01-05'),
('AA',4,'2011-01-07')
;
