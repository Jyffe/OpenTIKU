package fi.jyffe.sa.poc.chat_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Jyrki Rantonen
 * 
 * SA PoC chat microservice
 * 
 * TODO Move the static Web-page stuff elsewhere
 * TODO Build proper JUnit tests
 * TODO Add persistence 
 * 
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
