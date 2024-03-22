package com.example.casestudyclubbia.service.ipl;

import com.example.casestudyclubbia.model.PoolTable;
import com.example.casestudyclubbia.repository.IPoolRepo;
import com.example.casestudyclubbia.service.IPoolTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoolTableService implements IPoolTableService {
    @Autowired
    private IPoolRepo iPoolRepo;

    @Override
    public List<PoolTable> getAll() {
        return iPoolRepo.findAll();
    }

    @Override
    public Optional<PoolTable> findById(int id) {
        return iPoolRepo.findById(id);
    }

    @Override
    public void save(PoolTable poolTable) {
        iPoolRepo.save(poolTable);
    }

    @Override
    public void remove(PoolTable poolTable) {
        iPoolRepo.delete(poolTable);
    }
}
