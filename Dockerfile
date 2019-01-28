FROM openjdk:11.0-jdk
ADD ./target/MuzixApplication-0.0.1-SNAPSHOT.jar /muzix/add/MuzixApplication-0.0.1-SNAPSHOT.jar
WORKDIR muzix/add
ENTRYPOINT ["java", "-jar", "MuzixApplication-0.0.1-SNAPSHOT.jar"]