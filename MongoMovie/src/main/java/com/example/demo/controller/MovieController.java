package com.example.demo.controller;

import java.util.List;	
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Director;
import com.example.demo.repository.MovieRepository;

@RestController
public class MovieController {
	
	@Autowired
	private MovieRepository repository;

	@PostMapping(path ="/addmovie")
	public String savemovie(@RequestBody Director ex) {
		 repository.insert(ex);
		 return "Success";
		
	}

	@PutMapping(path ="/update")
	public String update(@RequestBody Director ex) {
		repository.save(ex);
		return "updated";
	}

	@GetMapping("/getall")
	public List<Director> getmovies(){
	return repository.findAll(); }
	
	@GetMapping("/getmovie")
	public void geterror(){
		throw new RuntimeException("Cannot be null");
	}
	
	@GetMapping("/getmovie/{id}")
	public Optional<Director> getmovie(@PathVariable int id){
	
		return repository.findById(id);
	}
	
	@GetMapping("/getbyname")
	public void getnamerror(){
		throw new RuntimeException("Name cannot be null");
	}
	@GetMapping("/getbyname/{name}")
	public List<Director> searchName(@PathVariable final String name){
	return repository.findByName(name);
	}

	@DeleteMapping("/deleteid/{id}")
	public String deletemovie(@PathVariable int id){
		 repository.deleteById(id);
		 return "Movie name deleted : " +id;
	}
}