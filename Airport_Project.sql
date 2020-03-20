CREATE SCHEMA airport AUTHORIZATION postgres;

drop table airport.airports cascade; 

CREATE TABLE airport.airports
(	airport_id 	    integer not null primary key,
	airport_name	varchar(50),
	airport_location varchar(100)
);

select * from airport.airports;



drop table airport.airways cascade;

CREATE TABLE airport.airways
(	airway_id 	    integer not null primary key,
	airway_name		varchar(50)
);

select * from airport.airways;



drop table airport.route cascade; 

CREATE TABLE airport.route
(	route_id 	    integer not null primary key,
	from_airport_id	integer,
	to_airport_id	integer
);

select * from airport.route;


drop table airport.flight_plan cascade;

CREATE TABLE airport.flight_plan
(	
	flight_plan_id	integer not null primary key,
	airway_id 	    integer,
	route_id		integer,
	flight_date		timestamp,
	plane_name		varchar(100),
	plane_capacity  integer,	
	full_seat_count integer,
	ticket_price	float
);

select * from airport.flight_plan;


drop table airport.flight_ticket cascade;

CREATE TABLE airport.flight_ticket
(	
	flight_ticket_id integer not null primary key,
	flight_plan_id 	integer,
	ticket_price    float,
	passenger_tckn  bigint,
	passenger_name	varchar(100),
	passenger_surname varchar(100)	
);

select * from airport.flight_ticket;
