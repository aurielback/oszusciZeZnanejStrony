package com.example.roomsandapartments.config;


import com.example.roomsandapartments.mappers.AnnouncementMapper;
import com.example.roomsandapartments.mappers.RoomMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {

    /**
     * bean for dependency injection RoomMapper
     *
     * @return mapper
     */
    @Bean
    public RoomMapper roomMapper() {
        return Mappers.getMapper(RoomMapper.class);
    }

    /**
     * bean for dependency injection AnnouncementMapper
     *
     * @return mapper
     */
    @Bean
    public AnnouncementMapper announcementMapper() {
        return Mappers.getMapper(AnnouncementMapper.class);
    }

}
