# Functional Thinking


## Why
Functional programming follows the pattern of **ceding** more control to the runtime. e.g. *garbage collection*. Low level operations and *state management operations* like iterating over a collection of objects, filtering by some rules, and transforming objects from one type to another are performed via built-in language implementations. The amount of state manipulation is greatly reduced an along with it many of the errors that come with rolling your own *state*. 

>OO makes code understandable by encapsulating moving parts. FP makes code understandable by minimizing moving parts. 
>- *Micaheal Feathers*

Encapsulation, scoping, visibility, and other mechanixms exist to exert fine-grained control over who can see and change state.

>Focus on results over steps.

The resulting code from functional programming is often more concise and more simple. 

## How

**Pure Functions** are functions which have no side effects - meaning they do not modify any outside state or the state of parameters. There are no reasons to *hide* pure functions as there is no state to protect. 

Another definition: A *pure* function is one that has no side  effects:

* It references no other mutable class fields
* It doesn't set any values other than the return value
* It relies only on the parameters for input

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

**Memoization** is a feature built into a programming language that enables automatic caching of recurring function-return values. Memoizing a function is a *metafunction* application: doing something to the function itself rather than the function results. Currying is another example of a metafunction technique.

Memoization can run into the same issues that recursion does with memory limitations. However, many languages which support memoization also provide additional customization methods, such as `memoizeAtMost()` which allow tweaking of the behavior in order to avoid physical limitations.

From the section comparing manually caching vs. language implemented memoization:

> In the imperative version, the developer owns the code (and responsibility). Functional languages build generic machinery -- sometimes with customization knobs (in the form of alternate functions or parameters) -- that you can apply to standard constructs.

>Language designers will always buid more efficient mechanisms because they are allowed to bend rules.

Make sure all memoized or cached functions are *pure* functions.