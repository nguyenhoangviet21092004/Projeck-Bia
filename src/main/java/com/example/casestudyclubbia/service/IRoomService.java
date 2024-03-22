package com.example.casestudyclubbia.service;

import com.example.casestudyclubbia.model.Room;

import java.util.List;
import java.util.Optional;

public interface IRoomService {
    List<Room> getAll();
    Optional<Room> findById(int id);
    void save(Room room);
    void remove(Room room);


}
