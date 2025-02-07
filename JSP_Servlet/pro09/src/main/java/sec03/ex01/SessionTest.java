package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); // MIME-TYPE 설정
		PrintWriter out = response.getWriter(); // PrintWriter 객체 생성 }

		HttpSession session = request.getSession();

		out.print("세션 아이디 : " + session.getId() + "<br>");
		out.print("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");

		// 세션에 저장
		Map<String, Object> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", 30);

		session.setAttribute("member", map);

		Map<String, Object> member = (Map<String, Object>) session.getAttribute("member");
		out.print(member.get("name") + "<br>");
		out.print(member.get("age") + "<br>");

	}

}
