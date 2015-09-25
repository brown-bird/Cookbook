
package reflection;

//import com.sun.java.util.jar.pack.Package.Class;


public class Driver
{
    public static void main(String[] args)
    {
        ReferenceEnum rEnum = Operation.PLUS;
        Class clazz = rEnum.getClass();
        
        Operation plus = (Operation) clazz.cast(rEnum);
        int x = 1, y = 3;
        System.out.println("x + y = " + plus.apply(x, y));
        
        System.out.println("x + y = " + ((Operation)(rEnum.getClass()).cast(rEnum)).MINUS.apply(x, y));
        
        
    }
}
