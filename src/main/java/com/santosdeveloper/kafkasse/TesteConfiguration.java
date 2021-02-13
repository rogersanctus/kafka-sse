package com.santosdeveloper.kafkasse;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.internals.ConsumerFactory;
import reactor.kafka.receiver.internals.DefaultKafkaReceiver;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TesteConfiguration {
    @Bean
    public KafkaReceiver receiver() {
        final String topico = "teste";
        String bootstrapAddress = "0.0.0.0:9092";

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "teste-kafka-sse");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "grupo-kafka-sse");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);

        return KafkaReceiver.create(ReceiverOptions.create(props).subscription(Collections.singleton(topico)));
    }

}
