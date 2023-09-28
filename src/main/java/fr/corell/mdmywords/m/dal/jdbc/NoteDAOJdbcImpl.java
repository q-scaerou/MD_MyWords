package fr.corell.mdmywords.m.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import fr.corell.mdmywords.m.bo.Note;
import fr.corell.mdmywords.m.bo.Notebook;
import fr.corell.mdmywords.m.dal.ConnectionProvider;
import fr.corell.mdmywords.m.dal.NoteDAO;

public class NoteDAOJdbcImpl implements NoteDAO {

	@Override
	public Note insert(Notebook notebook, String content, Note previousNote) {
		
		String insertSQL = "INSERT INTO NOTE (notebook, content, previousNote) VALUES (?, ?, ?);";
		Note note = new Note();
		note.setContent(content);
		note.setNotebook(notebook);
		
		PreparedStatement pStmt = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			pStmt = cnx.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, notebook.getId());
			pStmt.setString(2, content);
			if (previousNote != null) {
				pStmt.setInt(3, previousNote.getId());
			} else {
				pStmt.setNull(3, Types.INTEGER);
			}
			
			pStmt.executeUpdate();
			
			ResultSet rs = pStmt.getGeneratedKeys();
			
			if (rs.next()) {
				note.setId(rs.getInt(1));
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("ERROR WHEN INSERTING NOTE");
		}
		
		return note;
		
	}
	
	@Override
	public Note selectPreviousFromNotebook(Notebook notebook) {
		String selectPreviousSQL = """
				SELECT id, content FROM NOTE
				WHERE notebook = ?
				AND id = (SELECT MAX(id) FROM NOTE WHERE notebook = ?);
				""";
		Note note = null;
		
		PreparedStatement pStmt = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			pStmt = cnx.prepareStatement(selectPreviousSQL);
			pStmt.setInt(1, notebook.getId());
			pStmt.setInt(2, notebook.getId());
			
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				note = new Note();
				note.setId(rs.getInt("id"));
				note.setContent(rs.getString("content"));
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("ERROR WHEN SELECTING LAST NOTE FOR NOTEBOOK=" + notebook.getId());
		}
		
		return note;
		
	}

	
	
}
