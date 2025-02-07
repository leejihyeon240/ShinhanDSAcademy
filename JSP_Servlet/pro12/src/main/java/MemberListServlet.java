
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/member/list.do")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 파라미터 받기(검색 O = 값이 있음, 검색 X = null/'')
		String name = request.getParameter("name");
	
		// 파라미터를 MemberVO 객체에 저장
		MemberVO vo = new MemberVO();
		vo.setName(name);
	
		// MemberDAO객체의 listMembers 메서드를 호출하면서 MemberVO 객체를 파라미터로 전달
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.listMembers(vo);
		
		// request 저장소에 저장
		request.setAttribute("list", list);
		
		// 포워딩(/WEB-INF/view/member/list.jsp)
		request.getRequestDispatcher("WEB-INF/view/member/list.jsp");
	}

}
