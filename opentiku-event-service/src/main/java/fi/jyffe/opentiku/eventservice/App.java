package fi.jyffe.opentiku.eventservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Jyrki Rantonen
 * 
 * Open TIKU Event Microservice
 * 
 * Proof-of-concept for a open situational awareness software - OpenTIKU
 * 
 * Demonstrates a service that receives events from various integrations as messages over Kafka -topic
 * and sends them forward to registered clients over a WebSocket. 
 * 
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    		SpringApplication.run(App.class, args);
    }
}
