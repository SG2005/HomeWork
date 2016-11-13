package com.geekhub.homework4.task1;

public class Task {
    private String name;
    private String category;

    public Task(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", category: " + this.category;
    }

    public String getCategory() {
        return category;
    }
}
