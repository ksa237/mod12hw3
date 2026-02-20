DROP TABLE IF EXISTS public.persons;

create table public.persons(
id bigserial not null,
name varchar(20) not null,
surname varchar(50) not null,
age integer not null check (age > 0),
phone_number varchar(11) not null,
city_of_living varchar(30),
CONSTRAINT pk_persons PRIMARY KEY (name, surname, age)
);


