package fi.jyffe.sa.poc.issue_rest_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *  @RestController annotation marks the class as a REST controller where every method returns a domain object instead of a server
 *  side rendered view (as in case of a MVC controller)
 */
@RestController
public class IssueController {

	/*	Handles the HTTP GET request for /issue, i.e. returns HTTP 200 OK with a JSON representation of an Issue in the response body.
	 *  
	 *  TODO: Add mapping for all the HTTP operations (GET, PUT, POST, ...) and logic for handling those
	 */
    @RequestMapping("/issue")
    public Issue issue(@RequestParam(value="type", defaultValue="No type") String type) {
        return new Issue(type);
    }
}