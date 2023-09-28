package fr.corell.mdmywords.m.bll;

import java.time.LocalDate;
import java.util.List;

import fr.corell.mdmywords.m.bo.Notebook;
import fr.corell.mdmywords.m.dal.DAOFactory;

public class NoteBookManager {

	private static NoteBookManager instance;
	
	private NoteBookManager() {}
	
	public static NoteBookManager getInstance() {
		if (instance == null) {
			instance = new NoteBookManager();
		}
		
		return instance;
		
	}
	
	public Notebook insert(String title, LocalDate creationDate, List<String> notesContent) {
		return DAOFactory.getNoteBookDAO().insert(title, creationDate, notesContent);
	}
	
}
