## 🧾 클래스 구성 요약

Calendar: 일정 정보를 담는 JPA Entity 클래스

Base: 생성일, 수정일 자동 관리 상위 클래스

CalendarRequestDto: 일정 생성 요청용 DTO

CalendarResponseDto: 일정 응답용 DTO

CalendarRepository: JPA 인터페이스

CalendarService: 비즈니스 로직

CalendarController: REST API 요청 처리

GlobalExceptionHandler: 전역 예외 처리 클래스

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

# 📅 Lv1 Calendar API

간단한 일정 관리 API 서비스입니다. 사용자가 제목, 내용, 이름, 비밀번호를 입력하여 일정을 등록하고, 전체 일정을 조회할 수 있습니다.

---

## 🔗 API 명세서

### 📌 일정 등록

- **URL**: `POST /localhost:8080/calendars`
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
- **Response Body**
```json
{
    "id": 1,
    "title": "api 공부",
    "content": "오후 10시에 api 공부 진행",
    "name": "최민수",
    "createdAt": "2025-08-04T09:50:12.9575047",
    "updatedAt": "2025-08-04T09:50:12.9575047"
}
```

### 📌 일정 전체 조회

- **URL**: `GET /localhost:8080/calendars`
- Response (200 OK)
- **Response Body**
```json
[
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
]
```

---

# 📅 Lv2 Calendar API

간단한 일정 관리 API 서비스입니다. 사용자가 제목, 내용, 이름, 비밀번호를 입력하여 일정을 등록하고, 전체 일정 조회 및 개별 일정 조회 기능을 제공합니다.

---

## 🔗 API 명세서

### 📌 개별 일정 조회
- **URL**: `GET /localhost:8080/calendars/{calendarId}`
- Response (200 OK)
- **Response Body**
```json
  {
        "id": 1,
        "title": "api 공부",
        "content": "오후 10시에 api 공부 진행",
        "name": "최민수",
        "createdAt": "2025-08-04T09:50:12.957505",
        "updatedAt": "2025-08-04T09:50:12.957505"
    }
```

### 📌 개별 일정 조회 실패 시
- Response (400 Bad Request)
- **Response Body**
```json
{
    "error": "Bad Request",
    "message": "Calendar with id 15 does not exist",
    "timestamp": "2025-08-04T10:44:05.9068091",
    "status": 400
}
```

# 📅 Lv3 Calendar API

비밀번호로 일정 수정 권한을 간단히 인증할 수 있는 일정 관리 API 서비스입니다.  
사용자가 제목, 내용, 이름, 비밀번호를 입력하여 일정을 등록, 조회, 수정할 수 있습니다.

---

## 🔗 API 명세서

📌 일정 수정
- **URL**: `PUT /localhost:8080/calendars/{calendarId}`
- Response (200 OK)
- **Request Body**
```json
{
  "title": "변경된 수업 일정",
  "name": "김철수",
  "password": "1234"
}
```
- **Response Body**
```json
{
    "id": 1,
    "title": "변경된 수업 일정",
    "content": "오후 11시에 api 공부 진행",
    "name": "김철수",
    "createdAt": "2025-08-04T09:56:30.450859",
    "updatedAt": "2025-08-04T09:56:30.450859"
}
```

# 📅 Lv4 Calendar API

비밀번호를 통한 간단한 인증 기능이 포함된 일정 관리 API 서비스입니다.  
사용자는 제목, 내용, 이름, 비밀번호를 입력해 일정을 등록, 조회, 수정, 삭제할 수 있습니다.

---

## 🔗 API 명세서

### 📌 개별 일정 삭제
- **URL**: `DELETE /localhost:8080/calendars/{calendarId}`
- Response (200 OK)
- **Request Body**
```json
  {
        "password": "1234"
    }
```
