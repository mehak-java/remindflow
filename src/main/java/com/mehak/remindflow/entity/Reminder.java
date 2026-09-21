package com.mehak.remindflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name= "reminders")
@Getter
@Setter
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 100, message = "Title must not exceed 100 characters")
    @NotBlank(message = "Title is required")
    private String title;
    @Size(max = 500, message = "Description must not exceed 500 characters")
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Due date is required")
    private LocalDateTime dueDateTime;
    @NotNull(message = "Priority is required")
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private Boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
