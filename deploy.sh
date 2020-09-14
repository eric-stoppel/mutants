./mvnw clean package -Dmaven.test.skip=true jib:dockerBuild

docker-compose -f ops/docker-compose.yml up -d
