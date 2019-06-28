package com.kaushik.Megamart.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kaushik.Megamart.model.Products;

public interface ProductRepository extends CrudRepository<Products, Integer>{

	@Query(value = "SELECT c FROM Products c WHERE c.name LIKE '%' || :keyword || '%'")
    public List<Products> search(@Param("keyword") String keyword);
}


