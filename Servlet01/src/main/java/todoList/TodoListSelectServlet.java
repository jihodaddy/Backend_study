package todoList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoListSelectServlet
 */
@WebServlet("/todoListSelect")
public class TodoListSelectServlet extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		
		todoDAO dao = new todoDAO();
		
		ArrayList<todoVO> todoList = dao.todoSelect();
		
		out.print("<html><head></head><body>");
		out.print("<table border='none'><tr align='center' bgcolor='lightgrey'>");
		out.print("<td>번호</td><td width='200px'>할일</td>");
		out.print("<td>체크</td><td>삭제</td></tr>");
	
		for(int i=0; i<todoList.size(); i++) {
			todoVO vo = (todoVO)todoList.get(i);
			
			String todoNo = vo.getTodoNo();
			String todoText = vo.getTodoText();
			
		out.print("<tr><td>"+ todoNo+ "</td><td>"+ todoText +
				"<td><input type='radio' value='체크'></td><td>"+
				"<a href='/Servlet01/todoDelete?todoNo=" + todoNo + "'>삭제</a></td></tr>");
			
		}
		out.print("</table><a href='todoForm.html'>처음으로</a></body></html>");
	}
	
	
}
