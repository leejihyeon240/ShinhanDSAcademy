package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
//@WebServlet(urlPatterns = { "/sInit", "/sInit2" }, initParams = {
//		@WebInitParam(name = "email", value = "admin@jweb.com"), @WebInitParam(name = "tel", value = "010-1111-2222") })
public class InitParamServlet extends HttpServlet {
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

		String email = getInitParameter("email");
		String tel = getInitParameter("tel");

		out.print("<html><body><table><tr><td>email: </td><td>" + email + "</td><tr>");
		out.print("<tr><td>휴대전화: </td><td>" + tel + "</td");
		out.print("</tr></table></body></html>");
	}

}
