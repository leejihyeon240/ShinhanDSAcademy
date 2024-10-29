package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelectExample {

	public static void main(String[] args) {
		Connection conn = null;

		try {
			// 1. 클래스(드라이버) 로드
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. DB에 접속(host, id, pw, sid)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");

			String sql = "" + "SELECT userid, username, userpassword, userage, useremail " + "FROM users "
					+ "WHERE userid=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "winter");

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getNString("userpassword"));
				user.setUserAge(rs.getInt(4));
				user.setUserEmail(rs.getString(5));
				System.out.println(user);
			} else {
				System.out.println("사용자 아이디가 존재하지 않음");
			}
			rs.close();

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
