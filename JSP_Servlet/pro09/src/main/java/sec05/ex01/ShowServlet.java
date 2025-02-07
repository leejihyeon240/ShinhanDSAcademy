package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoeServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
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

		String id = "";
		String pwd = "";

		HttpSession session = request.getSession();
		Object result = session.getAttribute("isLogon");

		if (result != null) {
			id = (String) session.getAttribute("login.id");
			pwd = (String) session.getAttribute("login.pwd");
			out.print("<html><body>");
			out.print("아이디: " + id + "<br>");
			out.print("비밀번호: " + pwd + "<br>");
			out.print("</html></body>");

		} else {
			response.sendRedirect("login.html");
		}
	}

}
