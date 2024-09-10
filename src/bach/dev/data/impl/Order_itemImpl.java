package bach.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Order_itemImpl {
	
	private Connection conn;
	
	public Order_itemImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	//Thêm order_item mới
	public boolean insert() {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO ORDER_ITEMS(ID, QUANTITY, PRICE, ORDER_ID, PRODUCT_ID) VALUES(NULL, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,"orderItem Quantity");
            stmt.setDouble(2, "orderItem Price");
            stmt.setInt(3, "orderItem OrderId");
            stmt.setInt(4, "orderItem ProductId");
            
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return false;
    }
	//Cập nhật order_item
	public boolean update() {
        // TODO Auto-generated method stub
        String sql = "UPDATE ORDER_ITEMS SET quantity = ?, price = ?, order_id = ?, product_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,"orderItem Quantity");
            stmt.setDouble(2, "orderItem Price");
            stmt.setInt(3, "orderItem OrderId");
            stmt.setInt(4, "orderItem ProductId");
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	//Xoá order_item
	public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM ORDER-ITEMS WHERE ID = ?";
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
	//Tìm kiếm order_item theo id
	public void find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM ORDER-ITEMS" ;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
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
	//Lấy toàn bộ order_items
	public void findAll() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM CATEGORIES" ;
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
	//Tìm kiếm theo order
	public void findByOder(int orderId) {
        String sql = "SELECT * FROM ORDER_ITEMS WHERE order_id = ?";
        try {
            stmt.setInt(1, orderId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int productId = rs.getInt("product_id");
                System.out.format("%d:%d:%.2f:%d:%d", id, quantity, price, orderId, productId).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
