FROM java:8
EXPOSE 8080
ADD ./target/smartbanking-0.0.1-SNAPSHOT.jar smartbanking-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","smartbanking-0.0.1-SNAPSHOT.jar"]