package fi.jyffe.sa.poc.event_service.websocket;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventService {

    private AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    EventHandler eventHandler;
    
    @Scheduled(fixedDelay = 1000)
    public void sendCounterUpdate() {
        eventHandler.counterIncrementedCallback(counter.incrementAndGet());
    }

    Integer getValue() {
        return counter.get();
    }
}
