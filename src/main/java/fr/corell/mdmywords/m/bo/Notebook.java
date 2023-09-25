package fr.corell.mdmywords.m.bo;

import java.io.Serializable;
import java.time.LocalDate;

public class Notebook implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// ATTRIBUTES
	private int id;
	private String title;
	private LocalDate creationDate;
	private LocalDate modificationDate;
	private String link;
	private Group group;
	private boolean isActive;
	
	
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
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDate getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(LocalDate modificationDate) {
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
