package com.example.casestudyclubbia.repository;

import com.example.casestudyclubbia.model.PoolTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPoolRepo extends JpaRepository<PoolTable, Integer> {


    @Query("SELECT p FROM PoolTable as p WHERE p.room.id = ?1 ")
    Page<PoolTable> getAllById(int id , Pageable pageable);



}
