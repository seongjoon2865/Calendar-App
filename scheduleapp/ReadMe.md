| Method | Path                | Request    | Response                                        | Description | StatusCode |
|--------|---------------------|------------|-------------------------------------------------|-------------|------------|
| GET    | /api/schedules      | -          | [{"id":1, "title": "회의", "date": "2025-02-04"}] | 전체 일정 조회    |  200 |
| GET    | /api/schedules/{id} | id (일정 ID) | {"id": 1, "title": "회의", "date": "2025-02-04"}   | 특정 일정 조회    | 200 |
|POST    | /api/schedules      | {"title": "회의", "date": "2025-02-04", "description": " 팀 회의", "author": "홍길동", "password": "1234"} | {"id": 1, "title": "회의"} | 일정생성 | 201|
|PUT | /api/schedules/{id} | {"title": "수정된 회의", "date": "2025-02-04"} | {"id": 1, "title": "수정된 회의"} | 일정 수정 | 200|
|DELETE | /api/schedules/{id} | id (일정 ID) | {"message": "삭제 완료"} | 일정 삭제 | 200 |