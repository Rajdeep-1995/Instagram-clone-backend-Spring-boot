package com.example.kafka.config;

import lombok.Data;

@Data
public class SslConfig {

    private String protocol;

    private Ssl ssl;
}
