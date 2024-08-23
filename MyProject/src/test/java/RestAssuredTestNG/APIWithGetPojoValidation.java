package RestAssuredTestNG;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import pojo.FrankfurterPojo;

public class APIWithGetPojoValidation {
  @Test
  public void f() {
	  
	  RestAssured.baseURI = "https://www.frankfurter.app/docs";
	  FrankfurterPojo object=new FrankfurterPojo();
//	  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//	  Response res=given().		  
//	  header("Content-Type","application/json").queryParam("from","GBP").queryParam("to", "USD")
//	  .when().get("https://www.frankfurter.app/latest");
//	  
//	  Response res=given().
//			  header("Content-Type","application/json").queryParam("from","GBP").queryParam("to", "USD")
//			  .when().get("https://www.frankfurter.app/latest");
//	  
	  Response res=given().
			  header("Content-Type","application/json").queryParam("from","GBP")
			  .when().get("https://www.frankfurter.app/latest");
	  
	  
	  
	  object= res.getBody().as(FrankfurterPojo.class);
      
	  res.then().log().all().assertThat()
		.statusCode(200).body("amount", Matchers.equalTo(object.getAmount()))
		.body("base", Matchers.equalTo(object.base))
		.body("date", Matchers.equalTo(object.date))
		.body("rates.AUD", Matchers.equalTo(object.rates.aUD))
		.statusCode(200);
	  
	
      
	  
	  JsonPath path = res.jsonPath();
	  assertEquals(object.base,path.getString("base"),"Both base is matching values :"+object.base);
	  
	  
	  System.out.println(object.getRates().aUD);
	  
	  
	  RestAssured.baseURI="https://www.frankfurter.app";
	  
	  ExtractableResponse<Response> resHistory=given().
			  header("Content-Type","application/json").queryParam("to", "USD").pathParam("date", "2020-01-01")
			  .when().get("{date}")
			  .then().log().all().extract();
	  String contentType = resHistory.contentType();
	  System.out.println(contentType);
	  
	  String[] charArray = resHistory.toString().split(",");
	  
	  for (String c : charArray) {
		System.out.println(c.toString());
	}
	  
	  
	  RestAssured.baseURI = "https://www.frankfurter.app/latest";
	  
	  FrankfurterPojo as = given().header("Content-Type","application/json").queryParam("amount", 10).queryParam("to", "INR")
	  .get().then().log().all().extract().as(FrankfurterPojo.class);
	  
	  System.out.println(as.rates.getiNR());
	  

  }


}
