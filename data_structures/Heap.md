# Heap

An array based implementation of a binary tree. The left child of *k* is at *2k* and the right child is at *2k+1*. The parent of *n* is at *n/2*. A heap thus does not use pointers to connect the nodes in the tree. A heap cannot allow holes in the tree, so when a node is removed or added, 

### Problems solved 

Efficiently support Priority Queue operations *insert* and *extract-min/max*. They maintain a partial order on the set elements which is weaker than sorted order. A *min-heap* guarantees that for any root in the tree, the value at that root is greater than either of the two sub trees. 

Efficiently searching is **not** supported in heaps because heaps are not binary search trees. The relative order of the leaf nodes are **not** guaranteed. 

Heaps can be *space efficient* over pointer based trees as they can be stored in arrays with defined functions for locating child nodes and parent nodes.

**HeapSort** which uses a heap to sort elements in a collection has guaranteed *O(nlogn)* time complexity. Heapsort works by initilizing a heap with the collection of elements then calling extract min *n* times. 

### Operations

1. Insert
2. Find Minimum/Maximum
3. Delete Minimum/Maximum


**Inserting**

Insert into the leftmost empty spot in the array, the bottom of the heap, then recursively swap with the parent node, bubble up, if it is smaller. Stop if root node. Insertion is *O(logn)* as the height of the tree is at most *logn*. Thus initilizing a heap from an array of n elements is *O(nlogn)*. 

**Find Minimum/Maximum**

The root node is always the minimum/maximum. After extracting the min, replace the root node with the last element in the heap and bubble it down if it is not larger than both it's children. 

### Use Cases

### Trade-offs