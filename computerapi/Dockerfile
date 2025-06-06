FROM amazoncorretto:24.0.1-alpine3.21
LABEL authors="luisJuarez"

WORKDIR /app
COPY ./target/computerapi-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8081
CMD ["java", "-jar", "app.jar"]

