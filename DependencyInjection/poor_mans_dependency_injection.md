# Poor Man’s dependency Injection

Poor Man’s dependency Injection uses a default constructor that calls another constructor which exposes the classes dependencies with concrete implementations. <https://lostechies.com/jimmybogard/2010/05/20/the-religion-of-dependency-injection/>

Poor Man’s Dependency Injection in comparison to regular Dependency

- Has more code
- Is coupled to a specific implementation
- Decides it’s components life cycle

This pattern is transient the default constructor is used for each concrete classes dependencies recursively. Or concrete implementations are passed to the dependencies.

DI is about creating highly flexible components, both in lifecycle and component selection.  DI removes component resolution responsibilities from classes, therefore removing code.  And less code is ALWAYS a good thing.

Everywhere you use the "new" keyword you are introducing more coupling. 