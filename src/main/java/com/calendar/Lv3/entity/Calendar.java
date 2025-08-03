package com.calendar.Lv3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter // 모든 필드의 getter 메서드를 자동 생성
@RequiredArgsConstructor // final 필드 초기화하는 생성자 자동 생성
public class Calendar extends Base {
    @Id //기본 키(PK) 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // DB가 자동으로 숫자 증가시켜서 ID를 생성
    private Long id;

    private String title;
    private String content;
    private String name;
    private String password;

    public Calendar(String title, String content, String name, String password) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }

    public void updateCalendarTitle(String title, String name){
        this.title = title;
        this.name = name;
    }
}
