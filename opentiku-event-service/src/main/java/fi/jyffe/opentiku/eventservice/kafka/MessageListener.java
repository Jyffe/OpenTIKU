package fi.jyffe.opentiku.eventservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import fi.jyffe.opentiku.eventservice.websocket.EventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MessageListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageListener.class);
	
	@Autowired
    EventHandler eventHandler;
	
	//@KafkaListener(topics = "${kakfa.topic.json}")
	//@KafkaListener(topics = "${message.topic.name}", group = "foo", containerFactory = "fooKafkaListenerContainerFactory")
	@KafkaListener(topics = "${message.topic.name}")  
	public void receive(EventMessage eventMessage) {
	    LOGGER.info("received event message='{}'", eventMessage.toString());
	    eventHandler.messageCallback(eventMessage.getId());
	  }
	
	/*
	@KafkaListener(topics = "${message.topic.name}", group = "foo", containerFactory = "fooKafkaListenerContainerFactory")
    public void listenGroupFoo(String message) {
        System.out.println("Received Messasge in group 'foo': " + message);
        eventHandler.messageCallback(message);
        //eventHandler.counterIncrementedCallback(1);
    }
    */
}




/*
@Component
public class MessageListener {

    private CountDownLatch latch = new CountDownLatch(3);

    @KafkaListener(topics = "${message.topic.name}", group = "foo", containerFactory = "fooKafkaListenerContainerFactory")
    public void listenGroupFoo(String message) {
        System.out.println("Received Messasge in group 'foo': " + message);
        latch.countDown();
    }
}*/