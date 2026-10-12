from  eclipse-temurin:21-jdk 
expose 8181
workdir /app
copy target/*.jar spring-new-basic.jar
entrypoint ["java","-jar","spring-new-basic.jar"]