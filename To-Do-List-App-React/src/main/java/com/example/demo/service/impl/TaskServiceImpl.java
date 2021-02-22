package com.example.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;

@Service
public class TaskServiceImpl  implements TaskService{
	@Autowired
	TaskRepository taskRepo;

	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		task.setCreateDate(new Date());
		task.setUpdateDate(new Date());
		return taskRepo.save(task);
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
	 
		task.setUpdateDate(new Date());
		return taskRepo.save(task);
	}

	@Override
	public void deleteTask(Task task) {
		// TODO Auto-generated method stub
		taskRepo.delete(task);
	}

	@Override
	public Page<Task> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return taskRepo.findAll(pageable);
	}

	@Override
	public Task findById(long id) {
		// TODO Auto-generated method stub
		return taskRepo.findById(id).orElse(null);
	}

	@Override
	public Page<Task> findByName(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return taskRepo.findByNameContainingAllIgnoreCase(name, pageable);
	}

}
