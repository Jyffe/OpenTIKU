package fi.jyffe.opentiku.eventservice.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import fi.jyffe.opentiku.eventservice.kafka.KafkaMessageListener;

/**
* 
* @author Jyrki Rantonen
* 
* WebSocket Event Handler
* 
*/
@Component
public class WebSocketEventHandler extends TextWebSocketHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageListener.class);
	
    WebSocketSession session;
     
    /*
     * TODO: This will send only to one client(most recently connected), got to fix that 
     */
    public void messageCallback(String msg) {
    		LOGGER.info("trying to send message='{}'", msg);

        if (session != null && session.isOpen()) {
            try {
            	LOGGER.info("sending message='{}'", msg);    
                session.sendMessage(new TextMessage("{\"value\": \"" + msg + "\"}"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        		LOGGER.info("no open session to send='{}'", msg);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
    		LOGGER.info("connection established");

        this.session = session;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        if ("CLOSE".equalsIgnoreCase(message.getPayload())) {
            session.close();
        } else {
        	LOGGER.info("received message='{}'", message.getPayload());    
        }
    }

}
