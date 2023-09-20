package fr.corell.mdmywords.m.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	// ATTRIBUTES
	private int id;
	private String name;
	private List<User> users = new ArrayList<User>();
	
	
	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	// SPECIFIC METHODS
	public void addUser(User user) {
		this.users.add(user);
	}

	
	// CONSTRUCTORS
	public Group() {}
	
	
	// TO STRING
	@Override
	public String toString() {
		return "Group [idGroup=" + id + ", groupName=" + name + "]";
	}

}
