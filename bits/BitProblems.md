# Bit Problems

1. Converting from decimal to binary
2. Converting from binary to decimal
3. Counting the number of "set" bits in an integer
4. Determining the "parity" of an integer
5. Identify the lowest set bit of an integer
6. Clear the lowest set bit of an integer

### Count the number of bits in a binary word

```
public int countBits(int x)
{
  int count = 0;
  
  while (x != 0)
  {
    count += x & 1; // adds 1 if the last bit is 1
    x >>>= 1; // right shifts x left filling with a 0
  }
  
  return count;
}
```

### Compute the parity of a binary word
The parity of a binary word is 1 if the number of 1's in the word is odd; otherwise it is 0. 
For example, the parity of 1011 is 1 while the parity of 101101 is 0.

**Psuedocode:**

let x = the binary word.

```java
public short parity(long x)
{
	short parity = 0;
	
	while (x != 0)
	{
		// XOR. odd number of 1's will leave parity = 1. 
		// even number will leave it 0.
		parity ^= (x & 1); 
		x >>>= 1;
	}
	return parity;
}
```	

### Identify the lowest set bit of an integer

`y = x & ~(x-1)` isolates the lowest set bit in x. All other bits in `y` are 0. 

### Clear the lowest set bit of an integer

`x ^ (x & ~(x-1))` clears the lowest set bit of `x` using **XOR**
```
y = x & ~(x-1)  // isolates the lowest set bit in x
x ^ y           // clears the lowest set bit in x
```
A more simple solution to clearing the lowest set bit is to use:
`x & (x - 1)`

```
let x = 5, then x-1 = 4
101 // 5d
100 // 4d

101 & 100 = 100 // lowest bit in 101 is cleared!
```
### Resources

* [binary math](http://www.math.grin.edu/~rebelsky/Courses/152/97F/Readings/student-binary)
* [bitwise operators](http://playground.arduino.cc/Code/BitMath)
