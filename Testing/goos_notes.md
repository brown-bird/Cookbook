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