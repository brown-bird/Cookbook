# Design patterns with Lambdas



### Strategy Pattern or Higher Order Functions

A function which accepts a function as a parameter is a **higher order function**. The higher order function behaves similarly to the *Strategy Pattern* where in it depends on the behavior of another function to complete it's overall purpose. 

example using of a sum function that can also some even numbers or odd numbers based upon a `Predicate` which is passed in. 

~~~java
public class Sample
{
	private static void main(String[] args)
	{
		List<Integers> numbers = Arrays.asList(1,2,3,4,5,6);	
		// ways the function can be called:
		// calling with lambda
		int sum = sum(numbers, value -> true);
		int evenSum = sum(numbers, value -> value % 2 == 0);
			
		// using a method reference
		int oddSum = sum(numbers, Sample::isOdd);
		
	}// end main
	
	private static Integer sum(List<Integer> numbers, Predicate<Integer> predicate)
	{
		return numbers.stream()
			.filter(predicate)
			.reduce(0, Integer::sum);
	} // end sum
	
	private static boolean isOdd(Integer number)
	{
		return number % 2 != 0;
	}// end isOdd
	
}// end class

~~~

### Delegating and Testing

If a class depends on a functional interface for some behavior it can be convieniently constructed via lambdas or method references without another backing interface. This can reduce the need to build an interface hierarchy and make mocking behavior require less code. 

Given a sample class `StockCalculator` which depends on a service to fetch stocks. 

~~~java
import java.util.function.Function;
public class StockCalculator
{
	private Function<String, Double> priceFetcher;
	
	public StockCalculator(Function<String, Double> priceFetcher)
	{
		this.priceFetcher = priceFetcher;
	}
	
	public double compute(String ticker, int stocks)
	{
		// "apply" is the method implemented by a lambda or method reference.
		return stocks * priceFetcher.apply(ticker);
	}

}

~~~

Then a unit test can mock a real priceFetcher like

~~~java
// priceFetcher implemented with a lambda that allways returns 30
StockCalculator calculator = new StockCalculator(symbol -> 30);
~~~

### Decorating using lambdas

You can decorate lambdas by using the `andThen` and `compose` methods of `java.util.function.Function`.

### Execute Around Method

When some operations need to happend before or after the usage of a object. 

~~~java
class Resource {
  //we want to clean up the object quite deterministically as soon as we're done with it.
  //Java 7 ARM is a step closer to this, but still requires programmers to remember to use
  //the try format.
  //Using EAM pattern the Java 8 compiler can gently force the programmer to naturally use it without having
  //to remember.
  
  private Resource() { System.out.println("Instance created"); }
  
  public void op1() { System.out.println("op1 called...."); }
  public void op2() { System.out.println("op2 called..."); }
  
  private void close() { System.out.println("do any cleanup here..."); }
  
  public static void use(Consumer<Resource> consume) {
    Resource resource = new Resource();
    try {
      consume.accept(resource);
    } finally {
      resource.close();
    }
  }
}

public class Sample {
  public static void main(String[] args) {
    //This is how the class will be used by fellow programmers.
    
    Resource.use(resource -> {
      resource.op1();
      resource.op2();
    });
  }
}
~~~

<br>
Notes from the [video](https://www.youtube.com/watch?v=8qcHPEyLkPE) by Venkat	Subramaniam. Examples based on or from Venkat's website [agiledeveloper.com](http://agiledeveloper.com/downloads.html)