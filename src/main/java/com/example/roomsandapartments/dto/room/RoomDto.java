package com.example.roomsandapartments.dto.room;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomDto {
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
