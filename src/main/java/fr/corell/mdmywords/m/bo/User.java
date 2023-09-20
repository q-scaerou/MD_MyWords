package fr.corell.mdmywords.m.bo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// ATTRIBUTES
	private int idUser;
	private String userName;
	private String mail;
	private String password;
	private String[] role;
	private List<Group> groups;
	
	
	// GETTERS AND SETTERS
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getRole() {
		return role;
	}

	public void setRole(String[] role) {
		this.role = role;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	
	// SPECIFIC METHODS
	public void addGroup(Group group) {
		this.groups.add(group);
	}

	
	// CONSTRUCTORS
	public User() {}
	
	
	// TO STRING
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", role=" + Arrays.toString(role) + ", groups="
				+ groups + "]";
	}

}
