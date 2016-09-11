# Objects vs Data

1. Objects expose behavior
2. Data expose no behavior, only their data
3. Do not create hybrids
4. With objects it expensive to add behavior and cheap to add new implementations
5. With data it is cheap to add behavior but expensive to add new implementations


>Procedural code (code using data structures) makes it easy to add new functions without changing the existing data structures. OO code, on the other hand, makes it easy to add new classes without changing existing functions.
>
>The complement is also true:
>
>Procedural code makes it hard to add new data structures because all the functions must change. OO code makes it hard to add new functions because all the classes must change.

<br>
## Dependency Injection

One might be tempted to inject everything using dependency Injection, but does that really make sense? Injecting services (i.e. Objects that do things with real API's) makes sense as you might want to override the behavior of that service one day with a different implementation. Injecting the service allows you to compose behavior on the fly as it were. In a test, you have a nice seam which you can pass mock or null instances for unneeded/undesired behavior. Injecting a data structure on the other hand does not give you the same benefit. 