package org.adil.backend.messenger.resources.beans;

import jakarta.ws.rs.QueryParam;

public class MessageFilterBean {
	@QueryParam("start") private int start;
	@QueryParam("size") private int size;
	@QueryParam("year") private int year;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
