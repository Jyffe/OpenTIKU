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
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Target() {}
	
	public Target(String id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

}
