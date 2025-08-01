package com.calendar.Lv2.repository;

import com.calendar.Lv2.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findAllByOrderByUpdateAtDesc();
}
