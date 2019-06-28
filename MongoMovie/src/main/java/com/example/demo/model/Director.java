package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection ="ExpressMovie")
public class Director {
	@Id
	private int id;
	//private String fname;
	private String name;
	private String address;
	private int number;
	private String email;
	private List<MovieDetails> mov;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<MovieDetails> getMov() {
		return mov;
	}
	public void setMov(List<MovieDetails> mov) {
		this.mov = mov;
	}
	public Director(int id, String name, String address, int number, String email, List<MovieDetails> mov) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.email = email;
		this.mov = mov;
	}
	
	}

	