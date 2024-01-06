package com.example.roomsandapartments.mappers;

import com.example.roomsandapartments.dto.AnnouncementDto;
import com.example.roomsandapartments.model.Announcement;
import org.mapstruct.Mapper;

@Mapper
public interface AnnouncementMapper {

    Announcement announcementDtoToAnnouncementEntity(AnnouncementDto announcementDto);
    AnnouncementDto announcementEntityToAnnouncementDto(Announcement announcementEntity);

}
