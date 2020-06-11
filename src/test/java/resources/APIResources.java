package resources;

public enum APIResources {

	//enum is a special class with collection of methods and constants
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	APIResources(String resource) {
		
		this.resource = resource;
		
	}
	
	public String getResource()
	{
		return resource;
	}
	
}
