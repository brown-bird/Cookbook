# Exceptions

### Use Cases (item  57)

Use exceptions for exceptional conditions. i.e. don't use exceptions for normal control flow. Use exceptions to communicate problems to developers. i.e. a precondition is violated or an object state is not acceptable. 

### Checked vs. Unchecked (item 58)

Use checked exceptions for reasonably recoverable conditions. use runtime exceptions for programming errors.

### Favor Standard Exceptions (item 60)


- `IllegalArgumentException`: Inappropriate parameter value.
- `IllegalStateException`: Object state not ready for method call.
- `NullPointerException`: null parameter passed when not allowed.
- `IndexOutOfBoundsException`: Index value not in appropriate range.
- `ConcurrentModificationException`: Detection of concurrent modification
- `UnsupportedOperationException`: Object does not support method. Good use case is interface implementations where method is not defined. 

### Exception Translation and Chaining (item 61)

Wrap lower level exceptions with higher level exceptions if they provide better information about what went wrong given the appropriate level of abstraction. If lower level exceptions might be useful in debugging, use exception chaining where you pass the lower level abstraction as the _cause_ argument of the higher level exception. 