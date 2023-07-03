
package Common_APIMethods;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Patch_Method {
	public static int ResponseStatusCode(String BaseURI,String Resource, String RequestBody) {
		RestAssured.baseURI=BaseURI;
		
		 int ResponseStatusCode = given().header("Content-Type","application/json").body(RequestBody)
		 .when().patch(Resource).then().extract().statusCode();
		 return ResponseStatusCode;
	}
	
	public static String ResponseBody(String BaseURI,String Resource, String RequestBody) {
		RestAssured.baseURI=BaseURI;
		
		 String ResponseBody = given().header("Content-Type","application/json").body(RequestBody)
		 .when().patch(Resource).then().extract().response().asString();
		 return ResponseBody;
	}

}
