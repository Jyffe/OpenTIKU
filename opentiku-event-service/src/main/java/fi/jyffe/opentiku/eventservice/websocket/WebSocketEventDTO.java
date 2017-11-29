package fi.jyffe.opentiku.eventservice.websocket;

/**
 * 
 * @author Jyrki Rantonen
 *
 * DTO for carrying Event over WebSocket.
 * 
 * TODO: Other mandatory fields than type, e.g. location, relations to other issues, state, ...
 * 
 */

public class WebSocketEventDTO {
	
    private String type;

    public WebSocketEventDTO() {}
    
    public WebSocketEventDTO(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    public void setType(String type) {
    		this.type = type;
    }
}
