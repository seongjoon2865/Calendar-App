package com.example.scheduleapp.repository;

import com.example.scheduleapp.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Schedule save(Schedule schedule) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO schedule (title, description, date, author, password, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, schedule.getTitle());
            ps.setString(2, schedule.getDescription());
            ps.setObject(3, schedule.getDate());
            ps.setString(4, schedule.getAuthor());
            ps.setString(5, schedule.getPassword());
            ps.setObject(6, schedule.getCreatedAt());
            ps.setObject(7, schedule.getUpdatedAt());
            return ps;
        }, keyHolder);

        schedule.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return schedule;
    }

    @Override
    public List<Schedule> findAll() {
        return jdbcTemplate.query("SELECT * FROM schedule ORDER BY updated_at DESC",
                (rs, rowNum) -> new Schedule(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getTimestamp("date").toLocalDateTime(),
                        rs.getString("author"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ));
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM schedule WHERE id = ?",
                        (rs, rowNum) -> new Schedule(
                                rs.getLong("id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getTimestamp("date").toLocalDateTime(),
                                rs.getString("author"),
                                rs.getString("password"),
                                rs.getTimestamp("created_at").toLocalDateTime(),
                                rs.getTimestamp("updated_at").toLocalDateTime()
                        ), id)
                .stream()
                .findAny();
    }

    @Override
    public Schedule update(Long id, Schedule schedule) {
        jdbcTemplate.update("UPDATE schedule SET title = ?, description = ?, date = ?, updated_at = ? WHERE id = ?",
                schedule.getTitle(), schedule.getDescription(), schedule.getDate(), schedule.getUpdatedAt(), id);
        return findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM schedule WHERE id = ?", id);
    }
}

