package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/servlettest/login
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청정보에서 id, pw 추출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
				
		String str = sum(Integer.parseInt(id), Integer.parseInt(pw));
		
		//처리
		//결과응답(브라우저 한글인코딩-컴퓨터 (????) -서블릿(utf-8)
		response.setContentType("text/html;charset=utf-8"); //브라우저 전송문서타입 알려주는 형태
		PrintWriter out = response.getWriter();
		out.println("<h3 style='color:green'> 입력하신 아이디는 " + id + " 이고 암호는 " + pw +" 입니다.</h3>");
		out.println("<h3> 두 숫자의 합은" + str + " 입니다.</h3>");
		out.println("<h3> 정상적으로 로그인되셨습니다. </h3>");

		
	}
	
	public String sum(int a, int b) {
		return String.valueOf(a+b);
	}

}
