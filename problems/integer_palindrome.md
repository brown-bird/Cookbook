#Integer is palindrome

### Algorithm

Itertively compare the first and last digits of the number for equality, removing them after successful equality check, or stopping if they are not equal. 

**Number of digits** = log<sub>10</sub> n + 1 where n = the number.

**Least Significant Digit** = (x mod 10)

**Most Significant Digit** = x / 10<sup>n - 1</sup> *where n = number of digits in x*

Notes:

1. What if the number has an odd number of digits? Should we ignore the middle digit and proceed checking the others or fail. 
2. You can stop comparing after n / 2 comparisons where n = the number of digits