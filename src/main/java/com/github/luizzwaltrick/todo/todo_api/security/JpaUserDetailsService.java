package com.github.luizzwaltrick.todo.todo_api.security;

import com.github.luizzwaltrick.todo.todo_api.users.User;
import com.github.luizzwaltrick.todo.todo_api.users.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        User myUser = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));

        return new org.springframework.security.core.userdetails.User(
                myUser.getUsername(),
                myUser.getPassword(),
                Collections.emptyList()
        );
    }
}
