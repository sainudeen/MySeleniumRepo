package RestAssuredTestNG;

import org.apache.xpath.operations.Equals;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.matcher.*;

public class RestAssuredPostTrello {

	public static String key = "ff376935503b1ec01eeed8b136bd9a54";
	public static String token = "ATTA31c7627701ce096bb01dca5e914a289e4c66ea153c2495dd47282088ff0b3d78A9174E58";
	public static String updateColor = "pink";
	public static String updateName = "UpdateNewNameNew";

	@Test
	public void TrelloPost() {

		RestAssured.baseURI = "https://trello.com/1/";

		
		  Response res=given().queryParam("key", key). queryParam("name",
		  "28March2024New"). queryParam("token", token).
		  header("Content-Type","application/json").log().all()
		  .when().post("/boards/");
		 
		JsonPath path = res.jsonPath();
		String id = path.getString("id");

		System.out.println("Created Board Id is: " + id);

		res.then().assertThat().statusCode(200).log().all();

		// put operation
		try {
			given().queryParam("name", updateName).queryParam("key", key).queryParam("token", token)
					.queryParam("prefs/background", updateColor).header("Content-Type", "application/json")
					.pathParam("id", id).log().all().when().put("/boards/{id}").then().log().all().assertThat()
					.statusCode(200).body("name", Matchers.equalTo(updateName))
					.body("prefs.background", Matchers.equalTo(updateColor)).statusCode(200);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// "name", equalsTo(updateName)
		// get operation

		Response res2 = given().queryParam("key", key).queryParam("token", token)
				.header("Content-Type", "application/json").pathParam("id", id).log().all().when().get("/boards/{id}");

		res2.then().assertThat().body("name", Matchers.equalTo(updateName))
				.body("prefs.background", Matchers.equalTo(updateColor)).statusCode(200);

		// delete operations

		given().queryParam("key", key).queryParam("token", token).header("Content-Type", "application/json")
				.pathParam("id", id).log().all().when().delete("/boards/{id}").then().log().all().assertThat()
				.statusCode(200);

	}
}
