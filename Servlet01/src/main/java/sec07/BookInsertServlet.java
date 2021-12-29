package sec07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class BookInsertServlet
 */
@WebServlet("/bookInsert2")
public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //ctrl + shift + o
		//insert 메소드
		// 요청 받으면서 데이터 전달 받음
		String bookNo = request.getParameter("bookNo");
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		String  bookPrice = request.getParameter("bookPrice");
		String bookDate = request.getParameter("bookDate");
		String pubNo = request.getParameter("pubNo");
		
		//MemberVO 에 저장
		BookVO vo = new BookVO();
		vo.setBookNo(bookNo);
		vo.setBookName(bookName);
		vo.setBookAuthor(bookAuthor);
		vo.setBookPrice(bookPrice);
		vo.setBookDate(bookDate);
		vo.setPubNo(pubNo);
		
		//또는 생성자 사용
		//BookVO vo = new BookVO (bookNo, bookName, bookAuthor, bookPrice, bookDate, PubNo );
		
		//회원 정보 등록: MemberInsert() 호출 - > db에 저장
		BookDAO dao = new BookDAO();
		dao.bookInsert(vo);
		
		// select 결과 페이지로 포워딩
		response.sendRedirect("bookSelect2");
	}

}
