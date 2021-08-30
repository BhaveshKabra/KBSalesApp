FROM openjdk:11.0.10-jdk-buster
COPY target/KBSalesApp-0.0.1-SNAPSHOT.jar /KBSales.jar
CMD ["java", "-jar", "/KBSales.jar"]
EXPOSE 8080