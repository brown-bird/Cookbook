# Javascript Data Types

### What's the difference between an Object, Primative, and Literal?

A javascript _literal_ is a value of a specific type.

    "a string" // type = string
    0.95 // type = number
    true // type = boolean

A javascript _primative_ is an instance of a data type
    
    "this is a string"
    null

### What are the 5 primitave data types in javascript?
1. String
2. Number
3. Boolean
4. Null
5. Undefined

### Which primative data types have complementary constructors?
 1. String
 2. Number
 3. Boolean

### What is the benefit of an Object over a Primative?

An object has properties and functions available where as a primative does not. When a function or property is accessed from a primative behind the scenes an object is instantiated, the value of the primitive is set on the object, and the property or function is executed or accessed. Then the object is discarded. Javascript engines can actually emulate this behavior instead of actually creating an actual instance.

```javascript
var str1 = "this is a string"
console.log(str1.length);
```

### How can you create primatives?

You can create primatives by assigning them directly to variables

```js
var str1 = "this is a simple string"; // the quoted string is the literal

var num1 = 1.45; // the value of 1.45 is the literal

var answer = true; // the values of true and false are boolean literals
```

You can also create string, number, and boolean primatives using the complimentary constructors *without* the _new_ operator:

```js
var str1 = String("this is a string"); // primative string

var num1 = Number(1.45); // primative number

var bool1 = Boolean(true); // primative boolean
```

### How can you instantiate an  object instance?

```js
var str2 = new String("this is a string"); 

var num2 = new Number(1.45); 

var bool2 = new Boolean(true); 
```

### How does equality work between primatives, objects, and literals?

If you use _strict equality_ you can tell the difference:

```js
var str1 = String("string"); 
var num1 = Number(1.45); 
var bool1 = Boolean(true); 

str1 === "string" // true
num1 === 1.45 // true
bool1 === true // true

var str2 = new String("this is a string"); 
var num2 = new Number(1.45); 
var bool2 = new Boolean(true); 

str1 === str2 // false
num1 === num2 // false
bool1 === bool2 // false
```

Primative values are strictly equal to literals, while object instances are not. Primative are compared by value and Objects are not.

### How can you check the type of a variable?

You can use the `typeof` operator. The list of possible values is:

1. number
2. string
3. boolean
4. function
5. object // if the variable is null, an array, or another JavaScript object
6. undefined