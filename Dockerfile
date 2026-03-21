FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY myFirstProject .

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/*.jar"]