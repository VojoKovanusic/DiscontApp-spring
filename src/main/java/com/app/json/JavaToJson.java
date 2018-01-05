package com.app.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
 
 
public class JavaToJson {
	 
	private static ObjectMapper maper;
	static {
		maper = new ObjectMapper();
	}

	public static String convertJavaToJSON(Object obj) {
		String jsonRequest = "";

		try {
			jsonRequest = maper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return jsonRequest;
	}
	

	
	
}
