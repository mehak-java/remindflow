package com.mehak.remindflow.controller;

import com.mehak.remindflow.dto.CreateReminderRequest;
import com.mehak.remindflow.dto.ReminderResponse;
import com.mehak.remindflow.dto.UpdateReminderRequest;
import com.mehak.remindflow.entity.Priority;
import com.mehak.remindflow.service.ReminderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {
    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReminderResponse createReminder(@Valid @RequestBody CreateReminderRequest request) {
        return reminderService.createReminder(request);
    }

    @GetMapping
    public List<ReminderResponse> getAllReminders(@RequestParam(required = false) Priority priority,
                                                  @RequestParam(required = false) Boolean completed) {
        if (priority != null) {
            return reminderService.getRemindersByPriority(priority);
        }
        if (completed != null) {
            return reminderService.getRemindersByCompleted(completed);
        }
        return reminderService.getAllReminders();
    }

    @GetMapping("/{id}")
    public ReminderResponse getReminderById(@PathVariable Long id) {
        return reminderService.getReminderById(id);
    }

    @PutMapping("/{id}")
    public ReminderResponse updateReminder(
            @PathVariable Long id,
            @Valid @RequestBody UpdateReminderRequest request) {
        return reminderService.updateReminder(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
    }

    @PatchMapping("/{id}/complete")
    public ReminderResponse completeReminder(@PathVariable Long id) {
        return reminderService.completeReminder(id);
    }

}
