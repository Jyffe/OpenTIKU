package fi.jyffe.opentiku.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Jyrki Rantonen
 * 
 * Open TIKU Web App
 * 
 * Proof-of-concept for a open situational awareness software - OpenTIKU
 * 
 * Front-end for Angular Web App - using Spring Boot and Tomcat for now, need to look into this later on... 
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
