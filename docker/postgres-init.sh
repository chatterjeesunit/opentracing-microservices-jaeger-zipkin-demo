#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER "customerdb-user" WITH ENCRYPTED PASSWORD 'dummyPass!';
    CREATE DATABASE "customerdb";
    GRANT ALL PRIVILEGES ON DATABASE "customerdb" TO "customerdb-user";

    CREATE USER "productdb-user" WITH ENCRYPTED PASSWORD 'dummyPass!';
    CREATE DATABASE "productdb";
    GRANT ALL PRIVILEGES ON DATABASE "productdb" TO "productdb-user";

    CREATE USER "orderdb-user" WITH ENCRYPTED PASSWORD 'dummyPass!';
    CREATE DATABASE "orderdb";
    GRANT ALL PRIVILEGES ON DATABASE "orderdb" TO "orderdb-user";

    CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
EOSQL

psql -v ON_ERROR_STOP=1 --username "customerdb-user" --dbname "customerdb" <<-EOSQL
    CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
EOSQL

psql -v ON_ERROR_STOP=1 --username "productdb-user" --dbname "productdb" <<-EOSQL
    CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
EOSQL

psql -v ON_ERROR_STOP=1 --username "orderdb-user" --dbname "orderdb" <<-EOSQL
    CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
EOSQL
