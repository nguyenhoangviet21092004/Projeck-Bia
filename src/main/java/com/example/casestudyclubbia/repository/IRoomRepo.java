package com.example.casestudyclubbia.repository;

import com.example.casestudyclubbia.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepo extends JpaRepository<Room,Integer> {
}
