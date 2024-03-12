package GoogleNavigation;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;

public class AddPlace {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.addPlace()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
				.extract().response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println(placeId);

//		Update

		String expectedAddress = "Sanfransisco";

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"" + expectedAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")
				.when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

//		Get Schema
		String getPlaceResponse = given().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				.header("Content-Type", "application/json").when().get("/maps/api/place/get/json").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();

		System.out.println(getPlaceResponse);
		JsonPath js1=CommonMethods.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		Assert.assertEquals(expectedAddress, actualAddress);

		System.out.println(actualAddress);
	}
}
