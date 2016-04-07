# Composition Over Inheritance


### Problems Solved

#### 1. Getting crap you don't want for free...Yay!
You're tempted to use inheritance to use reuse some existing behavior but inheritance means getting more behavior than you want. You'd inherit the methods you want but also some you possibly don't want

#### 2. Didn't I say that already
a.k.a duplicated code... With inheritance you have to override unwanted behavior in every implementation. This likely results in **duplicated** code. With composition, unwanted behavior can be avoided by **one implementation** that can be reused. 

#### 3. Maintenance Code
Prioritizes lower maintenance costs over up front implementation costs. Since more effort is spent in maintenance, the effort to implement flexible code pays off over time. 


**Oh but I want default behavior!**

Still composition though!

Compose default behavior inside an implementation to a composable interface. Instead of inheriting default behavior you inject it. You create an abstraction for the default behavior that can be injected. You are essentially encapsulating the (public?) methods. Abstracting around the behaviors or algorithms instead of just types. 