package com.github.luizzwaltrick.todo.todo_api.task;

import com.github.luizzwaltrick.todo.todo_api.users.User;
import com.github.luizzwaltrick.todo.todo_api.users.UserRepository;
import com.github.luizzwaltrick.todo.todo_api.users.dto.TaskResponseDTO;
import com.github.luizzwaltrick.todo.todo_api.users.dto.UserResponseDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<TaskResponseDTO> findAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TaskResponseDTO createTask(Task newTask, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        newTask.setUser(user);
        Task savedTask = taskRepository.save(newTask);

        return convertToDTO(savedTask);
    }

    public Optional<TaskResponseDTO> updateExistingTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(updatedTask.getTitle());
                    existingTask.setComplete(updatedTask.isComplete());

                    Task savedTask = taskRepository.save(existingTask);

                    return convertToDTO(existingTask);
                });
    }

    public boolean deleteTaskById(long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);

            return true;
        }
        return false;
    }

    private TaskResponseDTO convertToDTO(Task task) {
        UserResponseDTO userDTO = new UserResponseDTO(
                task.getUser().getId(),
                task.getUser().getUsername()
        );

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.isComplete(),
                userDTO
        );
    }
}
