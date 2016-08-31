#Bitwise and Bit Shift Operators
[Java learning trail](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html)

[Mozilla Developer Network](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Bitwise_Operators)

### Bitwise AND

Bitwise "and" operator `&`. 

1 & 1 = 1

1 & 0 = 0 

0 & 0 = 0

### Bitwise XOR

Bitwise exclusive Or. Written using the `^` symbol. Similar to the bitwise **OR** operator `|`
except that it evaluates to 1 for a given position when exactly one of the input bits for that position
is 1. if both are 0 or both are 1, the **XOR** operator evaluates to 0:

0 ^ 0 = 0

0 ^ 1 = 1

1 ^ 0 = 1

1 ^ 1 = 0

Another way to look at bitwise **XOR** is that each bit in the result is a 1 if the input bits are different, or 0 if they are the same. 

The `^` operator is often used to toggle (i.e. change from 0 to 1, or 1 to 0) some of the bits in an integer expression while leaving others alone. For example:

	y = x ^ 1; // toggle the lowest bit in x, and store the result in y.

### Unary Bitwise complement operator

`~` inverts a bit pattern; it can be applied to any of the integral types, making every "0" a "1" and every "1" a "0". 
For example, a byte contains 8 bits; applying this operator to a value whose bit pattern is "00000000" would change its pattern to "11111111".


### Shift Operators

The signed left shift operator `<<` shifts a bit pattern to the left, and the signed right shift operator `>>` shifts a 
bit pattern to the right. The bit pattern is given by the left-hand operand, and the number of positions to shift by the 
right-hand operand. The unsigned right shift operator `>>>` shifts a zero into the leftmost position, while the leftmost 
position after `>>` depends on sign extension.

## Binary Math

* [binary math](http://www.math.grin.edu/~rebelsky/Courses/152/97F/Readings/student-binary) Great tutorial with examples

### Binary Addition

0 + 0 = 0

1 + 0 = 1

1 + 1 = 10 (*You carry the one*)

### Binary Subtraction 
[examples](http://sandbox.mc.edu/~bennet/cs110/pm/sub.html)

1 - 0 = 1

0 - 0 = 0

1 - 1 = 0

0 - 1 = *requires borrowing from the next least significant digit*

### Binary Multiplication 

Multiplication works the same as in decimal. What makes multiplication difficult is the need to add the partial products obtained by multiplying the multiplicand (the "upper" integer) by each bit of the multiplier (the "lower" integer). [example](http://www4.wittenberg.edu/academics/mathcomp/shelburne/comp255/notes/binarymultiplication)

0 * 0  = 0

1 * 0 = 0

0 * 1 = 0

1 * 1 = 1

	  1011 <-- Multiplicand (11d)
	 x 101 <-- Multiplier (5d)
	------- 
	  1011 <-- Partial products
	 0000  <--
	1011   <--
	--------
	110111  = (32 + 16 + 4 + 2 + 1) = 55d    

Multiplying by two: Just add a 0 to the right (the least significant digit). This is a left bit shift. 


### Sources:
1. http://playground.arduino.cc/Code/BitMath#bitwise_xor
2. http://www4.wittenberg.edu/academics/mathcomp/shelburne/comp255/notes/binarymultiplication
