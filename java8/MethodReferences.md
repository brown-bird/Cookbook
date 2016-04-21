# Method References

1. Are glue code - i.e. simple use cases
2. Can be used when a lambda is simply passing the arguments 
3. Can be used with with methods that accept multiple parameters. Order matters. 
4. Can **not** be used if you need to manipulate the arguments before passing them to the method reference. 
5. Can **not** use them when there is a conflict between instance and static methods. e.g. Integer has both a static and a instance definition of `toString`

<br>
### Examples:
Passing values **unmodified** through to another method. e.g.

~~~java
List<Integers> intList = Arrays.asList(1,2,3,4,5);
intList.stream()
	.forEach(n -> System.out.println(n));
	
// can be replaced with 

intList.stream()
	.forEach(System.out::println);	
~~~

Replacing lambda which accepts multiple arguments:

~~~java
System.out.println(
	numbers.stream()
		// .reduce(0, (total, n) -> Integer.sum(total, n)));
		.reduce(0, Integer::sum));
			
~~~

Replacing lambda which accepts multiple arguments and one arg is a target:

~~~java
System.out.println(
	numbers.stream()
		.map(String::valueOf)
		// .reduce(0, (total, n) -> Integer.sum(total, n)));
		.reduce(0, Integer::sum));
			
~~~

