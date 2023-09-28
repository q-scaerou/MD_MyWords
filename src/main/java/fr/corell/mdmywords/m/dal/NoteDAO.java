package fr.corell.mdmywords.m.dal;

import fr.corell.mdmywords.m.bo.Note;
import fr.corell.mdmywords.m.bo.Notebook;

public interface NoteDAO {
	
	Note insert(Notebook notebook, String content, Note previousNote);
	Note selectPreviousFromNotebook(Notebook notebook);

}
