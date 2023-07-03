package TEST_Classes;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_APIMethods.API_Method;
import Common_APIMethods.Common_Utility_Method;
import Request_Repositary.Post_Req_repository;
import io.restassured.path.json.JsonPath;

public class Post_TC1 {
	@Test
	public static void  extractor() throws IOException {
		for (int i =1;i<5;i++) {
		int ResponseStatusCode=API_Method.ResponseStatusCode(Post_Req_repository.BaseURL(), 
				Post_Req_repository.Resource(),Post_Req_repository.Post_TC1());
		System.out.println("ResponseStatusCode" + ResponseStatusCode);
		
		if (ResponseStatusCode == 201) {
		
		String ResponseBody=API_Method.ResponseBody(Post_Req_repository.BaseURL(),
				Post_Req_repository.Resource(),Post_Req_repository.Post_TC1());
		String RequestBody=API_Method.ResponseBody(Post_Req_repository.BaseURL(),
				Post_Req_repository.Resource(),Post_Req_repository.Post_TC1());
	
	
		System.out.println("ResponseBody \n" + ResponseBody);
		Common_Utility_Method.EvidenceCreator("Post_TC1", RequestBody, ResponseBody, ResponseStatusCode);
		validator(ResponseBody,RequestBody);
		break;
		}else {
			System.out.println(i + "incorrect stastus code received :" + ResponseStatusCode);
		}
	  }
	}
	    public static void validator(String ResponseBody,String RequestBody) {
	    JsonPath Jsprequest=new JsonPath(RequestBody);
		String Req_name=Jsprequest.getString("name");
		String Req_job=Jsprequest.getString("job");
		LocalDateTime currentdate=LocalDateTime.now();
		String expecteddate=currentdate.toString().substring(0,11);
		
		JsonPath Jspresponse = new JsonPath(ResponseBody);
		String Res_name = Jspresponse.getString("name");
		String Res_job = Jspresponse.getString("job");
		String Res_createdAt = Jspresponse.getString("createdAt");
		Res_createdAt = Res_createdAt.substring(0,11);
		Assert.assertEquals(Res_name,Req_name);
		Assert.assertEquals(Res_job,Req_job);
		Assert.assertEquals(Res_createdAt,expecteddate);
	}

}
