package fr.corell.mdmywords.m.bo;

import java.io.Serializable;

public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idNote;
	private Notebook noteBook;
	private String text;
	
	public int getIdNote() {
		return idNote;
	}
	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}
	public Notebook getNoteBook() {
		return noteBook;
	}
	public void setNoteBook(Notebook noteBook) {
		this.noteBook = noteBook;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Note() {}
	
	@Override
	public String toString() {
		return "Note [idNote=" + idNote + ", noteBook=" + noteBook + ", text=" + text + "]";
	}

}
