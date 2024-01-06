package com.example.roomsandapartments.service.serviceImpl;

import com.example.roomsandapartments.dto.RoomDto;
import com.example.roomsandapartments.exceptions.RoomExceptions.RoomNotFoundException;
import com.example.roomsandapartments.exceptions.RoomExceptions.RoomNotSavedException;
import com.example.roomsandapartments.mappers.RoomMapper;
import com.example.roomsandapartments.model.Room;
import com.example.roomsandapartments.repository.RoomRepository;
import com.example.roomsandapartments.service.RoomService;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    /**
     * Add room to database
     *
     * @param roomDto transfer object of Room entity
     */
    @Transactional(rollbackOn = RoomNotSavedException.class)
    public void addRoom(RoomDto roomDto) {
        Optional.ofNullable(roomDto)
                .orElseThrow(() -> new IllegalArgumentException("Room cannot be null"));
        try {
            roomRepository.save(roomMapper.roomDtoToRoomEntity(roomDto));
        } catch (DataAccessException e) {
            throw new RoomNotSavedException(e.toString());
        }
    }

    /**
     * get all rooms from database
     *
     * @return RoomDto
     */
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll().stream().map(
                roomMapper::roomEntityToRoomDto
        ).toList();
    }

    /**
     * get room by id
     *
     * @param id room's id
     * @return optional Room
     */
    public RoomDto findRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        return roomMapper.roomEntityToRoomDto(room);
    }

    /**
     * delete room by id
     *
     * @param id room's id
     */
    public void deleteRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        roomRepository.delete(room);
    }

    /**
     * update room
     *
     * @param roomDto given changes
     * @param id      room's id
     */
    public void updateRoom(RoomDto roomDto, Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        room.setArea(roomDto.getArea());
        room.setSpecialEquipment(roomDto.isSpecialEquipment());
        room.setStandardEquipment(roomDto.isStandardEquipment());
        roomRepository.save(room);
    }


}
