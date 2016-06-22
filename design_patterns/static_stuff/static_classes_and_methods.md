# Static Classes and Methods

**Perceived benefit:**

1. Code reuse

**Trade-Offs**:

1. Tight Coupling
2. Hidden dependencies
3. No Polymorphism
4. Highly used static methods are difficult to make instance methods. You must edit all the usages to create a new class with it's dependencies, which may be not readily available. 

Static utility classes and methods make it more work to use polymorphism and thus change or add behavior through interfaces and instances. Static methods give the illusion that a class has fewer dependencies than it actually does.
