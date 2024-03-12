package GoogleNavigation;

import io.restassured.path.json.JsonPath;

public class CommonMethods {

	public static JsonPath rawToJson(String respose) {
		JsonPath js = new JsonPath(respose);
		return js;
	}
}
