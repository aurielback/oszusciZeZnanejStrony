package com.example.roomsandapartments.service;

import com.example.roomsandapartments.dto.AnnouncementDto;
import com.example.roomsandapartments.dto.RoomDto;
import com.example.roomsandapartments.enums.City;
import com.example.roomsandapartments.mappers.AnnouncementMapper;
import com.example.roomsandapartments.mappers.RoomMapper;
import com.example.roomsandapartments.model.Announcement;
import com.example.roomsandapartments.repository.AnnouncementRepository;
import com.example.roomsandapartments.repository.RoomRepository;
import com.example.roomsandapartments.service.serviceImpl.AnnouncementServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AnnouncementServiceTest {

    @Mock
    private AnnouncementRepository announcementRepository;

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private RoomMapper roomMapper;

    @Mock
    private AnnouncementMapper announcementMapper;

    @InjectMocks
    private AnnouncementServiceImpl announcementService;

    @Test
    public void addAnnouncement() {
        // Given
        long id1 = 1L;
        RoomDto roomDto1 = new RoomDto();
        roomDto1.setId(id1);
        roomDto1.setArea(23);
        roomDto1.setSpecialEquipment(false);
        roomDto1.setStandardEquipment(true);

        long id2 = 2L;
        RoomDto roomDto2 = new RoomDto();
        roomDto2.setId(id2);
        roomDto2.setArea(33);
        roomDto2.setSpecialEquipment(true);
        roomDto2.setStandardEquipment(true);

        List<RoomDto> roomDtoList = Arrays.asList(roomDto1, roomDto2);

        long id = 1L;
        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setId(id);
        announcementDto.setCity(City.WARSZAWA);
        announcementDto.setRooms(roomDtoList);

        // When
        announcementService.addAnnouncement(announcementDto);

        // Then
        verify(roomRepository, times(1)).saveAll(anyList());
        verify(announcementRepository, times(1)).save(any(Announcement.class));
    }

}
