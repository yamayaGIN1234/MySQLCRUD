package bach.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemImpl {
	private Connection conn;
	
	public OrderItemImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean insert() {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO ORDER_ITEMS(ID, QUANTITY, PRICE, ORDER_ID, PRODUCT_ID) VALUES(NULL, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,3);
            stmt.setDouble(2, 180000);
            stmt.setInt(3, 2);
            stmt.setInt(4, 2);
            
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	public boolean update() {
        // TODO Auto-generated method stub
        String sql = "UPDATE ORDER_ITEMS SET quantity = ?, price = ?, order_id = ?, product_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,3);
            stmt.setDouble(2, 150000);
            stmt.setInt(3, 2);
            stmt.setInt(4, 2);
            stmt.setInt(5, 6);
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM ORDER_ITEMS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	public void find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM ORDER_ITEMS WHERE ID = ?" ;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int orderId = rs.getInt("order_id");
                int productId = rs.getInt("product_id");
                
                System.out.format("%d:%d:%.2f:%d:%d", id, quantity, price, orderId, productId).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	public void select() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM ORDER_ITEMS" ;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int orderId = rs.getInt("order_id");
                int productId = rs.getInt("product_id");
                
                System.out.format("%d:%d:%.2f:%d:%d", id, quantity, price, orderId, productId).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
