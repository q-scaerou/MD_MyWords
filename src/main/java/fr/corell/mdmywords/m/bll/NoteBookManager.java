package fr.corell.mdmywords.m.bll;

public class NoteBookManager {

	private static NoteBookManager instance;
	
	private NoteBookManager() {}
	
	public static NoteBookManager getInstance() {
		if (instance == null) {
			instance = new NoteBookManager();
		}
		return instance;
	}
	
}
