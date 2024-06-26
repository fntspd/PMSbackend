FROM eclipse-temurin:20-jdk-jammy

WORKDIR /app
#Workingdirectory

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src
CMD ["./mvnw","spring-boot:run"]