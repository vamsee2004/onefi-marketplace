package com.onefi.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefi.marketplace.entity.ProductVariant;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {

}