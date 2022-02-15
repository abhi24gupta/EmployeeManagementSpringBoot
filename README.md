# Employee-Management-SpringBoot

- Java Version Needed: java version "1.8.0_231"
- Intellij IDEA

**Steps to begin Project**
- Open Project in IntelliJ IDEA
- Create a database named "abhinav" in mysql server
- Run File "SpringbootEmployeeManagementApplication"


## CRUD API Mapping

***Department Table***
- Insert data in Department table (Post Method) : /api/departments
- Sample Data Body JSON Format
  ```
  {  
  "dep_name":"CAG",
  "dep_desc":"Comptroller and Auditor General of India",
  "dep_location":"India"
  }
  ```
- Similarly Insert Data as per need.



***Employee Table***
- Insert data in Employee table (Post Method) : /api/employees
- Sample Data Body JSON Format
  ```
  {
    "fname": "Abhinav",
    "lname": "Gupta",
    "gender": "M",
    "age": 23,
    "address": "Jaipur",
    "emp_email": "abhi2412gupta@gmail.com",
    "designation": "Intern",
    "department":{
        "depId":"1"
    }
  }
  ```
- Similarly Insert Data as per need.


***Leave Table***
- Insert data in Leave table (Post Method) : /api/leaves
- Sample Data Body JSON Format
  ```
  {
    "date":"2022-02-14",
    "reason":"Fever",
    "employee":{
        "id":1
    }
  }
    ```
- Similarly Insert Data as per need.


***Salary Table***
- Insert data in Salary table (Post Method) : /api/salary
- Sample Data Body JSON Format
- 
  ```
  {
    "amount": 70000,
    "deduction": 1257,
    "bonus": 650,
    "employee":{
        "id":1
       }
   }
    ```
- Similarly Insert Data as per need.

### CRUD Operations Performed
- GET
- POST
- PUT
- DELETE

            