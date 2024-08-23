package RestAssuredTestNG;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.PojoClass;

public class CreateAPIUserPojoClass {
  @Test
  public void CreatePojoClass() throws JsonProcessingException {
	 
	  PojoClass object=new PojoClass();
	  object.setName("Pojo2 VK");
	  object.setEmail("SampleRestGoPojo2@bosco.example");
	  object.setGender("male");
	  object.setStatus("active");
	  
	  ObjectMapper obj= new ObjectMapper();
	  
	  String writeValueAsString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	  
	//put / create user
		
			Response response= given().header(
			"Authorization","Bearer 6d29ff32cffaef485b8b01a8a65c203fcbc148727f57f0e1b54f66a3d1bd44cb"
			) .header("Content-Type", "application/json").body(object.toString()).log().all()
			.when().post("https://gorest.co.in/public/v2/users");
			
			JsonPath path = response.jsonPath();
			String id = path.getString("id");
			System.out.println("Created User Id is: " + id);

			response.then().assertThat().statusCode(201).log().all();
//			PojoClass pojoClass = response.getBody().as(PojoClass.class);
//			System.out.println("Deserilization Name  : "+pojoClass.getName());
//			System.out.println("Deserilization  email : "+pojoClass.getEmail());
//			
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
