package Meat;

// untestable Bacon Singleton
public class TestableBacon
{

    private volatile static TestableBacon instance;

    // relax visibility to allow subclassing for testing
    protected TestableBacon()
    {
    }
    
    // Double checked locking only incurs synchronization overhead if 
    // instance is null
    public static TestableBacon getInstance()
    {
        if (instance == null)
        {
            synchronized (TestableBacon.class)
            {
                if (instance == null)
                {
                    instance = new TestableBacon();
                }
            }

        }
        return instance;
    }
    
    // utility method for testing
    public static void setTestInstance(TestableBacon testInstance)
    {
        instance = testInstance;
    }
    
    // cleanup method for testing
    public static void resetInstance()
    {
        instance = null;
    }
    
    // this method does stuff we wouldn't want done in a test.
    public String makeNetworkCallsAndDoBaconRelatedDatabaseThings()
    {
        return "I did delicious network and datase things!";
    }
}
