/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Alex Beaver
 * @version 17 OCT
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		statement = statement.toLowerCase();
		if(statement.trim().length() <= 0){
		    response = "Please say something";
		}
		else if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0){
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("cat") >= 0
				|| statement.indexOf("kitten") >= 0
				|| statement.indexOf("dog") >= 0
				|| statement.indexOf("puppy") >= 0){
			response = "Tell me more about your pets.";
		}
		else if (statement.indexOf("malloy") >= 0
				|| statement.indexOf("ettlin") >= 0
				|| statement.indexOf("mr. um") >= 0){
			response = "He sounds like a good teacher.";
		}
		else if (statement.indexOf("No")>=0){
		    response = "Please maintain gracious profressionalism";
		}
		else if (statement.indexOf("brother") >= 0 || statement.indexOf("sister")>=0){
		    response = "Do you get along?";
		}
		else if(statement.indexOf("javascript") >= 0 || statement.indexOf("es6") >= 0){
		    response = "WHY?";
		}
		else{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Wow.";
		}
		else if (whichResponse == 5)
		{
			response = "Fascinating.";
		}

		return response;
	}
}
