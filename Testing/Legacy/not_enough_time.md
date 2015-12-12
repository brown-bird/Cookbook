# Legacy Code "Not Enough Time"

**Problem:** Need to insert new code in a location that is difficult to get under test for some given constraint and new code can be encapsulated in a method. Not as good testing the original code.

**Soution:** *Sprout Method*

#### Algorithm:
1. Identify change location
2. If change can be formulated as method, write method call and comment out.
3. Visibility of new method can be set to package private
4. Old method and new logic can be tested using reflection (expensive?)
5. Pass local variables (if needed) as arguments
6. Assign return value to variable if needed.
7. Develop method using TDD
8. Remove comment
 
 ---
 

**Problem:** Need to insert new code in a location that is difficult to get under test for some given constraint and new code can be encapsulated in a method. Giving up on testing calling code at the moment.

**Solution:** *Sprout Class*

#### Algorithm:
1. Identify change location
2. If change can be formulated as method, write method call and comment out.
3. Visibility of new method can be set to package private
4. Old method and new logic can be tested using reflection (expensive?)
5. Pass local variables (if needed) as arguments
6. Assign return value to variable if needed.
7. Develop method using TDD
8. Remove comment

 ---
 
### Wrap Method
Useful when a behavior needs to occur around the same time as an existing method invocation (temporal coupling)

#### Algorithm (re-name original method version):
1. Identify a method you need to change.
2. If the change can be formulated as a single sequence of statements in one place, rename the method and then create a new method with the same name and signature as the old method. Remember to Preserve Signatures(312) as you do this.
3. Place a call to the old method in the new method
4. Develop a method for the new feature, using TDD, and call it from the new method

#### Algorithm (not yet used method version):
1. Identify a method you need to change.
2. If the change can be formulated as a single sequence of statements in one place, develop a new method for it using TDD
3. Create another method that calls the new method and the old method

**Note:** version 2 preserves the original method signature and allows both versions to be called.
##### Advantages:
1. Explicitly makes new functionality independent of exiting functionality.
##### Disadvantages:
1. Can lead to poor names after re-naming operations
2. New functionality must be able to be executed either before or after existing functionality. It cannot occur during the original functionality.

 ---
 
### Wrap Class
##### Useful when:
1. The behavior to add is completely independent, and you don't want to pollute the existing class with behavior that is low level or unrelated.
2. The class has grown so large that you don't want to make it worse. In a case like this, wrap just to put a stake in the ground and provide a roadmap for later changes.
#### Algorithm:

1. Identify a method where you need to make a change.
2. If the change can be formulated as a single sequence of statements in one place, create a class that accepts the class you are going to wrap as a constructor argument. If yo have trouble creating a class that wraps the original class in a test harness, you might have to use Extract Implementer(356) or Extract Interface(362) on the wrapped class so that you can instantiate your wrapper.
3. Create a method on that class, using TDD, that does the new work. Write another method that calls the new method and the old method on the wrapped class.
4. Instantiate the wrapper class in your code in the place where you need to enable the new behavior.
