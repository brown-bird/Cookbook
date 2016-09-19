## Common JS Terms

**$q** - A service that helps you run functions asynchronously, and use their return values (or exceptions) when they are done processing. [Kris Kowal's Q](https://github.com/kriskowal/q)

**Promise** - If a function cannot return a value or throw an exception without blocking, it can return a promise instead. A promise is an object that represents the return value or the thrown exception that the function may eventually provide. A promise can also be used as a proxy for a remote object to overcome latency.