FROM ubuntu:latest

LABEL maintainer="pulkit.pushkarna@gmail.com"
LABEL version="v1"

RUN apt-get update && apt-get install -y openjdk-8-jdk

WORKDIR /usr/local/bin

COPY build/libs/app2.jar .

ENTRYPOINT ["java","-jar","kubenetes-spring-boot-0.0.1-SNAPSHOT.jar"]