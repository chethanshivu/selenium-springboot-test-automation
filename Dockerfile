FROM maven:3.5.2-jdk-8

RUN mkdir /workdir
COPY pom.xml /workdir
COPY ./src /workdir/src
WORKDIR /workdir

RUN mvn clean compile

CMD ["mvn", "clean", "test"]