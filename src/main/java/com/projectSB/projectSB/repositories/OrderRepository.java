package com.projectSB.projectSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectSB.projectSB.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
