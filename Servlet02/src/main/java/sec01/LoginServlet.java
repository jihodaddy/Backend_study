package sec01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		if(user_id != null && user_id.length() != 0) {
			String data = "<html><body>";
			data = "안녕하세요!<br> 로그인하셨습니다<br><br>";
			data += "아이디: " + user_id + "<br>";
			data += "비밀번호: " + user_pw + "<br>";
			data += "주소: " + user_address + "<br>";
			data += "이메일: " + user_email + "<br>";
			data += "휴대전화: " + user_hp + "<br>";
			data += "</body></html>";
			out.print(data);
			
			//URL Rewriting 방식 이용
			
			user_address = URLEncoder.encode(user_address,"utf-8");
			//인코딩 안한경우 second?user_id=asd&user_pw=1234&user_address=서울시%20종로구
			out.print("<br><br><a href='/Servlet02/second?user_id=" + user_id
							+ "&user_pw=" + user_pw
							+ "&user_address=" + user_address
							+"'>두 번째 서블릿으로 보내기</a>");
			data = "</body></html>";
	//		out.print(data);
		}else {
			out.println("로그인 하지 않았습니다.<br><br>");
			out.println("다시 로그인하세요.<br><br>");
			out.println("<a href='/Servlet02/login.html'>로그인 창으로 이동</a>");
		}
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
