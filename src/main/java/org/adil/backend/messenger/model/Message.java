package org.adil.backend.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import jakarta.json.bind.annotation.JsonbTransient;

@XmlRootElement
public class Message {
	private long messageId;
	private String message;
	private String author;
	private Date createdDate;
	private Map<Long, Comment> comments = new HashMap<>();

	public Message() {

	}

	/*
	 * public Message(long messageId, String message, String author) { super();
	 * this.messageId = messageId; this.message = message; this.author = author;
	 * this.createdDate = new Date(); }
	 */

	/*
	 * public Message(long messageId, String message, String author, Date
	 * createdDate, Map<Long, Comment> comments) { super(); this.messageId =
	 * messageId; this.message = message; this.author = author; this.createdDate =
	 * new Date(); this.comments = comments; }
	 */
	
	public Message(long messageId, String message, String author) {
    	this.messageId = messageId;
    	this.message = message;
    	this.author = author;
    	this.createdDate = new Date();
    }
	
	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@JsonbTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

}
