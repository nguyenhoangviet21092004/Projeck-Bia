package com.example.casestudyclubbia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "poolTable")
public class PoolTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String status;


    public PoolTable(int id, String name, String status, Room room) {
        this.id = id;
        this.name = name;
        this.status = status;
    }


    @ManyToOne
    @JoinColumn(name = "idRoom")
    private Room room;

    public PoolTable() {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
