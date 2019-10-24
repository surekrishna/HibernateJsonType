# HibernateJsonType
creating new HibernateJsonType
This project helps to use hibernate json custom columns
Credit : Vladminhalcea
References
Features
JSON -> https://github.com/vladmihalcea/hibernate-types

Oracle
You should use the JsonStringType to map a VARCHAR2 column type storing JSON.
You should use the JsonBlobType to map a BLOB column type storing JSON.
For more details, https://vladmihalcea.com/oracle-json-jpa-hibernate/

SQL Server
You should use this JsonStringType to map an NVARCHAR column type storing JSON.
For more details, https://vladmihalcea.com/sql-server-json-hibernate/

PostgreSQL
You should use this JsonBinaryType to map both jsonb and json column types.
For more details, https://vladmihalcea.com/how-to-map-json-objects-using-generic-hibernate-types/

MySQL
You should use this JsonStringType to map the json column type.
For more details, https://vladmihalcea.com/how-to-map-json-objects-using-generic-hibernate-types/
