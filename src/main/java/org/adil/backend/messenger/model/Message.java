package org.adil.backend.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private long messageId;
	private String message;
	private String author;
	private Date createdDate;
	
	public Message() {
		
	}
	
	
	public Message(long messageId, String message, String author) {
		super();
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
}
