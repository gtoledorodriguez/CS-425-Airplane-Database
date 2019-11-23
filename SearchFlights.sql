/*Only specified start and destinations airports should be shown*/
/*Connection Information:*/
/*
depart_airport
dest_airport
f_date
total Price
duration
depart_time
arrival_time
ec_price if there are open ec spots
fc_price if there are open fc spots
*/

/*Before button click shows:
 depart_airport
 dest_airport
 f_date
 */
/*Choose Flight ----Done-----*/
/*
SELECT *
FROM Flight
WHERE depart_airport = userC.depart_airport
AND dest_airport = userC.dest_airport
AND f_date = userC.f_date;

CALL tripDuration(userC.airline_id, userC.flight_num, userC.f_date)
*/
/*Customer Chooses if return, limit, max lenght, price*/
/*After choosing return flight, maybe in a column next to Flight*/
/*Choose Return Flight*/


/*limit number of connections*/
/*  Example */
/*
SELECT column_name(s)
FROM table_name
WHERE condition
LIMIT number;
*/

/*Max length of trip, or Duration ----Done-----*/
/*Tentative*/
/*
CALL tripDuration(userC.airline_id, userC.flight_num, userC.f_date)
SELECT arrival_time-depart_time
as Duration
from flight
where flight.airline_id = userC.airline_id
and flight.flight_num = userC.flight_num
and flight.f_date = userC.f_date;
*/

/*price*/


/*Ordered by flight*/

/*Ordered by price*/
