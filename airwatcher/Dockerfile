FROM java:8-jre

WORKDIR usr/src

ENV MYSQL_DATABASE=citydb

ENV MYSQL_USER=manish

ENV MYSQL_PASSWORD=test123

ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/citydb

ADD ./target/airwatcher-0.0.1-SNAPSHOT.jar /usr/src/airwatcher-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "airwatcher-0.0.1-SNAPSHOT.jar"]
