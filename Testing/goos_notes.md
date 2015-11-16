# GOOS Notes

TDD gives feedback on the quality of both it's *implementation* ("does it work?") and *design* ("Is it well structured?"). Developing test-first, we find we benefit twice from the effort. *Writing* tests:

* makes us clarify the acceptance criteria for the next piece of work -- we have to ask ourselves how we can tell when we're done (design)
* Encourages us to write loosely coupled components, so they can easily be tested in isolation and, at higher levels, combined together (design)
* adds an executable description of what the code does (design)
* adds to a complete regression suite (implementation)

*Running* tests:

* detects errors while the context is fresh in our mind (implementation)
* lets us know when we've done enough, discouraging "gold plating" and unecessary features (design)

*The Golden Rule of Test-Driven Development*

>Never write new functionality without a failing test


**Acceptance Test** - Exercises the functionality you want to build. Should be a *failing* test to begind with. When possible an acceptance test should exercise the system end-to-end without directly calling its internal code. 

---

#### Tell, Don't Ask

This is about followint the *Law of Demeter*. Objects should make decisions based only on the information they hold internally or that which came with the trigerring message. They should avoid navigating to other objects to make things happen. Followed consistently, this style produces more flexible *(modular)* code becuase it's easy to swap objects that play the same role. 

As well has hiding information *(implementation details)*, if forces explicit descriptions *(names)* for the interactions between objects rather than leaving them implicit in the chain of getters. **We should ask the question we really want answered, instead of asking for the information to help us figure out the answer ourselves.**

---

#### Unit -Test Behavior, Not Methods

The test name should provide *context* about what condition the test is exercising. The test method name and code needs to describe the scenario being tested. Try focusing on the *feature* that is being implemented not the method itself that is the door to the feature. The goal is to ensure that the test is **readable** and **maintainable**.

## Object - Oriented style

Value code that is easy to maintain over code that is easy to write. Implementing a feature in the most direct way can damage the maintainability of the system, for example by making the code difficult to understand or by introducing hidden dependencies between components. Not balancing immediate and long-term concerns can result in brittle systems and fragile projects that can no longer be delivered.

**Separation of Concerns** - When we have to change the behavior of a system, we want to change as little code as possible. Compose code of specific functionality into packages which represent that functionality.

**Higher levels of abstraction** - Avoid excessive complexity by working at higher levels of abstraction. Combine components of useful functionality rather than manipulating variables and control flow. *Order food from a menu rather than describe the detailed recipe to create it.*

---

*Note about testing through public api's vs testing private methods*

If you test through the api for which you plan to consume a feature you decouple your tests from the implementation details of what is being done. This allows you to refactor implementation details without refactoring tests that consume only the public api. Testing the smaller private methods may give the illusion of code that is easier to write *(i.e. fewer tests)*

---

#### Encapsulation

Ensures that the behavior of an object can only be affected through its API.
It lets us control how much a change to one object will impact other parts of
the system by ensuring that there are no unexpected dependencies between
unrelated components.

#### Information hiding

Conceals how an object implements its functionality behind the abstraction
of its API. It lets us work with higher abstractions by ignoring lower-level details
that are unrelated to the task at hand.

We’re most aware of encapsulation when we haven’t got it. When working with
badly encapsulated code, we spend too much time tracing what the potential
effects of a change might be, looking at where objects are created, what common
data they hold, and where their contents are referenced. The topic has inspired
two books that we know of, [Feathers04] and [Demeyer03].

Many object-oriented languages support encapsulation by providing control over
the visibility of an object’s features to other objects, but that’s not enough. Objects
can break encapsulation by sharing references to mutable objects, an effect known
as aliasing. Aliasing is essential for conventional object- oriented systems (otherwise
no two objects would be able to communicate), but accidental aliasing can
couple unrelated parts of a system so it behaves mysteriously and is inflexible to
change.

We follow standard practices to maintain encapsulation when coding: define
immutable value types, avoid global variables and **singletons**, copy collections
and mutable values when passing them between objects, and so on. We have
more about information hiding later in this chapter.

Designing a good API matters because it affects how easy an object is to use, and so
contributes to the internal quality of the system. If we expose too much of an
object’s internals through its API, its clients will end up doing some of its work.
We’ll have distributed behavior across too many objects (they’ll be coupled together),
increasing the cost of maintenance because any changes will now ripple
across the code.

~~~
((EditSaveCustomizer) master.getModelisable()
    .getDockablePanel()
        .getCustomizer())
            .getSaveItem().setEnabled(Boolean.FALSE.booleanValue());
~~~

Every getter in this example exposes a structural detail. If we wanted to change,
say, the way customizations on the master are enabled, we’d have to change all
the intermediate relationships.


#### Different Levels of Language

As you’ll see in Part III, we often write helper methods to make code more readable.
We’re not afraid of adding very small methods if they clarify the meaning of the
feature they represent. We name these methods to make the calling code read
as naturally as possible; we don’t have to conform to external conventions since
these methods are only there to support other code. For example, in Chapter 15
we have a line in a test that reads:

	allowing(sniperListener).sniperStateChanged(with(aSniperThatIs(BIDDING)));

We’ll explain what this means at the time. What’s relevant here is that
aSniperThatIs() is a local method that constructs a value to be passed to the
with() method, and that its name is intended to describe its intent in this context.
In effect, we’re constructing a very small embedded language that defines, in this
case, a part of a test.

As well as distinguishing between value and object types (page 13), we find that
we tend towards **different programming styles at different levels in the code**.
Loosely speaking, we use the *message-passing* style we’ve just described between
objects, but we tend to use a more *functional* style within an object, building up
behavior from methods and values that have no side effects.

Features without side effects mean that we can assemble our code from smaller
components, minimizing the amount of risky shared state. Writing large-scale
functional programs is a topic for a different book, but we find that a little
immutability within the implementation of a class leads to much safer code and
that, if we do a good job, the code reads well too.

#### Single Responsibility Principle

*No And's, Or's, or But's*

Every object should have a single, clearly defined responsibility; this is the “single
responsibility” principle [Martin02]. When we’re adding behavior to a system,
this principle helps us decide whether to extend an existing object or create a
new service for an object to call.

Our heuristic is that we should be able to describe what an object does without
using any conjunctions (“and,” “or”). If we find ourselves adding clauses to the
description, then the object probably should be broken up into collaborating
objects, usually one for each clause.


#### Object Peer Stereotypes

**Dependencies** - *Services that the object requires from its peers so it can perform its responsibilities*. The object cannot function without these services. It should not be
possible to create the object without them.

**Notifications** - *Peers that need to be kept up to date with the object’s activity*. The object
will notify interested peers whenever it changes state or performs a significant
action. Notifications are “fire and forget”; the object neither knows nor cares
which peers are listening. Notifications are so useful because they decouple
objects from each other. For example, in a user interface system, a button
component promises to notify any registered listeners when it’s clicked, but
does not know what those listeners will do. Similarly, the listeners expect to
be called but know nothing of the way the user interface dispatches its events.

**Adjustments** - *Peers that adjust the object’s behavior to the wider needs of the system*. This
includes policy objects that make decisions on the object’s behalf (the Strategy
pattern in [Gamma94]) and component parts of the object if it’s a composite.
For example, a Swing JTable will ask a TableCellRenderer to draw
a cell’s value, perhaps as RGB (Red, Green, Blue) values for a color. If we
change the renderer, the table will change its presentation, now displaying
the HSB (Hue, Saturation, Brightness) values.


#### Composite Simpler Than the Sum of Its Parts

The API of a composite object should not be more complicated than that of any of its components. The "Tell, Don't ASk" convention can help to guard against useless objects (or objects which do no real work) but rather serve only as accessors to their subcomponents. 

Bad:

~~~java
moneyEditor.getAmountField().setText(String.valueOf(money.amount()));
moneyEditor.getCurrencyField().setText(money.currencyCode());
~~~

Instead of exposing sub-components you could write:

~~~java
moneyEditor.setValue(money);
~~~

Composite objects can, of course, be used as components in larger-scale, more
sophisticated composite objects. As we grow the code, the “composite simpler
than the sum of its parts” rule contributes to raising the level of abstraction.


#### Context Independence

While the “composite simpler than the sum of its parts” rule helps us decide
whether an object hides **enough** information, the “context independence” rule
helps us decide whether an object hides too much or hides the wrong information.


A system is easier to change if its objects are context-independent; that is, if
each object has no built-in knowledge about the system in which it executes. This
allows us to take units of behavior (objects) and apply them in new situations.
To be context-independent, whatever an object needs to know about the larger
environment it’s running in must be passed in. Those relationships might be
“permanent” (passed in on construction) or “transient” (passed in to the method
that needs them).

In this “paternalistic” approach, each object is told just enough to do its job
and wrapped up in an abstraction that matches its vocabulary. Eventually, the
chain of objects reaches a process boundary, which is where the system will find
external details such as host names, ports, and user interface events.


### Achieving Object-Oriented Design

TDD with mock objects also encourages information hiding. We should mock
an object’s peers—its dependencies, notifications, and adjustments we categorized
on page 52—but not its internals. Tests that highlight an object’s neighbors help
us to see whether they are peers, or should instead be internal to the target object.

A test that is clumsy or unclear might be a hint that we’ve exposed too much
implementation, and that we should rebalance the responsibilities between the
object and its neighbors.

#### Value Types

*Values* are immutable, so they're simpler and have no meaninful identity; *objects* have state, so they have identity and relationships with each other.

The more code we write, the more we’re convinced that we should define
types to represent value concepts in the domain, even if they don’t do much. It
helps to create a consistent domain model that is more self-explanatory.


#### Creating Objects

Three basic techniques for introducing value types:

* **Breaking out** - When we find that the code in an object is becoming complex, that’s often
a sign that it’s implementing multiple concerns and that we can break out
coherent units of behavior into helper types.

* **Budding off** - When we want to mark a new domain concept in the code, we often introduce
a placeholder type that wraps a single field, or maybe has no fields at all. As
the code grows, we fill in more detail in the new type by adding fields and
methods. With each type that we add, we’re raising the level of abstraction
of the code.

* **Bundling up** - When we notice that a group of values are always used together, we take
that as a suggestion that there’s a missing construct. A first step might be to
create a new type with fixed public fields—just giving the group a name
highlights the missing concept. Later we can migrate behavior to the new type, which might eventually allow us to hide its fields behind a clean interface, satisfying the “composite simpler than the sum of its parts” rule.

**We find that the discovery of value types is usually motivated by trying to
follow our design principles, rather than by responding to code stresses when
writing tests.**

The categories for discovering object types are similar (which is why we shoehorned
them into these names), *except that the design guidance we get from
writing unit tests tends to be more important. As we wrote in “External and
Internal Quality” (page 10), **we use the effort of unit testing to maintain the
code’s internal quality.** There are more examples of the influence of testing on
design in Chapter 20.*

>**The Tests Say...**
>
>Break up an object if it becomes too large to test easily, or if its test failures become
difficult to interpret. Then unit-test the new parts separately.

#### Budding Off: Defining a New Service That an Object Needs and Adding a New Object to Provvide It


Our response is to create an interface to define the service that the object needs
from the object’s point of view. We write tests for the new behavior as if the
**service already exists**, using mock objects to help describe the relationship between
the target object and its new collaborator; this is how we introduced the
AuctionEventListener we mentioned in the previous section.

The development cycle goes like this. When implementing an object, we discover
that it needs a service to be provided by another object. We give the new service
a name and mock it out in the client object’s unit tests, to clarify the relationship
between the two. Then we write an object to provide that service and, in doing
so, discover what services that object needs. We follow this chain (or perhaps a
directed graph) of collaborator relationships until we connect up to existing objects,
either our own or from a third-party API. This is how we implement
“Develop from the Inputs to the Outputs”


---

**Problem:** *You are working with or are creating a concrete class with the prefix "IMPL"*

**Solution:** Name the concrete class with what is unique about it's implementation.



**Discussion:** *Identify Relationships with Interfaces*

This approach reflects an emphasis on the relationships between objects, as defined by their communication protocols. Interfaces can be used to name the roles that objects can play and to describe the messages they'll accept.

We also prefer interfaces to be as narrow as possible, even though that means
we need more of them. The fewer methods there are on an interface, the more
obvious is its role in the calling object. We don’t have to worry which other
methods are relevant to a particular call and which were included for convenience.
Narrow interfaces are also easier to write adapters and decorators for; there’s
less to implement, so it’s easier to write objects that compose together well.

“Pulling” interfaces into existence, as we described in “Budding Off,” helps
us keep them as narrow as possible. Driving an interface from its client avoids
leaking excess information about its implementers, which minimizes any implicit
coupling between objects and so keeps the code malleable.

> **Impl Classes Are Meaningless**
Sometimes we see code with classes named by adding “Impl” to the single interface
they implement. This is better than leaving the class name unchanged and
prefixing an “I” to the interface, but not by much. **A name like BookingImpl is duplication;
it says exactly the same as implements Booking, which is a “code smell.”**
We would not be happy with such obvious duplication elsewhere in our code,
so we ought to refactor it away.

>It might just be a naming problem. There’s always something specific about an
implementation that can be included in the class name: it might use a bounded
collection, communicate over HTTP, use a database for persistence, and so on.
A bridging class is even easier to name, since it will belong in one domain but
implement interfaces in another.

>If there really isn’t a good implementation name, it might mean that the interface
is poorly named or designed. Perhaps it’s unfocused because it has too many responsibilities;
or it’s named after its implementation rather than its role in the client;
or it’s a value, not an object—this discrepancy sometimes turns up when writing
unit tests, see “Don’t Mock Values” (page 237).


---
**Problem:** *There really isn't a good name for a concrete class.*

**Solution:** The interface may be poorly named or designed. Refactor the interface to have fewer responsibilities if it has too many. Rename if the interface is named after it's implementation instead of it's role. 

---


**Problem:** *Some Interfaces in the code base look similar*

**Solution:** Examine if the the similar interfaces really represent a single concept and should be merged. 

**Discussion:** Extracting common roles makes the design more malleable because more components will be "plug-compatible", so we can work at a higher level of abstraction. A secondary advantage is that there will be fewer concepts that cost time to understand.

Alternatively, if similar interfaces turn out to represent different concepts, we
can make a point of making them distinct, so that the compiler can ensure that
we only combine objects correctly. A decision to separate similar-looking interfaces
is a good time to reconsider their naming. It’s likely that there’s a more
appropriate name for at least one of them.

---

**Problem:** *When implementing an interface, the structure of the concrete class is unclear.*

**Solution:** If the concrete class has too many responsibilities consider refactoring the interface to be better focused. Maybe it should be split up. 

---


**Problem:** Assembling, or creating, an object graph doesn't explain the expectation of a test or express intent clearly. 

**Solution:** Organize the code into two layers. 

* Implementation layer - The graph of objects. it's behavior is the combined result of how its objects respond to events. 
* Declarative layer - Builds up the objects in the implementation layer, using small "sugar" methods and syntax to describe the **purpose** of each fragment. 

**Discussion:** The declarative layer describes what the code will
do, while the implementation layer describes how the code does it. The declarative
layer is, in effect, a small embedded domain-specific language.


The different purposes of the two layers mean that we use a different coding
style for each. For the implementation layer we stick to the conventional objectoriented
style guidelines we described in the previous chapter. We’re more flexible
for the declarative layer—we might even use “train wreck” chaining of method
calls or static methods to help get the point across.

Example creating an Expectations object in jMock. 

Before:

~~~java
InvocationExpectation expectation = new InvocationExpectation();
expectation.setParametersMatcher(
new AllParametersMatcher(Arrays.asList(new IsInstanceOf(String.class)));
expectation.setCardinality(new Cardinality(1, 1));
expectation.setMethodMatcher(new MethodNameMatcher("doSomething"));
expectation.setObjectMatcher(new IsSame<Example>(example));
context.addExpectation(expectation);
~~~

After, using a *declarative* layer:

~~~java
context.checking(new Expectations() {{
oneOf(example).doSomething(with(any(String.class)));
}});
~~~

--- 


#### About Classes

One last point. Unusually for a book on object-oriented software, we haven’t
said much about classes and inheritance. It should be obvious by now that we’ve
been pushing the application domain into the gaps between the objects, the
communication protocols. We emphasize interfaces more than classes because
that’s what other objects see: an object’s type is defined by the roles it plays.

We view classes for objects as an “implementation detail”—a way of implementing
types, not the types themselves. We discover object class hierarchies by
factoring out common behavior, but prefer to refactor to delegation if possible
since we find that it makes our code more flexible and easier to understand.5
Value types, on the other hand, are less likely to use delegation since they don’t
have peers.

---

#### Only Mock Types That You Own

**Problem:** You want to mock a type provided by a 3rd party library.

**Solution:** Don't! Use the real library in testing. Use an *Adapter* layer to connect the services we have defined as needed in our domain to the library that implements them. Test these in integration tests. 


**Discussion:** Although we know how we want our abstraction
to behave, we don’t know if it really does so until we test it in combination with
the third-party code.

We write a layer of adapter objects (as described in [Gamma94]) that uses the
third-party API to implement these interfaces, as in Figure 8.1. We keep this
layer as thin as possible, to minimize the amount of potentially brittle and hardto-
test code. We test these adapters with focused integration tests to confirm our
understanding of how the third-party API works. There will be relatively few
integration tests compared to the number of unit tests, so they should not get in
the way of the build even if they’re not as fast as the in-memory unit tests.

We also prefer not to change third-party code, even when we have the sources.
It’s usually too much trouble to apply private patches every time there’s a new
version.


A second risk is that we have to be sure that the behavior we stub or mock
**matches what the external library will actually do**. How difficult this is depends
on the quality of the library—whether it’s specified (and implemented) well
enough for us to be certain that our unit tests are valid. Even if we get it right
once, we have to make sure that the tests remain valid when we upgrade the
libraries. 

This precaution can include other teams code, which you do not control. If a bug is introduced through a code change, the unit test will not catch the **real** behavior that will crash in production. *Is it better to test only your code and let another team's bug enter production, via mocking the expected behavior of their code, or to test thier actual code and discover the bug earlier?* 

*There are some exceptions to this rule. e.g. call sequences, generating exceptions, etc. See text for more info*
