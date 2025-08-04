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
    "id": 1,
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

GlobalExceptionHandler: 애플리케이션 전역에서 발생하는 예외를 잡아 HTTP 응답으로 변환

---

# 📅 Lv2 Calendar API

간단한 일정 관리 API 서비스입니다. 사용자가 제목, 내용, 이름, 비밀번호를 입력하여 일정을 등록하고, 전체 일정 조회 및 개별 일정 조회 기능을 제공합니다.

---

## 🔗 API 명세서

### 📌 개별 일정 조회

- **URL**: `GET / localhost:8080/calendars/{calendarId}`
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
    }
```
### 📌 개별 일정 조회 실패 시

- Response (400 Bad Request)
- **Request Body**
```json
{
    "error": "Bad Request",
    "message": "Calendar with id 15 does not exist",
    "timestamp": "2025-08-04T10:44:05.9068091",
    "status": 400
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

CalendarController: REST API 엔드포인트를 담당하며 요청을 서비스로 전달

CalendarService: 비즈니스 로직 담당, 트랜잭션 관리 및 DB 저장/조회 처리

CalendarRepository: JPA를 이용한 DB CRUD 인터페이스

Calendar: JPA Entity, 일정 정보를 담고 있는 테이블 매핑 클래스

Base: 생성일(createdAt), 수정일(updatedAt) 자동 관리하는 상위 엔티티

CalendarRequestDto: 클라이언트에서 전달받는 일정 생성/수정용 데이터 전송 객체

CalendarResponseDto: 클라이언트에 반환하는 일정 조회용 데이터 전송 객체

GlobalExceptionHandler: 애플리케이션 전역에서 발생하는 예외를 잡아 HTTP 응답으로 변환

---

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

🧾 클래스 구성 요약
Calendar: JPA Entity, 일정 정보를 담고 있는 테이블 매핑 클래스

Base: 생성일, 수정일 자동 관리용 상위 클래스

CalendarRequestDto: 클라이언트 요청용 DTO (title, content, name, password)

CalendarResponseDto: 클라이언트 응답용 DTO (id, title, content, name, createdAt, updatedAt)

CalendarRepository: JPA 인터페이스, DB 접근 담당

CalendarService: 비즈니스 로직 처리, 일정 저장/조회/수정 및 비밀번호 검증

CalendarController: REST API 요청 처리 (POST, GET, PUT)

GlobalExceptionHandler: 애플리케이션 전역에서 발생하는 예외를 잡아 HTTP 응답으로 변환

---

# 📅 Lv4 Calendar API

비밀번호를 통한 간단한 인증 기능이 포함된 일정 관리 API 서비스입니다.  
사용자는 제목, 내용, 이름, 비밀번호를 입력해 일정을 등록, 조회, 수정, 삭제할 수 있습니다.

---

## 🔗 API 명세서

### 📌 개별 일정 삭제

- **URL**: `GET / localhost:8080/calendars/{calendarId}`
- Response (200 OK)
- **Request Body**
```json
  {
        "password": "1234"
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

Calendar: 일정 엔티티 (DB 테이블 매핑)

Base: 생성일, 수정일 자동 관리용 상위 클래스

CalendarRequestDto: 클라이언트 요청용 DTO (title, content, name, password)

CalendarResponseDto: 클라이언트 응답용 DTO (id, title, content, name, createdAt, updatedAt)

CalendarRepository: JPA 인터페이스, DB 접근 담당

CalendarService: 비즈니스 로직 처리, 일정 CRUD 및 비밀번호 검증

CalendarController: REST API 요청 처리 (POST, GET, PUT, DELETE)

Lv4CalendarApplication: Spring Boot 메인 애플리케이션, JPA Auditing 활성화

---
