package com.onefi.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onefi.marketplace.entity.ProductVariant;
import com.onefi.marketplace.repository.ProductVariantRepository;

@Service
public class ProductVariantService {

    private final ProductVariantRepository productVariantRepository;

    public ProductVariantService(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

    public ProductVariant createVariant(ProductVariant variant) {
        return productVariantRepository.save(variant);
    }

    public List<ProductVariant> getAllVariants() {
        return productVariantRepository.findAll();
    }

    public Optional<ProductVariant> getVariantById(Long id) {
        return productVariantRepository.findById(id);
    }

    public ProductVariant updateVariant(Long id, ProductVariant variantDetails) {

        ProductVariant variant = productVariantRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Product variant not found with id: " + id));

        variant.setVariantName(variantDetails.getVariantName());
        variant.setColor(variantDetails.getColor());
        variant.setStorage(variantDetails.getStorage());
        variant.setPrice(variantDetails.getPrice());
        variant.setStock(variantDetails.getStock());

        return productVariantRepository.save(variant);
    }

    public void deleteVariant(Long id) {
        productVariantRepository.deleteById(id);
    }
}