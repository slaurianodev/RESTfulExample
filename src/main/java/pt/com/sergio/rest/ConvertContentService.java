package pt.com.sergio.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;

@Path("/")
public class ConvertContentService {
	
	public interface Converter{
		String convert(String input);
	}
	
	List<Converter> converters;
	
	@POST
	@Path("convert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertContent(ContentDTO input) {
		String output = "Hi: " + input.getInput();
		 
		return Response.status(200).entity(output).build();
	}
	
	public String[] convert(String input) {
		List<String> result = new ArrayList<String>();
		converters = new ArrayList<Converter>();
		
		ConvertReversive reversive = new ConvertReversive();
				
		converters.add(reversive);
		
		for(Converter function: converters)
			result.add(function.convert(input));
		
		return result.toArray(new String[0]);
	}
}
