package stepDefinitions;

import cucumber.api.java.*;

public class Hooks {

	@Before("@DeletePlace")
	public void beforescenario() throws Exception
	{
		StepDefinition sd= new StepDefinition();
		
		if(StepDefinition.placeId==null) {
		sd.add_place_Payload_with("Joy", "English", "India");
		sd.user_call_with_http_request("AddPlaceAPI", "POST");
		sd.verify_the_place_id_created_maps_to_using("Joy", "GetPlaceAPI");
	}
		
	}
	
	
}
