FROM openjdk:12-alpine
EXPOSE 8088
RUN mkdir /app
COPY build/libs/section71-0.0.1-SNAPSHOT.jar /app/section71.jar
ENTRYPOINT ["java","-jar","/app/section71.jar"]