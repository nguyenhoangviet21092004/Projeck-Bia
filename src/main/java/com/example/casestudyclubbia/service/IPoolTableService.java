package com.example.casestudyclubbia.service;

import com.example.casestudyclubbia.model.PoolTable;
import com.example.casestudyclubbia.model.Room;

import java.util.List;
import java.util.Optional;

public interface IPoolTableService {
    List<PoolTable> getAll();
    Optional<PoolTable> findById(int id);
    void save(PoolTable poolTable);
    void remove(PoolTable poolTable);
}
