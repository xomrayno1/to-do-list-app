package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Task;

@Repository
public interface TaskRepository  extends CrudRepository<Task, Long>{

	Page<Task> findByNameContainingAllIgnoreCase(String name, Pageable pageable);
	Page<Task> findAll(Pageable pageable);
}
