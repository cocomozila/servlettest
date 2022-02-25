package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;


@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		MemberDTO dto = new MemberDTO(id, pw, name, phone, email, address);
		MemberDAO dao = new MemberDAO();
		dao.insertMember(dto);		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + id + "</h1>");
		out.println("<h1>" + pw + "</h1>");
		out.println("<h1>" + name + "</h1>");
		out.println("<h1>" + phone + "</h1>");
		out.println("<h1>" + email + "</h1>");
		out.println("<h1>" + address + "</h1>");
		

	}

}
