package fr.corell.mdmywords.m.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.corell.mdmywords.m.bll.GroupManager;
import fr.corell.mdmywords.m.bll.NoteManager;
import fr.corell.mdmywords.m.bo.Group;
import fr.corell.mdmywords.m.bo.Note;
import fr.corell.mdmywords.m.bo.Notebook;
import fr.corell.mdmywords.m.dal.ConnectionProvider;
import fr.corell.mdmywords.m.dal.NoteBookDAO;

public class NoteBookDAOJdbcImpl implements NoteBookDAO {
	
	@Override
	public List<Notebook> selectAll() {
		
		String selectAllSQL = "SELECT id, title, creationDate, modificationDate, link, id_group, isActive FROM Notebook;";
		
		List<Notebook> notebooks = new ArrayList<Notebook>();
		
		Statement stmt = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			stmt = cnx.createStatement();
			
			ResultSet rs = stmt.executeQuery(selectAllSQL);
			
			while (rs.next()) {				
				Notebook n = new Notebook();
				n.setId(rs.getInt("id"));
				n.setTitle(rs.getString("title"));
				n.setCreationDate(rs.getDate("creationDate").toLocalDate());
				n.setModificationDate(rs.getDate("creationDate").toLocalDate());
				n.setLink(rs.getString("link"));
				
				Group group = null; //GroupManager.getInstance().select(rs.getInt("id_group"));
				n.setGroup(group);
				
				n.setIsActive(rs.getBoolean("isActive"));
				
				notebooks.add(n);
			}
			
		} catch (SQLException sqle) {
			System.out.println("ERROR WHEN SELECTING ALL NOTEBOOKS FROM DB");
			sqle.printStackTrace();
			
		} finally {
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("ERROR WHEN CLOSING STATEMENT");
					e.printStackTrace();
				}
			}
			
		}
		
		return notebooks;
		
	}
	
	@Override
	public Notebook insert(String title, LocalDate creationDate, List<String> notesContents) {
		
		String insertSQL = "INSERT INTO Notebook (title, creationDate, modificationDate, isActive) VALUES (?, ?, ?, ?);";
		Notebook nb = null;
		Note previousNote = null;
		PreparedStatement pStmt = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			pStmt = cnx.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, title);
			pStmt.setDate(2, Date.valueOf(creationDate));
			pStmt.setDate(3, Date.valueOf(creationDate));
			pStmt.setBoolean(4, true);
			
			pStmt.executeUpdate();
			
			
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				nb = new Notebook();
				nb.setTitle(title);
				nb.setCreationDate(creationDate);
				nb.setModificationDate(creationDate);
				nb.setIsActive(true);
				nb.setId(rs.getInt(1));
			}
			
			for (int i = 0; i < notesContents.size(); i++) {
				
				if (i != 0) {
					previousNote = NoteManager.getInstance().selectPreviousFromNotebook(nb);
				}
				NoteManager.getInstance().insert(nb, notesContents.get(i), previousNote);
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("ERROR WHEN INSERTING NOTEBOOK");
		}
		
		return nb;
		
	}

}
