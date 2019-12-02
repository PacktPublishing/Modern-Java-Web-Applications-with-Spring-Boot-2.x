FROM openjdk:12-alpine
EXPOSE 8080
RUN mkdir /app
COPY section72-auth-0.0.1-SNAPSHOT.jar /app/section72-auth.jar
ENTRYPOINT ["java","-jar","/app/section72-auth.jar"]