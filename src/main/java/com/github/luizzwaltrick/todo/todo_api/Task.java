package com.github.luizzwaltrick.todo.todo_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private boolean isCompleted;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isComplete() {
        return isCompleted;
    }

    public void setComplete(boolean isComplete) {
        this.isCompleted = isComplete;
    }
}
