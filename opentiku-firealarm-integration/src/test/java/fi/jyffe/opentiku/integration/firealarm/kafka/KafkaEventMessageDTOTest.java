package fi.jyffe.opentiku.integration.firealarm.kafka;

import static org.junit.Assert.*;

import org.junit.Test;

import fi.jyffe.opentiku.integration.firealarm.kafka.KafkaEventMessageDTO;

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
		
		assertEquals("123", sut.getId());
		assertEquals("test", sut.getStatus());
		assertEquals("EventMessage [id=123, status=test]", sut.toString());
		
	}

}
