package com.projectSB.projectSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectSB.projectSB.entities.OrderItem;
import com.projectSB.projectSB.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
