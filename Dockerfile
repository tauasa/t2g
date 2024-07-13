
FROM openjdk:17
LABEL maintainer="tauasa.org"
ADD target/t2g-0.0.3-SNAPSHOT.jar t2g.jar
ENTRYPOINT [ "java", "-jar", "t2g.jar" ]