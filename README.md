# GithubRepoViewer

REST API for fetching Github Users Repositories information. Project is based on 
public [Github REST API](https://docs.github.com/en/rest?apiVersion=2022-11-28).
___

# Documentation

Code and packages organization: 
1. `api` is the web layer implemented by Spring Web
2. `core` is the business model layer
3. `application` is the high-level services for querying the data transfer objects
4. `infrastructure`  contains all the implementation classes as the technique details
### Tech stack

- Java 17
- Spring Boot 3 (Web, Validation, Lombok, SpringDoc)
- Github REST API

## Local environment

To run this project locally you need JDK 17 installed on your PC.

1. Clone this repository
```bash
git clone https://github.com/nominori-dev/GithubRepoViewer
# change directory to local repository
cd GithubRepoViewer
```

2. Download dependencies and run project
```bash
./mvnw install 

./mvnw spring-boot:run
```
Another way to run project is to clone using Intellij IDEA.
By default project runs on port **8080**, to change this use -Dserver.port=XXXX
```bash
./mvnw spring-boot:run -Dserver.port=8090
```

## Open API

Default Open API specification - http://localhost:8080/v3/api-docs
<br/>
Default Swagger UI - http://localhost:8080/swagger-ui/index.html

## Authors

- [@nominori-dev](https://www.github.com/nominori-dev)