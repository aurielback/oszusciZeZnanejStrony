package com.example.roomsandapartments.mappers;

import com.example.roomsandapartments.dto.room.RoomDto;
import com.example.roomsandapartments.model.Room;
import org.mapstruct.Mapper;

@Mapper
public interface RoomMapper {
        Room roomDtoToRoomEntity(RoomDto roomDto);
        RoomDto roomEntityToRoomDto(Room roomEntity);

}
