package com.github.luizzwaltrick.todo.todo_api.task;

import com.github.luizzwaltrick.todo.todo_api.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @ManyToOne
    private User user;
}
