package singleton;

public class EagerSingleton
{
    public static EagerSingleton INSTANCE = new EagerSingleton();
    
    private EagerSingleton(){}
    
    public EagerSingleton getInstance()
    {
        return INSTANCE;
    }
    
}
