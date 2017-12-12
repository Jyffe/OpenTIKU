package fi.jyffe.opentiku.eventservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fi.jyffe.opentiku.eventservice.websocket.WebSocketEventHandler;

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
	
	@Autowired
    WebSocketEventHandler eventHandler;
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	private KafkaEventMessageDTO eventMessage = new KafkaEventMessageDTO();
	
	public CountDownLatch getLatch() {
	    return latch;
	}
	
	public KafkaEventMessageDTO getMessage() {
		return this.eventMessage;
	}
	
	@KafkaListener(topics = "${message.topic.name}")  
	public void receive(KafkaEventMessageDTO eventMessage) throws JsonProcessingException {
	    LOGGER.info("received event message='{}'", eventMessage.toString());
	    
	    // Jackson 2 JSON mapper
	    final ObjectMapper mapper = new ObjectMapper();
	    
	    eventHandler.messageCallback(mapper.writeValueAsString(eventMessage));
	    
	    this.eventMessage = eventMessage;
		
		latch.countDown();
	  }
}