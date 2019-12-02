FROM openjdk:12-alpine
EXPOSE 8088
RUN mkdir /app
COPY build/libs/section75-0.0.1-SNAPSHOT.jar /app/section75.jar
ENTRYPOINT ["java","-jar","/app/section75.jar"]