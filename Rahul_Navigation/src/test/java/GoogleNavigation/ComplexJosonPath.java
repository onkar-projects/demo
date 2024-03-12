package GoogleNavigation;

import io.restassured.path.json.JsonPath;

public class ComplexJosonPath {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(Payload.coursePrize());
		
		int count = js.getInt("courses.size()");
		
		System.out.println(count);
		
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		String title = js.getString("courses[0].title");
		
		System.out.println(title);
		
		for(int i = 0; i<3; i++) {
			String allTitle = js.getString("courses["+i+"].title");
			System.out.println(allTitle);
		}
		
		for(int i = 0; i<3; i++) {
			String allTitle = js.getString("courses["+i+"].title");
			if(allTitle.equalsIgnoreCase("RPA")) {
				int rpaCopies = js.getInt("courses["+i+"].copies");
				System.out.println(rpaCopies);	
				break;
			}
		}
	}
}
