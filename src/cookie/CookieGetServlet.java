package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieget")
public class CookieGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie c_array [] = request.getCookies();
		
		ArrayList<Cookie> arr = new ArrayList();
		
		for (int i = 0; i < c_array.length; i++) {
			arr.add(c_array[i]);
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		for (Cookie c : arr) {
			out.println("<h1> 쿠키이름 : "+ c.getName() +"</h1>");
			out.println("<h1> 쿠키값 : "+ c.getValue() +"</h1>");
		}
	}

}
