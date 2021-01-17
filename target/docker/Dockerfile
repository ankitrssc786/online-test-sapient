FROM dockerfile/java:oracle-java8

VOLUME /tmp
ADD football-game-league.jar /opt/football-game-league/
EXPOSE 8080
WORKDIR /opt/football-game-league/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "football-game-league.jar"]
