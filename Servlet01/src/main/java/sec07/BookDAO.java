package sec07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAO {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	DataSource dataSource = null;
	
	public BookDAO() {
		
		try {
			Context init = new InitialContext();
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DB연결 성공");
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//book 정보 조회
	public ArrayList<BookVO> bookSelect(){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
			try {
				con = dataSource.getConnection();
				
				String query = "select * from book;";
				pstmt = con.prepareStatement(query);
				rs= pstmt.executeQuery();
				
				while(rs.next()) {	//결과 세트에서 한 행씩 처리
					String bookNo = rs.getString("bookNo");
					String bookName = rs.getString("bookName");
					String bookAuthor =rs.getString("bookAuthor");
					String bookPrice = rs.getString("bookPrice");
					String bookDate = rs.getString("bookDate");
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
	
	// BookInsert 메서드	
			public void bookInsert(BookVO vo) {
				
				try {
					con = dataSource.getConnection();
					//sql 문 작성
					String sql = "insert into book values(?, ?, ?, ?, ?, ?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					
					//sql 전달할 pstmt 객체 생성
					pstmt.setString(1, vo.getBookNo());
					pstmt.setString(2, vo.getBookName());
					pstmt.setString(3, vo.getBookAuthor());
					pstmt.setString(4, vo.getBookPrice());
					pstmt.setString(5, vo.getBookDate());
					pstmt.setString(6, vo.getPubNo());
					
		//쿼리문 실행 executeUpdate()
					int result = pstmt.executeUpdate(); 
					
					if(result > 0) {
						System.out.println("도서정보 입력 성공!");
					}
					pstmt.close();
					con.close();
									
				} catch (Exception e) {
					System.out.println("오류발생");
					e.printStackTrace();
				}
				
			}
	
			public void bookDelete(String bookNo ) {
				
				try {
					con = dataSource.getConnection();
					
					String sql = "delete from book where bookNo=?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, bookNo); 
					
					// 쿼리문 실행 : 영향을 받은 행의 수 반환
					//select : executeQuery - 결과 행 resultSet 반환.
					//insert / update / delete : executeUpdate() - 영향을 받은 행의 수 반환
					int result = pstmt.executeUpdate();
					
					if(result > 0) {
						System.out.println("도서 정보 삭제 성공!");
					}
					
					// 모든 객체 close() : 리소스 반납	
					pstmt.close();
					con.close();			
					
				} catch (Exception e) {
					System.out.println("오류 발생!");
					e.printStackTrace();
				}		
			}

			
			
	}


