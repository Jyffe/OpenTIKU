package fi.jyffe.opentiku.eventservice.websocket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *  @RestController annotation marks the class as a REST controller where every method returns a domain object instead of a server
 *  side rendered view (as in case of a MVC controller)
 */
@RestController
public class EventController {

	// To-be REST API part of the service...
    @RequestMapping("/subscribe")
    public Event event(@RequestParam(value="type", defaultValue="No type") String type) {
        return new Event(type);
    }
}