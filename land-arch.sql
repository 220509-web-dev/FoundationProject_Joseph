create schema landarch_app;

set search_path to landarch_app;

create table app_users (

id int generated always as identity,
firstname varchar not null,
lastname varchar not null,
username varchar unique not null check(length(username) >= 5),
password varchar not null check(length(password) >= 8),

constraint app_users_pk
primary key (id)
);
