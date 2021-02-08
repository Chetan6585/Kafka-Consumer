package com.albersons.inventory.kafka.consumer;

import com.albersons.inventory.kafka.consumer.inventory.Inventory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class KafkaConfig {
    @Bean
    public DefaultKafkaConsumerFactory pf(KafkaProperties properties) {
        Map<String, Object> props = properties.buildConsumerProperties();
     return new DefaultKafkaConsumerFactory(props,
                new JsonDeserializer(String.class)
                        .forKeys()
                        .ignoreTypeHeaders(),
                new JsonDeserializer<>(Inventory.class)
                        .ignoreTypeHeaders());
    }

}
