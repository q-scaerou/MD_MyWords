package fr.corell.mdmywords.m.bo;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// ATTRIBUTES
	private int idUser;
	private String userName;
	private String mail;
	private String password;
	private boolean isAdmin;
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

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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
	public boolean switchAdmin() {
		return !isAdmin;
	}

	
	// CONSTRUCTORS
	public User() {}
	
	
	// TO STRING
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", admin=" + isAdmin + ", groups="
				+ groups + "]";
	}

}
