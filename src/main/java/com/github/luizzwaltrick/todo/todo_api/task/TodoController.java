package com.github.luizzwaltrick.todo.todo_api.task;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.github.luizzwaltrick.todo.todo_api.users.dto.TaskResponseDTO;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TodoController {
    private final TaskService taskService;

    public TodoController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {
        return taskService.findAllTasks();
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody @Valid Task newTask,
                                           @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();

        TaskResponseDTO savedTask = taskService.createTask(newTask, username);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody @Valid Task updatedTask) {
        return taskService.updateExistingTask(id, updatedTask)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.deleteTaskById(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
