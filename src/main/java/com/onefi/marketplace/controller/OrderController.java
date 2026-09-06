package com.onefi.marketplace.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onefi.marketplace.entity.Order;
import com.onefi.marketplace.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // =========================
    // CREATE ORDER
    // =========================

    @PostMapping
    public ResponseEntity<Order> createOrder(
            @RequestBody Order order) {

        Order savedOrder =
                orderService.createOrder(order);

        return ResponseEntity.ok(savedOrder);
    }


    // =========================
    // GET ALL ORDERS
    // =========================

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {

        List<Order> orders =
                orderService.getAllOrders();

        return ResponseEntity.ok(orders);
    }


    // =========================
    // GET ORDER BY ID
    // =========================

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(
            @PathVariable Long id) {

        try {

            Order order =
                    orderService.getOrderById(id);

            return ResponseEntity.ok(order);

        } catch (RuntimeException e) {

            return ResponseEntity.notFound().build();
        }
    }


    // =========================
    // UPDATE ORDER
    // =========================

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable Long id,
            @RequestBody Order order) {

        try {

            Order updatedOrder =
                    orderService.updateOrder(
                            id,
                            order
                    );

            return ResponseEntity.ok(updatedOrder);

        } catch (RuntimeException e) {

            return ResponseEntity.notFound().build();
        }
    }


    // =========================
    // DELETE ORDER
    // =========================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(
            @PathVariable Long id) {

        try {

            orderService.deleteOrder(id);

            return ResponseEntity.ok(
                    "Order deleted successfully"
            );

        } catch (RuntimeException e) {

            return ResponseEntity.notFound().build();
        }
    }
}