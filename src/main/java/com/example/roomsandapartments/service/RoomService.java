package com.example.roomsandapartments.service;

import com.example.roomsandapartments.dto.RoomDto;
import com.example.roomsandapartments.exceptions.RoomNotFoundException;
import com.example.roomsandapartments.mappers.RoomMapper;

import com.example.roomsandapartments.model.Room;
import com.example.roomsandapartments.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    /**
     * Add room to database
     * @param roomDto transfer object of Room entity
     */
    public void addRoom(RoomDto roomDto) {
        roomRepository.save(roomMapper.roomDtoToRoomEntity(roomDto));
    }

    /**
     * get all rooms from database
     * @return RoomDto
     */
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll().stream().map(
                roomMapper::roomEntityToRoomDto
        ).toList();
    }

    /**
     * get room by id
     * @param id room's id
     * @return optional Room
     */
    public RoomDto findRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        return roomMapper.roomEntityToRoomDto(room);
    }

    /**
     * delete room by id
     * @param id room's id
     */
    public void deleteRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        roomRepository.delete(room);
    }

    /**
     * update room
     * @param roomDto given changes
     * @param id room's id
     */
    public void updateRoom(RoomDto roomDto, Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        room.setArea(roomDto.getArea());
        room.setSpecialEquipment(roomDto.isSpecialEquipment());
        room.setStandardEquipment(roomDto.isStandardEquipment());
        roomRepository.save(room);
    }


}
