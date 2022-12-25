create table if not exists cities(
  id serial not null unique primary key,
  name varchar(255) not null,
  population integer not null,
  area double precision not null
);