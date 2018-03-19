CREATE DATABASE sfg_dev;
CREATE DATABASE sfg_prod;

CREATE ROLE sfg_dev_user LOGIN PASSWORD 'guru';
CREATE ROLE sfg_prod_user LOGIN PASSWORD 'guru';

GRANT usage on schema public to sfg_dev_user;
GRANT usage on schema public to sfg_prod_user;

GRANT SELECT on all tables in schema public to sfg_dev_user;
GRANT SELECT on all tables in schema public to sfg_prod_user;

GRANT INSERT on all tables in schema public to sfg_dev_user;
GRANT INSERT on all tables in schema public to sfg_prod_user;

GRANT UPDATE on all tables in schema public to sfg_dev_user;
GRANT UPDATE on all tables in schema public to sfg_prod_user;

GRANT DELETE on all tables in schema public to sfg_dev_user;
GRANT DELETE on all tables in schema public to sfg_prod_user;