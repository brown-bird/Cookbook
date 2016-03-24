# PriorityQueue (Binary Heap Implementation)

### Problems solved 

Process a collection of items comparable by some priority. Can be implemented by 

* sorted / unsorted array
* unsorted / sorted list
* binary heap

Efficiently insert/delete elements into a sorted collection without sorting the entire collection.

[binary heaps and priority queues](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html) 

### Strengths

1. Frequent Inserts and maintaining order. Insertion is O(logn)
2. Remove min/max in O(1). Must sort on each remove. O(logn). 

### Weaknesses

1. Does not support binary search. Is a binary tree but not a binary search tree (bst). Searching is O(n). 
2. Removing min/max requires sorting. O(logn)

### Operations (Interface)

1. Insert
2. Find Minimum/Maximum
3. Delete Minimum/Maximum

### Use Cases

### Trade-offs