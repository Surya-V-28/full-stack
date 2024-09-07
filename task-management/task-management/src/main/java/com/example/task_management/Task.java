package com.example.task_management;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String priority; // e.g., LOW, MEDIUM, HIGH
    private LocalDateTime completionTime;
    private LocalDateTime createdTime;

    public Task() {
        this.createdTime = LocalDateTime.now(); // Automatically set the created time
    }

    // Getters and Setters



    // Additional Constructors if needed
}
