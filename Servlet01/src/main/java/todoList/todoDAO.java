package todoList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class todoDAO {

		private Connection con = null;
		private PreparedStatement pstmt = null;
		DataSource dataSource = null;
		
		public todoDAO() {
			
			try {
				Context init = new InitialContext();
				dataSource = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
				System.out.println("DB연결 성공");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//todolist 조회
			
			public ArrayList<todoVO> todoSelect(){
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				ArrayList<todoVO> todoList = new ArrayList<todoVO>();
				
				try {
					con = dataSource.getConnection();
					
					String query = "select * from todolist;";
					pstmt = con.prepareStatement(query);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						String todoNo = rs.getString("todoNo");
						String todoText = rs.getString("todoText");
						
						todoVO vo = new todoVO();
						vo.setTodoNo(todoNo);
						vo.setTodoText(todoText);
						
						todoList.add(vo);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					
					try {
						rs.close();
						pstmt.close();
						con.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				return todoList;
			}	
			//todoInsert 메서드
			public void todoInsert(todoVO vo) {
				
				try {
					con=dataSource.getConnection();
					
					String sql = "insert into todoList (todoText) values (?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, vo.getTodoText());
					
					int result = pstmt.executeUpdate();
					
					if(result > 0) {
						System.out.println(" 할일 입력 성공");
					}
					pstmt.close();
					con.close();
					
				} catch (Exception e) {
					System.out.println("오류발생");
					e.printStackTrace();
				}
				
				
			}

			public void todoDelete(String todoNo) {
				
				try {
					con = dataSource.getConnection();
					
					String sql = "delete from todolist where todoNo=?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, todoNo);
					
					int result = pstmt.executeUpdate();
					
					if(result>0) {
						System.out.println("할일 목록 삭제!");
					}
					pstmt.close();
					con.close();
	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
				
}
