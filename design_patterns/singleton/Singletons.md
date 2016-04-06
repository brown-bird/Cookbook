# Singletons


__Usages:__
Thread pools, caches, dialog boxes, objects that handle preferences and registry settings, objects used for logging, and objects that act as device drivers to devices like printers and graphics cards.

__Solved Problems:__ 
Incorrect behavior with multiple instances, overuse of resources, and inconsistent results. 

__Questions to consider:__
 
 1. Will more than one instance of this class cause incorrect behavior?
 
 2. Will more than one instance of this class unnecessarily overburden a resource? i.e. a cache could cut back on resource usage. 
 
#### Problems:

1. Testing multiple instances of a class which is a client of or contains a singleton as a member suffers from __coupling__ through the singleton. Without maintaining a strict "clean-up" operation, singletons can produce "spooky action at a distance". In other words, subsequent calls of the same method on two different objects of the same type which appear to have no reference to each other may produce inconsistent results if they both depend on the same singleton. 
2. To test properly, singleton must maintain a __backdoor__ (i.e. not intended for use other than testing) to either create additional instances or mutator methods to break static dependencies. 
3. All member classes are __transiently__ global. Should they be? Do they have state? i.e. Mixing lifecycle concerns. 
4. A singleton with state is essentially a __global variable__. This breaks the OO principle of _encapsulation_. 
5. Different threads accessing a singleton can end up with different instances. i.e. a __race condition__. 
6. Multiple Class Loaders can lead to more than one instance of a singleton.
7. Inappropriate usage can mislead subsequent users of a class. Designing a class as a Singleton implies that there __should__ only be one instance of a class "ever" and that there would be problems if more than one instance is solved. If this is not true, developers could be confused. 

<br>
## Implementation

#### Solving synchronization:

Use the `synchronized` keyword, however synchronization is expensive and only needed the very first time the instance is set. If calling getInstance is not a high frequency call in the application using this method can preserve the lazy instantiation of the uniqueInstance and may be suitable. 

~~~java
//synchronization example
public class Singleton
{
	private static Singleton uniqueInstance;
	
	private Singleton(){}
	
	public static synchonized Singleton getInstance()
	{
		if (uniqueInstance == null)
		{
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}
~~~

#### Eagerly create the instance. 

Preferable if `getInstance` will be called frequently and the overhead of synchronization would be detrimental. 

~~~java
// eager instatiation example
public class Singleton
{
	private static Singleton uniqueInstance = new Singleton();
	
	private Singleton(){}
	
	public static Singleton getInstance()
	{
		return uniqueInstance;
	}
}
~~~

#### Double-Checked locking

Check for an instance first and then synchonize the instantiation. This avoids synchronizing on every call of getInstance, synchronizing only on the first call. Mind the use of the `volatile` keyword. double-checked locking only works in java 1.5 or later.

~~~java
//synchronization example
public class Singleton
{
	private volatile static Singleton uniqueInstance;
	
	private Singleton(){}
	
	public static Singleton getInstance()
	{
		if (uniqueInstance == null)
		{
			synchonized(Singleton.class)
			{
				if (uniqueInstance == null)
					uniqueInstance = new Singleton();
			}
		}
		return uniqueInstance;
	}
}
~~~