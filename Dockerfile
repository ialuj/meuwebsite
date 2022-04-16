FROM maven:3.8.5-jdk-8

WORKDIR /builders-clients-mng-api

COPY . .

RUN mvn clean install

CMD mvn spring-boot:run