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
public class KafkaMessageSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageSender.class);
	
	@Value(value = "${message.topic.name}")
	private String messageTopic;

	@Autowired
	private KafkaTemplate<String, KafkaEventMessageDTO> kafkaTemplate;

	public void send(KafkaEventMessageDTO eventMessage) {
		
		LOGGER.info("sending event='{}'", eventMessage.toString());
		
		kafkaTemplate.send(messageTopic, eventMessage);
	}
}