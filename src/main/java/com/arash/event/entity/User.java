package com.arash.event.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * JPA managed Entity Bean for User
 * 
 * @author Arash Rajaeeyan
 *
 */
@Entity
@Table(name="USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long id;
	
	@Column(name="user_name")
	private String name;

	@JsonIgnore
	@ManyToMany(mappedBy = "registeredUsers")
	private List<Event> registeredEvents;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getRegisteredEvents() {
		return registeredEvents;
	}

	public void setRegisteredEvents(List<Event> registeredEvents) {
		this.registeredEvents = registeredEvents;
	}

}
