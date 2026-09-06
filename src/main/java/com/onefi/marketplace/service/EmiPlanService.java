package com.onefi.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onefi.marketplace.entity.EmiPlan;
import com.onefi.marketplace.entity.Product;
import com.onefi.marketplace.repository.EmiPlanRepository;

@Service
public class EmiPlanService {

    private final EmiPlanRepository emiPlanRepository;

    public EmiPlanService(EmiPlanRepository emiPlanRepository) {
        this.emiPlanRepository = emiPlanRepository;
    }

    // Create EMI Plan
    public EmiPlan createEmiPlan(EmiPlan emiPlan) {
        return emiPlanRepository.save(emiPlan);
    }

    // Get all EMI Plans
    public List<EmiPlan> getAllEmiPlans() {
        return emiPlanRepository.findAll();
    }

    // Get EMI Plan by ID
    public Optional<EmiPlan> getEmiPlanById(Long id) {
        return emiPlanRepository.findById(id);
    }

    // Get EMI Plans for a Product
    public List<EmiPlan> getEmiPlansByProduct(Product product) {
        return emiPlanRepository.findByProduct(product);
    }

    // Update EMI Plan
    public EmiPlan updateEmiPlan(Long id, EmiPlan emiPlanDetails) {

        EmiPlan emiPlan = emiPlanRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("EMI plan not found with id: " + id));

        emiPlan.setTenureMonths(emiPlanDetails.getTenureMonths());
        emiPlan.setInterestRate(emiPlanDetails.getInterestRate());
        emiPlan.setMonthlyEmi(emiPlanDetails.getMonthlyEmi());
        emiPlan.setProcessingFee(emiPlanDetails.getProcessingFee());
        emiPlan.setProduct(emiPlanDetails.getProduct());

        return emiPlanRepository.save(emiPlan);
    }

    // Delete EMI Plan
    public void deleteEmiPlan(Long id) {
        emiPlanRepository.deleteById(id);
    }
}