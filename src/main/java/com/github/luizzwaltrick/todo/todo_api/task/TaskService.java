package com.github.luizzwaltrick.todo.todo_api.task;

import com.github.luizzwaltrick.todo.todo_api.users.User;
import com.github.luizzwaltrick.todo.todo_api.users.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task newTask, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        newTask.setUser(user);

        return taskRepository.save(newTask);
    }

    public Optional<Task> updateExistingTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(updatedTask.getTitle());
                    existingTask.setComplete(updatedTask.isComplete());

                    return taskRepository.save(existingTask);
                });
    }

    public boolean deleteTaskById(long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);

            return true;
        }
        return false;
    }
}
