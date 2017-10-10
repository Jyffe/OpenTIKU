package fi.jyffe.sa.poc.event_websocket_service;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageTest {

	@Test
	public void test() {
		Message sut = new Message("Paul", "Test");
		
		assertEquals("Paul", sut.getFrom());
		assertEquals("Test", sut.getText());
		
		Message sut2 = new Message();
		
		sut2.setFrom("Lisa");
		sut2.setText("Text");

		assertEquals("Lisa", sut2.getFrom());
		assertEquals("Text", sut2.getText());
	}

}
