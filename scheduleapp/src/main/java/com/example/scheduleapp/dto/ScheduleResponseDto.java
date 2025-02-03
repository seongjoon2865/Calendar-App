package com.example.scheduleapp.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

