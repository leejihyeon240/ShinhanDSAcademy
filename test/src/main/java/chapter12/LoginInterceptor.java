package chapter12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		HttpSession sess = request.getSession();
		// 로그인 페이지에서 로그인성공시 세션에 loginInfo라는 이름으로 저장
		// sess.setAttribute("loginInfo", vo);
		System.out.println("왜안돼지?");
		if (sess.getAttribute("loginInfo") == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 사용가능합니다.');");
			out.println("location.href='/test/student/login.do';");
			out.println("</script>");
			out.close();
			return false; // 못가
		}
		return true; // 가던길 가
	}
}
