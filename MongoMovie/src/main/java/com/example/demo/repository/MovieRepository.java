package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Director;


public interface MovieRepository extends MongoRepository<Director, Integer> {

	List<Director> findByName(String name);
}
