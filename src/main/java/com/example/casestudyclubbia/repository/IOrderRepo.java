package com.example.casestudyclubbia.repository;

import com.example.casestudyclubbia.model.Order;
import com.example.casestudyclubbia.model.PoolTable;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepo  extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order as o WHERE o.poolTable.id = ?1  ")
    List<Order> getAllOrder(int id );
}
