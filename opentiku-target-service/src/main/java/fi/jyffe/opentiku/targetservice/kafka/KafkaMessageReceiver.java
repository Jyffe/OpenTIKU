package fi.jyffe.opentiku.targetservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 
* @author Jyrki Rantonen
* 
* Kafka message consumer
* 
* TODO: Separate this into a client library?
* 
*/
@Component
public class KafkaMessageReceiver {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageReceiver.class);
	
	//@Autowired
    //WebSocketEventHandler eventHandler;
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	private KafkaEventMessageDTO eventMessage = new KafkaEventMessageDTO();
	
	public CountDownLatch getLatch() {
	    return latch;
	}
	
	public KafkaEventMessageDTO getMessage() {
		return this.eventMessage;
	}
	
	// TODO: Just little something to send over atm... needs to be changed to something meaningful later on.
	@KafkaListener(topics = "${message.topic.name}")  
	public void receive(KafkaEventMessageDTO eventMessage) {
	    LOGGER.info("received event message='{}'", eventMessage.toString());
	    
	    //eventHandler.messageCallback(eventMessage.getId());
	    
	    this.eventMessage = eventMessage;
		
		latch.countDown();
	  }
}