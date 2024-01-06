package com.example.roomsandapartments.dto;

import com.example.roomsandapartments.enums.City;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementDto {

    @JsonProperty("announcement_id")
    private Long id;

    @JsonProperty("city")
    private City city;

    @JsonProperty("rooms")
    private List<RoomDto> rooms = new ArrayList<>();

    public AnnouncementDto() {
    }

    public AnnouncementDto(City city, List<RoomDto> rooms) {
        this.city = city;
        this.rooms = rooms;
    }

    public AnnouncementDto(Long id, City city, List<RoomDto> rooms) {
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

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
