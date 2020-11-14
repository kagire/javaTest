# If you have any questions...
### About database
Column `employee_id` in my **employeedb** is a Primary Key, that is important info to understand why im inserting fields like I do.\
SQL script to insert fields if you want your db not to be empty:
```postgres-sql
insert into employee (date_of_birth, department_id, first_name, gender, job_title, last_name)
values (TO_DATE('1/1/2011', 'DD/MM/YYYY'), 80, 'Sarah', 'FEMALE', 'Security manager', 'Andersen');

insert into employee (date_of_birth, department_id, first_name, gender, job_title, last_name)
values (TO_DATE('5/10/2002', 'DD/MM/YYYY'), 2, 'Miles', 'MALE', 'Spider-man', 'Morales');
```
### About tests
Test provided to service and connection. [Fast link to tests](https://github.com/kagire/javaTest/tree/main/src/test/java/com/mastery/simplewebapp "Fast link to tests")

### About UI
It's not fully-functional, but still can show ajax-requests are working, showing POST and GET methods.  [Fast link to UI](https://github.com/kagire/javaTest/tree/main/src/main/resources/static "Fast link to UI")

> You need to delete `@RequestBody` annotation from EmployeeController->newEmployee method to accept ajax JSON from html form
