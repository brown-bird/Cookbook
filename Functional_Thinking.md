# Functional Thinking


## Why
Functional programming follows the pattern of **ceding** more control to the runtime. e.g. *garbage collection*. Low level operations like iterating over a collection of objects, filtering by some rules, and transforming objects from one type to another are performed via built-in language implementations. The amount of state manipulation is greatly reduced an along with it many of the errors that come with rolling your own *state*. 

>OO makes code understandable by encapsulating moving parts. FP makes code understandable by minimizing moving parts. 
>- *Micaheal Feathers*

Encapsulation, scoping, visibility, and other mechanixms exist to exert fine-grained control over who can see and change state.

>Focus on results over steps.

The resulting code from functional programming is often more concise and more simple. 

## How

**Pure Functions** are functions which have no side effects - meaning they do not modify any outside state or the state of parameters. There are no reasons to *hide* pure functions as there is no state to protect. 

A **Closure** is a function that carries an implicit binding to all the variables referenced within it. In other words, the function (or method) encloses a context around the things it references. 

~~~groovy
class Employee{
	def name, salary
}

def paidMore(amount){
	return {Employee e -> e.salary > amount}
}

isHighPaid = paidMore(100000)
~~~

In the example above, a code block is returned where `amount` is permanently bound to the value it was when the block was created during the `paidMore(100000)` invocation.

~~~groovy
def Smithers = new Employee(name:"Fred", salary:120000)
def Homer = new Employee(name:"Homer", salary:80000)
println isHighPaid(Smithers)
println isHighPaid(Homer)
// true, false
~~~

For the above invocations of `isHighPaid` the value of `amount` *enclosed* in the code block is **100000**. When a *closure* is created, it creates an enclosure around the variables referenced within the scope of the code block (this the name *closure*). Each instance of the closure block has unique values, even for private variables. 

>Let the language manage state.

Imperative languages use *state* to model programming, exemplefied by parameter passing. Closures allow us to model *behavior* by encapsulating both code and context into a single construct, the closure, that can be passed around like traditional data structures and executed at exactly the correct time and place. 

>Capture the *context*, not the state

**Currying** describes the conversion of a multiargument function into a chain of single-argument functions. It describes the transformation process, not the invocation of the converted function. 

**Partial Application** descrives the conversion of a multiargument function into one that accepts fewer arguments, with values for the elided arguments supplied in advance. It applies some arguments to a function, returning a function with a signature that consists of the remaining arguments.

In *Scala* Partially Applied functions and Partial Functions are not the same thing. *Partial Functions* are functions with constrained parameter lists. 