# Mocking

**Problem:** You want to test a class or method but it requires extensive mocking. 

**Solution:** Replace chained getters with a new method which decouples the class under test from it's dependencies. Or better yet, ask for the object that is really needed to do the work in the method. 

Before: 

~~~java
public void doSomething(Foo foo)
{
	Bar bar = foo.getThingA().getThingyB().createMyBar();
	// do real work with bar
}
~~~

After:

~~~java

public void callDoSomething()
{
	// decouple yourself from foo's dependencies
	// and call "dosomething" passing the parameters
	// it needs!
	interestingClass.doSomething(foo.createBar());
}

// Somewhere in another class far, far away...
public void doSomething(Bar bar)
{
	// do real work with bar
}
~~~

**Discussion:** Is the amount of work you must do to construct an object an indication that refactoring may be needed? 