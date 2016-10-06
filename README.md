# IS2545 - DELIVERABLE 2: Unit Testing

In this project, I wrote a total of 10 tests.
For each class I constructed a test class that tested the methods of that class.

For the class CitySim9002, I used the test class "CitySimTest".

First, it tested the method "generateSeed" which was used to return the argument passed to the program as an integer.
I used two test cases to test this method, when the argument had only one character and when it had more then one character.
This is a happy path testing because the program already had a validator that filtered entries that were not parsible.

Then, it tested the method "travelCity" that returns an array of strings indicating where the visitor is going and whether they like the location, and the last string should say the visitor has left the city.
This method was difficult to test, because it had some amount of randomness, and I had trouble determining what the method returned.
For example, I tried using a stub for the Random.nextInt() method, which didn't work, and I also seperated the location into a different instance class for this.
I used the instance method "getLocation" and stubbed it, but when I used the "when().thenReturn()" method, it still wouldn't return what I told it to.
But I realized that if set the seed, the Random always returns the numbers in the same order, since I am not interested in how the Random works, I just set the seed and tested if it returns the correct string.
I did this to test if the visitor went somewhere at the first visit, the first string of the return array should always be "Visitor 1 is going to The Point". 
For the second string though, I tried a different way, just checked the part of the string that was always the same.
And I stubbed the method "getPreference" so that the visitor would always like the location, so it should always start with "Visitor 1 did like".
The downside of this part was that I couldn't know exactly what the location was, but I would test the method "getLocation" anyway.
At last I tested if the last string was always "Visitor 1 has left the city."

To test the Visitor class, I used the test class "VisitorTest".
First I tested the method "getVisitorType" which return the type of the visitor as a string.
I created a visitor, set it's type to 0, which is a student, and checked if the method returned "a Student".
Then I tested the method "getPreference" with two test cases. If the visitor did like the location, which should return true and if the visitor did not like the location, which should return false.

For the last Location class, which had only one method "getLocation".
I tested if the method returned the correct string.

All test passed.
