# Bowling Application


## Manual deployment

### Requirements

It's application requires the following:

- Java 8
- maven

### Generates jar File

It's necessary to package the code:
```
mvn install
mvn package
```

### Run application

The las command will generates a `.jar` file. You should be able to run the Application in the following way:

```
java -jar target/bowling-1.0.0-SNAPSHOT.jar "/Users/cristian/Downloads/scores .txt"
```


### Run unit test

```
mvn test
```

### Run Integration tests

```
mvn clean test-compile failsafe:integration-test
```


## Concourse deployment
