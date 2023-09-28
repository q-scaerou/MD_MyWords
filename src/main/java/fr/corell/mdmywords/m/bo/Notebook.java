package fr.corell.mdmywords.m.bo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Notebook implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// ATTRIBUTES
	private int id;
	private String title;
	private LocalDateTime creationDate;
	private LocalDateTime modificationDate;
	private String link;
	private Group group;
	private boolean isActive;
	private List<Note> notes;
	
	
	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(LocalDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	// SPECIFIC METHODS
	public void addNote(Note note) {
		notes.add(note);
	}
	
	
	// CONSTRUCTORS
	public Notebook() {}
	
	
	// TO STRING
	@Override
	public String toString() {
		return "NoteBook [idNoteBook=" + id + ", title=" + title + ", creationDate="
				+ creationDate + ", modificationDate=" + modificationDate + ", link=" + link + ", group=" + group
				+ ", isActive=" + isActive + "]";
	}
	
	

}
