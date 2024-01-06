package com.example.roomsandapartments.exceptions.RoomExceptions;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(Long id) {
        super("Room not found with id " + id);
    }
}
