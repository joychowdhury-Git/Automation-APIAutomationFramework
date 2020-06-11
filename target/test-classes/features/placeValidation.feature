Feature: Verify add place Apis

#Scenario: Verify if add place api functionality
	#Given Add place Payload
	#When user call "AddPlaceAPI" with "post" http request
	#Then The API call got success with status code 200
	#And "status" in response body is "OK"

@Addplace	
Scenario Outline: Verify if add place api functionality
	Given Add place Payload with <name> <language> <address>
	When user call "AddPlaceAPI" with "POST" http request
	Then The API call got success with status code 200
	And "status" in response body is "OK"
	And verify the place_id created maps to <name> using "GetPlaceAPI"
	
Examples:

	|name       | language |address            |
	|Rriti house|English   |World Trade center |
	#|Joy House  |French    |California         |

@DeletePlace
Scenario: Verify if delete place api functionality
	Given deleteplace payload
	When user call "DeletePlaceAPI" with "POST" http request
	Then The API call got success with status code 200
	And "status" in response body is "OK"
