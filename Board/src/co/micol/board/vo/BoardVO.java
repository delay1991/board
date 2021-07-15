package co.micol.board.vo;

import java.util.Date;

public class BoardVO {
	private String boardid;
	private String writer;
	private String title;
	private String subject;
	private Date date;
	private int hit;
	
	public BoardVO() { //jvm이 인자없으면 알아서 만들어줌~
	}

	
	public String getBoardid() {
		return boardid;
	}


	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	@Override
	public String toString() {
		System.out.println(boardid+" : "+writer+"\t"+title+"\t"+subject+"\t"+date+"\t"+hit);
		return null;
	}


	public void toString1() {
		System.out.println(subject);
		
	}
	
	
	
	
	
}
