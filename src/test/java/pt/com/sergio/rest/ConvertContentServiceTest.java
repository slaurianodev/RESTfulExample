package pt.com.sergio.rest;

import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConvertContentServiceTest {

	@Test
	public void test() {
		ConvertContentService ctService = new ConvertContentService();
		
		String[] result = ctService.convert("Hello");
		String[] expected = {"olleH"};
		
		assertArrayEquals(expected, result);
	}
}
