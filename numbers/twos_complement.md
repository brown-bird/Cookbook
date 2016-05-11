# Two's Complement
 .. or why a **byte** which is 8 bits in java can represent numbers in the range of -128 to 127.
 
 This range is actually -(2<sup>n - 1</sup>) to +(2<sup>n - 1</sup> - 1) where **n** is the number of bits that the number is represented in. 
 So, for an 8 bit value such as a byte, n = 8. Therefore, the range is -(2<sup>8 - 1</sup>) to +(2<sup>8 - 1</sup> - 1) or -128 to 127. 
 
 Numbers in java are stored in binary form encoded using two's complement notation. This allows many operations to reuse the same circuitry. For instance, subtraction can be computed by addition. e.g. 69 - 12 = 69 + (-12)
 
 Given a 3 bit representation i.e. n = 3, the corresponding range in two's complement is -(2<sup>3 - 1</sup>) to +(2<sup>3 - 1</sup> - 1) or ( -4 to 3) 
 
**Positive numbers** are represented in binary, unsigned value, and two's complement value as normal. i.e. for decimal value 3 in a 3 bit representation: 

Bits | Unsigned Value | Two's complement value |
-----|----------------|:----------------------:|
011  |3               | 3                      |

but for **negative numbers** the binary and two's complement representation of the number is different. e.g. for -3 in a 3 bit representation:

Bits | Unsigned Value | Two's complement value |
-----|----------------|:----------------------:|
101  |5               | -3                     |

To calculate the binary representation of a negative:

1. Start with the binary representation of the positive value.
2. Invert the binary value.
3. Add 1. 

[Examples](https://www.cs.cornell.edu/~tomf/notes/cps104/twoscomp.html)