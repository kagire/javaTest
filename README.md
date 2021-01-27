### About database
Column `employee_id` in my **employeedb** is a Primary Key, that is important info to understand why im inserting fields like I do.\
SQL script for fast db creation:
```sql
CREATE DATABASE employeedb;

CREATE TABLE public.employee(
    employee_id bigint,
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    department_id integer NOT NULL,
    job_title character varying NOT NULL,
    gender character varying(6) NOT NULL,
    date_of_birth date NOT NULL,
    PRIMARY KEY (employee_id)
);

insert into employee (date_of_birth, department_id, first_name, gender, job_title, last_name)
values (TO_DATE('1/1/2011', 'DD/MM/YYYY'), 80, 'Sarah', 'FEMALE', 'Security manager', 'Andersen');

insert into employee (date_of_birth, department_id, first_name, gender, job_title, last_name)
values (TO_DATE('5/10/2002', 'DD/MM/YYYY'), 2, 'Miles', 'MALE', 'Spider-man', 'Morales');
```
### About tests
Test provided to service and connection. [Fast link to tests](https://github.com/kagire/javaTest/tree/main/src/test/java/com/mastery/simplewebapp "Fast link to tests") \
Since jpa was added here is data jpa test also.
### About an actuator and logger
Used logger: **log4j** \
To change log level through actuator API you can use this request example (POST):
> http://localhost:5000/actuator/loggers/com.mastery.simplewebapp.service \
> body: `{"configuredLevel":"debug"}`


