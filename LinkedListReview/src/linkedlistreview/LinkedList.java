package linkedlistreview;

/**
 *
 * @author richardclay
 */
public class LinkedList
{

    private final Node head;
    private Integer size;

    public LinkedList()
    {
        this.head = new Node();
        this.head.next = this.head;
        this.head.prev = this.head;
        this.size = 0;
    }

    public Integer size()
    {
        return this.size;
    }

    public void add(Comparable data)
    {
        addLast(data);
    }

    public void addFirst(Comparable data)
    {
        Node newNode = new Node(data);
        newNode.next = this.head.next;
        newNode.prev = this.head;
        head.next = newNode;
        size++;
    }

    public void addLast(Comparable data)
    {
        Node newNode = new Node(data);
        newNode.prev = head.prev;
        newNode.next = head;
        head.prev.next = newNode;
        head.prev = newNode;
        size++;
    }

    public void remove(Comparable data)
    {
        Node currentNode = head.next;
        if (size() == 0)
        {
            throw new IllegalArgumentException("cannot remove items from an empty list");
        }

        while (currentNode != head)
        {
            if (currentNode.data.compareTo(data) == 0)
            {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                size--;
                break;
            }
            currentNode = currentNode.next;
        }
    }

    public Comparable getFirst()
    {
        if (size() < 1)
        {
            throw new IllegalStateException("list is empty");
        }

        return head.next.data;
    }

    public Comparable getLast()
    {
        if (size() < 1)
        {
            throw new IllegalStateException("list is empty");
        }

        return head.prev.data;
    }

    public boolean contains(Comparable target)
    {
        Node cur = head.next;
        final int same = 0;
        boolean found = true;

        while (cur != head)
        {
            if (cur.data.compareTo(target) == same)
            {
                return found;
            }

            cur = cur.next;
        }

        return !found;
    }

    public boolean isEmpty()
    {
        return this.size() < 1;
    }
    
    public void sort()
    {
        
        if(isEmpty())
            throw new IllegalStateException("cannot sort empty list");
        
        Node pos = head.next;
        Node cur = pos.next;
        Node min = pos;
       
        while(cur != head)
        {
            if(cur.data.compareTo(min.data) < 0)
                min = cur;
            
            cur = cur.next;
        }
        
        Comparable temp = pos.data;
        pos.data = min.data;
        min.data = temp;
        
    }

    private class Node
    {

        Comparable data;
        Node next;
        Node prev;

        public Node()
        {

        }

        public Node(Comparable data)
        {
            this.data = data;
        }

        public Node(Comparable data, Node next, Node prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }
}
