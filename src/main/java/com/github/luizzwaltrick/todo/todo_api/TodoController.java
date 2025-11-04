package com.github.luizzwaltrick.todo.todo_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class TodoController {
    private final TaskRepository repository;

    public TodoController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task newTask) {
        return repository.save(newTask);
    }
}
