package fi.jyffe.sa.poc.chat_service.websocket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.experimental.categories.Category;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 
 * @author Jyffe
 * https://medium.com/@MelvinBlokhuijzen/spring-websocket-endpoints-integration-testing-180357b4f24c
 * http://rafaelhz.github.io/testing-websockets/
 *
 */

@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebSocketEndpointIT {

	@Value("${local.server.port}")
    private int port;
    private String URL;
    
    private static final String SEND_CHAT_ENDPOINT = "/app/chat/";
    private static final String SUBSCRIBE_MESSAGES_ENDPOINT = "/topic/messages";
    
    private CompletableFuture<OutputMessage> completableFuture;

    @Before
    public void setup() {
        completableFuture = new CompletableFuture<>();
        URL = "http://localhost:" + port+"/chat";
    }
    
	@Test
	public void test() throws URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
		String uuid = UUID.randomUUID().toString();
		
		WebSocketStompClient stompClient = new WebSocketStompClient(new SockJsClient(createTransportClient()));
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        
        StompSession stompSession = stompClient.connect(URL, new StompSessionHandlerAdapter() {}).get(1, SECONDS);
        
        Message testMessage = new Message("Sender", "Test message");

        stompSession.subscribe(SUBSCRIBE_MESSAGES_ENDPOINT, new CreateStompFrameHandler());
        stompSession.send(SEND_CHAT_ENDPOINT + uuid, testMessage);
        
        OutputMessage outputMessage = completableFuture.get(10, SECONDS);

        Assert.assertTrue(outputMessage.getMessage().equals(testMessage.getText()));
        Assert.assertTrue(outputMessage.getFrom().equals(testMessage.getFrom()));
        Assert.assertTrue(outputMessage.getTopic().equals(uuid));
    
	}
	
	private List<Transport> createTransportClient() {
        List<Transport> transports = new ArrayList<>(1);
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        return transports;
    }
	
	private class CreateStompFrameHandler implements StompFrameHandler {
        @Override
        public Type getPayloadType(StompHeaders stompHeaders) {
            return OutputMessage.class;
        }

        @Override
        public void handleFrame(StompHeaders stompHeaders, Object o) {
            completableFuture.complete((OutputMessage) o);
        }
    }
}
