package org.opentiku.targetservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//http://websystique.com/spring-boot/spring-boot-rest-api-example/
//https://spring.io/guides/tutorials/bookmarks/

@RestController
@RequestMapping(value={"/targets", "/v1/targets", "/v1.0/targets"})
public class TargetRestController {

	private final TargetRepository targetRepository;
	
	@Autowired
	TargetRestController(TargetRepository targetRepository) {
		this.targetRepository = targetRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	Collection<Target> readTargets() {
		
		return this.targetRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{uuid}") 
	Collection<Target> readTarget(@PathVariable String uuid) {
	
		return this.targetRepository.findByUuid(uuid);
		
	}
}
