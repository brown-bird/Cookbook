# Algorithm Design Manual

Notes from the book

>there is a fundamental difference between algodrithms, which always produce a correcr result, and heuristics, whicdh may usually do a good job but without providing any guarantee.d


>Reasonable looking algorithms can easily be incorrect. Agorithms correctness is a property that must be carefully demonstrated.

---


#### Movie Showtimes / Actor job selection

The **problem:** An actor is offered a part in several films, many of which have overlapping starting and ending times for shooting. Select the set of films which the actor can star in which maximizes the number of films. 

**Solution:** While there are films in the set *I*, of all films, select the film *X*, which has the earliest ending time. Remove films which overlap *X*. 

**Reasoning:** Any films which overlap with *X* will end later and potentially block other selections. Therefore selecting the earlies ending time is a safe and correct algorithm. 

####Take-aways

An exhaustive solution which accounts for all possible combinations is a *correct* algorithm but it is not very efficient and does not scale well with large problem instances. Problem instances can quickly grow larger than a computer can process in a reasonable amount of time. 

>Ensuring the optimal answer over all possible inputs is a difficult but often achievable goal. **Seeking counterexamples that break pretender algorithms is an important part of the algorithm design process.**
>
>*Take-Home Lesson:* Reasonable looking algorithms can easily be incorrect. Algorithm correctness is a property that must be carefully demonstrated. 


#### Expressing Algorithms

In increasing magnitude of precision and decreasing order of *ease of expression*:

1. English
2. pseudocode
3. a real programming language

>The heart of any algorithm is an *idea*. If your idea is not clearly revealed when you express an algorithm, then you are using too low-level a notation to describe it. 

#### Reasoning about correctness

Demonstrating not *incorrectness* is a useful ability. The best way to prove that an algorithm is incorrect is to produce a counter-example. 

Techniques for finding counter-examples:

* Think Small
* Think Exhaustively
* Hunt for weekness
* Go for a tie
* Seek extremes

> Mathematical induction is usually the right way to verfy the correctness of a recursive or incremental insertion algorithm.

Mathematical induction is a common use case for proving the correctness of summation formulae. 