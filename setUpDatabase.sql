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
('AA',1,'01-01-2011','ORD','IAD','1:25:51','19:58:32',180,80),
('AA',2,'01-01-2011','ORD','IAD','5:34:13','23:45:43',180,80)
;
