package fi.jyffe.sa.poc.event_service.websocket;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
	
	@Autowired
    EventHandler eventHandler;
	
	@KafkaListener(topics = "${message.topic.name}", group = "foo", containerFactory = "fooKafkaListenerContainerFactory")
    public void listenGroupFoo(String message) {
        System.out.println("Received Messasge in group 'foo': " + message);
        eventHandler.messageCallback(message);
        //eventHandler.counterIncrementedCallback(1);
    }
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