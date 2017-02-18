## First Occurrence

### Problem

Given a sorted array of integers and a key *K* return the index of the first occurrence of *K* or `-1` if *K* is not in the array. 

~~~java
public int firstOccurrence(int k, Integer[] a)
{
	int left = 0, right = a.length -1, result = -1;
	
	while(left <= right)
	{
		int mid = left + (right - left) / 2;
		
		if (a[mid] > k)
		{
			right = mid - 1;
		}
		else if (a[mid] == k)
		{
			result = mid;
			right = mid - 1; // nothing right of mid can be the first occurrence
		}
		else
			left = mid + 1;
	}
	return result;
}
~~~

This solution uses **Binary Search** and has a time complexity of **O(logn)**. A more expensive alternative solution uses binary search to find *"an"* occurrence of k but then walks backwards till the first occurrence is identified. That solution has a time complexity of **O(n)** when all the elements in the array match the key. 

### Alternate

An alternative version of this problem is to find the first occurrence of a value larger than the key. 

~~~java
public int firstOccurrence(int k, Integer[] a)
{
	int left = 0, right = a.length -1, result = -1;
	
	while(left <= right)
	{
		int mid = left + (right - left) / 2;
		
		if (a[mid] > k)
		{
			result = mid;
			right = mid - 1;
		}
		else if (a[mid] == k)
		{
			left = mid + 1; // nothing left of mid can be greater than k
		}
		else
			left = mid + 1;
	}
	return result;
}
~~~