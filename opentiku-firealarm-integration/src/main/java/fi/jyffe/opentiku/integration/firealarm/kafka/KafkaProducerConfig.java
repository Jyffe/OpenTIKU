package fi.jyffe.opentiku.integration.firealarm.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
* 
* @author Jyrki Rantonen
* 
* Kafka producer configuration
* 
* Uses Spring Kafka JsonSerializer (and underlying Jackson ObjectMapper) for converting the EventMessageDTO
* object to JSON byte[] message over a Kafka topic.
* 
*/
@Configuration
public class KafkaProducerConfig {

	// TODO: Needs to support multiple addresses... bootrstrapAddress -> list of bootstrapServers
	@Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;
	
	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> properties = new HashMap<>();
		
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
	    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

	    return properties;
	}
	
	@Bean
	public ProducerFactory<String, KafkaEventMessageDTO> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean
	public KafkaTemplate<String, KafkaEventMessageDTO> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
}
