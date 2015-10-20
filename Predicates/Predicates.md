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