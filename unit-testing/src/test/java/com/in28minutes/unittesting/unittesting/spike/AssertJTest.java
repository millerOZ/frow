package com.in28minutes.unittesting.unittesting.spike;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {
	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12,15,45);
//		assertThat(numbers,hasSize(3));
		assertThat(numbers).hasSize(3)
						   .contains(12,15)
						   .allMatch(x -> x > 10)
						   .allMatch(x -> x < 100)
						   .noneMatch(x -> x < 0);
		
		assertThat("").isEmpty();
		assertThat("AABCD").contains("BC")
						   .startsWith("AA")
						   .endsWith("D");
//		assertThat(numbers,hasItems(12,15));
//		assertThat(numbers,everyItem(greaterThan(11)));
//		assertThat(numbers,everyItem(lessThan(100)));
//		
//		assertThat("",isEmptyString());
//		assertThat("ABCD",containsString("BCD"));
//		assertThat("ABCD",startsWith("ABC"));
//		assertThat("ABCD",endsWith("CD"));
	}
}
