package fi.jyffe.opentiku.integration.firealarm;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import fi.jyffe.opentiku.integration.firealarm.kafka.KafkaEventMessageDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch; //!?!?!

@Component
public class KafkaMessageReceiver {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageReceiver.class);
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	private KafkaEventMessageDTO eventMessage = new KafkaEventMessageDTO();
	
	public CountDownLatch getLatch() {
	    return latch;
	}
	
	public KafkaEventMessageDTO getMessage() {
		return this.eventMessage;
	}
	
	@KafkaListener(topics = "${message.topic.name}")  
	//public void receive(KafkaEventMessageDTO eventMessage) {
	public void receive(KafkaEventMessageDTO eventMessage) {
	    
		LOGGER.info("received event message='{}'", eventMessage.toString());
		this.eventMessage = eventMessage;
		
		latch.countDown();

	  }
}