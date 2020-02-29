// Java program to illustrate 
// bitwise operators 
public class operators { 
    public static void main(String[] args) 
    { 
        
        // bitwise and 
        // 0101 & 0111=0101 = 5 
        print(5, "&", 7, (5&7));

        // bitwise or 
        // 0101 | 0111=0111 = 7 
        print(5, "|", 7, (5|7));
  
        // bitwise xor 
        // 0101 ^ 0111=0010 = 2 
        print(5, "^", 7, (5^7)); 
  
        // bitwise and 
        // ~0101=1010 
        // will give 2's complement of 1010 = -6 
        print("~", 5, ~5);
  
        // can also be combined with 
        // assignment operator to provide shorthand 
        // assignment 
        // a=a&b becomes a &= b
        
        int a = 5;
        int b = 7; 
        a &= b;
        System.out.println("a=" + a);
        System.out.println("a=" + toBin(a)); 

        // TODO: Add some bit shifting examples
    } 

    private static String toBin(int x)
    {
        return Integer.toBinaryString(x);
    }

    private static void print(int a, String operator, int b, int result)
    {
        System.out.println(String.format("%d %s %d = %s", a, operator, b, result));
        System.out.println(String.format("%s %s %s = %s", toBin(a), operator, toBin(b), toBin(result)));
        System.out.println();
    }
    private static void print(String operator, int a, int result)
    {
        System.out.println(String.format("%s%d = %d", operator, a, result));
        System.out.println(String.format("%s%s = %s", operator, toBin(a), toBin(result)));
        System.out.println();
    }
}