package fi.jyffe.sa.poc.event_websocket_service;

import static org.junit.Assert.*;

import org.junit.Test;

public class OutputMessageTest {

	@Test
	public void test() {
		OutputMessage sut = new OutputMessage();
		
		sut.setFrom("John");
		sut.setMessage("Message");
		sut.setTopic("Topic");
		
		assertEquals("John", sut.getFrom());
		assertEquals("Message", sut.getMessage());
		assertEquals("Topic", sut.getTopic());
	}

}
