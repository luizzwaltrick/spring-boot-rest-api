package com.github.luizzwaltrick.todo.todo_api.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.luizzwaltrick.todo.todo_api.task.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Task> tasks;
}
