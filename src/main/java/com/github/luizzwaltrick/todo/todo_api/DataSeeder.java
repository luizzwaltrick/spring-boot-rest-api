package com.github.luizzwaltrick.todo.todo_api;


import com.github.luizzwaltrick.todo.todo_api.users.User;
import com.github.luizzwaltrick.todo.todo_api.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception{
        if (userRepository.count() == 0) {
            String hashedPassword = passwordEncoder.encode("password321");

            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(hashedPassword);

            userRepository.save(adminUser);

            System.out.println("--- Default 'admin' user created with password 'password321' ---");
        }
    }
}
