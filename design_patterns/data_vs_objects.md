# Data Structures Vs Objects

## Dependency Injection

One might be tempted to inject everything using dependency Injection, but does that really make sense? Injecting services (i.e. Objects that do things with real API's) makes sense as you might want to override the behavior of that service one day with a different implementation. Injecting the service allows you to compose behavior on the fly as it were. In a test, you have a nice seam which you can pass mock or null instances for unneeded/undesired behavior. Injecting a data structure on the other hand does not give you the same benefit. 