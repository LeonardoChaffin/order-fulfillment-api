package com.projectSB.projectSB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectSB.projectSB.entities.Order;
import com.projectSB.projectSB.repositories.OrderRepository;
import com.projectSB.projectSB.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	private final OrderRepository repository;

	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}

	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}