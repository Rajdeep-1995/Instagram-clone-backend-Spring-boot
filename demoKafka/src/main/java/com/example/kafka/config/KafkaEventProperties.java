package com.example.kafka.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "kafka-event")
@Component
public class KafkaEventProperties {

    private String name;

    private String topic;

    private List<String> bootstrapServers;

    private String eventId;

    private String operation;

    private String consumerId;

    private  String containerFactory;

    private String groupId;

    private int concurrency;

    private String compressionType;

    private int batchSize;

    private int lingerMs;

    private String acks;

    private int maxRetryAttempts;

    private SaslConfig saslConfig;

    private SslConfig sslConfig;

    private Map<String, EncryptionConfig> encryptionConfig = new LinkedHashMap<>();

    private String security;

    private Map<String, String> properties = new LinkedHashMap<>();


}
