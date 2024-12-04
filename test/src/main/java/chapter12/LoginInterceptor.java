package chapter12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {
		HttpSession sess = request.getSession();
		// 로그인 페이지에서 로그인 성공 시 세션에 loginInfo라는 이름으로 저장
		// sess.Attribute("loginInfo", vo);
		if (sess.getAttribute("loginInfo") == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인 후 사용 가능합니다.');");
			out.print("location.href='/test/student/index.do';");
			out.print("</script>");
			out.close();
			return false; // 못 가
		}
		return true; // 가던길 가
	}
}
