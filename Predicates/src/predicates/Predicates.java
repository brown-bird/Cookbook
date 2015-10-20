package predicates;

import java.util.function.Predicate;
import java.util.*;
import java.util.stream.IntStream;

public class Predicates
{
    public static void main(String[] args)
    {
        List<Person> people = new ArrayList();
        createSomePeople(people);
        
        // try out some predicate stuff
        printAllPeople(people);
        printOutAdults(people);
        predicateFromMethod(people);
        combineTwoPredicates(people); // and inline definition of predicates
        predicateDefinedAsClass(people);
    }

    private static void predicateDefinedAsClass(List<Person> people)
    {
        // print adult females
        System.out.println("Adult females");
        people.stream()
                .filter(new IsAdultFemale()) // predicate is it's own class
                .map(p -> p.getName() + " " + p.getGender())
                .forEach(System.out::println);
        System.out.println();
    }

    private static void combineTwoPredicates(List<Person> people)
    {
        // print females younger than 25
        System.out.println("Females under 25");
        // creating a reference to a predicate!
        Predicate<Person> IsYoungerThan25 = p -> p.getAge() < 25;
        // combining predicates using "and"
        Predicate<Person> isFemaleUnder25 = IsYoungerThan25.and(p -> p.getGender() == Gender.FEMALE);
        
        people.stream()
                .filter(isFemaleUnder25)
                .map(p -> p.getName() + " " + p.getGender())
                .forEach(System.out::println);
        System.out.println();
    }

    private static void predicateFromMethod(List<Person> people)
    {
        // print out adult males
        System.out.println("adult males");
        people.stream()
                .filter(isAdultMale())
                .map(p -> p.getName() + ", Gender: " + p.getGender())
                .forEach(System.out::println);
        System.out.println();
    }

    
    // A method returning a predicate
    public static Predicate<Person> isAdult()
    {
        return p -> p.getAge() >= 18;
    }
    
    public static Predicate<Person> isAdultMale()
    {
        return p -> p.getAge() >= 18 && p.getGender() == Gender.MALE;
    }
    
    private static void printAllPeople(List<Person> people)
    {
        // print out all people
        System.out.println("All the peoples:");
        people.stream()
                .map(p -> p.getName() + " " + p.getGender()) // map to stream of strings
                .forEach(System.out::println);
        System.out.println();
    }

    private static void printOutAdults(List<Person> people)
    {
        // use predicate to print out people who are adults
        System.out.println("Peoples who can go to grownup prison:");
        people.stream()
                .filter(isAdult())
                .map(p -> p.getName())
                .forEach(System.out::println);
        System.out.println();
    }

    private static void createSomePeople(List<Person> people)
    {
        // create some people
        IntStream.range(1,30)
                .forEach(i -> people.add(
                        new Person("Person" + i, i, (i % 2 == 0 ? Gender.MALE : Gender.FEMALE))));
    }



    
    
    // scaffold class
    static class Person
    {
        String name;
        Gender gender;
        int age;
        
        public Person(String name, int age, Gender gender)
        {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName()
        {
            return name;
        }

        public Gender getGender()
        {
            return gender;
        }

        public int getAge()
        {
            return age;
        }

        
    }
    
    enum Gender
    {
        MALE,
        FEMALE;
    }
}