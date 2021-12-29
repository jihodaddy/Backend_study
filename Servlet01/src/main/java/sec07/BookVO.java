package sec07;

import java.util.Date;

public class BookVO {

	private String bookNo;
	private String bookName;
	private String bookAuthor;
	private String bookPrice;
	private String bookDate;
	private String pubNo;
	
	// 생성자
	public BookVO() {}

	public BookVO(String bookNo, String bookName, String bookAuthor, String bookPrice, String bookDate, String pubNo) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookDate = bookDate;
		this.pubNo = pubNo;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getPubNo() {
		return pubNo;
	}

	public void setPubNo(String pubNo) {
		this.pubNo = pubNo;
	}

	
}