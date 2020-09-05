#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER "customerdb-user" WITH ENCRYPTED PASSWORD 'dummyPass!';
    CREATE DATABASE "customerdb";
    GRANT ALL PRIVILEGES ON DATABASE "customerdb" TO "customerdb-user";
EOSQL