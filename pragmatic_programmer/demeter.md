# Pragmatic Programmer Notes

## Law of Demeter

*Minimize Coupling between modules*

The law of Demeter for functions states that any method of an object should call only methods belonging to:

1. Itself
2. Any parameters that were passed into the method
3. Any objects it created<sup>1</sup>
4. Any directly held component objects

Example:

~~~java
public void plotDate(Date aDate, Selection aSelection)
{
	TimeZone tz = 
		aSelection.getRecorder().getLocation().getTimeZone();
	// do some stuff with tz
}
~~~

The problem with the above example is that `plotDate` is coupled to  **3** classes to do it's work. If any changes happen in one of those 3 classes, e.g. a `Location` no longer contains a `TimeZone`, then `plotDate` must also change it's code. 

Instead of digging throught the hierarchy yourself ask for what is needed *(ala Dependency Injection)*. The decoupled `plotDate` looks like this:

~~~java
public void plotDate(Date aDate, TimeZone aTimeZone)
{
	// do some stuff with aTimeZone
}
~~~

The law demeter differs from *method chaining* in that *method chaining* involves chaining method calls on the **same object** where as violation of the law of demeter involves executing method calls on objects returned from objects ... returned from objects ad infinitum.

**Benefits:** Your code is more adaptable and robust.

**Tradeoffs:** You end up creating a lot of *wrapper* methods which just delegate behavior to other classes<sup>2</sup>. This can impact performance and space complexity. 


**Notes:**

1. Minimize this by using *dependency injection*
2. This may actually indicate a need for refactoring. The object **eventually** doing the work may be the one where the behavior should reside instead of the calling method.