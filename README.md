# user-ms2
  This ms is to store User in a virtual DB and also makes in internal call to [address-ms2](https://github.com/tsmahur/address-ms1). This is a part of [ms-eureka-gateway-hysrtix-cloud-config](https://github.com/tsmahur/ms-eureka-gateway-hysrtix-cloud-config) Project.
  It will load yml properties from [configurations-server](https://github.com/tsmahur/configurations-server)
##
### Dependency
    h2,jpa,web,lombok,eureka discover client, spring-cloud-starter-config
	zipkin , sleuth

### application.yml
    port ,app name,eureka client(same in all MS)
    config:import: optional:configserver:http://localhost:8094
	zipkin:base-url: http://localhost:9411/

### main application class
    @EnableEurekaClient @LoadBalanced(added over the RestTemplate Bean-> to http://ADDRESS-SERVICE/address/ instead of http://localhost:8091/address/)

### EndPoints
    GATEWAY PORT : 8092

    POST http://localhost:8090/users
    {
        "firstName":"Ravi",
        "lastName": "Verma",
        "email": "ac@abc.com",
        "addressId": 1
    }

    GET http://localhost:8090/users/1

    POST http://localhost:8090/users/saveUserAndAddress
    {
    "user": {
        "firstName": "Ravi",
        "lastName": "Verma",
        "email": "ac@abc.com"
    },
    "address": {
        "city": "Noida2",
        "state": "Up",
        "pinCode": 1233456
    }
}
}
