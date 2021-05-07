#!/bin/bash
java "$JAVA_OPTS" -jar /app.jar >> app.log
ping localhost &
sleep infinity
