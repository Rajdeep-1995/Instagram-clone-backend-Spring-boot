package com.example.kafka.config;

import lombok.Data;

@Data
public class EncryptionConfig {

    private long cacheExpiry;

    private String url;

    private String path;

    private String token;
}
