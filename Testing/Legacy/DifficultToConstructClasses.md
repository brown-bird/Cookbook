# Difficult To Construct Classes

*Or "I can't get this class in a test harness"*

Techniques for writing tests for classes which have constructors that have dependencies on concrete implementations or dependencies with unwanted behavior. 

## Solutions

### Extract Interface

If the constructor of the class depends on a concrete implementation which itself is difficult to construct or has unwanted behavior, decouple the two classes by extracting an interface from the dependency on the dependent behavior. 

A race team class with a constructor like:

~~~java
Team(Paul driver, Sam mechanic, int teamNumber)
~~~	

Can be modified to depend on abstractions for it's dependencies:

~~~java
Team(Driver driver, Mechanic mechanic, int teamNumber)
~~~
Where the abstractions are based on the behavior that was used by the Team class for each dependecy.

~~~java
public interface Driver
{
	public void go(boolean realFast);
	public void stop(boolean realHard);
	public void turn(int turnRate, Direction direction, double finalAngle);
}

public interface Mechanic
{
	public Status checkCar();
	public void changeTires();
	...
}
~~~	

Once the interface has been extracted for the class you can substitute the real thing with a fake class that just implements the interface. *Is this what mocking libraries do using relfection?*

Speaking of Mockito, some mocking frameworks can mock concrete implementations directly, bypassing the need to create a fake object yourself or even extract the interface. 


### Pass null

If the constructor parameter is not used in the test, you should start by attempting to pass null instead of creating. This can help reduce the noise in a test, signaling that this parameter is not useful to the context of the test. 