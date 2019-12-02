FROM openjdk:12-alpine
EXPOSE 8088
RUN mkdir /app
COPY build/libs/section74-0.0.1-SNAPSHOT.jar /app/section74.jar
ENTRYPOINT ["java","-jar","/app/section74.jar"]