package com.example.kafka.config.producer;

import com.example.kafka.config.KafkaEventProperties;
import com.example.kafka.utils.KafkaConfigUtils;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class KafkaConfigProducer {

    @Autowired
    private KafkaEventProperties kafkaEventProperties;

    @Bean
    public ProducerFactory<String, Object> kafkaProducerFactory() {
        Map<String, Object> producerConfigs = new LinkedHashMap<>();
        producerConfigs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaEventProperties.getBootstrapServers());
        producerConfigs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerConfigs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        producerConfigs.put(ProducerConfig.PARTITIONER_ADPATIVE_PARTITIONING_ENABLE_CONFIG, true);
        producerConfigs.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, kafkaEventProperties.getCompressionType());
        producerConfigs.put(ProducerConfig.LINGER_MS_CONFIG, kafkaEventProperties.getLingerMs());
        producerConfigs.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaEventProperties.getBatchSize());
        producerConfigs.put(ProducerConfig.ACKS_CONFIG, kafkaEventProperties.getAcks());
        producerConfigs.put(ProducerConfig.RETRIES_CONFIG, kafkaEventProperties.getMaxRetryAttempts());

        if(kafkaEventProperties.getSecurity().equals("sasl") && kafkaEventProperties.getSaslConfig() != null) {
            producerConfigs.putAll(KafkaConfigUtils.mapSaslConfigs(kafkaEventProperties.getSaslConfig()));
        } else if(kafkaEventProperties.getSecurity().equals("ssl") && kafkaEventProperties.getSslConfig() != null) {
            producerConfigs.putAll(KafkaConfigUtils.mapSslConfigs(kafkaEventProperties.getSslConfig()));
        }

        producerConfigs.putAll(kafkaEventProperties.getProperties());
        return new DefaultKafkaProducerFactory<>(producerConfigs);
    }

    @Bean("customKafkaTemplate")
    public KafkaTemplate<String,Object> kafkaTemplate() {
        KafkaTemplate<String,Object> kafkaTemplate =  new KafkaTemplate<>(kafkaProducerFactory());
        kafkaTemplate.setDefaultTopic(kafkaEventProperties.getTopic());
        return kafkaTemplate;
    }


}
