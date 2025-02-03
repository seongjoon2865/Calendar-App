package com.example.scheduleapp.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private String title;
    private String description;
    private LocalDateTime date;
    private String author;
    private String password;
}
