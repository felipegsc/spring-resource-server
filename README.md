# Resource Server
This project is a demo of a Resource Server built by using Spring Boot and Spring OAuth2 capabilities.

## Usage
In order to use this project properly, it's necessary to use some Authorization Server. There's a simple one available [here](https://github.com/felipegsc/spring-authorization-server).

### Doing a test request
```
curl -i -X GET -H 'Authorization: Bearer <token>' <protocol>://<host>[:<port>]/hello
```
- The `<token>` should be obtained from the Authorization Server

There are another endpoints available for tests:
- `/hello-user`: Available only to users with the role **USER** or **ADMIN**
- `/hello-admin`: Available only to users with the role **ADMIN**
The endpoint `/hello` is available for any authenticated user
