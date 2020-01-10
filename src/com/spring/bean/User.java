package com.spring.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User 
{
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private int phone;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id",unique = true, nullable = false)
	public int getId() {
		return id;
	}
	@Column(name="Username",unique = true)
	public String getUsername() {
		return username;
	}
	@Column(name="Password")
	public String getPassword() {
		return password;
	}
	@Column(name="FirstName")
	public String getFirstname() {
		return firstname;
	}
	@Column(name="Lastname")
	public String getLastname() {
		return lastname;
	}
	@Column(name="Phone")
	public int getPhone() {
		return phone;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}	
}
