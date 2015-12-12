# Dependency Breaking Techniques

## Extract and Override Factory Method

Useful when you have a class that creates new objects in it's constructor. 

**Problem:** You want to test a class but it uses `new` to construct other objects in it's constructor. You don't want real instances of these objects created. 

**Solution:** Extract the object creation logic from the constructor into a factory method that you can then override with a testing subclass. 

Steps:

1. Identify an object creation in a constructor.
2. Extract all the work involved into a factory method.
3. Create testing subclass and override the factory method to return a fake or mock dependency. 

**Discussion:** This is a *work-around* solution which is less preferable to **passing in** the dependency into the constructor. 