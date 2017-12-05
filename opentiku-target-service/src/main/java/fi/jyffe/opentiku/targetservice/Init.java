package fi.jyffe.opentiku.targetservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fi.jyffe.opentiku.targetservice.repository.Target;
import fi.jyffe.opentiku.targetservice.repository.TargetRepository;


@Component
public class Init implements CommandLineRunner{

	@Autowired
	private TargetRepository targetRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		targetRepository.save(new Target("7016", "Suupantori", "empty", "61.4654625,23.6400013"));
		targetRepository.save(new Target("7014", "Pirkkala", "empty", "61.4654625,23.6400013"));
		targetRepository.save(new Target("7012", "Kurikka", "empty", "61.4660417,23.6500435"));
		targetRepository.save(new Target("7010", "Haikka", "empty", "61.4677072,23.6664586"));
		targetRepository.save(new Target("7008", "Loukonlahti", "empty", "61.4687936,23.6822193"));
		targetRepository.save(new Target("7006", "Nuolialan koulu", "empty", "61.4687936,23.6822193"));
		targetRepository.save(new Target("7004", "Hannunpolku", "empty", "61.4698903,23.6964243"));
		targetRepository.save(new Target("7002", "Pakkalankulma", "empty", "61.4693932,23.7073784"));
				
	}

}
