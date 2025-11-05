package com.github.luizzwaltrick.todo.todo_api.task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "The task title must not be empty.")
    private String title;

    private boolean isComplete;
}
