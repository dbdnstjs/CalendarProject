package com.calendar.Lv1.controller;

import com.calendar.Lv1.dto.CalendarRequestDto;
import com.calendar.Lv1.dto.CalendarResponseDto;
import com.calendar.Lv1.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON 반환하는 컨트롤러
@RequiredArgsConstructor // final 필드 초기화하는 생성자 자동 생성
public class CalendarController {
    private final CalendarService calendarService;

    @PostMapping("/calendars") // HTTP POST 요청 처리
    public ResponseEntity<CalendarResponseDto> createCalendar(@RequestBody CalendarRequestDto requestDto) {
        return ResponseEntity.ok(calendarService.save(requestDto));
    }

    @GetMapping("/calendars") //HTTP GET 요청 처리
    public ResponseEntity<List<CalendarResponseDto>> getCalendars() {
        return ResponseEntity.ok(calendarService.findCalendars());
    }
}