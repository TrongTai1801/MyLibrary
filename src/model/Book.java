package model;

public class Book {
	private int id; 
	private String name;
	private String author;
	private String content;
	private String publicTime;
	private int total;
	
	public Book() {
		super();
		this.id = 0;
		this.name = "";
		this.author = "";
		this.content = "";
		this.publicTime = "";
		this.total = 0;
	}
	
	public Book(int id, String name, String author, String content, String publicTime, int total) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.content = content;
		this.publicTime = publicTime;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublicTime() {
		return publicTime;
	}

	public void setPublicTime(String publicTime) {
		this.publicTime = publicTime;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", content=" + content + ", publicTime="
				+ publicTime + ", total=" + total + "]";
	}
	
}
