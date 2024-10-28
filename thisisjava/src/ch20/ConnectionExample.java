package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. 클래스(드라이버) 로드
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. DB에 접속(host, id, pw, sid)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
			// 3. SQL 실행할 객체(statement) 생성
			stmt = conn.createStatement();
			// 4. SQL(문자열) 실행
			rs = stmt.executeQuery("SELECT * FROM emp ORDER BY ename ASC");
			// 5. 실행결과 처리
			while (rs.next()) {
				System.out.println(rs.getString("ename") + "," + rs.getString("job"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {

				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {

				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {

				}
		}
	}

}
