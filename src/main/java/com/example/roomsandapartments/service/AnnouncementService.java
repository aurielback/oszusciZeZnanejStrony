package com.example.roomsandapartments.service;

import com.example.roomsandapartments.dto.AnnouncementDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementService {

    /**
     * Add announcement to database
     *
     * @param announcementDto transfer object of Announcement entity
     */

    void addAnnouncement(AnnouncementDto announcementDto);

    /**
     * get all announcements from database
     *
     * @return AnnouncementDto
     */
    List<AnnouncementDto> getAllAnnouncements();

    /**
     * get announcement by id
     *
     * @param id announcement's id
     * @return optional Announcement
     */
    AnnouncementDto findAnnouncementById(Long id);

    /**
     * delete announcement by id
     *
     * @param id announcement's id
     */
    void deleteAnnouncementById(Long id);

    /**
     * update announcement
     *
     * @param announcementDto given changes
     * @param id              announcement's id
     */
    void updateAnnouncement(AnnouncementDto announcementDto, Long id);

}
