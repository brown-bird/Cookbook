# String Integer Interconversion
7.1

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
