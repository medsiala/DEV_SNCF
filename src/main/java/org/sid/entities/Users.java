package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Users implements Serializable {
	@Id
	
	private String cp ;
	private String password ;
	private boolean actived ;
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Users(String cp, String password, boolean actived) {
		super();
		this.cp = cp;
		this.password = password;
		this.actived = actived;
	}
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Role> roles ;
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public Users(String cp, String password, Collection<Role> roles) {
		super();
		this.cp = cp;
		this.password = password;
		this.roles = roles;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
