#!/bin/bash
echo "Skip $1"

docker-compose -f docker-compose.performance.yml down --remove-orphans

if [[ $1 != "skipd" ]]
then
  if [[ $1 != "skipj" ]]
    then
      ./gradlew shadowJar
  fi
  docker build -f ./DockerfilePeformanceRunner -t samoilov/memoryleak-performance:latest .
fi

docker-compose -f docker-compose.performance.yml up -d
