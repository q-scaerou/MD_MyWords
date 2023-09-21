package fr.corell.mdmywords.m.dal;

import fr.corell.mdmywords.m.dal.jdbc.GroupDAOJdbcImpl;
import fr.corell.mdmywords.m.dal.jdbc.NoteBookDAOJdbcImpl;
import fr.corell.mdmywords.m.dal.jdbc.NoteDAOJdbcImpl;
import fr.corell.mdmywords.m.dal.jdbc.UserDAOJdbcImpl;

public class DAOFactory {
	
	public static NoteBookDAO getNoteBookDAO() {
		return new NoteBookDAOJdbcImpl();
	}
	
	public static GroupDAO getGroupDAO() {
		return new GroupDAOJdbcImpl();
	}
	
	public static UserDAO getUserDAO() {
		return new UserDAOJdbcImpl();
	}
	
	public static NoteDAO getNoteDAO() {
		return new NoteDAOJdbcImpl();
	}

}
