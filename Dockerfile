M frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/*.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]