# Interfaces, Communication, and Design

### Improved Communication

When an interface is defined as a dependency it communicates what the dependent behavior exactly is. Method and constructor signatures communicate more information

### Design

Interfaces force you to think about design. Concrete classes grow more easily with optionally used public methods. Working with lots of concrete classes produces a lot of Swiss army knife classes and duplicated logic. Adding to the api of an interface requires you to ask if the behavior belongs or not. This scrutiny can help keep implementations lean, organized, and focused on a single responsibility.

<br>
### Interfaces and Dependency Injection

Dependencies on abstractions combined with dependency injection allow for resilient code.  