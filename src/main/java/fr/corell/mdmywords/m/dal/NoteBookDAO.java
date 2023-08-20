package fr.corell.mdmywords.m.dal;

import java.util.List;

import fr.corell.mdmywords.m.bo.Notebook;

public interface NoteBookDAO {
	
	List<Notebook> selectAll();

}
