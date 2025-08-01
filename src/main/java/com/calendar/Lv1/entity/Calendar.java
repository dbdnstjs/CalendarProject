package com.calendar.Lv1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class Calendar extends Base{
    @Id //기본 키(PK) 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // DB가 자동으로 숫자 증가시켜서 ID를 생성
    private Long id;
    private String content;

    public Calendar(String content) {
        this.content = content;
    }
}
