package fr.corell.mdmywords.m.bo;

import java.io.Serializable;
import java.time.LocalDate;

public class Notebook implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idNotebook;
	private String notebookName;
	private LocalDate creationDate;
	private LocalDate modifyDate;
	private String shareLink;
	private Group group;
	private boolean isActive;
	
	public int getIdNotebook() {
		return idNotebook;
	}
	public void setIdNotebook(int idNotebook) {
		this.idNotebook = idNotebook;
	}
	public String getNotebookName() {
		return notebookName;
	}
	public void setNotebookName(String notebookName) {
		this.notebookName = notebookName;
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
	
	public Notebook() {}
	
	public Notebook(int idNotebook, String notebookName) {
		this();
		this.idNotebook = idNotebook;
		this.notebookName = notebookName;
	}
	
	@Override
	public String toString() {
		return "NoteBook [idNoteBook=" + idNotebook + ", noteBookName=" + notebookName + ", creationDate="
				+ creationDate + ", modifyDate=" + modifyDate + ", shareLink=" + shareLink + ", group=" + group
				+ ", isActive=" + isActive + "]";
	}
	
	

}
