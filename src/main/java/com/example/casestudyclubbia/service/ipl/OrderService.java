package com.example.casestudyclubbia.service.ipl;

import com.example.casestudyclubbia.model.Order;
import com.example.casestudyclubbia.repository.IOrderRepo;
import com.example.casestudyclubbia.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepo iOrderRepo;

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Optional<Order> findById(int id) {
        return iOrderRepo.findById(id);
    }

    @Override
    public void save(Order order) {
        iOrderRepo.save(order);
    }

    @Override
    public void remove(Order order) {

    }
}
