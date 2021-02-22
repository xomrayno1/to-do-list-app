package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.model.request.Pagination;
import com.example.demo.repository.TaskRepository;
import com.example.demo.response.APIResponse;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping
	public ResponseEntity<APIResponse> showAll(@RequestParam("limit") int limit,
			@RequestParam("page") int page){
		PageRequest pageRequest = PageRequest.of(page - 1, limit);
		Page<Task> tasks = taskRepository.findAll(pageRequest);
		
		return new ResponseEntity<APIResponse>(new APIResponse(tasks.getContent(),
										new Pagination(page,limit,tasks.getTotalElements())),HttpStatus.OK);
	}
	

}
