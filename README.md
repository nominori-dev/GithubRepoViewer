# GithubRepoViewer

REST API for fetching Github User Repositories information. Project is based on 
public [Github REST API](https://docs.github.com/en/rest?apiVersion=2022-11-28).
___

# Documentation

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

By default project runs on port **8080**, to change this use -Dserver.port=XXXX
```bash
./mvnw spring-boot:run -Dserver.port=8090
```


## Authors

- [@nominori-dev](https://www.github.com/nominori-dev)