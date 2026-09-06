package com.onefi.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefi.marketplace.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}