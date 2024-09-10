package bach.dev;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bach.dev.*;
import bach.dev.data.impl.CategoryImpl;
import bach.dev.data.impl.ProductImpl;
import bach.dev.data.impl.UserImpl;
public class MainApp {

	static final String DB_URL = "jdbc:mysql://localhost/shop";
	static final String DB_USER  = "root";
	static final String DB_PASS  = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		/**
		 * Category
		 */
//		CategoryImpl.insert();
//		CategoryImpl.update();
//		CategoryImpl.delete();
//		CategoryImpl.readOne();
//		CategoryImpl.readAll();
		
		/**
		 * User
		 */
//		UserImpl user = new UserImpl(con);
//		user.insert();
//		user.update();
//		user.delete(1);
//		user.find(1);
//		user.findAll();
		
		/**
		 * Product
		 */
//		ProductImpl product = new ProductImpl(con);
//		product.insert();
//		product.update();
//		product.delete(1);
//		product.find(1);
//		product.findAll();
		
		/**
		 * Order
		 */
//		OrderImpl order = new OrderImpl(con);
//		order.insert();
//		order.update();
//		order.delete(1);
//		order.find(1);
//		order.findAll
		
		/**
		 * Order_item
		 */
//		Order_itemImpl order_item = new Order_itemImpl(con);
//		order_item.insert();
//		order_item.update();
//		order_item.delete(1);
//		order_item.find(1);
//		order_item.findAll();
	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
