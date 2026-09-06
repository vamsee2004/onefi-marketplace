package com.onefi.marketplace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onefi.marketplace.entity.Order;
import com.onefi.marketplace.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Create Order
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get All Orders
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get Order By ID
    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Order not found with id: " + id));
    }

    // Update Order
    @Override
    public Order updateOrder(Long id, Order order) {

        // Get existing order
        Order existingOrder = getOrderById(id);

        // Update only fields that are provided
        if (order.getQuantity() != null) {
            existingOrder.setQuantity(order.getQuantity());
        }

        if (order.getTotalAmount() != null) {
            existingOrder.setTotalAmount(order.getTotalAmount());
        }

        if (order.getStatus() != null) {
            existingOrder.setStatus(order.getStatus());
        }

        if (order.getOrderDate() != null) {
            existingOrder.setOrderDate(order.getOrderDate());
        }

        if (order.getProduct() != null) {
            existingOrder.setProduct(order.getProduct());
        }

        if (order.getProductVariant() != null) {
            existingOrder.setProductVariant(order.getProductVariant());
        }

        if (order.getEmiPlan() != null) {
            existingOrder.setEmiPlan(order.getEmiPlan());
        }

        // Save updated order
        return orderRepository.save(existingOrder);
    }

    // Delete Order
    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}