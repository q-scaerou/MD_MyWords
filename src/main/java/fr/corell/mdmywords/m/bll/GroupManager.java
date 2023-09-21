package fr.corell.mdmywords.m.bll;

import fr.corell.mdmywords.m.bo.Group;
import fr.corell.mdmywords.m.dal.DAOFactory;

public class GroupManager {
	
	private static GroupManager instance;
	
	private GroupManager() {}
	
	public static GroupManager getInstance() {
		if (instance == null) {
			instance = new GroupManager();
		}
		return instance;
	}
	
	public Group select(int id) {
		return DAOFactory.getGroupDAO().select(id);
	}

}
