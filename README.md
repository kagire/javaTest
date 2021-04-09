### Actuator
To change log level through actuator API you can use this request example (POST): \
`http://localhost:5000/actuator/loggers/com.mastery.simplewebapp.service` \
body: `{"configuredLevel":"debug"}`

### ActiveMQ
Admin panel address: `http://localhost:8161/admin/` \
Sample message request (POST): `http://localhost:8080//messages/send` \
body: `\*any string\*`

### Logger and swagger:
Swagger panel: `http://localhost:8080/swagger-ui/` \
Used logger: **log4j**



