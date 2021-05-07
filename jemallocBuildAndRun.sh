#!/bin/bash
echo "Skip $1"

docker-compose -f docker-compose.jemalloc.yml down --remove-orphans
docker-compose -f docker-compose.performance.yml down --remove-orphans
docker-compose -f docker-compose.yml down --remove-orphans

if [[ $1 != "skipd" ]]
then
  if [[ $1 != "skipj" ]]
    then
      ./gradlew shadowJar
  fi
  docker build -f ./DockerfileJemallocRunner -t samoilov/memoryleak-jemalloc:latest .
fi

docker-compose -f docker-compose.jemalloc.yml up -d
