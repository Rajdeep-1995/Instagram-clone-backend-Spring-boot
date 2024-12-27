package com.example.kafka.config.consumer;

import com.example.kafka.config.KafkaEventProperties;
import com.example.kafka.operation.IOperation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpoint;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;

@Configuration
public class KafkaConsumerRegistrarAutoConfiguration implements InitializingBean {

    private final BeanFactory beanFactory;

    private final KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    private final KafkaEventProperties kafkaEventProperties;

    private final KafkaConsumerFactoryConfig kafkaConsumerFactoryConfig;

    public KafkaConsumerRegistrarAutoConfiguration(BeanFactory beanFactory, KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry, KafkaEventProperties kafkaEventProperties, KafkaConsumerFactoryConfig kafkaConsumerFactoryConfig) {
        this.beanFactory = beanFactory;
        this.kafkaListenerEndpointRegistry = kafkaListenerEndpointRegistry;
        this.kafkaEventProperties = kafkaEventProperties;
        this.kafkaConsumerFactoryConfig = kafkaConsumerFactoryConfig;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        IOperation messageOperation = beanFactory.getBean(kafkaEventProperties.getOperation(), IOperation.class);

        if(messageOperation == null) {
            throw new RuntimeException("Message operation must not be null");
        }

        ConcurrentKafkaListenerContainerFactory<Object,Object> concurrentKafkaListenerContainerFactory = kafkaConsumerFactoryConfig.concurrentKafkaListenerContainerFactory();

        KafkaListenerEndpoint kafkaListenerEndpoint = KafkaConsumerEndpointConfig.createKafkaListenerEndPoint(kafkaEventProperties, messageOperation);

        kafkaListenerEndpointRegistry.registerListenerContainer(kafkaListenerEndpoint, concurrentKafkaListenerContainerFactory, true);
    }
}
