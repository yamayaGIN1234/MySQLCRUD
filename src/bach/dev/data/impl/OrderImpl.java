package bach.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderImpl {
	private Connection conn;
	
	public OrderImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	//Thêm order mới
	public boolean insert(Order order) {
        String sql = "INSERT INTO ORDERS(ID, CODE, STATUS, USER_ID) VALUES(NULL, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "order Code");
            stmt.setString(2, "order Status");
            stmt.setInt(3, 1); //1 là id của user

            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	//Cập nhật order
	public boolean update() {
        String sql = "UPDATE ORDERS SET code = ?, status = ?, user_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "order Code");
            stmt.setString(2, "order Status");
            stmt.setInt(3, 1); //1 là id của user
            stmt.setInt(4, 2); //2 là id của order cần cập nhật
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	//Xoá order
	public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM ORDERS WHERE ID = ?";
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
	//Tìm kiếm order theo id
	public void find(int id) {
        String sql = "SELECT * FROM ORDERS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                Timestamp created_at = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%d:%s", id, code, status, userId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	//Lấy toàn bộ orders
	public void findAll() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM ORDERS";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                Timestamp created_at = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%d:%s", id, code, status, userId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	//Tìm kiếm order theo user
	public void findByUser(int userId) {
        String sql = "SELECT * FROM ORDERS WHERE user_id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%d:%s", id, code, status, userId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	//Tìm kiếm order theo status
	public void findByStatus(String status) {
        try {
            String sql = "SELECT * FROM ORDERS WHERE STATUS = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                int userId = rs.getInt("user_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                System.out.format("%d:%s:%s:%d:%s", id, code, status, userId, createdAt).println();
            }
        } catch (SQLException ex) {
        }
    }
	//Tìm kiếm order theo code
	public void findByCode(String code) {
        String sql = "SELECT * FROM ORDERS WHERE CODE= ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, code);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%d:%s", id, code, status, userId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	//Tính số lượng order theo ngày
	public int countOrderByDay(String date) {
        int count = 0;
        String sql = "SELECT COUNT(*) AS count FROM orders where date(created_at)=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
