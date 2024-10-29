package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. 클래스(드라이버) 로드
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. DB에 접속(host, id, pw, sid)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", 
					"testuser", 
					"test1234");
			// 3. SQL 실행할 객체(Statement) 생성
			pstmt = conn.prepareStatement("INSERT into users(userid, username, userpassword, userage, useremail) VALUES (?,?,?,?,?)");
			pstmt.setString(1, "winter");
			pstmt.setString(2, "한겨울");
			pstmt.setString(3, "12345");
			pstmt.setInt(4, 25);
			pstmt.setString(5, "winter@mycompany.com");
			// 4. SQL실행
			int rows = pstmt.executeUpdate();
			// 5. 실행결과 처리
			System.out.println("저장된 행 수 :"+rows);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원해제
			if (rs != null) try {rs.close();}catch(Exception e) {}
			if (pstmt != null) try {pstmt.close();}catch(Exception e) {}
			if (conn != null) try {conn.close();}catch(Exception e) {}
		}
	}

}