#!/bin/bash
java -agentpath:/jprofiler11.1.4/bin/linux-x64/libjprofilerti.so=port=8849 $JAVA_OPTS -jar /app.jar >> app.log
ping localhost &
sleep infinity
