package com.calendar.Lv4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter // 모든 필드의 getter 메서드를 자동 생성
@MappedSuperclass // 엔티티의 공통 부모 클래스
@EntityListeners(AuditingEntityListener.class) // JPA Auditing 기능 활성화: @CreatedDate, @LastModifiedDate가 동작
public class Base {

    @CreatedDate // 엔티티가 처음 저장될 때 자동으로 현재 시간을 저장
    @Column(updatable = false) // 저장 후 수정 불가능
    @Temporal(TemporalType.TIMESTAMP) // 날짜 + 시간 형태로 저장
    private LocalDateTime createdAt;

    @LastModifiedDate //  엔티티가 수정될 때마다 자동으로 현재 시간을 저장
    @Temporal(TemporalType.TIMESTAMP) // 날짜 + 시간 형태로 저장
    private LocalDateTime updatedAt;
}
