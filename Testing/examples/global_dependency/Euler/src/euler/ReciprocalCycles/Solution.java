package euler.ReciprocalCycles;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static int solve()
    {
        int maxOrder = 0;
        int valOfMax = 3;
        List<Integer> divisorsOf10 = getDivisors(10);
        
        for (int n = 3; n < 1000; n++)
        {
//            System.out.println("[testing=" + n + "\tmaxOrder=" + maxOrder + "]");
            if (n % 100 == 0)
                System.out.print(".");
            int order = 0;
            List<Integer> divisors = getDivisors(n);
            
            if (relativelyPrime(divisorsOf10, divisors))
            {
                order = multiplicativeOrder(n, totient(n, divisors));
                maxOrder = Math.max(order, maxOrder);
                valOfMax = maxOrder == order ? n : valOfMax;
            }
        }
        System.out.println();
        return valOfMax;
    }

    static boolean relativelyPrime(List<Integer> divisorsOfM, List<Integer> divisorsOfN)
    {
        return !divisorsOfM.stream().anyMatch(d -> divisorsOfN.contains(d));
        
    }

    static int multiplicativeOrder(int n, int maxDigits)
    {
        int e = 1;
        BigInteger order = BigInteger.TEN;
        BigInteger modVal = new BigInteger(String.valueOf(n));
        while(!BigInteger.TEN.pow(e).subtract(BigInteger.ONE).mod(modVal).equals(BigInteger.ZERO)
                && (e <= maxDigits))
        {
            e++;
        }
//        System.out.println("multiplicativeOrder(" + n + ")=" + e);
//        System.out.println();
        return e;
    }

    static List<Integer> getDivisors(int n)
    {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (n % i == 0)
                divisors.add(i);
        return divisors;
    }
    
    static int totient(int n, List<Integer> divisorsOfN)
    {
        int count = 0;

        for (int i = 1; i <= n; i++)
        {
            if (relativelyPrime(getDivisors(i), divisorsOfN))
                count++;
        }
//        System.out.println("totient of " + n + "=" + count);
        return count;
    }
}
