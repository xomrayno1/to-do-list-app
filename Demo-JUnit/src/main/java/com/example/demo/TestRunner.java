package com.example.demo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestEmployeeDetails.class);
		// lấy kết quả của các testcase
		for(Failure item : result.getFailures()) {
			System.out.println(item.toString());
			//trả về thông tin testcase false
		}
		System.out.println(result.wasSuccessful());
		// trả về true  nếu class đó các testcase đều true
	}
}