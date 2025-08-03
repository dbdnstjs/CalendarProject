package com.calendar.Lv4.repository;

import com.calendar.Lv4.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findAllByOrderByUpdatedAtDesc();
}
