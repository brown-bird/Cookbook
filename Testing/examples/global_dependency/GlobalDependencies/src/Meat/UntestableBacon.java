package Meat;

// untestable Bacon Singleton
public class UntestableBacon
{

    // eager instatiation to avoid synchronization issues
    // ok for heavily used singletons
    private volatile static UntestableBacon instance = new UntestableBacon();

    private UntestableBacon()
    {
    }
    
    public static UntestableBacon getInstance()
    {
        return instance;
    }
    
    // this method does stuff we wouldn't want done in a test.
    public String makeNetworkCallsAndDoBaconRelatedDatabaseThings()
    {
        return "I did delicious network and datase things!";
    }
}
