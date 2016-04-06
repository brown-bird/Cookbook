# Composition Over Inheritance

**Default Behavior**

Compose default behavior inside an implementation to a composable interface. Instead of inheriting default behavior you inject it. You create an abstraction for the default behavior that can be injected. You are essentially encapsulating the (public?) methods. Abstracting around the behaviors or algorithms instead of just types. 

### Problems Solved
1. With inheritance you have to override unwanted behavior in every implementation. This likely results in **duplicated** code. With composition, unwanted behavior can be avoided by **one implementation** that can be reused. 
2. Prioritizes lower maintenance costs over up front implementation costs. Since more effort is spent in maintenance, the effort to implement flexible code pays off over time. 