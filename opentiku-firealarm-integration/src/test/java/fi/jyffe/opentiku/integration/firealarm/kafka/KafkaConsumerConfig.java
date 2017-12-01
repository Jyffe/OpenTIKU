package fi.jyffe.opentiku.integration.firealarm.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import fi.jyffe.opentiku.integration.firealarm.kafka.KafkaEventMessageDTO;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapServers;

	@Bean
	  public Map<String, Object> consumerConfigs() {
	    Map<String, Object> properties = new HashMap<>();
	    
	    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	    properties.put(ConsumerConfig.GROUP_ID_CONFIG, "json"); // !?!?!?

	    return properties;
	  }

	  @Bean
	  public ConsumerFactory<String, KafkaEventMessageDTO> consumerFactory() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new JsonDeserializer<>(KafkaEventMessageDTO.class));
	  }

	  @Bean
	  public ConcurrentKafkaListenerContainerFactory<String, KafkaEventMessageDTO> kafkaListenerContainerFactory() {
	    ConcurrentKafkaListenerContainerFactory<String, KafkaEventMessageDTO> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory());

	    return factory;
	  }
}
