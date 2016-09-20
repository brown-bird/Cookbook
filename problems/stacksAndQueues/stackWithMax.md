# Stack with Max

### Problem

Implement a stack with push, pop, and max api

#### Sub-problems

1. Track max on push
2. Track max on pop

### Solution

Use a wrapper for each element in the stack that caches the Max 

```java
public class Stack
{
    // inner class that handles the caching
    private static class ElementWithCachedMax
    {
        public int element;
        public int max;

        public ElementWithCachedMax(int element, int max)
        {
            this.element = element;
            this.max = max;
        }
    }

    // internal stack that we are wrapping
    Deque<ElementWithCachedMax> cachedStack = new LinkedList<>();

    public int max()
    {
        if (empty())
            throw new IllegalStateException("empty stack");
        
        return this.cachedStack.peek().max;
    }

    public boolean empty()
    {
        return this.cachedStack.isEmpty();
    }

    public void push(int element)
    {
        this.cachedStack.addFirst(element, empty() ? element : Math.max(element, max()));
    }

    public int pop()
    {
        if (empty())
            throw new IllegalStateException("empty stack");
        
        return this.cachedStack.removeFirst().element;
    }

}
```

This solution trades time for space. The increased space complexity is now O(n) where n is the number of elements stored in the stack. All of the specified methods have a time complexity of O(1). 

