package org.adil.backend.messenger.model;

import java.util.Date;

public class Comment {
	
	private long commentId;
	private String comment;
	private Date createdDate;
	private String author;
	
	public Comment() {
		
	}
	public Comment(long commentId, String comment, String author) {
		
		this.commentId = commentId;
		this.comment = comment;
		this.createdDate = new Date();
		this.author = author;
	}
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
