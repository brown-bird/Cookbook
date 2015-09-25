/**
 * Subject: java 8 features
 * 
 * Topics:
 * - sorting (lambda, comparator, reversed)
 * - Comparator.comparing(...).thenBy(...)
 * - Method references
 * - default methods
 * - modifying each element in a stream
 * - distinct stream elements
 */


package java8fun;

import java.util.*;
import static java.util.Comparator.*;

/**
 *
 * @author Richard
 */
public class Java8Fun {
    
    public static void main(String[] args) {
        List<Person> people = new LinkedList();
        people.add(new Person("Alice", 55));
        people.add(new Person("Mark", 14));
        people.add(new Person("Charles", 57));
        people.add(new Person("Bob", 33));
        people.add(new Person("Alice", 27));
		
//**************************************************************************************************
//		 sorting (lambda, comparator, reversed)
//**************************************************************************************************
		// passing a functional interface (comparator) as lambda to List.sort(...)
		// comparator argument to sort defined as a lambda
        people.sort((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
        people.forEach(p -> System.out.println("Name=" + p.getName() + " Age=" + p.getAge()));
        System.out.println("******************");

        // Defining a Comparator as a lambda and reverse sorting with helper function
		// Note: Comparator is a @FunctionalInterface and can be stored in a variable
        Comparator<Person> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
        people.sort(comparator.reversed());
        people.forEach(p -> System.out.println("Name=" + p.getName() + " Age=" + p.getAge()));
        System.out.println("******************");


//**************************************************************************************************
//		Comparing is a new default method of Comparator. 
//		- Default methods can be overridden by inteface implementations
//**************************************************************************************************
        // Using new default method added to Comparator "comparing(lambda | method reference)"
		// Chaining comparators
		// Method references used as the consumers
        people.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName));
        people.forEach(p -> System.out.println("Name=" + p.getName() + " Age=" + p.getAge()));
        System.out.println("******************");

		// Defining the comparator as a lambda
		people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        people.forEach(p -> System.out.println("Name=" + p.getName() + " Age=" + p.getAge()));
		System.out.println("******************");

		// Reverse order using Comparator.comparing
        people.sort(comparing(Person::getName).reversed());
        people.forEach(p -> System.out.println(p.getName() + " " + p.getAge()));
        System.out.println("******************");
		
		
//**************************************************************************************************
//		Modifying each element of a stream
//**************************************************************************************************		
        // modify the age of all persons
        people.forEach(p -> p.setAge(42));
        people.forEach(p -> System.out.println("Name=" + p.getName() + " Age=" + p.getAge()));
		System.out.println("******************");


//**************************************************************************************************
//		Defining an interface with default methods
//**************************************************************************************************	
		// normal interface method
		System.out.println(people.get(0).sing());
		// default interface method
        System.out.println(people.get(0).dance());

		
//**************************************************************************************************
//		Distinct stream elements
//**************************************************************************************************			
        System.out.println("Streams:");
        people.stream().distinct().forEach(p -> System.out.println(p.getName()));
        System.out.println();

//**************************************************************************************************
//		Bounds i.e. max/min
//**************************************************************************************************			
        System.out.println("Getting highest age using streams");
        int oldestAge = people.stream()
                .mapToInt(p -> p.getAge())
                .max()
                .getAsInt();
        System.out.println("oldest age=" + oldestAge);

		
//**************************************************************************************************
//		Collections stuff
//**************************************************************************************************			
		
        System.out.println("\nCollections practice:");
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 11; i++) {
            set.add(i);
        }

        set.forEach(n -> System.out.println("set=" + n));
        Set<Integer> linkedSet = new LinkedHashSet<>(set);

        linkedSet.forEach(n -> System.out.println("lset=" + n));
//        Set<Integer> treeSet = new TreeSet<>(Comparator.comparing(Integer::intValue).reversed());
        Set<Integer> treeSet = new TreeSet<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++)
            treeSet.add(random.nextInt());
        
        treeSet.forEach(n -> System.out.println("tset=" + String.format("%,d", n)));
//**************************************************************************************************
//		More Stream stuff
//**************************************************************************************************			
		System.out.println("matching stuff");
		
                
        System.out.println("pass by value test");
        Person p = new Person("Peter", 100);
        System.out.println("p.age = " + p.age);
        System.out.println("main p.toString = " + p.toString());
        increaseAge(p);
        System.out.println("p.age = " + p.age);
        
        Person Alice = new Person("Alice", 25);
        System.out.println("Alice = " + Alice.name);
        Person Bob = new Person("Bob", 40);
        System.out.println("Bob = " + Bob.name);
        System.out.println("swap Alice and Bob");
        swap(Alice, Bob);
        System.out.println("Alice = " + Alice.name);
        System.out.println("Bob = " + Bob.name);
    }// end main
    
    private static void increaseAge(Person p)
    {
        System.out.println("increaseAge p.toString = " + p.toString());
        p.age++;
    }
    
    private static void swap(Person p1, Person p2)
    {
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
}// end class
