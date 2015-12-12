package Meat;

public class Chicken
{
    private static Chicken instance;
    
    protected Chicken(){}
    
    public static Chicken getInstance()
    {
        if (instance == null)
        {
            instance = new Chicken();
        }
        
        return instance;
    }
    
    public static void setTestInstance(Chicken testInstance)
    {
        instance = testInstance;
    }
    
    public String createSmell()
    {
        return "What kind of chicken smell am I?";
    }
    
    public String bite()
    {
        return "Delicious!";
    }
    
    // do other appetizing things...
}
