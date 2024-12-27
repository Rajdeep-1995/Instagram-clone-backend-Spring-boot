package com.example.kafka.config;

import lombok.Data;

@Data
public class SaslConfig {
    private String protocol;

    private String mechanism;

    private String jaasConfig;
}
