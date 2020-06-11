package stepDefinitions;

import static io.restassured.RestAssured.given;
import org.junit.Assert;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestdataBuild;
import resources.Utils;
import cucumber.api.java.en.*;

public class StepDefinition extends Utils {

	RequestSpecification reqspec;
	ResponseSpecification resspec;
	Response response;
	static String placeId;
	TestdataBuild databuild = new TestdataBuild();

	@Given("^Add place Payload with (.+) (.+) (.+)$")
	public void add_place_Payload_with(String name, String language, String address) throws Exception {		
		reqspec = given().spec(Requestspecificationdetails())
			 .body(databuild.addplacepayload(name, language, address));	
	}
	
	@When("^user call \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void user_call_with_http_request(String resource, String httprequest) {	
		
		resspec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
		
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(httprequest.equals("POST")) 
		{
		response =  reqspec.when().post(resourceAPI.getResource());
	    }
		else if (httprequest.equals("GET")) {
			response =  reqspec.when().get(resourceAPI.getResource());
		}
		else if (httprequest.equals("DELETE")) {
			response =  reqspec.when().delete(resourceAPI.getResource());
		}
	}

	@Then("^The API call got success with status code (\\d+)$")
	public void the_API_call_got_success_with_status_code(Integer code) {
		Assert.assertEquals(response.getStatusCode(),200);
	}

	@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String keyvalue, String Expectedvalue) {
		
		Assert.assertEquals(getJsonpath(response, keyvalue),Expectedvalue);		
	}
	
	@And("^verify the place_id created maps to (.+) using \"([^\"]*)\"$")
	public void verify_the_place_id_created_maps_to_using(String expectedname, String resource) throws Exception {
		placeId = getJsonpath(response, "place_id");
	    //requestspec
		reqspec= given().spec(Requestspecificationdetails()).queryParam("place_id", placeId);
		user_call_with_http_request(resource, "GET");
		String actualname = getJsonpath(response, "name");
		Assert.assertEquals(actualname, expectedname);
	}
	
	 @Given("^deleteplace payload$")
	public void deleteplace_payload() throws Exception {
	   
		 reqspec = given().spec(Requestspecificationdetails()).body(databuild.Deleteplacepayload(placeId));
	}		
}
