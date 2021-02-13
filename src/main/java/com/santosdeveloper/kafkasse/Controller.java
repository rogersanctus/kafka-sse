package com.santosdeveloper.kafkasse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverRecord;

@RequestMapping(path = "/sse")
@RestController
public class Controller {
    KafkaReceiver receiver;

    public Controller(KafkaReceiver receiver) {
        this.receiver = receiver;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux testeFlux() {
        Flux<ReceiverRecord<String, String>> flux = this.receiver.receive();

        return flux.log().doOnNext( record -> record.receiverOffset().acknowledge())
                .map(ReceiverRecord::value);
    }
}
