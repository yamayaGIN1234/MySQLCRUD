package bach.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryImpl {
	private Connection conn;
	
	public CategoryImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public void insert() {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO CATEGORIES VALUES(NULL, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "category name");
            stmt.setString(2, "url thumbnail");
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void update() {
        // TODO Auto-generated method stub
        String sql = "UPDATE CATEGORIES SET name = ?, description = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "category name");
            stmt.setString(2, "mo ta");
            stmt.setInt(3, 1); //1 là id của category
            stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void delete() {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM CATEGORIES WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1); //1 là id của category
            stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void select() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM CATEGORIES";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                System.out.format("%d : %s : %s%n", id, name, description).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
