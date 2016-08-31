# Array Problems

## Dutch National Flag

**Problem:** Write a program that takes an array **A** and and index **i** into **A**,
and rearranges the elements such that all elements less than A[i] (the "pivot") appear first, followed
by elements equal to the pivot, followed by elements greater than the pivot.

### Notes:

1. A constant number of passes through an array is still linear time complexity. 2n is insignificant
comared to n<sup>2 as n approaches positive infinity.

**Solution** Time complexity = O(n), Space complexity = O(1)

Make two passes. In the first pass move all the elements less than the partition to the
beginning of the array. In the second pass move the larger elements to the end.

``` java
public static enum Color {RED, WHITE, BLUE}

public static void dutchFlagPartition(int pivotIndex, List<Color> A)
{
    Color pivot = A.get(pivotIndex);
    // First pass; group elements smaller than pivot.
    int smaller = 0;
    for (int i = 0; i < A.size(); ++i)
    {
        if (A.get(i).ordinal() < pivot.ordinal())
            Collections.swap(A, smaller++, i);
    }

    // Second pass; group[ elements larger than pivot
    int larger = A.size() - 1;
    

}
```



