package com.onefi.marketplace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emi_plans")
public class EmiPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tenureMonths;

    private Double interestRate;

    private Double monthlyEmi;

    private Double processingFee;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public EmiPlan() {
    }

    public EmiPlan(Integer tenureMonths, Double interestRate,
                   Double monthlyEmi, Double processingFee,
                   Product product) {
        this.tenureMonths = tenureMonths;
        this.interestRate = interestRate;
        this.monthlyEmi = monthlyEmi;
        this.processingFee = processingFee;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTenureMonths() {
        return tenureMonths;
    }

    public void setTenureMonths(Integer tenureMonths) {
        this.tenureMonths = tenureMonths;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Double getMonthlyEmi() {
        return monthlyEmi;
    }

    public void setMonthlyEmi(Double monthlyEmi) {
        this.monthlyEmi = monthlyEmi;
    }

    public Double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(Double processingFee) {
        this.processingFee = processingFee;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}