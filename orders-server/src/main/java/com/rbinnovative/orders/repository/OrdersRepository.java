package com.rbinnovative.orders.repository;

import com.rbinnovative.orders.model.dao.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    public List<Orders> findByUserId(String userId);
}
