import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class GetExampleTest {
	
	@Test
	public void getUsers() {
		Response res=given().baseUri("https://reqres.in/").when().get("api/users?page=2");
		Assert.assertTrue(res.statusCode()==200);
		JsonPath path = res.jsonPath();
		String s=path.get("support.url").toString();
		System.out.println("anser="+s);
		Assert.assertTrue(s.contains("contentcaddy.io"));
		
		String total=path.get("total").toString();
		System.out.println("total="+total);
		Assert.assertTrue(total.equals("12"));
		
	}

}
