package com.ojas.security.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;



@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer uid;
	private String name;
	private String email;
	private String pwd;
	
	@ElementCollection
	@CollectionTable(name="rolestab",//table name
					joinColumns = @JoinColumn(name="uid")//key column
			)
	private List<String> roles;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public User(Integer uid, String name, String email, String pwd, List<String> roles) {
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.roles = roles;
	}
	
	public User() {
		
	}
}
