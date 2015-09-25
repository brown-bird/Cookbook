/*
 * input: Array A[0...n-1] of strings
 * output: string x, such that x occurs the most 
 * times in A
 * 
 */

//package com.richardclay.working;

import java.util.HashMap;
public class StringOccurence
{

	
	public static void main(String[] args)
	{
		String[] A = {"four", "five", "five", "four", "one", "two", "four"};
		
	
		
		System.out.println("string: " + maxOccur(A));
	}//end main
	
	private static String maxOccur(String[] A)
	{
		int max = 0;
		String maxStr = "";
		
	HashMap<String, Integer> wordMap = new HashMap<String, Integer>(3 * A.length);
		
		for(String s : A)
		{
			if(wordMap.containsKey(s))
			{
				Integer old = (Integer)wordMap.get(s);
				old = old + 1;
				wordMap.put(s, old);
				if(old > max)
				{
					max = old;
					maxStr = s;
				}// end if
			}//end if
			else
			{
				wordMap.put(s,1);
			}//end else
		}// end for s
		
		return maxStr;
	}// end maxOccur

}// end class
