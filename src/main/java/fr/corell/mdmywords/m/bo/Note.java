package fr.corell.mdmywords.m.bo;

import java.io.Serializable;

public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// ATTRIBUTES
	private int id;
	private Notebook notebook;
	private String text;
	
	
	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Notebook getNotebook() {
		return notebook;
	}
	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	// CONSTRUCTORS
	public Note() {}
	
	
	// TO STRING
	@Override
	public String toString() {
		return "Note [idNote=" + id + ", noteBook=" + notebook + ", text=" + text + "]";
	}

}
