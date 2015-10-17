# Test Smells

Test Smells increase the cost of maintenance on a project and can discourage testing. 

### Test Levels
- System (functional)
- Component
- Integration
- Unit Testing

Unit tests provide the highest level of defect localization or the ability to zoom-in on the problem area in a way that higher level tests don't.

### Tests that are not unit tests

According to Michael Feathers author of ["Working Effectively With Legacy Code"](http://www.amazon.com/Working-Effectively-Legacy-Michael-Feathers/dp/0131177052)

> A test is not a unit test if:
>  
> * It talks to the database
> * It communicates across the network
> * It touches the file system
> * It can't run the same time as any of your other tests
> * You have to do special things to your environment (such as editing config files) to run it

[more...](http://www.artima.com/weblogs/viewpost.jsp?thread=126923)

### System (functional, component, integration, etc.) test failing but no unit test failing
This indicates a ***missing unit test***. 

Unit Tests that are __"white box"__ know the implementation of the behavior they are testing.
This is close coupling and will cause __Fragile Tests__ which need to be updated frequently. Unit tests should be __Black Box__ and know only the contract of the SUT.

---

### Test Smell Types
- Code Smells - Visible Problems in Test Code
- Behavior Smells - Tests Behaving Badly
- Project Smells - Testing-related problems isible to a project Manager

***Note:*** Code smells may be root cause of Project and Behavior Smells

---

### Test Smells
- Tests are hard to understand
- Tests contain coding errors that may result in
	- Missed bugs
	- Erratic Tests
- Tests are difficult or impossible to write
	- No Test API on SUT
	- Cannot control initial state of SUT
	- Cannot observe final state of SUT
- Conditional Test Logic
	- Not quite sure what you are testing 
- Hard to Test Code
- Obscure Test (Irrelevant Information)
- Test Code Duplication
- Test Logic in Production
- Hard-Wired Test Data (Obscure Test)
- Verbose Test
- Inline Fixture Teardown
	- Teardown logic is really a smell itself and indicates that you don't have a seam between your persistence layer. 

---

### Solutions
- Custom Assertions - Good for Verbose Tests 
- Replace conditionals with "Guard Assertion"
- Automated Fixture Teardown	
	- Better still to not be coupled to persistence layer when testing business logic.  
- Use generated Values instead of hard-coded values. Indicates to the reader that the value is not important to the test. 
- Instead of cluttering tests with hard-coded values or passing null values, hide the setup using a test object creation method(factory). 
- Utility methods can speed up test writing
	- write tests from __outside in__. Write the methods you wish existed instead of looking for them and use the IDE to implement the body once the test is written. 
- Avoid over generalizing test cases. e.g. `testAddingThreeLineItems()` doesn't really add any benefit to the test suite in addition to `testAddingTwoLineItems`.

---

### Common Behavior Smells
- Slow Tests
	- Shared Fixtures __(bad)__ 
- Erratic Tests
	- Interacting Tests 
		- Shared Fixtures __(bad)__ 
	- Unrepeatable Tests
	- Test Run War	 
- Fragle Tests (The 4 sensitivities)
	- Interface Sensitivity
	- Behavior Sensitivity
	- Data Sensitivity - Tests start failing when a shared fixture is modified. e.g. new records are put in the database. 
	- Context Sensitivity - Something outside the SUT changes. e.g. System time/date, contents of another application.
- Assertion Roulette
- Frequent Debugging
- Manual Intervention

### Solutions
- Fresh Fixture - Ultimate solution for erratic tests. Opposite of a Fresh Fixture is a Stale Fixture. If shared fixture must be used ensure fixture is immutable. 
