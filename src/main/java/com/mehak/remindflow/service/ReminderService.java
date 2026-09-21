package com.mehak.remindflow.service;

import com.mehak.remindflow.dto.CreateReminderRequest;
import com.mehak.remindflow.dto.ReminderResponse;
import com.mehak.remindflow.dto.UpdateReminderRequest;
import com.mehak.remindflow.entity.Priority;
import com.mehak.remindflow.entity.Reminder;
import com.mehak.remindflow.exception.ReminderNotFoundException;
import com.mehak.remindflow.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReminderService {
    private final ReminderRepository repo;

    public ReminderService(ReminderRepository repo) {
        this.repo = repo;
    }

    public ReminderResponse createReminder(CreateReminderRequest request) {
        Reminder reminder1 = new Reminder();
        reminder1.setPriority(request.getPriority());
        reminder1.setTitle(request.getTitle());
        reminder1.setDescription(request.getDescription());
        reminder1.setCompleted(Boolean.FALSE);
        reminder1.setDueDateTime(request.getDueDateTime());
        reminder1.setCreatedAt(LocalDateTime.now());
        reminder1.setUpdatedAt(LocalDateTime.now());
        Reminder savedReminder = repo.save(reminder1);
        return mapToResponse(savedReminder);
    }

    public List<ReminderResponse> getAllReminders() {
        List<Reminder> reminders = repo.findAll();
        return reminders.stream().map(this::mapToResponse).toList();
    }

    public ReminderResponse getReminderById(Long id) {
        Reminder reminder = repo.findById(id)
                .orElseThrow(() -> new ReminderNotFoundException("Reminder not found"));
        return mapToResponse(reminder);
    }

    public ReminderResponse updateReminder(Long id, UpdateReminderRequest request) {
        Reminder reminder = repo.findById(id).orElseThrow(() -> new ReminderNotFoundException("Reminder not found"));
        reminder.setCompleted(request.getCompleted());
        reminder.setPriority(request.getPriority());
        reminder.setTitle(request.getTitle());
        reminder.setDescription(request.getDescription());
        reminder.setUpdatedAt(LocalDateTime.now());
        reminder.setDueDateTime(request.getDueDateTime());
        Reminder savedReminder = repo.save(reminder);
        return mapToResponse(savedReminder);
    }

    public void deleteReminder(Long id) {
        Reminder reminder = repo.findById(id).orElseThrow(() -> new ReminderNotFoundException("Reminder not found"));
        repo.delete(reminder);
    }

    public ReminderResponse completeReminder(Long id) {
        Reminder reminder = repo.findById(id).orElseThrow(() -> new ReminderNotFoundException("Reminder not found"));
        reminder.setCompleted(Boolean.TRUE);
        reminder.setUpdatedAt(LocalDateTime.now());
        Reminder savedReminder = repo.save(reminder);
        return mapToResponse(savedReminder);
    }

    private ReminderResponse mapToResponse(Reminder reminder) {

        ReminderResponse response = new ReminderResponse();

        response.setId(reminder.getId());
        response.setTitle(reminder.getTitle());
        response.setDescription(reminder.getDescription());
        response.setDueDateTime(reminder.getDueDateTime());
        response.setPriority(reminder.getPriority());
        response.setCompleted(reminder.getCompleted());
        response.setCreatedAt(reminder.getCreatedAt());
        response.setUpdatedAt(reminder.getUpdatedAt());

        return response;
    }

    public List<ReminderResponse> getRemindersByPriority(Priority priority) {

        List<Reminder> reminders = repo.findByPriority(priority);

        return reminders.stream()
                .map(this::mapToResponse)
                .toList();
    }
    public List<ReminderResponse> getRemindersByCompleted(Boolean completed) {

        List<Reminder> reminders = repo.findByCompleted(completed);

        return reminders.stream()
                .map(this::mapToResponse)
                .toList();
    }
}
