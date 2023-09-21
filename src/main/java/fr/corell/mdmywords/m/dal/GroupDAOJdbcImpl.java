package fr.corell.mdmywords.m.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.corell.mdmywords.m.bo.Group;

public class GroupDAOJdbcImpl implements GroupDAO {

	@Override
	public Group select(int id) {

		String selectIdSQL = "SELECT id, name FROM GROUP WHERE id = ?;";
		
		Group group = null;
		
		PreparedStatement pStmt = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			pStmt = cnx.prepareStatement(selectIdSQL);
			pStmt.setInt(1, id);
			
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				
				group = new Group();
				group.setId(id);
				group.setName(rs.getString("name"));
				
			}
			
		} catch (SQLException sqle) {
			System.out.println("ERROR WHEN SELECT GROUP WITH id=" + id);
			sqle.printStackTrace();
			
		} finally {
			
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (SQLException e) {
					System.out.println("ERROR WHEN CLOSING PREPARED STATEMENT");					
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		return group;
		
	}

}
