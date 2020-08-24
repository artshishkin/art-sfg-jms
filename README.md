# art-sfg-jms
SFG Spring 5 Tutorial - Section 29 - JMS Messaging


####  460 Running Active MQ in Docker
-  use instructions of docker image from `vromero` to run ActiveMQ in docker container
-  `https://hub.docker.com/r/vromero/activemq-artemis`
```shell script
docker run -it --rm \
  -p 8161:8161 \
  -p 61616:61616 \
  vromero/activemq-artemis
```
-  username `artemis`
-  password `simetraehcapa`
