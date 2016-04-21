# Extract and Override Factory Method

Useful when you have a class that creates new objects in it's constructor. 

**Problem:** You want to test a class but it uses `new` to construct other objects in it's constructor. You don't want real instances of these objects created. 

**Solution:** Extract the object creation logic from the constructor into a factory method that you can then override with a testing subclass. 

Steps:

1. Identify an object creation in a constructor.
2. Extract all the work involved into a factory method.
3. Create testing subclass and override the factory method to return a fake or mock dependency. 

**Discussion:** This is a *work-around* solution which is less preferable to **passing in** the dependency into the constructor. 

### Warning!!

This is can be a problematic and bug prone solution if used in production code. Because super class constructors are called implicitly first in subclass constructors, overriden methods in subclasses **which depend on values not yet initialized in sub-classes** can cause problems when invoked by the super class constructor. *Source: Effective Java 2nd edition Item: 17*

example from source:

~~~java

public class Super {       // Broken - constructor invokes an overridable method       public Super() {           overrideMe();       }       public void overrideMe() {       }}

public final class Sub extends Super {       private final Date date; // Blank final, set by constructor       
       Sub() {           date = new Date();		}       
       // Overriding method invoked by superclass constructor       @Override public void overrideMe() {           System.out.println(date);		}
		       public static void main(String[] args) {           Sub sub = new Sub();           sub.overrideMe();		} 
}

~~~