package rangking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RangkingDAO {
	private PreparedStatement pstmt;
	private Connection con;

	private DataSource dataFactory;

	public RangkingDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<RangkingVO> listMembers() {
		List<RangkingVO> list = new ArrayList<>();
		try {
//			connDB();
			con = dataFactory.getConnection();
			String query = "SELECT USER_NAME, WIN_COUNT "
					+ "FROM (SELECT USER_NAME, WIN_COUNT FROM USER_TABLE ORDER BY WIN_COUNT DESC) "
					+ "WHERE ROWNUM <= 3";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String userName = rs.getString("user_name");
				int winCount = rs.getInt("win_count");

				RangkingVO vo = new RangkingVO();
				vo.setUserName(userName);
				vo.setWinCount(winCount);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
