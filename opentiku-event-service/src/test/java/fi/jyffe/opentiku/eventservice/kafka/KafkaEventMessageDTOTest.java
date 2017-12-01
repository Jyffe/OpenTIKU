package fi.jyffe.opentiku.eventservice.kafka;

import static org.junit.Assert.*;

import org.junit.Test;

import fi.jyffe.opentiku.eventservice.kafka.KafkaEventMessageDTO;

public class KafkaEventMessageDTOTest {

	/*
	 * I know, I know... this is NOT a unit test but just something to check out that the separation in between of Unit Tests
	 * and Integration Tests works right... 
	 */
	@Test
	public void test() {
		
		KafkaEventMessageDTO sut = new KafkaEventMessageDTO();
		
		sut.setId("123");
		sut.setStatus("test");
		sut.setLocation("testlab");
		sut.setMeasurement("3,14159");
		
		assertEquals("123", sut.getId());
		assertEquals("test", sut.getStatus());
		assertEquals("testlab", sut.getLocation());
		assertEquals("3,14159", sut.getMeasurement());
		assertEquals("EventMessage [id=123, status=test, location=testlab, measurement=3,14159]", sut.toString());
		
	}

}
