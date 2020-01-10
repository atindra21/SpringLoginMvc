package com.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Message")
public class Message 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="Id",unique = true, nullable = false)
	private int id;
	private String name;
	private String message;
	private String username;
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "User")
	@Column(name="Username")
	public String getUsername() {
		return username;
	}
	@Column(name="Name")
	public String getName() {
		return name;
	}
	@Column(name="Message")
	public String getMessage() {
		return message;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
