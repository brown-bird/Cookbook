## Integer Square Root

#### Problem

Write a program which takes a non-negative integer and returns the largest integer whose square is less than or equal to the input integer. 

#### Brute force

 Square each number from 1 to the key **K** stopping when we exceed **K**. For large integers, such as 64 bit integers, this can be prohibitively slow. 

#### Binary Search 

Using the fact that if x<sup>2</sup> < k, then no number smaller than x can be the result. Similarly, if x<sup>2</sup> > k, then no number larger than x can be the result. We can maintain an interval whose squares are unknown with respect to k. 

We initialize the interval `[0,k]`. We compare the square of `m = (l + r) / 2` with k. If m<sup>2</sup> less than k, we update the interval to be `[m + 1, r]`. If m<sup>2</sup> is greater than k, we update the interval to `[l, m - 1]`. The algorithm terminates when the interval is empty, `l > r` at which point every number less than `l` has a square < k. The solution is `l-1`


```java

int squareRoot(int k)
{
	int l = 0; 
	int r = k;
	
	while (l <= r)
	{
		mid = l + (l + r) / 2;
		midSquared = mid * mid;
		if (midSquared <= k)
			l = mid + 1;
		else
			r = mid - 1;
	}// end while
	return l - 1;
}
```

#### Discussion

The key observation here is that the binary search solution takes advantage of certain problem facts. The sequence of possible values from 1 to k is sorted and we do not need to check every value since we can eliminate large sections of possible solutions using the relationship of mid<sup>2</sup> to k. 