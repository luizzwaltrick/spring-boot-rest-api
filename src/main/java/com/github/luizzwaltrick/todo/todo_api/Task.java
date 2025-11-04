package com.github.luizzwaltrick.todo.todo_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public record Task (
    @Id @GeneratedValue
    long id,

    String title,
    boolean isComplete
) {

}
