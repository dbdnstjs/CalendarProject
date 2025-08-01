package com.calendar.Lv2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // 모든 필드 getter 메서드 자동 생성
@Setter
@NoArgsConstructor //Lombok이 기본 생성자 자동 생성
public class CalendarRequestDto {
    private String title;
    private String content;
    private String name;
    private String password;
}
