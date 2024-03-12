package GoogleNavigation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonValidation {
	
	@Test
	public void sumOfCourses() {
		JsonPath js = new JsonPath(Payload.coursePrize());
		
		int count = js.getInt("courses.size()");
		int sum = 0;
		for(int i=0; i< count ;i++) {
			int price = js.get("courses["+i+"].price");
			int copies = js.get("courses["+i+"].copies");
			int amount = price * copies;
			System.out.println(amount);
			sum = sum + amount;
		}
		System.out.println("sum = "+sum);
		
	int purchesAmt=	js.getInt("dashboard.purchaseAmount");
	
	Assert.assertEquals(sum, purchesAmt);
	}
}
