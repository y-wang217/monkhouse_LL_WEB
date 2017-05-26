package web.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class UserDao {
	
	public HashMap<String, String> executeQuery(String username, String password){
		HashMap<String, String> resultMap = new HashMap<>();
		
		String sql = "SELECT * FROM USER WHERE NAME = '"+username+"' AND PASSWORD = '"+password+"';";

		Connection conn = null;

		int custId = 1;
		try {
	    	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/monkhouse?user=root&password=password");
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resultMap.put("user", rs.getString("name"));
				resultMap.put("title", rs.getString("title"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return resultMap;
	}
	
	public static void main(String[] args){
		UserDao test = new UserDao();
		HashMap<String, String> res = test.executeQuery("test", "asdf");
		for(String key: res.keySet()){
			System.out.println("("+key+", " + res.get(key) + ")");
		}
	}
}
