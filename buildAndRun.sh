docker-compose down --remove-orphans
./gradlew shadowJar
docker build -t samoilov/memoryleak:latest .
docker-compose up -d
