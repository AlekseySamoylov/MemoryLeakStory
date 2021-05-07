#!/bin/bash
docker-compose down --remove-orphans
docker-compose -f docker-compose.performance.yml down --remove-orphans
