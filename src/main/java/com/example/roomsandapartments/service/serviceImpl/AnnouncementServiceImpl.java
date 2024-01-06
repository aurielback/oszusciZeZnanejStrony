package com.example.roomsandapartments.service.serviceImpl;

import com.example.roomsandapartments.dto.AnnouncementDto;
import com.example.roomsandapartments.exceptions.AnnouncementNotFoundException;
import com.example.roomsandapartments.mappers.AnnouncementMapper;
import com.example.roomsandapartments.mappers.RoomMapper;
import com.example.roomsandapartments.model.Announcement;
import com.example.roomsandapartments.model.Room;
import com.example.roomsandapartments.repository.AnnouncementRepository;
import com.example.roomsandapartments.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl {

    private final AnnouncementRepository announcementRepository;
    private final RoomRepository roomRepository;
    private final AnnouncementMapper announcementMapper;
    private final RoomMapper roomMapper;

    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository, RoomRepository roomRepository, AnnouncementMapper announcementMapper, RoomMapper roomMapper) {
        this.announcementRepository = announcementRepository;
        this.roomRepository = roomRepository;
        this.announcementMapper = announcementMapper;
        this.roomMapper = roomMapper;
    }

    /**
     * Add announcement to database
     * @param announcementDto transfer object of Announcement entity
     */
    @Transactional
    public void addAnnouncement(AnnouncementDto announcementDto) {
        Announcement announcementEntity = announcementMapper.announcementDtoToAnnouncementEntity(announcementDto);
        roomRepository.saveAll(announcementEntity.getRooms());
        announcementRepository.save(announcementEntity);
    }

    /**
     * get all announcements from database
     * @return AnnouncementDto
     */
    public List<AnnouncementDto> getAllAnnouncements() {
        return announcementRepository.findAll().stream().map(
                announcementMapper::announcementEntityToAnnouncementDto
        ).toList();
    }

    /**
     * get announcement by id
     * @param id announcement's id
     * @return optional Announcement
     */
    public AnnouncementDto findAnnouncementById(Long id) {
        Announcement announcement = announcementRepository.findById(id).orElseThrow(() -> new AnnouncementNotFoundException(id));
        return announcementMapper.announcementEntityToAnnouncementDto(announcement);
    }

    /**
     * delete announcement by id
     * @param id announcement's id
     */
    public void deleteAnnouncementById(Long id) {
        Announcement announcement = announcementRepository.findById(id).orElseThrow(() -> new AnnouncementNotFoundException(id));
        announcementRepository.delete(announcement);
    }

    /**
     * update announcement
     * @param announcementDto given changes
     * @param id announcement's id
     */
    public void updateAnnouncement(AnnouncementDto announcementDto, Long id) {
        Announcement announcement = announcementRepository.findById(id).orElseThrow(() -> new AnnouncementNotFoundException(id));
        announcement.setCity(announcementDto.getCity());
        List<Room> roomsList = announcementDto.getRooms().stream()
                .map(roomMapper::roomDtoToRoomEntity).toList();

        announcement.setRooms(roomsList);
        announcementRepository.save(announcement);
    }

}
