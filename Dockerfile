# Set the base image
FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy the target folder from host machine to docker
ADD ./target/restclient.jar /app/restclient.jar

# Run the spring boot jar file in docker and expose the port (9999) number of the application
ENTRYPOINT ["java", "-jar", "/app/restclient.jar"]
