FROM openjdk:15
WORKDIR /home
ADD './build/libs/java-dev-0.0.1-SNAPSHOT.jar' MyDev.jar
RUN ls
CMD ["java","-XX:ParallelGCThreads=2", "-jar", "MyDev.jar"]
