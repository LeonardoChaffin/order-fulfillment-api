package com.projectSB.projectSB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectSB.projectSB.entities.Product;
import com.projectSB.projectSB.repositories.ProductRepository;
import com.projectSB.projectSB.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	private final ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}