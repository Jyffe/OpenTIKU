package fi.jyffe.opentiku.eventservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Jyrki Rantonen
 * 
 * SA PoC event microservice
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
