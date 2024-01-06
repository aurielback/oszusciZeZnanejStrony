package com.example.roomsandapartments.service;

import com.example.roomsandapartments.dto.RoomDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomService {

    /**
     * Add room to database
     *
     * @param roomDto transfer object of Room entity
     */
    void addRoom(RoomDto roomDto);

    /**
     * get all rooms from database
     *
     * @return RoomDto
     */
    List<RoomDto> getAllRooms();

    /**
     * get room by id
     *
     * @param id room's id
     * @return optional Room
     */
    RoomDto findRoomById(Long id);

    /**
     * delete room by id
     *
     * @param id room's id
     */
    void deleteRoomById(Long id);

    /**
     * update room
     *
     * @param roomDto given changes
     * @param id      room's id
     */
    void updateRoom(RoomDto roomDto, Long id);

}
