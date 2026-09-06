package com.onefi.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefi.marketplace.entity.EmiPlan;
import com.onefi.marketplace.entity.Product;

public interface EmiPlanRepository extends JpaRepository<EmiPlan, Long> {

    List<EmiPlan> findByProduct(Product product);
}