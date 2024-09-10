package bach.dev.data.impl;

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
            stmt.setString(1, "test@gmail.com");
            stmt.setString(2, "123456");
            stmt.setString(3, "user");

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
            stmt.setString(1, "test2@gmail.com");
            stmt.setString(2, "1234567");
            stmt.setString(3, "user");
            stmt.setInt(4, 1); //1 la id user can cap nhat
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	public void delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM USERS WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	//Tìm kiếm user theo id
	public void find(int id) {
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String email = rs.getString("test@gmail.com");
                String password = rs.getString("123456");
                String role = rs.getString("user");

                System.out.format("id:%d-email:%s-password:%s-role:%s", id, email, password, role).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	//Lấy toàn bộ users
	public void findAll() {
        String sql = "SELECT * FROM Users WHERE ID > ? ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 0);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
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
	//Tìm kiếm user theo email và password
	public void find(String email, String password) {
        String sql = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String role = rs.getString("role");
                System.out.format("id:%d-email:%s-password:%s-role:%s", id, email, password, role).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	//
	private void find(String email) {
        String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
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
