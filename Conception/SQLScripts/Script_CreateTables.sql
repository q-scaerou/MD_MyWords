USE MDMW_DB;

DROP TABLE IF EXISTS Notebooks;
GO

CREATE TABLE Notebooks (
	idNotebook int,
	notebookName VARCHAR(50)
);

DROP TABLE IF EXISTS Users;
GO

CREATE TABLE Users (
	idUser int
);

DROP TABLE IF EXISTS Groups;
GO

CREATE TABLE Groups (
	idGroup int
);

DROP TABLE IF EXISTS Notes;

CREATE TABLE Notes (
	idNote int
);