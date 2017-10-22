package fi.jyffe.sa.poc.chat_service.websocket;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Jyffe
 * 
 * Yeah, yeah... not a unit test. Just something to validate the Maven setup for unit tests vs. integration tests.
 *
 */
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
