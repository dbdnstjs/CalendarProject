package com.calendar.Lv3.repository;

import com.calendar.Lv3.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findAllByOrderByUpdateAtDesc();
}
