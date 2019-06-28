package com.kaushik.Megamart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.kaushik.Megamart.model.Register;

public interface RegisterRepository extends JpaRepository<Register, String> {

}
	