package com.example.roomsandapartments.exceptions.RoomExceptions;

public class RoomNotSavedException extends RuntimeException {
    public RoomNotSavedException(String string) {
        super("Room not saved! " + string);
    }

}
