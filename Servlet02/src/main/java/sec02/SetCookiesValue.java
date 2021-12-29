package sec02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookiesValue
 */
@WebServlet("/setCookie")
public class SetCookiesValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		//Cookie객체 생성한 후 cookieTest 이름으로 한글 정보를 인코딩해서 쿠키에 저장
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("Cookie테스트2 입니다.","utf-8")); // 인코딩 안 하면 오류
//		Cookie cookie = new Cookie("cookieTest", "Cookie테스트2 입니다.");
//		cookie.setMaxAge(24*60*60);	//유효기간 설정
		cookie.setMaxAge(-1);	//Session 쿠키로 설정(음수값)":브라우저 종료되면 쿠키 만료
		response.addCookie(cookie);	//생성한 쿠키를 브라우저로 전송해서 저장
		out.println("현재시간: " + d);
		out.println("<br>Cookie에 저장");
		
		
	}

}
