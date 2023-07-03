package Request_Repositary;

import java.io.IOException;
import java.util.ArrayList;

import Common_APIMethods.Common_Utility_Method;

public class Post_Req_repository {
	public static String BaseURL() {
		String BaseURL="https://reqres.in/";
		return BaseURL;
	}
	public static String Resource() {
		String Post_resource="api/users";
		return Post_resource;
	}
	
	public static String Post_TC1() throws IOException {
		ArrayList<String> Req_Data = Common_Utility_Method.ReadDataExcel("PostTC1","TC3");
		System.out.println(Req_Data);
		String Req_Name = Req_Data.get(1);
		String Req_Job = Req_Data.get(2);
		String RequestBody="{\r\n"
				+ "    \"name\": \""+Req_Name+"\",\r\n"
				+ "    \"job\": \""+Req_Job+"\"\r\n"
				+ "}";
		return RequestBody;
	}

}
