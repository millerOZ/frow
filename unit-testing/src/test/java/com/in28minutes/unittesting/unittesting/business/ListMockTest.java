package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
	
	List<String> mock = mock(List.class);
	
	@Test
	public void testsize_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	@Test
	public void testDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		
		assertEquals(5,mock.size());
		assertEquals(10,mock.size());
	}
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("TDD");
		assertEquals("TDD", mock.get(0));
	}
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("TDD");
		
		assertEquals("TDD", mock.get(0));
		assertEquals("TDD", mock.get(1));
	}
	@Test
	public void verificationBasics() {
		String value = mock.get(0);
		String value2 = mock.get(1);
		 
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	@Test
	public void argumentCapturing() {
		//SUT
		mock.add("DDD");
		//verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("DDD", captor.getValue());
	}
	@Test
	public void multipleCapturing() {
		//SUT
		mock.add("DDD");
		mock.add("Unit Test");
		//verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mock, times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		
		assertEquals("DDD", allValues.get(0));
		assertEquals("Unit Test", allValues.get(1));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0)); //null
		System.out.println(arrayListMock.size()); //0
		arrayListMock.add("Test"); 
		arrayListMock.add("Test2"); 
		System.out.println(arrayListMock.size()); // 0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size()); //5
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0"); 
		System.out.println(arrayListSpy.get(0)); //test0
		System.out.println(arrayListSpy.size()); //1
		arrayListSpy.add("Test"); 
		arrayListSpy.add("Test2"); 
		System.out.println(arrayListSpy.size()); //3
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size()); //5
		
		arrayListSpy.add("Test6");
		System.out.println(arrayListSpy.size()); //5
		
		verify(arrayListSpy).add("Test6");
	} 
	
}
