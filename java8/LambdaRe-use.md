# Lambda Re-use

#### Problem

Multiple lambdas are similar save for components which could be parameterized. 

#### Solution

Define a higher order function that returns a lambda constructed in  part by a passed in parameter. 

#### Problem

Static **higher order functions** are polluting your class.

#### Solution

Define a Function reference, defined with a lambda which returns the desired higher order function, just before the code that would use it.

Example:

```java
// defining the function which will return the lambda
final Function<String, Predicate<String>> startsWithLetter = 
    (letter) -> (name) -> name.startsWith(letter);

// usage
final long countFriendsStartsN = 
    friends.stream().filter(startsWithLetter("N")).count();

final long countFriendsStartsB = 
    friends.stream().filter(startsWithLetter("B")).count();
```  