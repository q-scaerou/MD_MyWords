package fr.corell.mdmywords.m.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.corell.mdmywords.m.bo.User;
import fr.corell.mdmywords.m.dal.ConnectionProvider;
import fr.corell.mdmywords.m.dal.UserDAO;
import fr.corell.mdmywords.m.security.BCrypt;

public class UserDAOJdbcImpl implements UserDAO {

	@Override
	public void initDataset() {
		
		User u1 = new User();
		u1.setUsername("test_user");
		u1.setMail("test@test.te");
		u1.setPassword("test");
		u1.setIsAdmin(false);
		
		User u2 = new User();
		u2.setUsername("admin");
		u2.setMail("admin@test.te");
		u2.setPassword("admin");
		u2.setIsAdmin(true);
		
		insert(u1);
		insert(u2);
		
	}
	
	public void insert(User user) {
		
		String insertSQL = "INSERT INTO APP_USER (username, mail, password, isAdmin) VALUES (?, ?, ?, ?);";
		
		PreparedStatement pStmt = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			pStmt = cnx.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pStmt.setString(1, user.getUsername());
			pStmt.setString(2, user.getMail());
			String salt = BCrypt.gensalt(12);
			String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
			pStmt.setString(3, hashedPassword);
			pStmt.setBoolean(4, user.getIsAdmin());
			
			pStmt.executeUpdate();
			
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				user.setIdUser(rs.getInt(1));
			}
						
		} catch (SQLException sqle) {
			
			System.out.println("ERROR ON INSERT USER=" + user);
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
		
	}

}
