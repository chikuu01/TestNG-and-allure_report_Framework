package Request_Repositary;

public class Patch_Req_repository {
	public static String BaseURL() {
		String BaseURI="https://reqres.in/";
		return BaseURI;
	}
	public static String Resource() {
		String Patch_Resource="api/users/2";
		return Patch_Resource;
	}
	public static String RequestBody() {
		String RequestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return RequestBody;
	}

}
