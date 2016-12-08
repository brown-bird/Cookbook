## Dutch National Flag Problem
### Description
Given an array and a pivot index into the array, re-organize the elements in the array so that elements less than the pivot appear first followed by elements equal to the pivot followed by elements greater than the pivot. 


**Naive Solution**

Maintain three lists: values less than partition (p), equal to p, and greater than p. Fill the array with the contents of the lists. Time = O(n), Space = O(n)

**Single Pass, Time = O(n), Space = O(1)**

The key is to maintain four sub arrays:

1. Bottom - elements less than the pivot
2. Equal - elements equal to the pivot
3. Unclassified - elements not yet classified
4. Top - elements larger than the pivot

Keep the following invariants during partitioning

1. Bottom group = A.subList(0, smaller)
2. Middle group = A.subList(smaller, equal)
3. Unclassified group = A.subList(equal, larger)
3. Top group = A.subList(equal, A.size())

**ara[equal]** is the incoming unclassified element

```java
public static void dutchFlagPartition(Comparable[] ara, int pivot)
    {
        int smaller = 0, equal = 0, larger = ara.length;
        while (equal < larger)
        {
            if (ara[equal].compareTo(ara[pivot]) < 0)
            {
                swap(ara, smaller++, equal++);
            } else if (ara[equal].compareTo(ara[pivot]) == 0)
            {
                ++equal;
            } else // ara[equal] > pivot
            {
                swap(ara, larger--, equal);
	
            }
        }
    }
```