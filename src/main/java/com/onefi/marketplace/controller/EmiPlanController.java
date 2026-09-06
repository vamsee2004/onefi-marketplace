package com.onefi.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onefi.marketplace.entity.EmiPlan;
import com.onefi.marketplace.entity.Product;
import com.onefi.marketplace.service.EmiPlanService;
import com.onefi.marketplace.service.ProductService;

@RestController
@RequestMapping("/api/emi-plans")
public class EmiPlanController {

    private final EmiPlanService emiPlanService;
    private final ProductService productService;

    public EmiPlanController(
            EmiPlanService emiPlanService,
            ProductService productService) {

        this.emiPlanService = emiPlanService;
        this.productService = productService;
    }

    // Create EMI Plan
    @PostMapping
    public ResponseEntity<EmiPlan> createEmiPlan(
            @RequestBody EmiPlan emiPlan) {

        EmiPlan savedPlan = emiPlanService.createEmiPlan(emiPlan);

        return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);
    }

    // Get all EMI Plans
    @GetMapping
    public ResponseEntity<List<EmiPlan>> getAllEmiPlans() {

        List<EmiPlan> plans = emiPlanService.getAllEmiPlans();

        return ResponseEntity.ok(plans);
    }

    // Get EMI Plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmiPlan> getEmiPlanById(
            @PathVariable Long id) {

        Optional<EmiPlan> plan =
                emiPlanService.getEmiPlanById(id);

        if (plan.isPresent()) {
            return ResponseEntity.ok(plan.get());
        }

        return ResponseEntity.notFound().build();
    }

    // Get EMI Plans for a Product
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<EmiPlan>> getEmiPlansByProduct(
            @PathVariable Long productId) {

        Optional<Product> product =
                productService.getProductById(productId);

        if (product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<EmiPlan> plans =
                emiPlanService.getEmiPlansByProduct(product.get());

        return ResponseEntity.ok(plans);
    }

    // Update EMI Plan
    @PutMapping("/{id}")
    public ResponseEntity<EmiPlan> updateEmiPlan(
            @PathVariable Long id,
            @RequestBody EmiPlan emiPlanDetails) {

        EmiPlan updatedPlan =
                emiPlanService.updateEmiPlan(id, emiPlanDetails);

        return ResponseEntity.ok(updatedPlan);
    }

    // Delete EMI Plan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmiPlan(
            @PathVariable Long id) {

        emiPlanService.deleteEmiPlan(id);

        return ResponseEntity.noContent().build();
    }
}