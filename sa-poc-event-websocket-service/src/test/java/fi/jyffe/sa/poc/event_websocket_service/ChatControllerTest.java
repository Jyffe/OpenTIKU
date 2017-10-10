package fi.jyffe.sa.poc.event_websocket_service;

import static org.junit.Assert.*;
import org.junit.Test;

public class ChatControllerTest {

	@Test
	public void test() {
		ChatController sut = new ChatController();
		
		Message msg = new Message("Mr. Bean", "Test message");
		
		try {
			assertEquals("Mr. Bean", sut.send("Test topic", msg).getFrom());
			assertEquals("Test message", sut.send("Test topic", msg).getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
