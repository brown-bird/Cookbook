package linkedlistreview;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author richardclay
 */
public class LinkedListTest
{
    
    public LinkedListTest()
    {
    }

    /**
     * Test of size method, of class LinkedList.
     */
    @Test
    public void testSize()
    {
        LinkedList instance = new LinkedList();
        Integer expResult = 3;
        
        instance.add(1);
        instance.add(1);
        instance.add(1);
        
        assertEquals(instance.size(), expResult);
    }

    /**
     * Test of add method, of class LinkedList.
     */
    @Test
    public void testAdd()
    {
        LinkedList instance = new LinkedList();
        String data = "word";
        instance.add(data);
        
        assertTrue(instance.contains("word"));
    }

    /**
     * Test of addFirst method, of class LinkedList.
     */
    @Test
    public void testAddFirst()
    {
        Comparable data = 42;
        LinkedList list = new LinkedList();
        list.addFirst(data);
        System.out.println("first" + list.getFirst());
        assertEquals(list.getFirst().compareTo(data), 0);
    }

    /**
     * Test of addLast method, of class LinkedList.
     */
    @Test
    public void testAddLast()
    {
        LinkedList list = new LinkedList();
        
        for(int num = 0; num < 10; num ++)
            list.addLast(num);
        
        Comparable expected = 9;
        assertEquals(list.getLast(), expected);
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemove()
    {
        LinkedList instance = new LinkedList();
        
        for(int i = 1; i <= 10; i++)
            instance.add(i);
        
        instance.remove(3);
        Integer target = 3;
        assertFalse(instance.contains(target));
        target = 10;
        instance.remove(target);
        assertFalse(instance.contains(target));
    }
    
    @Test
    public void testContains()
    {
        LinkedList list = new LinkedList();
        list.add(7);
        list.add(4);
        list.add(42);
        assertFalse(list.contains(3));
        assertTrue(list.contains(42));
    }
    
    @Test
    public void testSort()
    {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        
        list.sort();
        
        assertEquals(list.getFirst().compareTo(7), 0);
        assertEquals(list.getLast().compareTo(10), 0);
    }
    
    @Test
    public void testSortWithStrings()
    {
        LinkedList list = new LinkedList();
        list.add("Zebra");
        list.add("Baboon");
        list.add("Gorilla");
        list.add("Cheetah");
        list.add("Alligator");
        
        list.sort();
        
        assertEquals(list.getFirst().compareTo("Alligator"), 0);
        assertEquals(list.getLast().compareTo("Zebra"), 0);
    }
}
