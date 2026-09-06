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

import com.onefi.marketplace.entity.ProductVariant;
import com.onefi.marketplace.service.ProductVariantService;

@RestController
@RequestMapping("/api/variants")
public class ProductVariantController {

    private final ProductVariantService productVariantService;

    public ProductVariantController(ProductVariantService productVariantService) {
        this.productVariantService = productVariantService;
    }

    // Create a new variant
    @PostMapping
    public ResponseEntity<ProductVariant> createVariant(
            @RequestBody ProductVariant variant) {

        ProductVariant savedVariant =
                productVariantService.createVariant(variant);

        return new ResponseEntity<>(savedVariant, HttpStatus.CREATED);
    }

    // Get all variants
    @GetMapping
    public ResponseEntity<List<ProductVariant>> getAllVariants() {

        List<ProductVariant> variants =
                productVariantService.getAllVariants();

        return ResponseEntity.ok(variants);
    }

    // Get variant by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductVariant> getVariantById(
            @PathVariable Long id) {

        Optional<ProductVariant> variant =
                productVariantService.getVariantById(id);

        if (variant.isPresent()) {
            return ResponseEntity.ok(variant.get());
        }

        return ResponseEntity.notFound().build();
    }

    // Update variant
    @PutMapping("/{id}")
    public ResponseEntity<ProductVariant> updateVariant(
            @PathVariable Long id,
            @RequestBody ProductVariant variantDetails) {

        ProductVariant updatedVariant =
                productVariantService.updateVariant(id, variantDetails);

        return ResponseEntity.ok(updatedVariant);
    }

    // Delete variant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(
            @PathVariable Long id) {

        productVariantService.deleteVariant(id);

        return ResponseEntity.noContent().build();
    }
}