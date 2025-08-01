package com.calendar.Lv1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter // 모든 필드 getter 메서드 자동 생성
@NoArgsConstructor //Lombok이 기본 생성자 자동 생성
public class CalendarResponseDto {
    private Long id;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CalendarResponseDto(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
