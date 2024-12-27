package com.example.kafka.config.consumer;

import com.example.kafka.config.KafkaEventProperties;
import com.example.kafka.operation.IOperation;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.config.KafkaListenerEndpoint;
import org.springframework.kafka.config.MethodKafkaListenerEndpoint;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

public class KafkaConsumerEndpointConfig {

    public static KafkaListenerEndpoint createKafkaListenerEndPoint(KafkaEventProperties kafkaEventProperties, IOperation<Object> operation) throws NoSuchMethodException {
        MethodKafkaListenerEndpoint<String, Object> kafkaListenerEndpoint = creatDefaultEndpoint(kafkaEventProperties);
        kafkaListenerEndpoint.setBean(new KafkaMessageListener(operation));
        kafkaListenerEndpoint.setMethod(KafkaMessageListener.class.getMethod("onMessage", ConsumerRecord.class));

        return kafkaListenerEndpoint;
    }

    private static MethodKafkaListenerEndpoint<String,Object> creatDefaultEndpoint(KafkaEventProperties kafkaEventProperties) {
        MethodKafkaListenerEndpoint<String,Object> kafkaListenerEndpoint = new MethodKafkaListenerEndpoint<>();
        kafkaListenerEndpoint.setId(kafkaEventProperties.getConsumerId());
        kafkaListenerEndpoint.setGroupId(kafkaEventProperties.getGroupId());
        kafkaListenerEndpoint.setAutoStartup(Boolean.TRUE);
        kafkaListenerEndpoint.setConcurrency(kafkaEventProperties.getConcurrency());
        kafkaListenerEndpoint.setMessageHandlerMethodFactory(new DefaultMessageHandlerMethodFactory());

        return kafkaListenerEndpoint;
    }


    static class KafkaMessageListener implements MessageListener<String,Object> {

        private final IOperation<Object> operation;

        public KafkaMessageListener(IOperation<Object> operation) {
            this.operation = operation;
        }

        @Override
        public void onMessage(ConsumerRecord<String, Object> consumerRecord) {
            operation.handle(consumerRecord.value());
        }
    }

}
