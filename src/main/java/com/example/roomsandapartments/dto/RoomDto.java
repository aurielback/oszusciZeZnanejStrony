package com.example.roomsandapartments.dto;

import com.example.roomsandapartments.model.Announcement;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class RoomDto {

    @JsonProperty("room_id")
    private Long id;

    @JsonProperty("area")
    private double area;

    @JsonProperty("standard_equipment")
    private boolean standardEquipment;

    @JsonProperty("special_equipment")
    private boolean specialEquipment;

    @JsonProperty("announcement_id")
    private Announcement announcement;

    @JsonProperty("price")
    private BigDecimal price;

    public RoomDto() {
    }

    public RoomDto(double area, boolean standardEquipment, boolean specialEquipment, Announcement announcement, BigDecimal price) {
        this.area = area;
        this.standardEquipment = standardEquipment;
        this.specialEquipment = specialEquipment;
        this.announcement = announcement;
        this.price = price;
    }

    public RoomDto(Long id, double area, boolean standardEquipment, boolean specialEquipment, Announcement announcement, BigDecimal price) {
        this.id = id;
        this.area = area;
        this.standardEquipment = standardEquipment;
        this.specialEquipment = specialEquipment;
        this.announcement = announcement;
        this.price = price;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
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
