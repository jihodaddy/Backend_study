package sec07;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec06.MemberDAO;

/**
 * Servlet implementation class BookDeleteServlet
 */
@WebServlet("/bookDelete")
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String bookNo = request.getParameter("bookNo");
		
		BookDAO dao = new BookDAO();
		dao.bookDelete(bookNo);
		
		// select 결과 페이지로 포워딩
		response.sendRedirect("bookSelect2");
		
		
	}
}
