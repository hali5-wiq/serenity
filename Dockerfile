FROM maven:latest

LABEL maintainer="Hussein Ali"

ENV APP_HOME /app

#Create working Directory if it doesn't exist
#Copy just the pom file over and resolve dependencies
#Package and confirm
RUN useradd 1000100000 && usermod -a -G root 1000100000
RUN mkdir -m 0775 $APP_HOME && \
    mkdir -m 0775 $APP_HOME/target

USER 1000100000

WORKDIR $APP_HOME
COPY pom.xml pom.xml
RUN ["mvn", "dependency:resolve-plugins", "dependency:resolve", "clean", "package", "verify"]

#Adding source, compile and package
#Docker ignore file forgets target folder
COPY . .
RUN ["mvn", "clean", "package"]

#Execute the tests
CMD ["mvn", "clean", "verify"]