package fr.corell.mdmywords.m.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.corell.mdmywords.m.bo.Notebook;

public class NoteBookDAOJdbcImpl implements NoteBookDAO {
	
	private static final String SELECT_ALL = "SELECT * from Notebooks;";

	@Override
	public List<Notebook> selectAll() {
		List<Notebook> notebooks = new ArrayList<Notebook>();
		
		Statement stmt = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			stmt = cnx.createStatement();
			
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			
			while (rs.next()) {
				int idNotebook = rs.getInt("idNotebook");
				String notebookName = rs.getString("notebookName");
				
				Notebook n = new Notebook(idNotebook, notebookName);
				notebooks.add(n);
			}
			
		} catch (SQLException sqle) {
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

}
