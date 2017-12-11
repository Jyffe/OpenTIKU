package fi.jyffe.opentiku.targetservice.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.jyffe.opentiku.targetservice.repository.Target;
import fi.jyffe.opentiku.targetservice.repository.TargetRepository;

@RestController
@RequestMapping(value={"/targets", "/v1/targets", "/v1.0/targets"})
public class TargetRestController {

	private final TargetRepository targetRepository;
	
	@Autowired
	TargetRestController(TargetRepository targetRepository) {
		this.targetRepository = targetRepository;
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET)
	Collection<Target> readTargets() {
		
		return this.targetRepository.findAll();
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, value = "/{uuid}") 
	Collection<Target> readTarget(@PathVariable String uuid) {
	
		return this.targetRepository.findById(uuid);
		
	}
}
