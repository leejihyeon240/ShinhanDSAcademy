package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemverVO;

/**
 * Servlet implementation class JstlTest
 */
@WebServlet("/jstl")
public class JstlTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request로 저장?
		request.setAttribute("name", "홍길동");

		// 로그인 성공 가정
		MemverVO vo = new MemverVO();
		vo.setId("lee");
		vo.setName("이순신");
		request.getSession().setAttribute("loginSession", vo);

		List<MemverVO> list = new ArrayList<>();
		list.add(vo);

		// List(MemberVO) 객체 생성 (DB에서 조회될 데이터)
		vo = new MemverVO();
		vo.setId("kim");
		vo.setName("김길동");
		list.add(vo);
		vo = new MemverVO();
		vo.setId("hong");
		vo.setName("홍길동");
		list.add(vo);

		request.setAttribute("memberList", list);

		// 포워딩
		request.getRequestDispatcher("/WEB-INF/view/jstl/index.jsp").forward(request, response);

	}

}
