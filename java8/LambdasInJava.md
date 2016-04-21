# Lambdas in Java

### When to use:

Where single abstract method interfaces (aka Functional Interfaces) are required. e.g. *Runnable* . 

### Benefits:

1. Reduction in code noise. 
2. Replaces Anonymous Inner Classes.
3. Less creation overhead and cleanup (garbage collection) for labmdas. No extra ".class" files like annonymous inner classes. 

Four parts of a method:

1. name
2. parameter list
3. method body
4. return type

Lambda's reduce the what you need to define a method to 

1. ~~name~~ - not needed
2. parameter list 
3. method body
4. ~~return type~~ - inferred

Caveats:

**Keep lambda's simple**. Complicated logic in lambda's can be difficult to understand and can promote duplication. Extract complicated logic into a testable method. [Lambda's are glue code](http://blog.agiledeveloper.com/2015/06/lambdas-are-glue-code.html)

**Method references are for the simplest cases**


### Iterators

Internal vs. External

The normal for and for-each loops are external iterators. They are very familiar and usually boiler plate code. 

Calling `Collection.forEach()` is an internal iterator. You can benefit from polymorphism when calling a method on an object vs passing an object **into** a method. 

With internal interation the iteration behavior is abstracted and the behavior to be performed on each value of the iterator is abstracted. 