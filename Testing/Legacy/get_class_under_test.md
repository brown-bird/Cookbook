# Trouble getting a class into a test harness


### The Case of the Irritating Global Dependency p.118

**Problem:** It is difficult to get a class or method under test because it has global dependencies.

**Solution(s):** For simple cases use: 

- Parameterize Constructor (379)
- Parameterize Method (383)
- Extract and Override Call (348)

For more extensive and pervasive dependencies use: 

- Introduce Static Setter (372)
- Subclass and Override Method (401)
- Extract Interface (362) + Lean on the Compiler (315)

The above techniques work around the global dependency problem as opposed to removing the problem. To tackle this problem consider:

- Parameterize Method (383)
- Parameterize Constructor (379)

**Discussion:** One problem with *Parameterize Method* is that you can end up with many distracting methods that can make it difficult for people trying to understand a class. *//todo: continue from p.126*