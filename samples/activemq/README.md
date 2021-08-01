# Spring Native ActiveMQ Sample

## Design

An embedded ActiveMQ broker runs in-process.

## Attributions

Code in this project was adapted from the Spring guide, ["Messaging with
JMS"][messaging-with-jms].

## How to Build/Run/Verify This Sample

### Via `spring-native` Project's Integration Test Scripts

This will use the Maven "native" profile (defined in the parent POM) and thus
use Spring Native's `native-maven-plugin`.

```sh
./build.sh
```

### Via Maven with Local JVM

```sh
mvn spring-boot:run
```

Then check to see that "Hello, world!" is printed to `stdout`.

---

[messaging-with-jms]: https://spring.io/guides/gs/messaging-jms/
