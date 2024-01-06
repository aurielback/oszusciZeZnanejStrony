package com.example.roomsandapartments.controller;

import com.example.roomsandapartments.dto.RoomDto;
import com.example.roomsandapartments.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRoom(@RequestBody RoomDto room) {
        roomService.addRoom(room);
        return ResponseEntity.ok("Created!");
    }

    @GetMapping("/all")
    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public RoomDto getRoomById(@PathVariable Long id) {
        return roomService.findRoomById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoomById(id);
        return ResponseEntity.ok("Deleted!");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
        roomService.updateRoom(roomDto, id);
        return ResponseEntity.ok("Updated!");
    }
}

