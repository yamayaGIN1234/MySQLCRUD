package bach.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductImpl {
	private Connection conn;
	
	public ProductImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public void insert() {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, THUMBNAIL, PRICE, QUANTITY, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Bose SoundLink Mini");
            stmt.setString(2, "Engine");
            stmt.setString(3, "thumbnail5.jpg");
            stmt.setDouble(4, 80000);
            stmt.setInt(5, 50);
            stmt.setInt(6, 2);
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void update() {
        // TODO Auto-generated method stub
        String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail = ?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Bose SoundLink Mini");
            stmt.setString(2, "Engine");
            stmt.setString(3, "thumbnail3.jpg");
            stmt.setDouble(4, 80000);
            stmt.setInt(5, 55);
            stmt.setInt(6, 2);
            stmt.setInt(7, 3);
            stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void delete() {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM PRODUCTS WHERE ID =?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 3); 
            stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void select() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	int id = rs.getInt("id");
            	String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                System.out.format("id: %d - name: %s - price: %.2f - quantity: %d%n", id, name, price, quantity);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
