package fi.jyffe.opentiku.eventservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import fi.jyffe.opentiku.eventservice.websocket.EventHandler;

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
public class KafkaMessageListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageListener.class);
	
	@Autowired
    EventHandler eventHandler;
	
	// TODO: Just little something to send over atm... needs to be changed to something meaningful later on.
	@KafkaListener(topics = "${message.topic.name}")  
	public void receive(KafkaEventMessageDTO eventMessage) {
	    LOGGER.info("received event message='{}'", eventMessage.toString());
	    eventHandler.messageCallback(eventMessage.getId());
	  }
}