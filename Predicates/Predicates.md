# Predicates in Java 8

Predicates are new in Java 8. 

~~~java
@FunctionalInterface
public interface Predicate<T>
~~~

Represents a predicate (boolean-valued function) of one argument. This is a functional interface whose functional method is `test(Object)`.

You can define a class which implements the Predicate interface

~~~java
public class IsAdultFemale implements Predicate<Person>
{

    @Override
    public boolean test(Person person)
    {
        return person.getAge() >= 18 && person.getGender() == Gender.FEMALE;
    }
}
~~~

You can define an in-line reference to a predicate

~~~java
// creating a reference to a predicate!
Predicate<Person> IsYoungerThan25 = p -> p.getAge() < 25;
// combining predicates using "and"
Predicate<Person> isFemaleUnder25 = 
	IsYoungerThan25.and(p -> p.getGender() == Gender.FEMALE);

people.stream()
        .filter(isFemaleUnder25) // predicate reference used!
        .map(p -> p.getName() + " " + p.getGender())
        .forEach(System.out::println);
~~~

---

#### More examples

The following examples use the object the class _Foo_ defined as such:

~~~java
public class Foo
{
    private boolean isValid;
    private String name;
    
    public Foo(boolean isValid, String name)
    {
        this.isValid = isValid;
        this.name = name;
    }

    // Getters and toString...
}
~~~

Find the first invalid Foo in a list of valid and invalid foos

~~~java
List<Foo> foos = new LinkedList();

// create some valid and invalid foos
IntStream.range(1, 5)
        .forEach(i -> foos.add(
            	new Foo(i % 2 == 0, "foo" + i)));
    
// Find first foo which is false
// stream processing stops after first false foo is found!
Optional<Foo> firstFalseFoo = foos.stream()
        .peek(f -> System.out.println("peek: " + f)) 
        .filter(f -> !f.isValid())
        .findFirst();

System.out.println(firstFalseFoo.orElse(new Foo(true, "NO FALSE FOO")));

//peek: foo1 false
//foo1 false
~~~ 

`.peek` is used to view how many elements are processed by the stream. Since the elements are processed through the pipeline one at a time, only the elements up until the first invalid foo is found are processed. In this case the first foo is invalid. 

`findFirst()` returns an `Optional<T>` in this case `Optional<Foo>`. If a `Foo` is not returned from `findFirst()`, you can use the `orElse(Foo)` like in the example to return a default foo you specify. 

You could alternatively collect all foos which are invalid into a list

~~~java

// create some valid and invalid foos
IntStream.range(1, 10)
        .forEach(i -> foos.add(
        		new Foo(i % 2 == 0, "foo" + i)));
        

// collect the foos that are invalid
List<Foo> invalidFoos = foos.stream()
        .filter(f -> !f.isValid())
        .collect(Collectors.toList());

// use StringJoiner to format list                           
StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
    
invalidFoos.stream()
        .forEach(f -> stringJoiner.add(f.toString()));
System.out.println("Invalid foos: " + stringJoiner);

//Invalid foos: [foo1 false, foo3 false, foo5 false, foo7 false, foo9 false]
~~~