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

**Acceptane Test** - Starts out as a failing test that defines the new feature to be implemented. Mimmics how the feature will be used. 