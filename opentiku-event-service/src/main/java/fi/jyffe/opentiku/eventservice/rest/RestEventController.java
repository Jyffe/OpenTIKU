package fi.jyffe.opentiku.eventservice.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.jyffe.opentiku.eventservice.websocket.WebSocketEventDTO;

/**
 * 
 * @author Jyrki Rantonen
 * 
 * TOBE REST Controller
 *
 */
@RestController
public class RestEventController {

	// To-be REST API part of the service...
    @RequestMapping("/subscribe")
    public WebSocketEventDTO event(@RequestParam(value="type", defaultValue="No type") String type) {
        return new WebSocketEventDTO(type);
    }
}