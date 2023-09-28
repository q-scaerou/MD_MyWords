package fr.corell.mdmywords.m.dal;

import java.time.LocalDate;
import java.util.List;

import fr.corell.mdmywords.m.bo.Notebook;

public interface NoteBookDAO {
	
	List<Notebook> selectAll();
	Notebook insert(String title, LocalDate creationDate, List<String> notesContents);

}
