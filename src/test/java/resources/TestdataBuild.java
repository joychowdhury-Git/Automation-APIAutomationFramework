package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.LocationClass;

public class TestdataBuild {

	public AddPlace addplacepayload(String name, String language, String address)
	{
		AddPlace ap = new AddPlace();
		ap.setAccuracy(50);
		//ap.setAddress("29sidelayoutcohen09");
		ap.setAddress(address);
		ap.setLanguage(language);
		//ap.setName("Frontline house");
		ap.setName(name);
		ap.setPhone_number("+919838933937");
		ap.setWebsite("http://www.google.com");
		// add the types
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		ap.setTypes(myList);
		//add the location
		LocationClass loc = new LocationClass();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);		
		ap.setLocation(loc);
		return ap;
	}
	
	
	public String Deleteplacepayload(String placeId)
	{
		return "{\r\n\"place_id\":\""+placeId+"\"\r\n}";
	}
	
}
