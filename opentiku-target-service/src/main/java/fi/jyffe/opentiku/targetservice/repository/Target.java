package fi.jyffe.opentiku.targetservice.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Target {
	
	//@Id
    //@GeneratedValue
    //private Long id;
	
	@Id
	private String id;
	
	private String name;
	
	private String state;
	
	private String location;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Target() {}
	
	public Target(String id, String name, String state, String location) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.location = location;
	}

}
