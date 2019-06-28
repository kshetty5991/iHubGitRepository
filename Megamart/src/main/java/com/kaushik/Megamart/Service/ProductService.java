package com.kaushik.Megamart.Service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaushik.Megamart.model.Products;
import com.kaushik.Megamart.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired ProductRepository repo;
	
	public List<Products> listAll() {
        return (List<Products>) repo.findAll();
    }
	
	public List<Products> search(String keyword) {
	    return repo.search(keyword);
	}
	private List<Products> products;

	public  Products find(String id) {
		for (Products product : this.products) {
			if (product.getId().equalsIgnoreCase(id)){
				return product;
			}
		}
		return null;
	}
}
