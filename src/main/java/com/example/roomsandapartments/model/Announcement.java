package com.example.roomsandapartments.model;

import com.example.roomsandapartments.enums.City;
import jakarta.persistence.*;

import java.math.BigDecimal;
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

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    private City city;

    @Column(
            name = "rooms"
    )
    @OneToMany(mappedBy = "announcement")
    private List<Room> rooms = new ArrayList<>();

    @Column(
            name = "overall_price"
    )
    private BigDecimal overallPrice;

    public Announcement() {
    }

    public Announcement(Long version, City city, List<Room> rooms, BigDecimal overallPrice) {
        this.version = version;
        this.city = city;
        this.rooms = rooms;
        this.overallPrice = overallPrice;
    }

    public Announcement(Long id, Long version, City city, List<Room> rooms, BigDecimal overallPrice) {
        this.id = id;
        this.version = version;
        this.city = city;
        this.rooms = rooms;
        this.overallPrice = overallPrice;
    }

    public BigDecimal getOverallPrice() {
        return overallPrice;
    }

    public void setOverallPrice(BigDecimal overallPrice) {
        this.overallPrice = overallPrice;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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
