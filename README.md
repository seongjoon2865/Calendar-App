# Calendar-App



기능
Method
URL
요청 Body / 요청 Param
상태코드


일정 등록
POST
/schedules
json {"title": "회의", "description": "주간 회의", "date": "2025-01-25", "time": "14:00", "location": "회의실 A"}
json {"id": 1, "title": "회의", "description": "주간 회의", "date": "2025-01-25", "time": "14:00", "location": "회의실 A", "createdAt": "2025-01-23T10:00:00Z"}
200: 정상등록


일정 조회(단건)
GET
/schedules/{id}
id (경로 파라미터)
json {"id": 1, "title": "회의", "description": "주간 회의", "date": "2025-01-25", "time": "14:00", "location": "회의실 A"}
200: 정상조회


일정 목록 조회
GET
/schedules
date (선택적), keyword (선택적)
json [{"id": 1, "title": "회의"}, {"id": 2, "title": "점심 약속"}]
200: 정상조회


일정 수정
PUT
/schedules/{id}
json {"title": "업데이트된 회의", "description": "변경된 주간 회의", "date": "2025-01-26", "time": "15:00", "location": "회의실 B"}
json {"id": 1, "title": "업데이트된 회의", "description": "변경된 주간 회의", "date": "2025-01-26", "time": "15:00", "location": "회의실 B", "updatedAt": "2025-01-23T12:00:00Z"}
200: 정상수정


일정 삭제
DELETE
/schedules/{id}
id (경로 파라미터)
json {"message": "일정이 정상적으로 삭제되었습니다.", "deletedId": 1}
200: 정상삭제
