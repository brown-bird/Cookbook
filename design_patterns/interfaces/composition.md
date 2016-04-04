# Composition Over Inheritance

Compose default behavior inside an implementation to a composable interface. Instead of inheriting default behavior you inject it. You create an abstraction for the default behavior that can be injected. You are essentially encapsulating the (public?) methods. Abstracting around the behaviors or algorithms. 

### Problems Solved
1. With inheritance you have to override unwanted behavior in every implementation. This likely results in duplicated code. With composition, unwanted behavior can be avoided by one implementation that can be reused. 