# Java 8 Streams 
*STRAMS* for those in the know ;)

__Note:__ Streams in Java 8 are not the same things as `InputStream` and `OutputStream` from Java I/O.

### Some Stream Operations
- reduce
- collect
- flatMap
 
Stream Operations are either __intermediate__ or __terminal__. Intermediate operations return a stream and can be chained. Terminal operations are either void or return a non-stream result.

Intermediate operation examples:

- filter
- map
- sorted

Terminal operation example:

- forEach

Most stream operations accept a lambda expression or functional interface. Most of those operations must be both _non-interferring_ and _stateless_.

A function is [non-interfering][] when it does not modify the underlying data source of the stream. 

A function is [stateless][] when the execution of the operation is deterministic. In other words the function doesn't depend on any mutable variables or state from outside the scope of the function. 


#### Stream Creation

You can create streams from collections, such as lists and sets, but you can also create streams from object references by using `Stream.of`

~~~java
Stream.of("a1", "a2", "a3");
~~~

You can work with streams of primitives using `IntStream`, `LongStream` and `DoubleStream`. Primative streams use specialized lambda expressions, e.g. `IntFunction` instead of `Function` or `IntPredicate` instead of `Predicate`. Primative streams support additional terminal aggregate operations such as `sum()` and `average()`

Replace the regular for loop with `IntStream.range()`

~~~java
IntStream.range(1, 4)
	.forEach(System.out::println);
//1
//2
//3
~~~

To convert from object stream to a primative stream use `mapToInt`, `mapToDouble` and `mapToLong` which take a lambda or functiona reference which does the mapping and returns the appropriate primative stream

~~~java
Stream.of("a1", "a2", "a3")
	.map(s -> s.substring(1))
	.mapToInt(Integer::parseInt)
	.max()
	.ifPresent(System.out::println); // 3
~~~

Convert a primative stream to an object stream with `mapToObj()`

~~~java
IntStream.range(1, 4)
	.mapToObj(i -> "a" + i)
	.forEach(System.out::println);
~~~

Example of stream of doubles converted to ints then to objects.

~~~java
Stream.of(1.0, 2.0, 3.0)
	.mapToInt(Double::intValue)
	.mapToObj(i -> "a" + i)
	.forEach(System.out::println);
~~~

Intermediate operations will only be executed when a terminal operation is present. Nothing happens in the following example because there is no terminal operation. 

~~~java
Stream.of("d2", "a2", "b1", "b3", "c")
	.filter(s -> {
		System.out.println("filter: " + s);
		return true;
	});
~~~

Add a terminal `forEach` operation to the above example produces the following:


~~~java
Stream.of("d2", "a2", "b1", "b3", "c")
	.filter(s -> {
		System.out.println("filter: " + s);
		return true;
	})
	.forEach(s -> System.out.println("forEach: " + s));
~~~

Output:

	filter:  d2
	forEach: d2
	filter:  a2
	forEach: a2
	filter:  b1
	forEach: b1
	filter:  b3
	forEach: b3
	filter:  c
	forEach: c
	
	
Notice that each element is fully processed one at a time through all operations. Filtering early can greatly reduce the work done by the stream of operations as additional operations will only be done on elements for which the filter predicate is true.

An exception to the vertical processing of elements is `sorted()` which operates horizontally on each element, i.e. it processes all elements first before passing on the stream on through the pipeline. `sorted` is a stateful operation. Again execution order is important and placing any filter predicates before `sorted` can reduce the amount of work done as the number of elements in the stream increases. 

#### Streams are not re-usable

Calling a terminal operation on a stream closes the stream. Create a stream supplier if multiple terminal operations are required for a given set of intermediate operations.

~~~java
Supplier<Stream<String>> streamSupplier = 
	() -> Stream.of("d2", "a2", "b1", "b3", "c")
			.filter(s -> s.startsWith("a"));
			
streamSupplier.get().anyMatch(s -> true); // ok
streamSupplier.get().noneMatch(s -> true); // ok	
~~~

The second call would throw an `IllegalStateException` if called on the same stream and not on the stream returned from a stream supplier. In this example each call to `get()` contructs a new stream which you can then call terminal operations on. 

---

#### Predicate
A functional interface that can be used as the assignment target for a lambda expression or method reference. 

###Operations


`filter` accepts a `Predicate`. Returns a `Stream<T>` consisting of the elements of this stream that match the given predicate. _Intermediate_ operation.

`map` accepts a `Function`. Returns a stream consisting of the results of applying the given function to the elements of this stream. _Intermediate_ operation


`anyMatch` accepts a `Predicate`. Returns whether any elements of this stream match the provided predicate. Stops on first true. _Terminal_ operation. 

`collect` accepts a `Collector` and transforms the elements of a stream into a different kind of result, e.g. `List`, `Set` or `Map`.

~~~java
List<Person> filtered = 
	persons
		.stream()
		.filter(p -> p.name.startsWith("P"))
		.collect(Collectors.toList());
~~~

Group by operations

~~~java
Map<Integer, List<Person>> personsByAge = 
	.stream()
	.collect(Collectors.groupingBy(p -> p.age));
	
personsByAge
	.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
	
// age 18: [Max]
// age 23: [Peter, Pamela]
// age 12: [David]	
~~~	


#### When to use streams?

#### When not to use them?	

<!-- links -->
[non-interfering]:http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#NonInterference

[stateless]: http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#Statelessness