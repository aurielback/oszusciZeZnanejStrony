package com.example.roomsandapartments.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "room_id"
    )
    private Long id;

    @Version
    private Long version;

    @Column(
            name = "area"
    )
    private double area;

    @Column(
            name = "standard_equipment"
    )
    private boolean standardEquipment;

    @Column(
            name = "special_equipment"
    )
    private boolean specialEquipment;

    @Column(
            name = "price"
    )
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "announcement_id")
    private Announcement announcement;

    public Room() {
    }

    public Room(Long version, double area, boolean standardEquipment, boolean specialEquipment, BigDecimal price, Announcement announcement) {
        this.version = version;
        this.area = area;
        this.standardEquipment = standardEquipment;
        this.specialEquipment = specialEquipment;
        this.price = price;
        this.announcement = announcement;
    }

    public Room(Long id, Long version, double area, boolean standardEquipment, boolean specialEquipment, BigDecimal price, Announcement announcement) {
        this.id = id;
        this.version = version;
        this.area = area;
        this.standardEquipment = standardEquipment;
        this.specialEquipment = specialEquipment;
        this.price = price;
        this.announcement = announcement;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean isStandardEquipment() {
        return standardEquipment;
    }

    public void setStandardEquipment(boolean standardEquipment) {
        this.standardEquipment = standardEquipment;
    }

    public boolean isSpecialEquipment() {
        return specialEquipment;
    }

    public void setSpecialEquipment(boolean specialEquipment) {
        this.specialEquipment = specialEquipment;
    }

}
