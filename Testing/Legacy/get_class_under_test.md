# Trouble getting a class into a test harness


### The Case of the Irritating Global Dependency p.118

**Problem:** It is difficult to get a class or method under test because it has global dependencies.

**Solution(s):** For simple cases use: 

- Parameterize Constructor (379)
- Parameterize Method (383)
- Extract and Override Call (348)

For more extensive and pervasive dependencies use: 

- Introduce Static Setter (372)
- Subclass and Override Method (401)
- Extract Interface (362) + Lean on the Compiler (315)

The above techniques work around the global dependency problem as opposed to removing the problem. To tackle this problem consider:

- Parameterize Method (383)
- Parameterize Constructor (379)

**Discussion:** One problem with *Parameterize Method* is that you can end up with many distracting methods that can make it difficult for people trying to understand a class. *//todo: continue from p.126*

---

### Introduce Static Setter (372)

**Discussion:** This is a *work-around* solution for dealing with global dependencies/singletons. Ideally, we would prefer to reduce how much we have to work with singletons or manage their singleton-ness externally if possible. 

Example:

Assume you want to test a method like this:

~~~java
public void methodToTest()
{
	// it uses a singleton like so...
	Bacon bacon = Bacon.getInstance();
	String result =
		bacon.makeNetworkCallsAndDoBaconRelatedDatabaseThings();
		
	// do stuff with result...
}
~~~

And `Bacon` is a *Singleton* defined as such: 

~~~java
package Meat;

// Untestable Bacon Singleton
public class Bacon
{

    // Eager instatiation to avoid synchronization issues
    // ok for heavily used singletons
    private volatile static Bacon instance = new Bacon();

    private Bacon()
    {
    }
    
    public static Bacon getInstance()
    {
        return instance;
    }
    
    // This method does stuff we wouldn't want done in a test.
    public String makeNetworkCallsAndDoBaconRelatedDatabaseThings()
    {
        return "I did delicious network and datase things!";
    }
}
~~~

This makes `methodToTest` difficult to test because `Bacon` does things we don't like in our tests such as network requests and database calls. We can instead use a *Static Setter* to set the instance of the singleton to that of a subclass we define for testing which overrides undesireable behavior. Let's see what that might look like. 

We relax the visibility of the constructor of our singleton to 
`protected` so that we can sub-class. We also define a `setTestInstance` method which allows us to set the instance to the subclass we want. Finally we override the unwanted behavior in our test subclass definition. 

####Our new singleton:

We relax visibility.

~~~java
package Meat;

// Testable Bacon Singleton
public class Bacon
{
    private volatile static Bacon instance;

    protected Bacon()
    {
    }
    ...
~~~

We used **double checked locking** instead of eager instantiation to avoid null pointer exceptions when using our new `resetInstance()` cleanup method. 

~~~java
	...    

    public static Bacon getInstance()
    {
        if (instance == null)
        {
            synchronized (Bacon.class)
            {
                if (instance == null)
                {
                    instance = new Bacon();
                }
            }
        }
        return instance;
    }
    ...
~~~

We define a `setTestInstance` method so we can control the singleton instance during testing. A `resetInstance` method is defined to cleanup the instance before other tests run. You can also see the method we want to override above.

~~~java    
    ...
    // Utility method for testing
    public static void setTestInstance(Bacon testInstance)
    {
        instance = testInstance;
    }
    
    // cleanup method for testing
    public static void resetInstance()
    {
        instance = null;
    }
    
    // this method does stuff we wouldn't want done in a test.
    public String makeNetworkCallsAndDoBaconRelatedDatabaseThings()
    {
        return "I did delicious network and datase things!";
    }
}

~~~

####Now our test using our "improved" singleton:

We set the test instance in the constructor or using a `@Before` method. 

~~~java
public class BaconTest
{
    Bacon bacon;
    
    public BaconTest()
    {
        Bacon.setTestInstance(new TestBacon());
        bacon = Bacon.getInstance();
    }
    ...
~~~

We cleanup the test instance after each test. If you are substituting the same test fake (subclass) for every test it doesn't make sense to actually use `resetInstance`. 

~~~java    
    ...
    @After
    public void cleanup()
    {
        Bacon.resetInstance();
    }
    ...
~~~    

Now we can test `methodToTest()` without worrying about network and database requests! Note: SUT = "System Under Test"

~~~java
    @Test
    public void testMethodToTest()
    {
        // get reference to class containing methodToTest
        SUT sut = new SUT();
        
        // methodToTest will use our test subclass
        assertThat(sut.methodToTest(), doesRightStuff());
    }
    ...
~~~

And finally our we've defined our subclass that overrides the method with undesired behavior. We've also decided to define this class as a [static nested class](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html) in the test itself since this is the only place it is used. 

~~~java    

    // Subclass for testing only which overrides
    // methods that we want to alter the behavior of.
    private static class TestBacon extends Bacon
    {
        public TestBacon()
        {
        }
        
        // override to prevent unwanted behavior
        @Override
        public String makeNetworkCallsAndDoBaconRelatedDatabaseThings()
        {
            return "I made no calls but still smell delicious!";
        }
    }// end TestBacon sublcass
}// end BaconTest
~~~

