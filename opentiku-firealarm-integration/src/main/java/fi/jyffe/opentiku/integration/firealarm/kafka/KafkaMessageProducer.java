package fi.jyffe.opentiku.integration.firealarm.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

/**
* 
* @author Jyrki Rantonen
* 
* Kafka message producer
* 
* TODO: Separate this into a client library?
* 
*/
public class KafkaMessageProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageProducer.class);
	
	@Value(value = "${message.topic.name}")
	private String jsonTopic;

	@Autowired
	private KafkaTemplate<String, KafkaEventMessageDTO> kafkaTemplate;

	public void send(KafkaEventMessageDTO eventMessage) {
		LOGGER.info("sending car='{}'", eventMessage.toString());
		kafkaTemplate.send(jsonTopic, eventMessage);
	}
}