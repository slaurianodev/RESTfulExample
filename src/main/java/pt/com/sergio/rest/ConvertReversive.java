package pt.com.sergio.rest;

import pt.com.sergio.rest.ConvertContentService.Converter;

public class ConvertReversive implements Converter {

	public String convert(String input) {
		return !input.isEmpty() ? convert(input.substring(1)) + input.charAt(0) : input;
	}

}
