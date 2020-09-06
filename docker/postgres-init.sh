#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER "customerdb-user" WITH ENCRYPTED PASSWORD 'dummyPass!';
    CREATE DATABASE "customerdb";
    GRANT ALL PRIVILEGES ON DATABASE "customerdb" TO "customerdb-user";
    CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
EOSQL

psql -v ON_ERROR_STOP=1 --username "customerdb-user" --dbname "customerdb" <<-EOSQL
    CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
EOSQL
