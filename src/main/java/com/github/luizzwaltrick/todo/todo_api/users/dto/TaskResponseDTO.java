package com.github.luizzwaltrick.todo.todo_api.users.dto;

import com.github.luizzwaltrick.todo.todo_api.users.dto.UserResponseDTO;

public record TaskResponseDTO (
    Long id,
    String title,
    boolean isComplete,
    UserResponseDTO user
) {

}
