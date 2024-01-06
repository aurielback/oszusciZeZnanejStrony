package com.example.roomsandapartments.controller;

import com.example.roomsandapartments.dto.AnnouncementDto;
import com.example.roomsandapartments.service.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/announcement")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAnnouncement(@RequestBody AnnouncementDto announcement) {
        announcementService.addAnnouncement(announcement);
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<AnnouncementDto> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AnnouncementDto findAnnouncementById(@PathVariable Long id) {
        return announcementService.findAnnouncementById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncementById(id);
        return new ResponseEntity<>("Deleted!", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateAnnouncement(@PathVariable Long id, @RequestBody AnnouncementDto announcementDto) {
        announcementService.updateAnnouncement(announcementDto, id);
        return new ResponseEntity<>("Updated!", HttpStatus.OK);
    }

}
