# Anuj_BED_LabRestAPI6  -- Documentation


Swagger and h2-console antMatchers are permitted for all

# Follwowing are the APIs:

- GET http://localhost:8222/student/all
- POST http://localhost:8222/student
- PUT http://localhost:8222/student/{std_id}
- DELETE http://localhost:8222/student/{std_id}


# Security Layer:
## There are two roles-
- ADMIN - Can UPDATE and DELETE the student, in addition to createNew and Read
- USER - Can only Read and Create a student

## Theer are two users added by default
### user_name/password ----
- user/user
- admin/admin
