package sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BookDAO {

	private Connection connDB() {
		Connection con = null;
		
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				String url = "jdbc:mysql://localhost:3306/servletdb?serverTimezone=UTC";
				String user = "root";
				String pwd = "1234";
				
				con = DriverManager.getConnection(url, user, pwd);

				if(con != null) {
					System.out.println("DB 연동 성공");
						
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return con;
	}
	
	//book 정보 조회
	public ArrayList<BookVO> bookSelect(){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
			try {
				con = connDB();
				
				String query = "SELECT * FROM servletdb.book;;";
				pstmt = con.prepareStatement(query);
				rs= pstmt.executeQuery();
				
				while(rs.next()) {	//결과 세트에서 한 행씩 처리
					String bookNo = rs.getString("bookNo");
					String bookName = rs.getString("bookName");
					String bookAuthor =rs.getString("bookAuthor");
					int bookPrice = rs.getInt("bookPrice");
					Date bookDate = rs.getDate("bookDate");
					String pubNo = rs.getString("pubNo");
					
					BookVO vo = new BookVO();
					vo.setBookNo(bookNo);
					vo.setBookName(bookName);
					vo.setBookAuthor(bookAuthor);
					vo.setBookPrice(bookPrice);
					vo.setBookDate(bookDate);
					vo.setPubNo(pubNo);
					
					bookList.add(vo);
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
			
			return bookList;
	}
	
	
	
}


