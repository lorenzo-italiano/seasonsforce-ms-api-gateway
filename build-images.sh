mvn clean install

mv target/seasonsforce-ms-api-gateway-1.0-SNAPSHOT.jar api-image/seasonsforce-ms-api-gateway-1.0-SNAPSHOT.jar

cd api-image

docker build -t api-gateway .