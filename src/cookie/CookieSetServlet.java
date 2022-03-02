package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieset")
public class CookieSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");		
		
		Cookie id_cookie = new Cookie(id, id);
		/*
		Cookie id_name = new Cookie("c_name", "90000");
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Cookie time_cookie = new Cookie("c_time", java.net.URLEncoder.encode(sdf.format(now),"utf-8"));
		*/
		id_cookie.setMaxAge(60*60*24); // 쿠키의 수명정해주기
		
		response.addCookie(id_cookie);
//		response.addCookie(id_name);
//		response.addCookie(time_cookie);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> "+ id +"쿠키를 저장하였습니다.</h1>");
		
	}

}
