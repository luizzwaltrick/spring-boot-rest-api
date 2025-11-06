package com.github.luizzwaltrick.todo.todo_api.users;

import com.github.luizzwaltrick.todo.todo_api.task.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User createUser(User newUser) {
        return repository.save(newUser);
    }

    public Optional<User> getUserById(long id) {
        return repository.findById(id);
    }

    public boolean deleteUserById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return true;
        }
        return false;
    }
}
