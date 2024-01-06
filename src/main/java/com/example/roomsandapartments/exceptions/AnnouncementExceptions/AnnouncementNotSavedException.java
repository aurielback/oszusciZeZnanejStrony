package com.example.roomsandapartments.exceptions.AnnouncementExceptions;

public class AnnouncementNotSavedException extends RuntimeException{

    public AnnouncementNotSavedException(String s) {
        super("Announcement not saved! " + s);
    }
}
