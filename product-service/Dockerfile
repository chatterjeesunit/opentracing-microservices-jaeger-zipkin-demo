# CREATE AN DOCKER IMAGE WITH LAYERED SPRING BOOT JAR
FROM adoptopenjdk/openjdk11:jre-11.0.8_10-alpine
LABEL maintainer="Sunit Chatterjee (developerpod.com)"
RUN adduser --no-create-home --disabled-password springuser


# Add Dockerize Support
ENV DOCKERIZE_VERSION v0.6.1
ENV DOCKERIZE_NAME dockerize-alpine-linux-amd64
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/$DOCKERIZE_NAME-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf $DOCKERIZE_NAME-$DOCKERIZE_VERSION.tar.gz \
    && rm $DOCKERIZE_NAME-$DOCKERIZE_VERSION.tar.gz

USER springuser:springuser


# If you want to use docker layers with exploded jars.
# Commented out for now
# ARG DEPENDENCY=build/dependency
# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app
# ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.spring.demo.ProductServiceApplication"]

COPY build/libs/product-service-*.jar app.jar

# Replace ENTRYPOINT with CMD
# ENTRYPOINT ["java","-jar","/app.jar"]
CMD ["java","-jar","/app.jar"]