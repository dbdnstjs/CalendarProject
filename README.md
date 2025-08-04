# 📅 Lv1 Calendar API

간단한 일정 관리 API 서비스입니다. 사용자가 제목, 내용, 이름, 비밀번호를 입력하여 일정을 등록하고, 전체 일정을 조회할 수 있습니다.

---

## 🔗 API 명세서

### 📌 일정 등록

- **URL**: `POST / localhost:8080/calendars`
- Response (200 OK)
- **Request Body**
```json
  {
    "title": "api 공부",
    "content": "오후 10시에 api 공부 진행",
    "name": "최민수",
    "password": "1234"
  }
```

```json
{
    "id": 13,
    "title": "api 공부",
    "content": "오후 10시에 api 공부 진행",
    "name": "최민수",
    "createdAt": "2025-08-04T09:50:12.9575047",
    "updatedAt": "2025-08-04T09:50:12.9575047"
}
```

### 📌 일정 전체 조회

- **URL**: `GET / localhost:8080/calendars`
- Response (200 OK)
- **Request Body**
```json
  {
        "id": 1,
        "title": "api 공부",
        "content": "오후 10시에 api 공부 진행",
        "name": "최민수",
        "createdAt": "2025-08-04T09:50:12.957505",
        "updatedAt": "2025-08-04T09:50:12.957505"
    },
    {
        "id": 2,
        "title": "api 공부2",
        "content": "오후 11시에 api 공부 진행",
        "name": "박민수",
        "createdAt": "2025-08-04T09:56:30.450859",
        "updatedAt": "2025-08-04T09:56:30.450859"
    }
```

## 🗂 ERD

```diff
[Calendar]
- id: Long (PK)
- title: String
- content: String
- name: String
- password: String
- createdAt: LocalDateTime
- updatedAt: LocalDateTime
```

## 🧾 클래스 구성 요약

Calendar: 일정 Entity

Base: 생성일, 수정일 공통 필드 상속용

CalendarRequestDto: 일정 생성 요청 DTO

CalendarResponseDto: 일정 응답 DTO

CalendarRepository: JPA 인터페이스

CalendarService: 비즈니스 로직

CalendarController: API 컨트롤러

---
