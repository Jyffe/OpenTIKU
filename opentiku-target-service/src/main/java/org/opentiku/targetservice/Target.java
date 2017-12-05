package org.opentiku.targetservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Target {
	
	//@Id
    //@GeneratedValue
    //private Long id;
	
	@Id
	private String uuid;
	
	private String name;
	
	private String location;
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	
	public Target(String targetId, String name, String location) {
		this.uuid = targetId;
		this.name = name;
		this.location = location;
	}

}
