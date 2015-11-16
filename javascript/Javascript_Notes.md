# Javascript Notes

**Undefined** - a variable *declared* but not defined. A variable that is not declared but referenced will throw a `ReferenceError`

* evaluates to `NaN` in numerical context
* evaluates to false in a conditional

**null**

* evaluates to **0** in numerical context
* evaluates to false in a conditional


**global scope** - variable defined outside a function. *Acessible outside of the function!*

Prior to ECMAScript 6 block scoped variables do not exist. The `let` keyword introduced in ECMAScript 6 addresses this. 

`let` allows you to declare variables that are limited in scope to the block, statement, or expression on which it is used. This is unlike the var keyword, which defines a variable globally, or locally to an entire function *regardless* of block scope.

#### Hey string, give me your number!

**Radix** - the base of a number. When using `parseInt` it is best practice to pass the radix to avoid confusion with different default implementations when no radix is passed. example: `var num = parseInt("1500", 10);`. 

An alternative method to retrieve a numerical value from a string is with the `+` unary operator like:

	var sum = +"1.1" + +"1.1"; // returns 2.2
	
#### Literals
Array literal

	var coffees = ["French Roast", "Colombian", "Kona"];
	
If an **array** is created using a literal in a top-level script, JavaScript interprets the array **each time** it evaluates the expression containing the array literal. In addition, a literal used in a function is **created each time** the function is called.

`var fish = ["Lion", , "Angel"];` creates an **undefined** element at `fish[1]`. It is better to explicitly declare undefined elements as undefined


#### Exceptions

Create an exception using the `throws` keyword like:

~~~javascript
throw "Some String";
throw 42;
throw myExceptionObject; // A previously created object
~~~

If there is a `return` statement in a `finally` block, this becomes the `return` statement for the whole `try`, `catch`, `finally` block. 


