FROM maven:3.9.9-eclipse-temurin-21-noble

WORKDIR /starter-project
COPY . .

RUN mvn clean install

CMD mvn spring-boot:run