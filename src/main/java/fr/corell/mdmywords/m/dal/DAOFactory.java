package fr.corell.mdmywords.m.dal;

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
