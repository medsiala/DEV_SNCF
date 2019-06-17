package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Role implements Serializable {
	@Id
	private String role ;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
