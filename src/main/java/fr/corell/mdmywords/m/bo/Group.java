package fr.corell.mdmywords.m.bo;

import java.io.Serializable;

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idGroup;
	private String groupName;
	
	public int getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Group() {}
	
	@Override
	public String toString() {
		return "Group [idGroup=" + idGroup + ", groupName=" + groupName + "]";
	}

}
