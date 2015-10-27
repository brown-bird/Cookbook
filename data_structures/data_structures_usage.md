# Data Structures

When to use what data structure? Data Structures can be grouped according to their performance requirements. 

### Grouping by Performance Requirements

#### Random access + Known data size

- Array
- ArrayList

#### Random acess + Unkown data size

- Map
	- HashMap
	- LinkedHashMap

#### Frequent Insertions and Deletions

- Array
- LinkedList
- Maps 

#### Unique Members (No Duplicates)

Sets _(Classes)_

- HashSet
- AbastractSet
- ConcurrentSkipListSet
- CopyOnWriteArraySet
- EnumSet
- JobStateReasons      
- LinkedHashSet        
- TreeSet              

Sets _(Interfaces)_

- NavigableSet
- SortedSet

#### Frequent Searching

- Maps
- Heaps
- Trees _(when sorted)_

#### Hierarchical Data, Order Matters

- Trees
- Heaps
- PriorityQueue

#### Order Matters

- Arrays
- LinkedLists


#### Traversal

- Array
- ArrayList
- LinkedList
- Stack
- Queue

---

### Definitions

#### Heap

A heap is a complete binary tree whose elements have keys which satisfy the following _heap property_: The keys along any path from root to leaf are descending (i.e., _non-increasing_)

#### TreeMap

SortedMap implementation. Red Black Tree implementation. Sorted by natural ordering of it's keys or via a Comparator provided at map creation time. Guaraneed log(n) time cost for `containsKey`, `get`, `put`, and `remove` operations. **Not synchronized**. 