package org.mitre.openid.connect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	private String username;
	private String password;
	private boolean enabled;
	
	public User(String username,String password,boolean enabled)
	{
		if (((username == null) || "".equals(username)) || (password == null)) {
			throw new IllegalArgumentException(
					"Cannot pass null or empty values to constructor");
		}
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public User()
	{
		
	}
	
	@Id 
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "enabled")
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
