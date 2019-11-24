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
	lname character varying,
	port_id character)
LANGUAGE 'plpgsql'

AS $BODY$
BEGIN
	INSERT INTO Customer(email_id, password, age, first_name, middle_name, last_name, airport_id)
	values (eid, pwd, _age, fname, mname, lname, port_id);

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
