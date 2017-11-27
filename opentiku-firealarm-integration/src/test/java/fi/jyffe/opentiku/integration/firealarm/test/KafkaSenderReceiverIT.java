package fi.jyffe.opentiku.integration.firealarm.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

import fi.jyffe.opentiku.integration.firealarm.kafka.KafkaEventMessageDTO;
import fi.jyffe.opentiku.integration.firealarm.kafka.KafkaMessageSender;

@Category(IntegrationTest.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaSenderReceiverIT {

  @Autowired
  private KafkaMessageSender producer;

  @Autowired
  private KafkaMessageReceiver consumer;

  @Autowired
  private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

  @ClassRule
  public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "event.t");

  @Before
  public void setUp() throws Exception {
    // wait until the partitions are assigned
    for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
        .getListenerContainers()) {
      ContainerTestUtils.waitForAssignment(messageListenerContainer,
          embeddedKafka.getPartitionsPerTopic());
    }
  }

  @Test
  public void testReceive() throws Exception {
    KafkaEventMessageDTO message = new KafkaEventMessageDTO("123", "test");
    producer.send(message);

    consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
    
    assertThat(consumer.getLatch().getCount()).isEqualTo(0);
    assertEquals("test", consumer.getMessage().getStatus());
    assertEquals("123", consumer.getMessage().getId());
    
  }
}
