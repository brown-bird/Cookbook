String Integer Interconversion
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