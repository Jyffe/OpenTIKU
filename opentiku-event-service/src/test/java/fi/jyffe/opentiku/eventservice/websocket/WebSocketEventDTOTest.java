package fi.jyffe.opentiku.eventservice.websocket;

import static org.junit.Assert.*;

import org.junit.Test;

import fi.jyffe.opentiku.eventservice.websocket.WebSocketEventDTO;

public class WebSocketEventDTOTest {

	/*
	 * I know, I know... this is NOT a unit test but just something to check out that the separation in between of Unit Tests
	 * and Integration Tests works right... 
	 */
	@Test
	public void test() {
		
		WebSocketEventDTO sut = new WebSocketEventDTO();
		
		sut.setType("test");
		
		assertEquals("test", sut.getType());
		
	}
}
