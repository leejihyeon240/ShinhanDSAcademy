package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	private void connDB() {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", 
//												"testuser", "test1234");
//			stmt = con.createStatement();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public List<MemberVO> listMembers(String searchType, String searchWord) {
		List<MemberVO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
//			connDB();
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			String whereQuery = "";
			if (searchWord != null && !"".equals(searchWord)) {
				if ("all".equals(searchType)) {
					whereQuery = " where id like '%"+searchWord+"%' or name like '%"+searchWord+"%' or email like '%"+searchWord+"%'";
				} else {
					whereQuery = " where "+searchType+" like '%"+searchWord+"%'";
				}
			}
			query += whereQuery;
//			rs = stmt.executeQuery(query);
			// PreparedStatement
			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, "");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();}catch(Exception e) {}
			try {stmt.close();}catch(Exception e) {}
			try {pstmt.close();}catch(Exception e) {}
			try {con.close();}catch(Exception e) {}
		}
		
		return list;
	}
	
	public void addMember(MemberVO vo) {
		try {
			con = dataFactory.getConnection();
			String query = "INSERT INTO t_member (id,pwd,name,email) VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();}catch(Exception e) {}
			try {con.close();}catch(Exception e) {}
		}
	}
	
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			String query = "DELETE FROM t_member WHERE id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();}catch(Exception e) {}
			try {con.close();}catch(Exception e) {}
		}
	}
	public boolean overlappedID(String id) throws Exception {
		boolean result = false;
		try {
			con = dataFactory.getConnection();
			String query = "SELECT COUNT(*) AS cnt FROM t_member WHERE id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if (rs.getInt("cnt") == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();}catch(Exception e) {}
			try {con.close();}catch(Exception e) {}
		}
		return result;
	}
}
