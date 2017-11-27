package fi.jyffe.opentiku.integration.firealarm.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;


public class MessageProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);
	
	//@Value("${kafka.topic.json}")
	@Value(value = "${message.topic.name}")
	private String jsonTopic;

	@Autowired
	private KafkaTemplate<String, EventMessage> kafkaTemplate;

	public void send(EventMessage eventMessage) {
		LOGGER.info("sending car='{}'", eventMessage.toString());
		kafkaTemplate.send(jsonTopic, eventMessage);
	}
	
	/**
	 * The old String sender

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${message.topic.name}")
    private String topicName;

    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
    }
	 */
}