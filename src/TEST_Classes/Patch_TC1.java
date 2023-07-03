package TEST_Classes;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_APIMethods.Patch_Method;
import Request_Repositary.Patch_Req_repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 {
	@Test
	public static void extractor() {
		int ResponseStatusCode=Patch_Method.ResponseStatusCode(Patch_Req_repository.BaseURL(),Patch_Req_repository.Resource(),Patch_Req_repository.RequestBody());
		System.out.println(ResponseStatusCode);
		
		String ResponseBody=Patch_Method.ResponseBody(Patch_Req_repository.BaseURL(),Patch_Req_repository.Resource(),Patch_Req_repository.RequestBody());
		System.out.println(ResponseBody);
		String RequestBody=Patch_Method.ResponseBody(Patch_Req_repository.BaseURL(),Patch_Req_repository.Resource(),Patch_Req_repository.RequestBody());
		
		JsonPath Jsprequest = new JsonPath(RequestBody);
		String Req_Name = Jsprequest.getString("name");
		String Req_Job = Jsprequest.getString("job");
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate=currentdate.toString().substring(0, 11);
		
		JsonPath Jspresponse=new JsonPath(ResponseBody);
		String Res_Name = Jspresponse.getString("name");
		String Res_Job = Jspresponse.getString("job");
		String Res_updatedAt = Jspresponse.getString("updatedAt");
		Res_updatedAt = Res_updatedAt.substring(0,11);
		Assert.assertEquals(Res_Name,Req_Name);
		Assert.assertEquals(Res_Job,Req_Job);
		Assert.assertEquals(Res_updatedAt,expecteddate);
	}

}
