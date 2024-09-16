package bach.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl {
	private Connection conn;

	public UserImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	public void insert() {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO USERS(ID, EMAIL, PASSWORD, ROLE) VALUES(null, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "gumitvtt@gmail.com");
            stmt.setString(2, "password");
            stmt.setString(3, "role3");

            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void update() {
        // TODO Auto-generated method stub
        String sql = "UPDATE USERS SET email = ? ,password = ?, role = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "gumitvtt@gmail.com");
            stmt.setString(2, "password");
            stmt.setString(3, "role2");
            stmt.setInt(4, 1); //1 la id user can cap nhat
            stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public void delete() {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM USERS WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);

            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void select() {
        String sql = "SELECT * FROM Users";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");

                System.out.format("id:%d - email:%s - password:%s - role:%s", id, email, password, role).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void find(int id) {
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");

                System.out.format("id:%d-email:%s-password:%s-role:%s", id, email, password, role).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
