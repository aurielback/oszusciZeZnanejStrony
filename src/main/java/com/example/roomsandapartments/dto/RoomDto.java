package com.example.roomsandapartments.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomDto {

    @JsonProperty("room_id")
    private Long id;

    @JsonProperty("area")
    private double area;

    @JsonProperty("standard_equipment")
    private boolean standardEquipment;

    @JsonProperty("special_equipment")
    private boolean specialEquipment;


    public RoomDto() {
    }

    public RoomDto(double area, boolean standardEquipment, boolean specialEquipment) {
        this.area = area;
        this.standardEquipment = standardEquipment;
        this.specialEquipment = specialEquipment;
    }

    public RoomDto(Long id, double area, boolean standardEquipment, boolean specialEquipment) {
        this.id = id;
        this.area = area;
        this.standardEquipment = standardEquipment;
        this.specialEquipment = specialEquipment;
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
