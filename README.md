1. Install JProfiler locally
2. Download linux archive: https://www.ej-technologies.com/download/jprofiler/version_111 and store it to "performance_tools" project folder
3. Download jamalloc archive: https://github.com/jemalloc/jemalloc/releases and store it to "performance_tools" project folder
4. Execute ./performanceImageBuild.sh to build docker image with JDK 11, JProfiler and jemalloc
5. Execute:    
   `./performanceBuildAndRun.sh` to build jar and start it inside docker container with memory leak detection tools    
   `./performanceBuildAndRun.sh skipj` ot skip build jar    
   `./performanceBuildAndRun.sh skipd` ot skip build jar and docker image    
   
6. `jeprof --show_bytes --gif $(which java) jeprof.<pid>.0.f.heap > result.gif`
   ENTRYPOINT exec java -agentpath:/jprofiler11.1.4/bin/linux-x64/libjprofilerti.so=port=8849 $JAVA_OPTS -jar /app.jar
