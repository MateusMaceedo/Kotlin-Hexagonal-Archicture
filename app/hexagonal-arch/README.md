### Aplicação modelo hexagonal

> Dependencias

- Java 17
- PostgreSQL 

> Endpoints

POST -> http://localhost:8080/students-management/v1/students

Payload:
`
{"name": "value"}
`

GET -> http://localhost:8080/students-management/v1/students/{id}

- response
`
  {
  "id": "string_value",
  "name": "value"
  }
`
