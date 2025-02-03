Schedule API
간단한 일정 관리 애플리케이션으로, JDBC를 사용하여 MySQL과 연동됩니다.

 

Features
일정 생성 (할 일, 작성자명, 비밀번호, 날짜 포함)
전체 일정 조회 (수정일 기준 내림차순 정렬)
특정 일정 조회 (ID 기반)
일정 수정 (제목, 설명 변경)
일정 삭제

 

Tech Stack
Backend: Java 17, Spring Boot, Spring JDBC
Database: MySQL
Tools: IntelliJ, Postman

 

How to Run
1. MySQL 테이블 생성

 

CREATE TABLE schedule (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    date        DATETIME NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    author      VARCHAR(100) NOT NULL,
    password    VARCHAR(255) NOT NULL
);

 

2. application.properties 설정

 

spring.datasource.url=jdbc:mysql://localhost:3306/schedule_db

spring.datasource.username=root spring.datasource.password=your_password # 실제 비밀번호 입력 spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver spring.datasource.hikari.maximum-pool-size=10

 

3. 프로젝트 실행

 

spring-boot:run

 

API Endpoints


일정 생성

 POST /api/schedules

{
  "title": "회의 일정",
  "description": "주간 회의",
  "date": "2025-02-10T10:00:00",
  "author": "홍길동",
  "password": "1234"
}

 

전체 일정 조회
GET /api/schedules

특정 일정 조회
GET /api/schedules/{id}

일정 수정
PUT /api/schedules/{id}

 

{
  "title": "수정된 일정",
  "description": "변경된 내용"
}

 

일정 삭제

 DELETE /api/schedules/{id}
