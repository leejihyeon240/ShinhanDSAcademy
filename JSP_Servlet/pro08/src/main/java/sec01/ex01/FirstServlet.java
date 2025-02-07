package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
//@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8"); // MIME-TYPE 설정
		PrintWriter out = response.getWriter(); // PrintWriter 객체 생성 }
//		response.sendRedirect("second");
		// 져장소에 저장하기
		request.setAttribute("name", "홍길동");
		
		// 포워딩
//		request.getRequestDispatcher("second").forward(request, response); // 주소 변동 x
		RequestDispatcher rd = request.getRequestDispatcher("second");
		rd.forward(request, response);
		out.print("first");
		System.out.println("first");
	}

}
