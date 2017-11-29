package fi.jyffe.opentiku.eventservice.kafka;

/**
* 
* @author Jyrki Rantonen
* 
* DTO for carrying EventMessage over Kafka topic
* 
* TODO: This is now just something to carry over for quick testing purposes. Actual fields necessary for a generic 
* EventMessage needs to be thought of later on.
* 
* TODO: Separate this into a client library?
* 
*/
public class KafkaEventMessageDTO {

		private String id;
		private String status;
	
		public KafkaEventMessageDTO() {}
		
		public KafkaEventMessageDTO(String id, String status) {
			this.id = id;
			this.status = status;
			
		}
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getStatus() {
			return status;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
			return "EventMessage [id=" + id +", status=" + status + "]";
		}
}