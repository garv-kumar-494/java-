FROM openjdk:17-jdk-slim

WORKDIR /app

COPY myFirstProject .

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/*.jar"]