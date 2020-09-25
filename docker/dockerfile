FROM openjdk

ENV dburl 127.0.0.1:5432/tp_devops
ENV dbname tp_devops
ENV dbpwd tp_devops

EXPOSE 8080

ARG JAR_FILE=../build/libs/tp-docker-1.0.0.jar
ADD ${JAR_FILE} tp-docker.jar

ENTRYPOINT java -Ddatabase.url=${dburl} -Ddatabase.usernamer=${dbname} -Ddatabase.password=${dbpwd} -jar tp-docker-1.0.0.jar