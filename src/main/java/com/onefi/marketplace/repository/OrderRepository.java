package com.onefi.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefi.marketplace.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}