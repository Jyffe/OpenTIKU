package fi.jyffe.sa.poc.firealarm_integration_service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App 
{	
    public static void main( String[] args ) throws InterruptedException
    {
    		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    		
    		MessageProducer producer = context.getBean(MessageProducer.class);

    		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    		executorService.scheduleAtFixedRate(new Runnable() {
    			
    			int i = 0;
    			
    			@Override
    	        public void run() {
    	            
    	            producer.sendMessage("Alarm "+i++);
    	        }
    	    }, 0, 1, TimeUnit.SECONDS);
    }
    
    @Bean
    public MessageProducer messageProducer() {
        return new MessageProducer();
    }

}

