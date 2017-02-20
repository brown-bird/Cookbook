# Buy And Sell A Stock Once

*EPI pg1. & problem 6-11*

Design an algorithm that determines the maximum profit that could have been made my buying and selling a single share over a given day range, subject to the constraint that the buy and the sell have to take place at the start of the day. 

### Solution

Compute the maximum profit by computing the difference of the current entry with the minimum value seen so far as we iterate through the array. 

~~~java
public static double computeMaxProfit(List<Double> prices)
{
	double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
	
	for (Double price : prices)
	{
		maxProfit = Math.max(maxProfit, price - minPrice);
		minPrice = Math.min(minPrice, price);
	}
	return maxProfit;
}
~~~

### Notes

1. The **max profit** (for each element) is defined in terms of the current element and what's been processed so far. This definition and caculation as we go is the key insight to this solution. Instead of looking ahead in the array to calculate the max profit for the current element we just keep track of the minimum so far. 