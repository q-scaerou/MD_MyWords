package fr.corell.mdmywords.m.bo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idUser;
	private String userName;
	private String[] role;
	private List<Group> groups;
	
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
	
	public User() {}
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", role=" + Arrays.toString(role) + ", groups="
				+ groups + "]";
	}

}
