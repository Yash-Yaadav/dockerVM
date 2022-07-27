FROM openjdk:11
MAINTAINER Yash Yadav<yash.mlvt@gmail.com>
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/springCRUD-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} springCRUD-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/springCRUD-0.0.1-SNAPSHOT.jar"]
