package com.example.roomsandapartments.repository;

import com.example.roomsandapartments.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    @Query("SELECT SUM(r.price) FROM announcement a JOIN a.rooms r WHERE a.id = :announcementId")
    BigDecimal getTotalPriceByAnnouncementId(@Param("announcementId") Long announcementId);
}
