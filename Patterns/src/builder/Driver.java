package builder;

import java.util.*;
import java.util.function.Function;

public class Driver
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        List<Integer> list = new LinkedList();
        for (int i = 0; i < 11; i++)
        {
            list.add(i);
        }

        list.forEach(System.out::println);
        Function<String, String> greeter = whom -> "Hello " + whom + "!";
        
        greetWorld(greeter);
        
        
        Function<String, Integer> countString = string -> string.length();
        printWordCount(countString);
        
        // static factory method
        Customer c = Customer.washingtonCustomer();
        System.out.println("c.address="+c.address);
        
        
        // builder pattern
        NutritionFacts facts = new NutritionFacts.Builder(100, 200).calories(20).carbohydrate(55).build();
        
        System.out.println(facts);
    }
    
    public static void greetWorld(Function<String, String> greeter)
    {
        System.out.println(greeter.apply("World"));
    }
    
    public static void printWordCount(Function<String, Integer> countString)
    {
        System.out.println(countString.apply("Four"));
    }
    
}
