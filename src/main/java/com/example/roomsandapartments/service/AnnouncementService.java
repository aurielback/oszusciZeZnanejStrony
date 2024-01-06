package com.example.roomsandapartments.service;

import com.example.roomsandapartments.dto.AnnouncementDto;
import com.example.roomsandapartments.exceptions.AnnouncementNotFoundException;
import com.example.roomsandapartments.model.Announcement;
import com.example.roomsandapartments.model.Room;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementService {

    /**
     * Add announcement to database
     * @param announcementDto transfer object of Announcement entity
     */

    public void addAnnouncement(AnnouncementDto announcementDto);

    /**
     * get all announcements from database
     * @return AnnouncementDto
     */
    public List<AnnouncementDto> getAllAnnouncements();

    /**
     * get announcement by id
     * @param id announcement's id
     * @return optional Announcement
     */
    public AnnouncementDto findAnnouncementById(Long id);

    /**
     * delete announcement by id
     * @param id announcement's id
     */
    public void deleteAnnouncementById(Long id);

    /**
     * update announcement
     * @param announcementDto given changes
     * @param id announcement's id
     */
    public void updateAnnouncement(AnnouncementDto announcementDto, Long id);

}
