package GoogleNavigation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import  static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicJson {
	
	
	
	@Test(dataProvider = "AddBook")
	public void addBook(String isbn,String aisle) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response =	given().body(Payload.addBook(isbn,aisle))
			.when().post("/Library/Addbook.php")
			.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = CommonMethods.rawToJson(response);
		
		String id = js.getString("ID");
		System.out.println(id);
		}
	
	
	@DataProvider(name = "AddBook")
	public Object[][] getData() {
		return new Object[][] {{"sdf","123456"},{"sadf","879879"}};
	}
	}