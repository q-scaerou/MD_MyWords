package fr.corell.mdmywords.m.bo;

import java.io.Serializable;
import java.time.LocalDate;

public class NoteBook implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idNoteBook;
	private String noteBookName;
	private LocalDate creationDate;
	private LocalDate modifyDate;
	private String shareLink;
	private Group group;
	private boolean isActive;
	public int getIdNoteBook() {
		return idNoteBook;
	}
	public void setIdNoteBook(int idNoteBook) {
		this.idNoteBook = idNoteBook;
	}
	public String getNoteBookName() {
		return noteBookName;
	}
	public void setNoteBookName(String noteBookName) {
		this.noteBookName = noteBookName;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDate getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getShareLink() {
		return shareLink;
	}
	public void setShareLink(String shareLink) {
		this.shareLink = shareLink;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public NoteBook() {}
	
	@Override
	public String toString() {
		return "NoteBook [idNoteBook=" + idNoteBook + ", noteBookName=" + noteBookName + ", creationDate="
				+ creationDate + ", modifyDate=" + modifyDate + ", shareLink=" + shareLink + ", group=" + group
				+ ", isActive=" + isActive + "]";
	}
	
	

}
