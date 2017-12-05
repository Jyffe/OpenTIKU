package fi.jyffe.opentiku.targetservice;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.jyffe.opentiku.targetservice.repository.Target;
import fi.jyffe.opentiku.targetservice.repository.TargetRepository;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    		SpringApplication.run(App.class, args);
    }
    
    @Bean
	CommandLineRunner init(TargetRepository targetRepository) {
    	
    	return (evt) -> Arrays.asList(
				"Suupantori,Pirkkala,Kurikka,Haikka,Loukonlahti,Nuolialan koulu,Hannunpolku,Pakkalankulma".split(","))
				.forEach(
						a -> {
							targetRepository.save(new Target(a, "name", "location"));
						});
	}
}
