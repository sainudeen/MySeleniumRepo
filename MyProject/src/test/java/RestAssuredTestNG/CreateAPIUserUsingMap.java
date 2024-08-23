package RestAssuredTestNG;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateAPIUserUsingMap {

	public static String token = "Bearer 6d29ff32cffaef485b8b01a8a65c203fcbc148727f57f0e1b54f66a3d1bd44cb";

	@Test
	public void CreateuserUsingMapAsBody() {

		/*
		 * String bodyContent = "{\n" + "    \"name\": \"Sainu SAi VV\",\n" +
		 * "    \"email\": \"saiabc@bosco.example\",\n" + "    \"gender\": \"male\",\n"
		 * + "    \"status\": \"active\"\n" + "}";
		 */
		HashMap<Object,Object> bodyContent=new HashMap<Object,Object>();
		bodyContent.put("name", "SampleRestGoNew");
		bodyContent.put("email", "SampleRestGoNew@bosco.example");
		bodyContent.put("gender", "male");
		bodyContent.put("status", "active");
		
		
		//put / create user
		
		Response response= given().header(
		"Authorization","Bearer 6d29ff32cffaef485b8b01a8a65c203fcbc148727f57f0e1b54f66a3d1bd44cb"
		) .header("Content-Type", "application/json").body(bodyContent).log().all()
		.when().post("https://gorest.co.in/public/v2/users");
		
		JsonPath path = response.jsonPath();
		String id = path.getString("id");
		System.out.println("Created User Id is: " + id);

		response.then().assertThat().statusCode(201).log().all();

		
		
		// get / extract the values
		Response responseGet= given().header(
				"Authorization","Bearer 6d29ff32cffaef485b8b01a8a65c203fcbc148727f57f0e1b54f66a3d1bd44cb"
				) .header("Content-Type", "application/json").pathParam("id", id).log().all()
				.when().get("https://gorest.co.in/public/v2/users/{id}");
		
		responseGet.then().assertThat().statusCode(200).log().all();
		
		
		
		Response responseDelete= given().header(
				"Authorization","Bearer 6d29ff32cffaef485b8b01a8a65c203fcbc148727f57f0e1b54f66a3d1bd44cb"
				) .header("Content-Type", "application/json").pathParam("id", id).log().all()
				.when().delete("https://gorest.co.in/public/v2/users/{id}");
		responseDelete.then().assertThat().statusCode(204).log().all();
		
		System.gc();
		

	}

	
}
