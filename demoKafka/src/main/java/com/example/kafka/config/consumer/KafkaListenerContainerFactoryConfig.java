package com.example.kafka.config.consumer;

import lombok.Data;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpoint;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

@Data
public class KafkaListenerContainerFactoryConfig<K,V> extends ConcurrentKafkaListenerContainerFactory<K,V> {

    private String topic;

    private String groupId;

    @Override
    protected ConcurrentMessageListenerContainer<K, V> createContainerInstance(KafkaListenerEndpoint endpoint) {
        ContainerProperties properties = new ContainerProperties(topic);
        properties.setGroupId(groupId);
        return new ConcurrentMessageListenerContainer<>(getConsumerFactory(), properties);
    }
}
