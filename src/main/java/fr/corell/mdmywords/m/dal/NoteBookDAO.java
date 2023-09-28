package fr.corell.mdmywords.m.dal;

import java.time.LocalDateTime;
import java.util.List;

import fr.corell.mdmywords.m.bo.Notebook;

public interface NoteBookDAO {
	
	List<Notebook> selectAll();
	Notebook insert(String title, LocalDateTime creationDate, List<String> notesContents);
	List<Notebook> selectRecent();
	Notebook select(int id);
}
