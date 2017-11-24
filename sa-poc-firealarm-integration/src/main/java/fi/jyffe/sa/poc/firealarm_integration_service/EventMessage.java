package fi.jyffe.sa.poc.firealarm_integration_service;

import java.sql.Timestamp;

public class EventMessage {

		private String id;
		private String status;
	
		public EventMessage() {}
		
		public EventMessage(String id, String status) {
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