package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqspec;
	
	public RequestSpecification Requestspecificationdetails() throws Exception 
	{		
	if(reqspec==null)
	{
	PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));	
	 reqspec = new RequestSpecBuilder()
	.setBaseUri(GlobalKeyvalue("baseUrl"))
	.addQueryParam("key","qaclick123")
	.addHeader("Content-Type", "application/json")
	.addFilter(RequestLoggingFilter.logRequestTo(stream))
	.addFilter(ResponseLoggingFilter.logResponseTo(stream))
	.setContentType(ContentType.JSON)
	.build();
	 return reqspec; 
	}	
	return reqspec;
	}
	
	public static String GlobalKeyvalue(String key) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\joych\\NewWorkspace\\APIAutomation\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);		
		return prop.getProperty(key);	
	}	
	
	public String getJsonpath(Response response, String key) {
		String responseString = response.asString();
		//System.out.println("The response is :"+ responseString);		
		JsonPath js = new JsonPath(responseString);
		return js.get(key).toString();
	}
	
}
