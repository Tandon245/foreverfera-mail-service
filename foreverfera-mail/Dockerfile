FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew clean build -x test

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -Djava.net.preferIPv4Stack=true -jar $(ls build/libs/*.jar | grep -v plain)"]