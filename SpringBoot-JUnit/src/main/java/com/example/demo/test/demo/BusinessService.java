package com.example.demo.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

	@Autowired
	private DataService dataService;
	
//	public BusinessService(DataService dataService) {
//		super();
//		this.dataService = dataService;
//	}

	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;

		for (int value : data) {
			if (value > greatest) {
				greatest = value;
			}
		}
		return greatest;
	}
}
