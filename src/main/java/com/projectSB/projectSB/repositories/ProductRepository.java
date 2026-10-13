package com.projectSB.projectSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectSB.projectSB.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
