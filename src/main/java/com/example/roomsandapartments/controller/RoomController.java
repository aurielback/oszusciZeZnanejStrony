package com.example.roomsandapartments.controller;

import com.example.roomsandapartments.dto.RoomDto;
import com.example.roomsandapartments.service.serviceImpl.RoomServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/room")
public class RoomController {

    private final RoomServiceImpl roomServiceImpl;

    public RoomController(RoomServiceImpl roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRoom(@RequestBody RoomDto room) {
        roomServiceImpl.addRoom(room);
        return ResponseEntity.ok("Created!");
    }

    @GetMapping("/all")
    public List<RoomDto> getAllRooms() {
        return roomServiceImpl.getAllRooms();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public RoomDto getRoomById(@PathVariable Long id) {
        return roomServiceImpl.findRoomById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id) {
        roomServiceImpl.deleteRoomById(id);
        return ResponseEntity.ok("Deleted!");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
        roomServiceImpl.updateRoom(roomDto, id);
        return ResponseEntity.ok("Updated!");
    }
}

