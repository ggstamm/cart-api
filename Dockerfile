FROM adoptopenjdk/openjdk11:alpine
VOLUME /tmp
COPY build/libs/cart-api-0.0.1-SNAPSHOT.jar cart-api.jar
COPY /src/main/resources/products.json products.json
ENTRYPOINT ["java","-jar","/cart-api.jar"]