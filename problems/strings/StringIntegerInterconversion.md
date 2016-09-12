# String Integer Interconversion
7.1

### Root Problem

Write two programs, one to convert an integer to a string and another to convert a string to an integer. You may not use library functions such as `Integer.parseInt`. The programs should handle negative numbers. 

### Sub-Problems

1. Converting a single integer to a char and vice versa
2. Handling negative numbers
3. Efficient string building
4. Obtaining the least significant digit of a number
5. Dealing with the immutability of strings


### Notes

Converting from char to int using the char's integer value:
```java
int intVal = charVal - '0';
```

Converting from int to char using casting:
```java
char charVal = (char) ('0' + intVal)
```

### Converting from String to Integer

```java
private static int bookStringToInt(String s)
{
    boolean isNegative = s.charAt(0) == '-';
    int result = 0;
    
    for (int i = isNegative ? 1 : 0; i < s.length(); i++)
    {
        int digit = s.charAt(i) - '0';
        result = result * 10 + digit;
    }
    return isNegative ? -result : result;
}
```

### Converting from Integer to String

 Appends the modulo remainder to the string builder and reverses when done. Appending and reversing is supposedly "more efficient" than prepending

```java
private static String bookIntToString(int n)
{
    boolean isNegative = n < 0;
    if(isNegative)
        n = -n;
    StringBuilder sb = new StringBuilder();
    do 
    {
        sb.append((char) ('0' + n % 10));
        n = n / 10;
    } while (n != 0);
    
    if (isNegative)
        sb.append('-'); // add the negative back in
    
    return sb.reverse().toString();
    
}
```
