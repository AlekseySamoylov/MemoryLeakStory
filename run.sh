docker-compose -f docker-compose.jemalloc.yml down --remove-orphans
docker-compose -f docker-compose.performance.yml down --remove-orphans
docker-compose -f docker-compose.yml down --remove-orphans
docker-compose up -d
