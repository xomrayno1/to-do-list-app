package com.example.demo.test.demo;

import org.springframework.stereotype.Repository;

@Repository
public class DataService {

	public int[] retrieveAllData() {
		return new int[] {1,2,4,2,6,8,10};
	}
}
