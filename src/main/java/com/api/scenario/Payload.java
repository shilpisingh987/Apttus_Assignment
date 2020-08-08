package com.api.scenario;

public class Payload {

public static String AddPlace() {
		
		return "{\r\n" + 
				"\"external_id\":\"DEMO_TEST001\",\r\n" + 
				"\"name\":\"San Francisco Test Station\",   \r\n" + 
				"\"latitude\": 33.33,\r\n" + 
				"\"longitude\": -111.43,\r\n" + 
				"\"altitude\" : 444\r\n" + 
				"}";
}
}