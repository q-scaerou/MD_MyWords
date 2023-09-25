package fr.corell.mdmywords.m.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.corell.mdmywords.m.bll.GroupManager;
import fr.corell.mdmywords.m.bo.Group;
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
				n.setTitle(rs.getString("name"));
				n.setCreationDate(rs.getDate("creationDate").toLocalDate());
				n.setModificationDate(rs.getDate("creationDate").toLocalDate());
				n.setLink(rs.getString("link"));
				
				Group group = GroupManager.getInstance().select(rs.getInt("group"));
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

}
