// Multiples of 3 and 5
// Find the sum of all the multiples of 3 or 5 below 1000
package problem1;

import java.util.stream.IntStream;

public class Problem1
{
	public static void main(String[] args)
	{
		System.out.println("sum = "
				+ IntStream.range(0, 1000)
				.filter(n -> n % 3 == 0 || n % 5 == 0)
				.sum());
	}
}