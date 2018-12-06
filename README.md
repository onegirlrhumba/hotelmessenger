# hotelmessenger
README for HotelMessenger application
Author: Kirsten Ruge

Running the program

The Messenger can be run from the command line with “java -jar Messenger.jar”. The user will be prompted to enter a Hotel ID (integer), Guest ID (integer) and either a Message Template ID (integer) or a custom message using the provided space-holders for custom inputs such as hotel name, checkout time, etc.

The necessary JSON files (Companies.json, Guests.json, Messages.json) are included in the main directory along with all necessary libraries as listed in the manifest. 

Thoughts behind the design

	I created objects to represent Guest, Company, Message and Request in order to pass around the required data from the different JSON files. I used the Google GSON library to parse the JSON data into said objects. I had to add quite a bit of logic around validating the user inputs as I was storing all the needed data in various HashMaps with Integers as the keys and any non Integer inputs would cause exceptions. I’ve put Utility type methods in the Util class and broken the Main class into a runnable main method and formMessage method to make it easier to unit test with JUNit, which I did, although I mostly tested each part of this application manually through running it with all sorts of problematic inputs and debugging the code.
	I added functionality to parse the Epoch timestamp values into human-readable date time fields with correct timezone adjustments, and was planning on adding the option to send a customer the amount of time they have left until check-in or check-out until I realized the dates in the sample data are from 2017. Maybe I will go in there and change them so I can add in a “count down” option to the message templates fields.
	
Language choice

	Java was my first programming language, and I feel most comfortable with its object-oriented functionality. I’ve also used the GSON library extensively in the past. I also have a better understanding of how to handle exceptions in Java than Python or JavaScript. 

Process for verifying correctness of code

	I wrote some basic unit test using JUnit and System tools that are included in the project. For the most part, however, I ran and debugged the program using different inputs and noted whether the outcomes were as expected or not. I made the decision to handle most common user-input error situations within the code and not catch it as an exception, as you can see in the do/while loops for each of the three user input sections.
	
	

What I wish I’d had time to do

	I know that a lot of my code is in Main currently that and that isn’t ideal, especially for unit testing, so if I had a little more time I would refactor most of that into methods that would be easier to unit test. Also, I am 100% positive that this application as it exists right now will not scale well, and if I had had more time I would have refactored it as a multithreaded application with some load balancing. Were this in an enterprise setting, I’m sure this would have been written as an API and potentially using Kafka or a similar system to handle massive amounts of requests and responses.
	If I had more time to devote to this project, I would try to learn some new tools to make it more real-world, enterprise ready, and to level up my knowledge of scalability in Java and current API best practices. That being said, I had a lot of fun figuring this challenge out and am really glad I took the time to complete it for you! 
	
	
