FROM adoptopenjdk/openjdk11:jdk-11.0.10_9
RUN mkdir /app
COPY ./build/libs/*-all.jar /app/java-application.jar
WORKDIR /app
CMD "java" "-jar" "java-application.jar"
