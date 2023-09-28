package fr.corell.mdmywords.m.bll;

import fr.corell.mdmywords.m.bo.Note;
import fr.corell.mdmywords.m.bo.Notebook;
import fr.corell.mdmywords.m.dal.DAOFactory;

public class NoteManager {
	
	private static NoteManager instance;
	
	private NoteManager() {}
	
	public static NoteManager getInstance() {
		if (instance == null) {
			instance = new NoteManager();
		}
		return instance;
	}
	
	public Note insert(Notebook notebook, String content, Note previousNote) {
		return DAOFactory.getNoteDAO().insert(notebook, content, previousNote);
	}
	
	public Note selectPreviousFromNotebook(Notebook notebook) {
		return DAOFactory.getNoteDAO().selectPreviousFromNotebook(notebook);
	}

}
