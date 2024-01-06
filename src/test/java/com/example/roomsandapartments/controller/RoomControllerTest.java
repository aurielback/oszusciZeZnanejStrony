package com.example.roomsandapartments.controller;

import com.example.roomsandapartments.dto.RoomDto;
import com.example.roomsandapartments.service.serviceImpl.RoomServiceImpl;
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

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper; // Dla ObjectMapper

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*; // Dla when, doNothing, doAnswer, verify
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class RoomControllerTest {

    @Mock
    private RoomServiceImpl roomServiceImpl;

    @InjectMocks
    private RoomController roomController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
    }

    @Test
    void findRoomById_shouldReturnRoomDto() throws Exception {
        // Given
        long id = 1L;
        RoomDto roomDto = new RoomDto();
        roomDto.setId(id);
        roomDto.setArea(23);
        roomDto.setSpecialEquipment(false);
        roomDto.setStandardEquipment(true);

        // When
        when(roomServiceImpl.findRoomById(anyLong())).thenReturn(roomDto);

        // Then
        mockMvc.perform(get("/api/v1/room/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "\"area\":23," +
                        "\"standard_equipment\":true," +
                        "\"special_equipment\":false}"
                ));
    }

    @Test
    void addRoom_ShouldReturnCreated() throws Exception {
        // Given
        long id = 1L;
        RoomDto roomDto = new RoomDto();
        roomDto.setId(id);
        roomDto.setArea(23);
        roomDto.setSpecialEquipment(false);
        roomDto.setStandardEquipment(true);

        // When
        doNothing().when(roomServiceImpl).addRoom(any(RoomDto.class));

        // Then
        mockMvc.perform(post("/api/v1/room/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(roomDto)))
                .andExpect(status().isOk());

        // Verify if the service method was called with the correct parameter
        verify(roomServiceImpl).addRoom(any(RoomDto.class));
    }

    @Test
    void getAll_shouldReturnRoomDto() throws Exception {
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

        // When
        when(roomServiceImpl.getAllRooms()).thenReturn(roomDtoList);

        // Then
        mockMvc.perform(get("/api/v1/room/all/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].room_id").value(1L))
                .andExpect(jsonPath("$[0].area").value(23))
                .andExpect(jsonPath("$[0].standard_equipment").value(true))
                .andExpect(jsonPath("$[0].special_equipment").value(false))
                .andExpect(jsonPath("$[1].room_id").value(2L))
                .andExpect(jsonPath("$[1].area").value(33))
                .andExpect(jsonPath("$[1].standard_equipment").value(true))
                .andExpect(jsonPath("$[1].special_equipment").value(true));
    }

    @Test
    void getAll_shouldDeleteRoomDto() throws Exception {
        // Given
        long id1 = 1L;

        // When
        doNothing().when(roomServiceImpl).deleteRoomById(anyLong());

        ResultActions resultActions = mockMvc.perform(delete("/api/v1/room/" + id1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        resultActions.andExpect(content().string("Deleted!"));
    }

    @Test
    void updateRoom_ShouldReturnUpdated() throws Exception {
        // Given
        long id = 1L;
        RoomDto roomDto = new RoomDto();
        roomDto.setId(id);
        roomDto.setArea(30);
        roomDto.setSpecialEquipment(true);
        roomDto.setStandardEquipment(false);

        // When
        doNothing().when(roomServiceImpl).updateRoom(any(RoomDto.class), anyLong());

        // Then
        mockMvc.perform(put("/api/v1/room/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(roomDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("Updated!"));

        verify(roomServiceImpl).updateRoom(any(), eq(id));
    }

}
