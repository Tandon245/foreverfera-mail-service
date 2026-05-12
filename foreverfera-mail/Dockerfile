FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew build -x test

EXPOSE 8080

CMD ["sh", "-c", "java -Djava.net.preferIPv4Stack=true -jar $(ls build/libs/*.jar | grep -v plain)"]