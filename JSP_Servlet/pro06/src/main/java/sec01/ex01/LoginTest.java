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
@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글처리
		response.setContentType("text/html;charset=utf-8"); // MIME-TYPE 설정
		PrintWriter out = response.getWriter(); // PrintWriter 객체 생성

		String user_id = request.getParameter("user_id"); // user_id 파라미터 받기
		String user_pw = request.getParameter("user_pw"); // user_pw 파라미터 받기

		System.out.println("아이디 : " + user_id);
		System.out.println("패스워드 : " + user_pw);

		if (user_id != null && (user_id.length() != 0)) {
			if ("admin".equals(user_id)) {
				out.print("<html>");
				out.print("<body>");
				out.print("<font size ='12'> 관리자로 로그인 하셨습니다!! </font>");
				out.print("<br>");
				out.print("<input type='button' value = '회원정보 수정하기' />");
				out.print("<input type='button' value = '회원정보 삭제하기' />");
				out.print("</boby>");
				out.print("</html>");
			} else {
				out.print("<html>");
				out.print("<body>");
				out.print(user_id + " 님!! 로그인 하셨습니다.");
				out.print("</boby>");
				out.print("</html>");
			}

		} else {
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요!!!");
			out.print("<br>");
			out.print("<a href='/pro06/test01/login.html'> 로그인 창으로 이동 </a>");
			out.print("</boby>");
			out.print("</html>");
		}
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

}
