#Bitwise and Bit Shift Operators
[Java learning trail](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html)
[Mozilla Developer Network](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Bitwise_Operators)

### XOR
*TODO*

### Unary Bitwise complement operator

`~` inverts a bit pattern; it can be applied to any of the integral types, making every "0" a "1" and every "1" a "0". 
For example, a byte contains 8 bits; applying this operator to a value whose bit pattern is "00000000" would change its pattern to "11111111".


### Shift Operators

The signed left shift operator `<<` shifts a bit pattern to the left, and the signed right shift operator `>>` shifts a 
bit pattern to the right. The bit pattern is given by the left-hand operand, and the number of positions to shift by the 
right-hand operand. The unsigned right shift operator `>>>` shifts a zero into the leftmost position, while the leftmost 
position after `>>` depends on sign extension.
