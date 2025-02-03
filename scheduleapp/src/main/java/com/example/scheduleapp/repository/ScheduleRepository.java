package com.example.scheduleapp.repository;

import com.example.scheduleapp.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);
    List<Schedule> findAll();
    Optional<Schedule> findById(Long id);
    Schedule update(Long id, Schedule schedule);
    void delete(Long id);
}

