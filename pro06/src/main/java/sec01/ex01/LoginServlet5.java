package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login2")
public class LoginServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글처리
		String user_id = request.getParameter("user_id"); // user_id 파라미터 받기
		String user_pw = request.getParameter("user_pw"); // user_pw 파라미터 받기

		response.setContentType("text/html;charset=utf-8"); // MIME-TYPE 설정
		PrintWriter out = response.getWriter(); // PrintWriter 객체 생성
		String data = "<html>"; // 문자열(사용자한테 응답할)
		data += "<body>";
		data += "아이디: " + user_id;
		data += "<br>";
		data += "패스워드: " + user_pw;
		data += "</boby>";
		data += "</html>";
		out.print(data); // 출력 -> 톰캣이 브라우저한테 전송(응답)

	}

}
