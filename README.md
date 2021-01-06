# account-manager

A sample springboot project that provides restful webservices.

## How to use

Git clone or download the project to your computer

`git clone https://github.com/NosearY/account-manager.git`

Cd into the project root folder

`cd account-manager`

Start the boot (maven and jre 8 installation required)

`mvn spring-boot:run`


## Additional Info:
Login user：

1. user1@gmail.com/123456
2. user2@gmail.com/123456

H2 DB console url:

`http://localhost:8080/h2-console`, login as `root/root`

Swagger API documentation
`http://localhost:8080/swagger-ui/`

## Sample curl command

Login and get authen token (token valid for 1 weeks)

```bash
curl -X POST 'http://localhost:8080/api/v1/auth/signIn' \
  -H 'Connection: keep-alive' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -H 'Origin: http://localhost:8080' \
  -H 'Referer: http://localhost:8080/swagger-ui/index.html' \
  -H 'Accept-Language: en-US,en;q=0.9,zh-CN;q=0.8,zh-TW;q=0.7,zh;q=0.6' \
  --data-binary $'{\n  "password": "123456",\n  "username": "user1@gmail.com"\n}' \
  --compressed
```

Get all account for current logged in user

```bash
curl -X GET 'http://localhost:8080/api/v1/user-account/' \
  -H 'Connection: keep-alive' \
  -H 'accept: application/json' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMUBnbWFpbC5jb20iLCJpYXQiOjE2MDk5NDM4MjMsImV4cCI6MTYxMDU0ODYyM30.6mOChl1mGROrO6OaXX6IT9Rl1DxQ87kQN1U3-CReE8zW6ekGEkiw9diRxA8DZCIqMzncOBZNXCi70AX7Gf0UnA' \
  -H 'Referer: http://localhost:8080/swagger-ui/index.html' \
  -H 'Accept-Language: en-US,en;q=0.9,zh-CN;q=0.8,zh-TW;q=0.7,zh;q=0.6' \
  --compressed
```

Get account balance

```bash
curl -X GET 'http://localhost:8080/api/v1/user-account/12345678/balance' \
  -H 'Connection: keep-alive' \
  -H 'accept: application/json' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMUBnbWFpbC5jb20iLCJpYXQiOjE2MDk5NDM4MjMsImV4cCI6MTYxMDU0ODYyM30.6mOChl1mGROrO6OaXX6IT9Rl1DxQ87kQN1U3-CReE8zW6ekGEkiw9diRxA8DZCIqMzncOBZNXCi70AX7Gf0UnA' \
  -H 'Referer: http://localhost:8080/swagger-ui/index.html' \
  -H 'Accept-Language: en-US,en;q=0.9,zh-CN;q=0.8,zh-TW;q=0.7,zh;q=0.6' \
  --compressed
```

Transfer money


```bash
curl -X POST 'http://localhost:8080/api/v1/user-account/12345678/transactions' \
  -H 'Connection: keep-alive' \
  -H 'accept: application/json' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMUBnbWFpbC5jb20iLCJpYXQiOjE2MDk5NDcyNjMsImV4cCI6MTYxMDU1MjA2M30.3_-hincdELvvjhHEJ0_mYwq0w5zFpkL0-7-dw6H3KP_u_c4wmkaiubmQcaYN27uGl0dbR72QW0irUxS_V6NjHA' \
  -H 'Content-Type: application/json' \
  -H 'Origin: http://localhost:8080' \
  -H 'Accept-Language: en-US,en;q=0.9,zh-CN;q=0.8,zh-TW;q=0.7,zh;q=0.6' \
  --data-binary $'{\n  "amount": 100,\n  "toAccount": "88888888"\n}' \
  --compressed
```

More to be find out in swagger ui URL aforementioned...

## Libraies used:
- Jdk8
- Spring Boot + Spring MVC + Spring Security
- JUnit 5
- Mockito
- Swagger3
- Mybatis
- H2 Database
