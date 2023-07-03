package TEST_Classes;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_APIMethods.Put_API_Method;
import Request_Repositary.Put_Req_repository;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {
	@Test
	public static void extractor() {
		int ResponseCode=Put_API_Method.ResponseStatusCode(Put_Req_repository.BaseURI(),Put_Req_repository.Resource(),Put_Req_repository.Put_TC1());
		System.out.println(ResponseCode);
		
		String ResponseBody= Put_API_Method.ResponseBody(Put_Req_repository.BaseURI(),Put_Req_repository.Resource(),Put_Req_repository.Put_TC1());
		System.out.println(ResponseBody);
		String RequestBody= Put_API_Method.ResponseBody(Put_Req_repository.BaseURI(),Put_Req_repository.Resource(),Put_Req_repository.Put_TC1());
		//System.out.println(ResponseBody);
		
		JsonPath Jsprequest = new JsonPath(RequestBody);
		String Req_Name = Jsprequest.getString("name");
		String Req_Job = Jsprequest.getString("job");
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate=currentdate.toString().substring(0, 11);
		
		
		//Create an object to JSON path to parse an response body;
		JsonPath Jspresponse = new JsonPath(ResponseBody);
		String Res_Name=Jspresponse.getString("name");
		String Res_Job=Jspresponse.getString("job");
		String Res_updatedAt=Jspresponse.getString("updatedAt");
		Res_updatedAt = Res_updatedAt.substring(0,11);
		//Validate the response body parameters
		Assert.assertEquals(Res_Name,Req_Name);
		Assert.assertEquals(Res_Job,Req_Job);
		Assert.assertEquals(Res_updatedAt, expecteddate);
	}
}
