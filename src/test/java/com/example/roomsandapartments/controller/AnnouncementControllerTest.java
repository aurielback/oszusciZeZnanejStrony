package com.example.roomsandapartments.controller;

import com.example.roomsandapartments.dto.AnnouncementDto;
import com.example.roomsandapartments.dto.RoomDto;
import com.example.roomsandapartments.enums.City;
import com.example.roomsandapartments.service.AnnouncementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
public class AnnouncementControllerTest {

    @Mock
    private AnnouncementService announcementService;

    @InjectMocks
    private AnnouncementController announcementController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(announcementController).build();
    }

    @Test
    void findAnnouncementById_shouldReturnAnnouncementDto() throws Exception {
        // Given
        long id1 = 1L;
        RoomDto roomDto1 = new RoomDto();
        roomDto1.setId(id1);
        roomDto1.setArea(23);
        roomDto1.setSpecialEquipment(false);
        roomDto1.setStandardEquipment(true);

        long id2 = 2L;
        RoomDto roomDto2 = new RoomDto();
        roomDto2.setId(id2);
        roomDto2.setArea(33);
        roomDto2.setSpecialEquipment(true);
        roomDto2.setStandardEquipment(true);

        List<RoomDto> roomDtoList = Arrays.asList(roomDto1, roomDto2);

        long id = 1L;
        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setId(id);
        announcementDto.setCity(City.WARSZAWA);
        announcementDto.setRooms(roomDtoList);

        // When
        when(announcementService.findAnnouncementById(anyLong())).thenReturn(announcementDto);

        // Then
        mockMvc.perform(get("/api/v1/announcement/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(announcementDto)));
    }

    @Test
    void addAnnouncement_ShouldReturnCreated() throws Exception {
        // Given
        long id1 = 1L;
        RoomDto roomDto1 = new RoomDto();
        roomDto1.setId(id1);
        roomDto1.setArea(23);
        roomDto1.setSpecialEquipment(false);
        roomDto1.setStandardEquipment(true);

        long id2 = 2L;
        RoomDto roomDto2 = new RoomDto();
        roomDto2.setId(id2);
        roomDto2.setArea(33);
        roomDto2.setSpecialEquipment(true);
        roomDto2.setStandardEquipment(true);

        List<RoomDto> roomDtoList = Arrays.asList(roomDto1, roomDto2);

        long id = 1L;
        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setId(id);
        announcementDto.setCity(City.WARSZAWA);
        announcementDto.setRooms(roomDtoList);

        // When
        doNothing().when(announcementService).addAnnouncement(any(AnnouncementDto.class));

        // Then
        mockMvc.perform(post("/api/v1/announcement/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(announcementDto)))
                .andExpect(status().isOk());

        // Verify if the service method was called with the correct parameter
        verify(announcementService).addAnnouncement(any(AnnouncementDto.class));
    }

    @Test
    void getAll_shouldReturnAnnouncementDto() throws Exception {
        // Given
        RoomDto roomDto1 = new RoomDto();
        roomDto1.setId(1L);
        roomDto1.setArea(23);
        roomDto1.setSpecialEquipment(false);
        roomDto1.setStandardEquipment(true);

        RoomDto roomDto2 = new RoomDto();
        roomDto2.setId(2L);
        roomDto2.setArea(33);
        roomDto2.setSpecialEquipment(true);
        roomDto2.setStandardEquipment(true);

        List<RoomDto> roomDtoList = Arrays.asList(roomDto1, roomDto2);

        long id1 = 1L;
        AnnouncementDto announcementDto1 = new AnnouncementDto();
        announcementDto1.setId(id1);
        announcementDto1.setCity(City.WARSZAWA);
        announcementDto1.setRooms(roomDtoList);

        long id2 = 2L;
        AnnouncementDto announcementDto2 = new AnnouncementDto();
        announcementDto2.setId(id2);
        announcementDto2.setCity(City.WARSZAWA);
        announcementDto2.setRooms(roomDtoList);

        List<AnnouncementDto> announcementDtoList = Arrays.asList(announcementDto1, announcementDto2);

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Convert the list of AnnouncementDto objects to JSON
        String expectedJson = objectMapper.writeValueAsString(announcementDtoList);

        // When
        when(announcementService.getAllAnnouncements()).thenReturn(announcementDtoList);

        // Then
        mockMvc.perform(get("/api/v1/announcement/all/"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

    @Test
    void getAll_shouldDeleteAnnouncementDto() throws Exception {
        // Given
        long id1 = 1L;

        // When
        doNothing().when(announcementService).deleteAnnouncementById(anyLong());

        ResultActions resultActions = mockMvc.perform(delete("/api/v1/announcement/" + id1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        resultActions.andExpect(content().string("Deleted!"));
    }

    @Test
    void updateAnnouncement_ShouldReturnUpdated() throws Exception {
        // Given
        long id1 = 1L;
        RoomDto roomDto1 = new RoomDto();
        roomDto1.setId(id1);
        roomDto1.setArea(23);
        roomDto1.setSpecialEquipment(false);
        roomDto1.setStandardEquipment(true);

        long id2 = 2L;
        RoomDto roomDto2 = new RoomDto();
        roomDto2.setId(id2);
        roomDto2.setArea(33);
        roomDto2.setSpecialEquipment(true);
        roomDto2.setStandardEquipment(true);

        List<RoomDto> roomDtoList = Arrays.asList(roomDto1, roomDto2);

        long id = 1L;
        AnnouncementDto announcementDto = new AnnouncementDto();
        announcementDto.setId(id);
        announcementDto.setCity(City.WARSZAWA);
        announcementDto.setRooms(roomDtoList);


        // When
        doNothing().when(announcementService).updateAnnouncement(any(AnnouncementDto.class), anyLong());

        // Then
        mockMvc.perform(put("/api/v1/announcement/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(announcementDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Updated!"));

        verify(announcementService).updateAnnouncement(any(), eq(id));
    }

}
