FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY myFirstProject .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/myFirstProject-0.0.1-SNAPSHOT.jar"]