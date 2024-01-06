package com.example.roomsandapartments.exceptions.AnnouncementExceptions;

public class AnnouncementNotFoundException extends RuntimeException {

    public AnnouncementNotFoundException(Long id) {
        super("Announcement not found with id " + id);
    }
}
