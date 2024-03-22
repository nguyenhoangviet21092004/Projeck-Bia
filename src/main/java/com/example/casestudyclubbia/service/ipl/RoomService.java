package com.example.casestudyclubbia.service.ipl;

import com.example.casestudyclubbia.model.Room;
import com.example.casestudyclubbia.repository.IRoomRepo;
import com.example.casestudyclubbia.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private IRoomRepo iRoomRepo;


    @Override
    public List<Room> getAll() {
        return iRoomRepo.findAll();
    }

    @Override
    public Optional<Room> findById(int id) {
        return iRoomRepo.findById(id);
    }

    @Override
    public void save(Room room) {
        iRoomRepo.save(room);
    }

    @Override
    public void remove(Room room) {
        iRoomRepo.delete(room);
    }
}
