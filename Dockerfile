FROM selenium/standalone-chrome

RUN mkdir /workdir
COPY pom.xml /workdir
COPY ./src /workdir/src
WORKDIR /workdir

RUN mvn clean compile

CMD ["mvn", "clean", "test"]