package problem2;

import java.util.stream.IntStream;

public class EvenFibonacciNumbers
{

	private static final int MAX = 4_000_000;

	public static void main(String[] args)
	{
//		System.out.println("sum = " + fibSum(100));
//
//		// sanity check
//		System.out.println("IntStream.of = "
//				+ IntStream.of(1, 2, 3, 5, 8, 13, 21, 34, 55, 89).sum());

		System.out.println(
				"sum of even fibonacci values less than "
				+ MAX + " = "
				+ evenFibSum(MAX));
	}

	private static int evenFibSum(int max)
	{
		int a = 0, b = 1, c = 0, sum = 0;
		while (a + b < max)
		{
			c = a + b;
			a = b;
			b = c;

			sum += c % 2 == 0 ? c : 0;
		}
		return sum;
	}

	private static int fibSum(int max)
	{
		int a = 0, b = 1, c = 0, sum = 0;
		while (a + b < max)
		{
			c = a + b;
			a = b;
			b = c;

			sum += c;
		}
		return sum;
	}

}
