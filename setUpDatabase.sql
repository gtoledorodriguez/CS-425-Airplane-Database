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
INSERT into airport
values ('DFW', 'Dallas/Fort Worth International Airport', 'USA', 'TX'),
('DIA', 'Denver International Airport', 'USA', 'CO'),
('HNL', 'Daniel K Inouye International Airport', 'USA', 'HI'),
('TUS', 'Tucson International Airport', 'USA', 'AZ'),
('FAT', 'Fresno Yosemite International Airport', 'USA', 'AZ'),
('AAI', 'Airdrie Airodome International Airport', 'Canada', 'AL')
;


insert into customer
values ('bwayne', 'batcave', 32, 'Bruce','', 'Wayne'),
('dgrayson', 'nwing', 27, 'Richard','', 'Grayson'),
('jtodd', 'rhood', 22, 'Jason','', 'Todd'),
('tdrake', 'rrobin', 18, 'Timothy','', 'Drake'),
('bgordon', 'batgirl', 22, 'Barbara','', 'Gordon'),
('skyle', 'catwoman', 31, 'Selina','', 'Kyle'),
('hquinn', 'mallot', 26, 'Harleen','', 'Quinn'),
('canders', 'starfire', 26, 'Cory','', 'Anders')
;


insert into address
values ('900', 'Wayne Dr','', 'Chicago', 'Illinois', '60601'),
('301S770', 'Milwaukee Av','', 'Chicago', 'Illinois', '60608'),
('54W110', 'Circus St', '1R', 'Dallas', 'Texas', '75019'),
('3201', 'Washtenaw Av','', 'Denver', 'Colorado', '80217'),
('600', 'Arthur Ln','', 'Denver', 'Colorado', '80256'),
('99', 'Oligret Ctr','', 'Grand Junction', 'Colorado', '81503'),
('866', 'Simba St','', 'Honolulu', 'Hawaii', '96853'),
('202', 'Kerope Ln','', 'Hilo', 'Hawaii', '96721'),
('552', 'Shotoba Av','', 'Kahului', 'Hawaii', '96793'),
('40W622', 'Oracle Blvd','', 'Tucson', 'Arizona', '85719'),
('55N62', 'Cameron Ave','', 'Fresno', 'California', '93715'),
('215W62', 'Proctor Av','', 'Airdrie', 'Alberta', 'T4A0B1')
;



insert into creditcard
values (9822085925411040, 598, 04, 2022),
(9371016697000001, 602, 01, 2023),
(9371016697000002, 758, 07, 2024),
(9371016697000003, 717, 06, 2025),
(9371016697000004, 751, 02, 2024),
(9371016697000005, 100, 11, 2023),
(9371016697000006, 509, 3, 2029),
(9371016697000007, 141, 5, 2025),
(9371016697000008, 811, 1, 2022)
;



insert into billing
values (9822085925411040, '301S770', 'Milwaukee Av','', 'Chicago', 'Illinois', '60608'),
(9371016697000001, '54W110', 'Circus St', '1R', 'Dallas', 'Texas', '75019'),
(9371016697000002, '600', 'Arthur Ln','', 'Denver', 'Colorado', '80256'),
(9371016697000003, '202', 'Kerope Ln','', 'Hilo', 'Hawaii', '96721'),
(9371016697000004, '552', 'Shotoba Av','', 'Kahului', 'Hawaii', '96793'),
(9371016697000005, '40W622', 'Oracle Blvd','', 'Tucson', 'Arizona', '85719'),
(9371016697000006, '55N62', 'Cameron Ave','', 'Fresno', 'California', '93715'),
(9371016697000007, '215W62', 'Proctor Av','', 'Airdrie', 'Alberta', 'T4A0B1'),
(9371016697000008, '54W110', 'Circus St', '1R', 'Dallas', 'Texas', '75019')
;



insert into lives
values ('bwayne', '900', 'Wayne Dr','', 'Chicago', 'Illinois', '60601'),
('bwayne', '301S770', 'Milwaukee Av','', 'Chicago', 'Illinois', '60608'),
('dgrayson', '54W110', 'Circus St', '1R', 'Dallas', 'Texas', '75019'),
('jtodd', '3201', 'Washtenaw Av','', 'Denver', 'Colorado', '80217'),
('jtodd', '600', 'Arthur Ln','', 'Denver', 'Colorado', '80256'),
('jtodd', '99', 'Oligret Ctr','', 'Grand Junction', 'Colorado', '81503'),
('tdrake','866', 'Simba St','', 'Honolulu', 'Hawaii', '96853'),
('tdrake', '202', 'Kerope Ln','', 'Hilo', 'Hawaii', '96721'),
('tdrake', '552', 'Shotoba Av','', 'Kahului', 'Hawaii', '96793'),
('bgordon', '40W622', 'Oracle Blvd','', 'Tucson', 'Arizona', '85719'),
('skyle', '55N62', 'Cameron Ave','', 'Fresno', 'California', '93715'),
('hquinn', '215W62', 'Proctor Av','', 'Airdrie', 'Alberta', 'T4A0B1'),
('canders', '54W110', 'Circus St', '1R', 'Dallas', 'Texas', '75019')
;

insert into hascc
values ('bwayne', 9822085925411040),
('dgrayson', 9371016697000001),
('jtodd', 9371016697000002),
('tdrake', 9371016697000003),
('tdrake', 9371016697000004),
('bgordon', 9371016697000005),
('skyle', 9371016697000006),
('hquinn', 9371016697000007),
('canders', 9371016697000008)
;


insert into homeairport
values('bwayne', 'ORD'),
('dgrayson', 'DFW'),
('jtodd', 'DIA'),
('tdrake', 'HNL'),
('bgordon', 'TUS'),
('skyle', 'FAT'),
('hquinn', 'AAI'),
('canders', 'DFW')
;

Insert into Airport
VALUES
("ORD", "O'Hare International Airport", "USA", "IL"),
("IAD", "Dulles International Airport", "USA", "VA");

Insert into airline
VALUES  
('AA', 'American Airlines', 'USA'),
('UA', 'United Airlines', 'USA')
;

Insert into airport
VALUES
( 'ORD', 'OHare International Airport', 'USA', 'IL'),
( 'IAD', 'Dulles International Airport', 'USA', 'VA')
;
Insert into flight
Values
('AA',1,'2011-01-01','ORD','IAD', '01:25:51','19:58:32',180,80),
('AA',2,'2011-01-01','ORD','IAD', '05:34:13','23:45:43',180,80),
('AA',3,'2011-01-05','IAD','ORD', '05:56:32','23:12:23',180,80),
('AA',4,'2011-01-07','IAD','ORD', '04:43:33','12:34:12',180,80),
('UA',1,'2011-02-12','ORD','IAD', '12:45:32','23:34:41', 180,80),
('UA',2,'2011-03-23','ORD','IAD', '12:45:32','23:34:41', 180,80)
;
Insert into Price (airline_id, flight_num, f_date)
VALUES
('AA',1,'2011-01-01'),
('AA',2,'2011-01-01'),
('AA',3,'2011-01-05'),
('AA',4,'2011-01-07')
;
Insert into Price
VALUES
('UA',1,'2011-02-12',123, 546),
('UA',2,'2011-03-23',435, 634)
;

/*Procedures*/
CREATE OR REPLACE PROCEDURE public.addcust(
	eid character varying,
	pwd character varying,
	_age integer,
	fname character varying,
	mname character varying,
	lname character varying)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
	INSERT INTO Customer(email_id, password, age, first_name, middle_name, last_name)
	values (eid, pwd, _age, fname, mname, lname);

END;
$BODY$;

CREATE OR REPLACE PROCEDURE public.addhomeport(
	eid character varying,
	port_id character)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
	INSERT INTO HomeAirport(email_id, airport_id)
	values (eid, port_id);

END;
$BODY$;


CREATE OR REPLACE PROCEDURE public.addaddr(
	eid character varying,
	snum character varying,
	sname character varying,
	apt_num character varying,
	_city character varying,
	_state character varying,
	zcode character)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
	INSERT INTO Address(street_number, street_name, apt_number, city, state, zipcode)
	values (snum, sname, apt_num, _city, _state, zcode);

	INSERT INTO Lives(email_id, street_number, street_name, apt_number, city, state, zipcode)
	values (eid, snum, sname, apt_num, _city, _state, zcode);
END;
$BODY$;

CREATE OR REPLACE PROCEDURE public.addcc(
	cc_num bigint,
	_cvv integer,
	exp_m integer,
	exp_y integer,
	eid character varying,
	s_num character varying,
	s_name character varying,
	apt_num character varying,
	_city character varying,
	_state character varying,
	zcode character)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
	INSERT INTO CreditCard(cc_number, cvv, exp_month, exp_year)
	values (cc_num, _cvv, exp_m, exp_y);

	INSERT INTO HasCC(email_id, cc_number)
	values (eid, cc_num);

	INSERT INTO Address(street_number, street_name, apt_number, city, state, zipcode)
	select s_num, s_name, apt_num, _city, _state, zcode
	where not exists (select * from address where street_number = s_num and street_name = s_name and apt_number = apt_num and city = _city and state = _state and zipcode = zcode);

	INSERT INTO Lives(email_id, street_number, street_name, apt_number, city, state, zipcode)
	select eid, s_num, s_name, apt_num, _city, _state, zcode
	where not exists (select * from lives where email_id = eid and street_number = s_num and street_name = s_name and apt_number = apt_num and city = _city and state = _state and zipcode = zcode);

	INSERT INTO Billing(cc_number, street_number, street_name, apt_number, city, state, zipcode)
	values (cc_num, s_num, s_name, apt_num, _city, _state, zcode);
END;
$BODY$;

CREATE OR REPLACE PROCEDURE public.changeaddr(
	eid character varying,
	old_snum character varying,
	old_sname character varying,
	old_apt_num character varying,
	old_city character varying,
	old_state character varying,
	old_zcode character,
	new_snum character varying,
	new_sname character varying,
	new_apt_num character varying,
	new_city character varying,
	new_state character varying,
	new_zcode character)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
	delete from lives
	where email_id = eid and street_number = old_snum and street_name = old_sname and apt_number = old_apt_num and city = old_city and state = old_state and zipcode = old_zcode;

	delete from Address
	where street_number = old_snum and street_name = old_sname and apt_number = old_apt_num and city = old_city and state = old_state and zipcode = old_zcode;

	INSERT INTO Address(street_number, street_name, apt_number, city, state, zipcode)
	values (new_snum, new_sname, new_apt_num, new_city, new_state, new_zcode);

	INSERT INTO Lives(email_id, street_number, street_name, apt_number, city, state, zipcode)
	values (eid, new_snum, new_sname, new_apt_num, new_city, new_state, new_zcode);
END;
$BODY$;

CREATE OR REPLACE PROCEDURE public.changecc(
	eid character varying,
	old_cc_num bigint,
	old_cvv integer,
	old_exp_m integer,
	old_exp_y integer,
	old_snum character varying,
	old_sname character varying,
	old_apt_num character varying,
	old_city character varying,
	old_state character varying,
	old_zcode character,
	new_cc_num bigint,
	new_cvv integer,
	new_exp_m integer,
	new_exp_y integer,
	new_snum character varying,
	new_sname character varying,
	new_apt_num character varying,
	new_city character varying,
	new_state character varying,
	new_zcode character)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
	delete from hasCC
	where cc_number = old_cc_num and email_id = eid;

	delete from billing
	where cc_number = old_cc_num and street_number = old_snum and street_name = old_sname and apt_number = old_apt_num and city = old_city and state = old_state and zipcode = old_zcode;

	delete from CreditCard
	where cc_number = old_cc_num and cvv=old_cvv and exp_month = old_exp_m and exp_year = old_exp_y;

	delete from lives
	where email_id = eid and street_number = old_snum and street_name = old_sname and apt_number = old_apt_num and city = old_city and state = old_state and zipcode = old_zcode;

	delete from Address
	where street_number = old_snum and street_name = old_sname and apt_number = old_apt_num and city = old_city and state = old_state and zipcode = old_zcode;

	INSERT INTO CreditCard(cc_number, cvv, exp_month, exp_year)
	values (new_cc_num, new_cvv, new_exp_m, new_exp_y);

	INSERT INTO HasCC(email_id, cc_number)
	values (eid, new_cc_num);

	INSERT INTO Address(street_number, street_name, apt_number, city, state, zipcode)
	values (new_snum, new_sname, new_apt_num, new_city, new_state, new_zcode);

	INSERT INTO Lives(email_id, street_number, street_name, apt_number, city, state, zipcode)
	values (eid, new_snum, new_sname, new_apt_num, new_city, new_state, new_zcode);

	INSERT INTO Billing(cc_number, street_number, street_name, apt_number, city, state, zipcode)
	values (new_cc_num, new_snum, new_sname, new_apt_num, new_city, new_state, new_zcode);

END;
$BODY$;

CREATE OR REPLACE PROCEDURE public.removeaddr(
	eid character varying,
	snum character varying,
	sname character varying,
	apt_num character varying,
	_city character varying,
	_state character varying,
	zcode character)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN

	delete from creditcard
	where cc_number in (select cc_number from Billing where street_number = snum and street_name = sname and apt_number = apt_num and city = _city and state = _state and zipcode = zcode);

	delete from lives
	where email_id = eid and street_number = snum and street_name = sname and apt_number = apt_num and city = _city and state = _state and zipcode = zcode;

	delete from Address
	where street_number = snum and street_name = sname and apt_number = apt_num and city = _city and state = _state and zipcode = zcode;

END;
$BODY$;

CREATE OR REPLACE PROCEDURE public.deletecc(
	cc_num bigint)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
	delete from CreditCard
	where cc_number = cc_num;

END;
$BODY$;
