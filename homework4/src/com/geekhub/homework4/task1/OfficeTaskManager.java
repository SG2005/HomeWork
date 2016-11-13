package com.geekhub.homework4.task1;

import java.time.LocalDateTime;
import java.util.*;

public class OfficeTaskManager implements TaskManager {
    private Map<LocalDateTime, Task> tasks = new TreeMap<>();

    public Map<LocalDateTime, Task> getTasks() {
        return this.tasks;
    }

    @Override
    public void add(LocalDateTime date, Task task) {
        tasks.put(date, task);
    }

    @Override
    public void remove(LocalDateTime date) throws NoSuchElementException {
        Iterator<LocalDateTime> iterator = tasks.keySet().iterator();
        boolean flag = false;
        while (iterator.hasNext()) {
            if (iterator.next().equals(date)) {
                iterator.remove();
                flag = true;
            }
        }
        if (!flag) {
            throw new NoSuchElementException("There is no element with this date");
        }
    }

    @Override
    public Set<String> getCategories() {
        Set<String> categories = new HashSet<>();
        for (Task task : this.tasks.values()) {
            categories.add(task.getCategory());
        }
        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) throws NoSuchElementException {
        if (categories.length == 0) {
            throw new NoSuchElementException("You didn't specify a categories");
        }
        Map<String, List<Task>> tasksByCategories = new HashMap<>();
        for (String category : categories) {
            tasksByCategories.put(category, getTasksByCategory(category));
        }
        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) throws NoSuchElementException {
        boolean flag = false;
        List<Task> tasksByCategory = new ArrayList<>();
        for (Task task : this.tasks.values()) {
            if (task.getCategory().equalsIgnoreCase(category)) {
                tasksByCategory.add(task);
                flag = true;
            }
        }
        if (!flag) {
            throw new NoSuchElementException("There is no element with this category");
        }
        return tasksByCategory;
    }

    @Override
    public List<Task> getTasksForToday() throws NoSuchElementException {
        List<Task> tasksForToday = new ArrayList<>();
        for (Map.Entry<LocalDateTime, Task> entry : tasks.entrySet()) {
            if (entry.getKey().toLocalDate().equals(LocalDateTime.now().toLocalDate())) {
                tasksForToday.add(entry.getValue());
            }
        }
        if (tasksForToday.isEmpty()) {
            throw new NoSuchElementException("There are no tasks today.");
        }
        return tasksForToday;
    }
}
