package fr.corell.mdmywords.m.bll;

import fr.corell.mdmywords.m.dal.DAOFactory;

public class UserManager {
	
	private static UserManager instance;
	
	private UserManager() {}
	
	public static UserManager getInstance() {
		if (instance == null) {
			instance = new UserManager();		
		}
		return instance;
	}
	
	public void initDataset() {
		DAOFactory.getUserDAO().initDataset();
	}

}
