package Request_Repositary;

public class Put_Req_repository { 
	public static String BaseURI() {
		String BaseURI = "https://reqres.in/";
		return BaseURI;
	}
	
	public static String Resource() {
		String Put_Resource="api/users/2";
		return Put_Resource;
	}
	
	public static String Put_TC1() {
		String RequestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return RequestBody;
	}
	
         
}
