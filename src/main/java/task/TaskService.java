package task;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task createTask(Task newTask) {
        return repository.save(newTask);
    }

    public Optional<Task> updateExistingTask(Long id, Task updatedTask) {
        return repository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(updatedTask.getTitle());
                    existingTask.setComplete(updatedTask.isComplete());

                    return repository.save(existingTask);
                });
    }

    public boolean deleteTaskById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return true;
        }
        return false;
    }
}
