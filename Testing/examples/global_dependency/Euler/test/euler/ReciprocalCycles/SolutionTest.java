package euler.ReciprocalCycles;

import static euler.ReciprocalCycles.Solution.*;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest
{
    
    public SolutionTest()
    {
    }

    /**
     * Test of relativelyPrime method, of class Solution.
     */
//    @Test
//    public void testRelativelyPrime()
//    {
//        System.out.println("relativelyPrime");
//        assertFalse(relativelyPrime(2));
//        assertFalse(relativelyPrime(5));
//        assertTrue(relativelyPrime(3));
//        assertTrue(relativelyPrime(7));
//        assertTrue(relativelyPrime(13));
//        assertTrue(relativelyPrime(131));
//        
//    }

    /**
     * Test of multiplicativeOrder method, of class Solution.
     */
    @Test
    public void testMultiplicativeOrder()
    {
        System.out.println("multiplicativeOrder");
        
        assertThat(multiplicativeOrder(13, 12), is(6));
        assertThat(multiplicativeOrder(7, 6), is(6));
        assertThat(multiplicativeOrder(9, 8), is(1));
    }
    
    @Test
    public void testSanity()
    {
        Double d = Math.pow(10, 991);
        System.out.println("d=" + d);
//        System.out.println("math: " + (( - 1) % 991));
    }
    
    
    @Test
    public void testDivisors()
    {
        List<Integer> divisors = Solution.getDivisors(131);
        System.out.println("begin divisors");
        divisors.stream().forEach(System.out::println);
        System.out.println("end divisors");
    }
}
