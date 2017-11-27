package fi.jyffe.opentiku.integration.firealarm;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import fi.jyffe.opentiku.integration.firealarm.kafka.EventMessage;
import fi.jyffe.opentiku.integration.firealarm.kafka.MessageProducer;

/**
 * 
 * @author Jyrki Rantonen
 * 
 * SA PoC Firealarm Integration Microservice
 * 
 * Proof-of-concept for a open situational awareness software - OpenTIKU
 * 
 * Demonstrates a generic service that integrates with an external subsystem (firealarm system in this case)
 * and produces incoming events (i.e. state changes) as messages over Kafka -topic.
 * 
 */
@SpringBootApplication
public class App 
{	
	/* Being lazy here for now... instead of doing a proper integration I have just 
	 * 
	 * TODO: Have a proper interface and integration instead of all this. Web Services/SOAP perhaps?
	 * 
	 */
    public static void main( String[] args ) throws InterruptedException
    {
    		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    		
    		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    		
    		MessageProducer producer = context.getBean(MessageProducer.class);
    		
    		/* Keep sending the message and increment the id once a second so that we just see something 
    		going through the system...
    		*/
    		executorService.scheduleAtFixedRate(new Runnable() {
    			
    			Integer i = 0;
    			
    			@Override
    	        public void run() {
    				
    				producer.send(new EventMessage(i.toString(), "status"));
    				
    				i++;
    	        }
    	    }, 0, 1, TimeUnit.SECONDS);
    }
    
    @Bean
    public MessageProducer messageProducer() {
        return new MessageProducer();
    }

}

