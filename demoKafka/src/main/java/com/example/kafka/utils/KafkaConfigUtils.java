package com.example.kafka.utils;

import com.example.kafka.config.SaslConfig;
import com.example.kafka.config.SslConfig;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;

import java.util.LinkedHashMap;
import java.util.Map;

public class KafkaConfigUtils {

    public static Map<String,String> mapSaslConfigs(SaslConfig saslConfig) {
        Map<String,String> saslSecurityProperties = new LinkedHashMap<>();

        saslSecurityProperties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, saslConfig.getProtocol());
        saslSecurityProperties.put(SaslConfigs.SASL_MECHANISM, saslConfig.getMechanism());
        saslSecurityProperties.put(SaslConfigs.SASL_JAAS_CONFIG, saslConfig.getJaasConfig());

        return saslSecurityProperties;
    }

    public static Map<String, String> mapSslConfigs(SslConfig sslConfig) {
        Map<String,String> sslSecurityProperties = new LinkedHashMap<>();

        sslSecurityProperties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, sslConfig.getProtocol());
        sslSecurityProperties.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, sslConfig.getSsl().getKeyPassword());
        sslSecurityProperties.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, sslConfig.getSsl().getKeyStore());
        sslSecurityProperties.put(SslConfigs.SSL_KEYSTORE_TYPE_CONFIG, sslConfig.getSsl().getKeyStoreType());
        sslSecurityProperties.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, sslConfig.getSsl().getKeyStorePassword());
        sslSecurityProperties.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, sslConfig.getSsl().getTrustStore());
        sslSecurityProperties.put(SslConfigs.SSL_TRUSTSTORE_TYPE_CONFIG, sslConfig.getSsl().getKeyStoreType());
        sslSecurityProperties.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, sslConfig.getSsl().getTrustStorePassword());

        return sslSecurityProperties;
    }
}
