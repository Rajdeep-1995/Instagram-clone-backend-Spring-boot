package com.example.kafka.config;

import lombok.Data;

@Data
public class Ssl {

    private String keyStore;

    private String keyPassword;

    private String keyStoreType;

    private String keyStorePassword;

    private String trustStore;

    private String trustStoreType;

    private String trustStorePassword;


}
