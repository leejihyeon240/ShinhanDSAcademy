package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		try {
			MemberDAO dao = new MemberDAO();
			boolean result = dao.overlappedID(id);
			PrintWriter out = response.getWriter();
			if (result) {
				out.print("not_usable");
			} else {
				out.print("usable");
			}
		} catch (Exception e) {
			
		}
	}

}
