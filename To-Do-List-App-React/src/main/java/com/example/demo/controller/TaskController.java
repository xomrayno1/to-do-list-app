package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Task;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.request.Pagination;
import com.example.demo.response.APIResponse;
import com.example.demo.service.TaskService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	
	@GetMapping
	public ResponseEntity<APIResponse> showAll(@RequestParam("limit") int limit,
			@RequestParam("page") int page,
			@RequestParam("title") String name){
		PageRequest pageRequest = PageRequest.of(page - 1, limit);
		Page<Task> tasks = taskService.findByName(name, pageRequest);
//		if(name == null) {
//			tasks = taskService.findAll(pageRequest);
//		}else {
//			tasks = taskService.findByName(name, pageRequest);
//		}
		return new ResponseEntity<APIResponse>(new APIResponse(tasks.getContent(),
										new Pagination(page,limit,tasks.getTotalElements())),
				HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Task> getById(@PathVariable("id") long id){
		 
		Task task = taskService.findById(id);
		if(task == null) {
			throw new ResourceNotFoundException("task not found exception with id :");
		}
		
		return new ResponseEntity<Task>(task,HttpStatus.OK);
	}
	@PostMapping 
	public ResponseEntity<Task> createTask(@RequestBody @Validated Task task){
		 
		task = taskService.createTask(task);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
									.buildAndExpand(task.getId()).toUri();
		return ResponseEntity.created(location).body(task);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable("id") long id){
		 
		Task task = taskService.findById(id);
		if(task == null) {
			throw new ResourceNotFoundException("task not found exception with id :");
		}else {
			taskService.deleteTask(task);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	
}
