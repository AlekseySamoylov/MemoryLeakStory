FROM adoptopenjdk/openjdk11:jdk-11.0.10_9
COPY ./build/libs/*-all.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
