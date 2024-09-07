package com.example.task_management;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {

        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(updatedTask.getTitle());
        task.setPriority(updatedTask.getPriority());
        task.setCompletionTime(updatedTask.getCompletionTime());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksSortedByCreatedTime() {
        return taskRepository.findAllByOrderByCreatedTimeAsc();
    }

    public List<Task> getTasksSortedByPriority() {
        return taskRepository.findAllByOrderByPriorityAsc();
    }
}
