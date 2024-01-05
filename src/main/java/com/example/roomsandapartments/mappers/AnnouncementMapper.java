package com.example.roomsandapartments.mappers;

import com.example.roomsandapartments.dto.room.AnnouncementDto;
import com.example.roomsandapartments.dto.room.RoomDto;
import com.example.roomsandapartments.model.Announcement;
import com.example.roomsandapartments.model.Room;
import org.mapstruct.Mapper;

@Mapper
public interface AnnouncementMapper {

    Announcement announcementDtoToAnnouncementEntity(AnnouncementDto announcementDto);
    AnnouncementDto announcementEntityToAnnouncementDto(Announcement announcementEntity);

}
