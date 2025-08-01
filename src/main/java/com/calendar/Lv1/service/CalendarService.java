package com.calendar.Lv1.service;

import com.calendar.Lv1.dto.CalendarRequestDto;
import com.calendar.Lv1.dto.CalendarResponseDto;
import com.calendar.Lv1.entity.Calendar;
import com.calendar.Lv1.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // 비즈니스 로직을 담당하는 서비스 클래스
@RequiredArgsConstructor // final 필드 초기화하는 생성자 자동 생성
public class CalendarService {
    private final CalendarRepository calendarRepository;

    @Transactional //트랜잭션을 시작하고, 끝날 때 커밋 또는 롤백
    public CalendarResponseDto save(CalendarRequestDto request) {
        Calendar calendar = new Calendar(request.getContent());
        Calendar saveCalendar = calendarRepository.save(calendar);

        return new CalendarResponseDto(
                saveCalendar.getId(),
                saveCalendar.getContent(),
                saveCalendar.getCreateAt(),
                saveCalendar.getUpdateAt()
        );
    }
    @Transactional(readOnly = true)
    public List<CalendarResponseDto> findCalendars() {
        List<Calendar> calendars = calendarRepository.findAll();
        return calendars.stream()
                .map(calendar -> new CalendarResponseDto(
                        calendar.getId(),
                        calendar.getContent(),
                        calendar.getCreateAt(),
                        calendar.getUpdateAt()
                ))
                .toList();
    }
}
