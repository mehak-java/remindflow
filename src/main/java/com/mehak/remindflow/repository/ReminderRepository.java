package com.mehak.remindflow.repository;

import com.mehak.remindflow.entity.Priority;
import com.mehak.remindflow.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByPriority(Priority priority);
    List<Reminder> findByCompleted(Boolean completed);
}
