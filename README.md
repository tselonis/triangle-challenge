# triangle-challenge
A web application that determines the type of a triangle

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

* RUN ON THE COMMAND LINE

```
1) Download the project
```

```
2) Extract it in a folder
```

```
3) Navigate to the project folder (the one that contains the pom.xml)
```

```
4) Execute mvn spring-boot:run
```



* RUN FROM EXECUTABLE JAR

```
1) Repeat steps 1 to 3 from above
```

```
2) Execute mvn clean install
```

```
3) Navigate to local maven repository ( defaults to $HOME/.m2/repository folder)
```

```
4) Locate executable jar ( $HOME/.m2/repository/com/example/triangle/0.0.1-SNAPSHOT/triangle-0.0.1-SNAPSHOT.jar)
```

```
5) Execute java -jar triangle-0.0.1-SNAPSHOT.jar
```

**NOTE**: Using either the first or the second way the application could be reached at **http://localhost:8080/**

### Prerequisites

Java 8 (Developed with Java 1.8.0_152)

Maven 3.5.0 or above

## Running the tests

Navigate to the project folder and execute the following command

```
mvn clean test
```

## Authors

* **Alexandros Tselonis**
