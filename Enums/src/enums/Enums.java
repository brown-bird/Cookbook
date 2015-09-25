/**
 * Subject: Enums 
 * 
 * Topics:
 * - constant defined methods
 * - enums with constructors
 * - overriding toString method
 */

package enums;

public class Enums
{

	public static void main(String[] args)
	{
		Operation plus = Operation.PLUS;
		double x = 5.2;
		double y = 3.0;
		double result = plus.apply(x, y);
		
		/**
		 * "toString" is overridden in each constant to return the private member
		 * variable "symbol"
		 *
		 * Each constant implements the abstract method "apply()" differently
		 */
		System.out.printf("%.2f %s %.2f = %.2f%n", x, plus, y, result);
		System.out.printf("%.2f %s %.2f = %.2f%n", x, Operation.MINUS, y, Operation.MINUS.apply(x, y));
		System.out.printf("%.2f %s %.2f = %.2f%n", x, Operation.DIVIDE, y, Operation.DIVIDE.apply(x, y));
		System.out.printf("%.2f %s %.2f = %.2f%n", x, Operation.TIMES, y, Operation.TIMES.apply(x, y));
		
		//name() returns the constant name i.e. PLUS.name() returns "PLUS"
		System.out.println("Plus.name()="+plus.name());
	}

}
