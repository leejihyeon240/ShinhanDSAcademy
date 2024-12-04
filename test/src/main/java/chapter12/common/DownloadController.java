package chapter12.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DownloadController {

	@GetMapping("/download.do")
	public void download(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String file_repo = request.getRealPath("/upload/");
		String fileName = (String)request.getParameter("real");
		String org = (String)request.getParameter("org");
		org = new String(org.getBytes("UTF-8"), "ISO-8859-1");
		OutputStream out = response.getOutputStream();
		String downFile = file_repo + "/" + fileName;
		File f = new File(downFile);
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName="+org);
		FileInputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024*8];
		while (true) {
			int count = in.read(buffer);
			if (count == -1) {
				break;
			}
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
}