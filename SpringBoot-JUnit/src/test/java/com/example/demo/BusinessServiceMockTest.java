package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.test.demo.BusinessService;
import com.example.demo.test.demo.DataService;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceMockTest {

	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	BusinessService businessImpl;
	
	@Test
	public void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 25, 15, 5 });
		assertEquals(25, businessImpl.findTheGreatestFromAllData());
	}
	
	
	
}
