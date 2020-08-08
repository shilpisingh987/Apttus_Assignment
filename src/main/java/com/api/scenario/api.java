package com.api.scenario;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class api {

	@Test(priority = 1)
	public void postStationWithKey() {

		JsonObject json1 = new JsonObject();
		json1.addProperty("external_id", "DEMO_TEST002");
		json1.addProperty("name", "San Francisco Test Station 123");
		json1.addProperty("latitude", 33.33);
		json1.addProperty("longitude", -111.43);
		json1.addProperty("altitude", 444);

		RestAssured.baseURI = "http://api.openweathermap.org/";

		RequestSpecification httpRequest = RestAssured.given();

		String endpoint = "data/3.0/stations";
		Response response = httpRequest.queryParam("APPID", "ff4a52244d14cd46f45c594d5fa2684d")
				.header("Content-Type", "application/json").body(json1).log().all().post(endpoint);

		String responseBody = response.getBody().asString();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println(responseBody);
	}

	@Test(priority = 2)

	public void getStation() {
		RestAssured.baseURI = "http://api.openweathermap.org/";
		String getStringResponse = given().log().all().queryParam("APPID", "4755daadb056244b06b01b722278b0b1").when()
				.get("data/3.0/stations").then().assertThat().log().all().statusCode(200).extract().response()
				.asString();
		System.out.println(getStringResponse);
	}

	@Test(priority = 3)
	public void deleteRequest() {

		JsonObject json1 = new JsonObject();
		json1.addProperty("id", "5f2921fecca8ce0001ef5027");
		json1.addProperty("created_at", "2020-08-03T12:50:08.994Z");
		json1.addProperty("updated_at", "2020-08-03T12:50:08.994Z");
		json1.addProperty("external_id", "DEMO_TEST001");
		json1.addProperty("name", "San Francisco Test Station");
		json1.addProperty("longitude", -111.43);
		json1.addProperty("longitude", 33.33);
		json1.addProperty("altitude", 444);
		json1.addProperty("altitude", 10);

		RestAssured.baseURI = "http://api.openweathermap.org/";

		RequestSpecification httpRequest = RestAssured.given();

		String endpoint = "data/3.0/stations/5f2921fecca8ce0001ef5027";

		Response response = httpRequest.queryParam("APPID", "ff4a52244d14cd46f45c594d5fa2684d")
				.header("Content-Type", "application/json").body(json1).log().all().delete(endpoint);

		String responseBody = response.getBody().asString();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 204);
		System.out.println(responseBody);
	}

	@Test(priority = 4)
	public void getdeleteRequest() {

		JsonObject json1 = new JsonObject();
		json1.addProperty("id", "5f2921fecca8ce0001ef5027");
		json1.addProperty("created_at", "2020-08-03T12:50:08.994Z");
		json1.addProperty("updated_at", "2020-08-03T12:50:08.994Z");
		json1.addProperty("external_id", "DEMO_TEST001");
		json1.addProperty("name", "San Francisco Test Station");
		json1.addProperty("longitude", -111.43);
		json1.addProperty("longitude", 33.33);
		json1.addProperty("altitude", 444);
		json1.addProperty("altitude", 10);

		RestAssured.baseURI = "http://api.openweathermap.org/";

		RequestSpecification httpRequest = RestAssured.given();

		String endpoint = "data/3.0/stations/5f2921fecca8ce0001ef5027";

		Response response = httpRequest.queryParam("APPID", "ff4a52244d14cd46f45c594d5fa2684d")
				.header("Content-Type", "application/json").body(json1).log().all().get(endpoint);

		String responseBody = response.getBody().asString();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 404);
		System.out.println(responseBody);

	}

	@Test(priority = 5)
	public void getStationWithoutKey() {
		RestAssured.baseURI = "http://api.openweathermap.org/";
		String getresponse = given().log().all().header("Content-Type", "application/json").body(Payload.AddPlace())
				.when().get("data/3.0/stations").then().assertThat().statusCode(401).extract().asString();
		System.out.println(getresponse);
	}

}