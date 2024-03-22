package com.example.casestudyclubbia.service;

import com.example.casestudyclubbia.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> getAll();
    Optional<Order> findById(int id);
    void save(Order order);
    void remove(Order order);
}
