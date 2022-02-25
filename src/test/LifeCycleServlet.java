package test;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/life")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	//get방식 요청 - init - doGet - destroy
	//서블릿코드 수정 - 재컴파일(자동) - 서버 서블릿reload(이전 서블릿 삭제) destroy 실행
	
	int count = 0;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버 시스템 콘솔창 출력
		System.out.println("== doGet 호출중(수정) ==");
		response.getWriter().append("<h1>"+ ++count + "<h1>");
	}

	@Override
	public void destroy() {
		//초상태변수값 메모리 정리
		System.out.println("== destroy 호출중 ==");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//서블릿 최초상태변수값 설정
		System.out.println("== init 호출중 ==");
	}

	

}
