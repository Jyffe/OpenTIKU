package fi.jyffe.opentiku.eventservice.kafka;

/**
* 
* @author Jyrki Rantonen
* 
* DTO for carrying EventMessage over Kafka topic
* 
* TODO: Separate this into a client library?
* 
*/
public class KafkaEventMessageDTO {

		// Unique identifer of target target (device, sensor, machine, vehicle, ...) that the received event is about
		private String id;
		
		// Status of the target (on, off, running, stopping, stopped, starting, alarming, ...)
		private String state;
		
		// Location of the target in case it does not have a fixed location (e.g. moving vehicle) or it is otherwise known
		// by the sender
		private String location;
		
		// Measurement (voltage, degree, milliamper, ...)
		private String measurement;
			
		public KafkaEventMessageDTO() {}
		
		public KafkaEventMessageDTO(String id, String state, String location, String measurement) {
			this.id = id;
			this.state = state;
			this.location = location;
			this.measurement = measurement;
			
		}
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getStatus() {
			return state;
		}
		
		public void setStatus(String status) {
			this.state = status;
		}
		
		public String getLocation() {
			return location;
		}
		
		public void setLocation(String location) {
			this.location = location;
		}
		
		public String getMeasurement() {
			return measurement;
		}
		
		public void setMeasurement(String measurement) {
			this.measurement = measurement;
		}
		
		@Override
		public String toString() {
			return "EventMessage [id=" + id + ", status=" + state + ", location=" + location + ", measurement=" + measurement + "]";
		}
}