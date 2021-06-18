FROM ubuntu:latest

LABEL maintainer="pulkit.pushkarna@gmail.com"
LABEL version="v2"

RUN apt-get update && apt-get install -y openjdk-8-jdk

WORKDIR /usr/local/bin

COPY build/libs/kubenetes-spring-boot-0.0.1-SNAPSHOT-V3.jar .

ENTRYPOINT ["java","-jar","kubenetes-spring-boot-0.0.1-SNAPSHOT-V3.jar","--spring.config.location=/appConfigFile/application.properties"]