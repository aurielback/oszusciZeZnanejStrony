package com.example.roomsandapartments.controller;

import com.example.roomsandapartments.dto.AnnouncementDto;
import com.example.roomsandapartments.service.serviceImpl.AnnouncementServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/announcement")
public class AnnouncementController {

    private final AnnouncementServiceImpl announcementServiceImpl;

    public AnnouncementController(AnnouncementServiceImpl announcementServiceImpl) {
        this.announcementServiceImpl = announcementServiceImpl;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAnnouncement(@RequestBody AnnouncementDto announcement) {
        announcementServiceImpl.addAnnouncement(announcement);
        return ResponseEntity.ok("Created!");
    }

    @GetMapping("/all")
    public List<AnnouncementDto> getAllAnnouncements() {
        return announcementServiceImpl.getAllAnnouncements();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AnnouncementDto findAnnouncementById(@PathVariable Long id) {
        return announcementServiceImpl.findAnnouncementById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnnouncement(@PathVariable Long id) {
        announcementServiceImpl.deleteAnnouncementById(id);
        return ResponseEntity.ok("Deleted!");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateAnnouncement(@PathVariable Long id, @RequestBody AnnouncementDto announcementDto) {
        announcementServiceImpl.updateAnnouncement(announcementDto, id);
        return ResponseEntity.ok("Updated!");
    }

}
