# Profile activation methods in Spring

## Inside properties file
- spring.profiles.active=<profile_name>

## Using Environment Vars:
```export SPRING_PROFILES_ACTIVE=<profile_name>``` and then run the jar file ```java -jar myApp-0.0.1-SNAPSHOT.jar```

or use .env file and put the following in the .env

```SPRING_PROFILES_ACTIVE=<profile_name>``` and then do ```mvn spring-boot:run```

## Java System Property

```java "-Dspring-boot.run.profiles=prod" -jar myApp-0.0.1-SNAPSHOT.jar```

or ```mvn spring-boot:run "-Dspring-boot.run.profiles=prod"```

## Programatically inside the app
- use setAdditionalProfiles("<profile_name>")

## While doing testing
- use ```@SpringBootTest
         @ActiveProfiles({"<profile_name>"})```


## Activating multiple profiles at the same time

- use comma separated list of profile names in any of the approaches above
- eg: ```java "-Dspring-boot.run.profiles=dev,prod" -jar myApp-0.0.1-SNAPSHOT.jar```