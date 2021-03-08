package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	//J601用のパス
  private final String JDBC_URL = "jdbc:mysql://172.16.61.111:3306/test";
  private final String DB_USER = "yasui";
  private final String DB_PASS = "yasui";

	//自宅用のパス
//	private final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
//    private final String DB_USER = "root";
//    private final String DB_PASS = "root11pass";

    //最初のドライバ接続処理
	public UserDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public User findByLogin(User user) {
		//戻り値（照合するパスワード）の初期化
		User loginUser = null;

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT id, pass FROM user WHERE id = ? AND pass = ?";
			//String data = user.getUserName();
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1,  user.getUserName());
			pStmt.setString(2,  user.getPass());

			ResultSet rs = pStmt.executeQuery();


			while(rs.next()) {
			    String userName = rs.getString("id");
				String pass = rs.getString("pass");

				loginUser = new User(userName, pass);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return loginUser;
	}
}
