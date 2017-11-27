package fi.jyffe.sa.poc.event_service.websocket;

/**
 * 
 * @author Jyrki RAntonen
 *
 * Resource representation class for an Issue
 * 
 * TODO: Other mandatory fields than type, e.g. location, relations to other issues, state, ...
 * 
 */

public class Event {
	
    private String type;

    public Event(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    public void setType(String type) {
    		this.type = type;
    }
}
