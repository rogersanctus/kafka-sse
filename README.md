Teste com Spring Webflow + Kafka + SSE
--------------------------------------

Este projeto é um teste básico das tecnologias Kafka e SSE, usando Webflow do Spring e o Reactor Kafka. Se inscrevendo em um tópico, previamente criado, do kafka, abre um stream no caminho /sse que permite a replicação das mensagens produzidas no tópico kafka direto pela stream.
Para rodar o projeto é necessário ter o kafka instalado e rodando (zookeeper, broker kafka e o kafka-console-producer). E para conectar ao stream SSE replicante use:

```
curl --location --request GET 'localhost:8080/sse' --header 'Content-Type: text/event-stream;charset=UTF-8' --header 'Accept: text/event-stream;charset=UTF-8'
``` 