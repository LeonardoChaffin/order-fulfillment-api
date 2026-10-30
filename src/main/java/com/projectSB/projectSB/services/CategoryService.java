package com.projectSB.projectSB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectSB.projectSB.entities.Category;
import com.projectSB.projectSB.repositories.CategoryRepository;
import com.projectSB.projectSB.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	private final CategoryRepository repository;

	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}

	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}