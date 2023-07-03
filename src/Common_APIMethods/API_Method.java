package Common_APIMethods;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class API_Method {
	public static int ResponseStatusCode(String BaseURI,String Resource,String requestBody) {
		RestAssured.baseURI=BaseURI;
		
		
		int ResponseStatusCode=given().header("Content-Type","application/json").body(requestBody).when().
				post(Resource).then().extract().statusCode();
		return ResponseStatusCode;
     }
	
	public static String ResponseBody(String BaseURI,String Resource,String requestBody) {
		RestAssured.baseURI=BaseURI;
		
		String ResponseBody=given().header("Content-Type","application/json").body(requestBody).when().
				post(Resource).then().extract().response().asString();
		return ResponseBody;
     }
}
