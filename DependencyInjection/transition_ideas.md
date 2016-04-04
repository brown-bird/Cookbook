# Dependency Injection Transition

a. Can static factories be useful for transitioning to guice?
b. Are producer methods like factories?

**Bubble up factory inception:**
When adding a new class to a project that is not Guice managed, wherever the dependency will be used, declare it in a constructor and initialize it with a static factory method. Declaring it in a constructor can help "gather" the classes dependencies together, even though they are being initialized with static methods. Otherwise, they can be spread out hiding throughout the class. The new class can declare it's dependencies through it's constructor using normal DI. When you are ready to bubble up to the next level, replace all "new" calls for the next level up class with factory calls. In that class declare it's dependencies in the constructor using normal DI. Any factory calls that were inside of the constructor before get moved into the new factory. After successive bubbling up, you end up with one or a few factories mainly making calls on other factories to create the top level objects of the graph(used in the resource). 

### Benefits of factories:

1. Encapsulation of construction logic. 
2. Loose coupling. Changes can occur to how dependencies are constructed without changing 1,000 usages.
3. Can enable some classes to be tested via dependency injection