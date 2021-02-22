package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Task;

public interface TaskService {
	
	Task createTask(Task task);
	Task updateTask(Task task);
	void deleteTask(Task task);
	Page<Task> findAll(Pageable pageable);
	Task findById(long id);
	Page<Task> findByName(String name,Pageable pageable);
}
