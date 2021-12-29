package todoList;

public class todoVO {

	private String todoNo;
	private String todoText;
	
	public todoVO() {}

	public todoVO(String todoNo, String todoText) {
		this.todoNo = todoNo;
		this.todoText = todoText;
	}

	public String getTodoNo() {
		return todoNo;
	}

	public void setTodoNo(String todoNo) {
		this.todoNo = todoNo;
	}

	public String getTodoText() {
		return todoText;
	}

	public void setTodoText(String todoText) {
		this.todoText = todoText;
	}
	
	
}
