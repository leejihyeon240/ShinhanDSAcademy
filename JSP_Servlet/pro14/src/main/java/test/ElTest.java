package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemverVO;

/**
 * Servlet implementation class ElTest
 */
@WebServlet("/el")
public class ElTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 포워딩
		request.getRequestDispatcher("/el/index.jsp").forward(request, response);

		request.setAttribute("name", "홍길동");
		HttpSession sess = request.getSession();

		sess.setAttribute("id", "kim");
		
		// 같은 이름으로 
		request.setAttribute("id", "kim");

		// MemverVO 객체에 저장
		MemverVO vo = new MemverVO();
		vo.setId("lee");
		vo.setName("이순신");

		request.setAttribute("member", vo);

		// Map 객체에 저장
		Map<String, Object> map = new HashMap<>();
		map.put("tel", "010-1111-2222");
		// Map 안에 MemberVO
		map.put("vo", vo);
		request.setAttribute("map", map);

	}

}
