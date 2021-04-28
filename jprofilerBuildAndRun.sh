docker-compose -f jprofiler-docker-compose.yml down --remove-orphans
./gradlew shadowJar
docker build -f ./DockerfileJprof -t samoilov/memoryleak-jprof:latest .
docker-compose -f jprofiler-docker-compose.yml up -d
