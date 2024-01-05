package com.example.roomsandapartments.model;

import com.example.roomsandapartments.enums.City;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "announcement_id"
    )
    private Long id;

    @Enumerated(EnumType.STRING)
    private City city;

    @Column(
            name = "rooms"
    )
    @OneToMany
    private List<Room> rooms = new ArrayList<>();

    public Announcement() {
    }

    public Announcement(City city, List<Room> rooms) {
        this.city = city;
        this.rooms = rooms;
    }

    public Announcement(Long id, City city, List<Room> rooms) {
        this.id = id;
        this.city = city;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
