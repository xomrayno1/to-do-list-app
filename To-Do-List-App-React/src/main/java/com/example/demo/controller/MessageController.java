package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
	@GetMapping
	public ResponseEntity<String> getMessage(){
		 String message = "Todo App";
		 
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
