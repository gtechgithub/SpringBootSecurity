package com.javapoint;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity

@Table (name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	

	@Column(name="email")
	@Email(message="Please provide vaild email!!")
	@NotEmpty(message="please provide an email")
	private String email;
	
	@Column(name="password")
	@Length(min=5,message="your password must be atleast 5 character long")
	@NotEmpty(message="please provide your password")
	//@Transient
	private String password;
	
	@Column(name="name")
	@NotEmpty(message="please provide your name")
	private String name;
	

	@Column(name="last_name")
	@NotEmpty(message="please provide your last name")
	private String lastname;

	@Column(name="active")
	private int active;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id") , inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;

	
	//getter setter functions
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
