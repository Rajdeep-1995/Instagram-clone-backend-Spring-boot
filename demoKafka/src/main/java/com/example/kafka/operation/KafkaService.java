package com.example.kafka.operation;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component("kafka-service")
public class KafkaService implements IOperation<Map<String, Object>> {


    @Override
    public void handle(Map<String, Object> consumerRequest) {
        System.out.println("Message received: ");
        System.out.println(consumerRequest);
    }
}
