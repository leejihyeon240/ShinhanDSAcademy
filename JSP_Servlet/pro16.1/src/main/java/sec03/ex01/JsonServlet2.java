package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		JSONObject totalObject = new JSONObject();
		JSONArray memberArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		memberInfo.put("name", "박지성");
		memberInfo.put("age", 25);
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날센돌이");
		memberArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", 21);
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		memberArray.add(memberInfo);
		
		totalObject.put("members", memberArray);
		PrintWriter writer = response.getWriter();
		writer.print(totalObject.toJSONString());
	}

}
