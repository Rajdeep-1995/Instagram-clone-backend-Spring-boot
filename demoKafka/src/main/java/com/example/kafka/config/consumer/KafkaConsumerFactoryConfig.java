package com.example.kafka.config.consumer;

import com.example.kafka.config.KafkaEventProperties;
import com.example.kafka.utils.KafkaConfigUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerFactoryConfig {

    @Autowired
    private KafkaEventProperties kafkaEventProperties;

    private final int DEFAULT_PARTITION_COUNT = 1;

    public ConsumerFactory<Object, Object> kafkaConsumerFactory() {
        Map<String, Object> consumerConfigs = new LinkedHashMap<>();

        consumerConfigs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaEventProperties.getBootstrapServers());
        consumerConfigs.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaEventProperties.getGroupId());
        consumerConfigs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerConfigs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        consumerConfigs.put(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, Boolean.FALSE);
       // consumerConfigs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.TRUE);
        consumerConfigs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        if(kafkaEventProperties.getSecurity().equals("sasl") && kafkaEventProperties.getSaslConfig() != null) {
            consumerConfigs.putAll(KafkaConfigUtils.mapSaslConfigs(kafkaEventProperties.getSaslConfig()));
        } else if(kafkaEventProperties.getSecurity().equals("ssl") && kafkaEventProperties.getSslConfig() != null) {
            consumerConfigs.putAll(KafkaConfigUtils.mapSslConfigs(kafkaEventProperties.getSslConfig()));
        }

        consumerConfigs.putAll(kafkaEventProperties.getProperties());

        return new DefaultKafkaConsumerFactory<>(consumerConfigs);
    }

    public ConcurrentKafkaListenerContainerFactory<Object,Object> concurrentKafkaListenerContainerFactory() {
        KafkaListenerContainerFactoryConfig<Object, Object> factory = new KafkaListenerContainerFactoryConfig<>();
        factory.setConsumerFactory(kafkaConsumerFactory());
        factory.setConcurrency(DEFAULT_PARTITION_COUNT);
        factory.setTopic(kafkaEventProperties.getTopic());
        factory.setGroupId(kafkaEventProperties.getGroupId());
        return factory;
    }

}
