package com.calendar.Lv3.service;

import com.calendar.Lv3.dto.CalendarRequestDto;
import com.calendar.Lv3.dto.CalendarResponseDto;
import com.calendar.Lv3.entity.Calendar;
import com.calendar.Lv3.repository.CalendarRepository;
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
        Calendar calendar = new Calendar(
                request.getTitle(),
                request.getContent(),
                request.getName(),
                request.getPassword()
        );
        Calendar saveCalendar = calendarRepository.save(calendar);

        return new CalendarResponseDto(
                saveCalendar.getId(),
                saveCalendar.getTitle(),
                saveCalendar.getContent(),
                saveCalendar.getName(),
                saveCalendar.getCreateAt(),
                saveCalendar.getUpdateAt()
        );
    }
    @Transactional(readOnly = true) // 읽기 전용 트랜잭션으로 설정
    public List<CalendarResponseDto> findCalendars() {
        List<Calendar> calendars = calendarRepository.findAllByOrderByUpdateAtDesc();

        return calendars.stream()
                .map(calendar -> new CalendarResponseDto(
                        calendar.getId(),
                        calendar.getTitle(),
                        calendar.getContent(),
                        calendar.getName(),
                        calendar.getCreateAt(),
                        calendar.getUpdateAt()
                ))
                .toList();
    }
    @Transactional(readOnly = true)
    public CalendarResponseDto findId(Long id) {
        Calendar calendar = calendarRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Calendar with id " + id + " does not exist")
        );
        return new CalendarResponseDto(
                calendar.getId(),
                calendar.getTitle(),
                calendar.getContent(),
                calendar.getName(),
                calendar.getCreateAt(),
                calendar.getUpdateAt()
        );
    }


}
