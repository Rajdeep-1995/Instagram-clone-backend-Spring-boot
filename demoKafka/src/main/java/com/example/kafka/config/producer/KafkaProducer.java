package com.example.kafka.config.producer;


import com.example.kafka.config.KafkaEventProperties;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@RestController
public class KafkaProducer {

    @Autowired
    @Qualifier("customKafkaTemplate")
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private KafkaEventProperties kafkaEventProperties;

    @GetMapping("/send")
    public void sendMessage() {
        System.out.println("sending static message...");
        Map<String,String> sampleMsg = new HashMap<>();
        sampleMsg.put("test-key1","test-value1");

        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(kafkaEventProperties.getTopic(), sampleMsg);
        CompletableFuture<SendResult<String,Object>> completableFuture = kafkaTemplate.send(producerRecord);

        completableFuture.whenComplete((result, err) -> {
            if(result != null) {
                System.out.println("Produced to offset: " + result.getRecordMetadata().offset());
            } else {
                System.out.println("err " + err);
            }
        });
    }
}

