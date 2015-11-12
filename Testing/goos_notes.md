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

---

**Acceptance Test** - Exercises the functionality you want to build. Should be a *failing* test to begind with. When possible an acceptance test should exercise the system end-to-end without directly calling its internal code. 

---

#### Unit -Test Behavior, Not Methods

The test name should provide *context* about what condition the test is exercising. The test method name and code needs to describe the scenario being tested. Try focusing on the *feature* that is being implemented not the method itself that is the door to the feature. The goal is to ensure that the test is **readable** and **maintainable**.

#### Object - Oriented style

Value code that is easy to maintain over code that is easy to write. Implementing a feature in the most direct way can damage the maintainability of the system, for example by making the code difficult to understand or by introducing hidden dependencies between components. Not balancing immediate and long-term concerns can result in brittle systems and fragile projects that can no longer be delivered.

**Separation of Concerns** - When we have to change the behavior of a system, we want to change as little code as possible. Compose code of specific functionality into packages which represent that functionality.

**Higher levels of abstraction** - Avoid excessive complexity by working at higher levels of abstraction. Combine components of useful functionality rather than manipulating variables and control flow. *Order food from a menu rather than describe the detailed recipe to create it.*

#### Note about testing through public api's vs testing private methods

If you test through the api for which you plan to consume a feature you decouple your tests from the implementation details of what is being done. This allows you to refactor implementation details without refactoring tests that consume only the public api. Testing the smaller private methods may give the illusion of code that is easier to write *(i.e. fewer tests)*

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






