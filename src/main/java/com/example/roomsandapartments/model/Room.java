package com.example.roomsandapartments.model;

import jakarta.persistence.*;

@Entity(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "room_id"
    )
    private Long id;

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

    public Room() {
    }

    public Room(double area, boolean standardEquipment, boolean specialEquipment) {
        this.area = area;
        this.standardEquipment = standardEquipment;
        this.specialEquipment = specialEquipment;
    }

    public Room(Long id, double area, boolean standardEquipment, boolean specialEquipment) {
        this.id = id;
        this.area = area;
        this.standardEquipment = standardEquipment;
        this.specialEquipment = specialEquipment;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
