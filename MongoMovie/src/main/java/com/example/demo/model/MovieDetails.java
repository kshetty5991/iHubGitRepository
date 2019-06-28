package com.example.demo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDetails {
	
	private int movid;  
	private String movtitle;
	private Date datereleased;
	public int getMovid() {
		return movid;
	}
	public void setMovid(int movid) {
		this.movid = movid;
	}
	public String getMovtitle() {
		return movtitle;
	}
	public void setMovtitle(String movtitle) {
		this.movtitle = movtitle;
	}
	public Date getDatereleased() {
		return datereleased;
	}
	public void setDatereleased(Date datereleased) {
		this.datereleased = datereleased;
	}
	public MovieDetails(int movid, String movtitle, Date datereleased) {
		super();
		this.movid = movid;
		this.movtitle = movtitle;
		this.datereleased = datereleased;
	}
	
}
