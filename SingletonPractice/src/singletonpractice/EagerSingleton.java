package singletonpractice;

public class EagerSingleton
{
    private static EagerSingleton instance = new EagerSingleton();
    private String name;
    private int num;
    
    private EagerSingleton()
    {
    }
    
    public static EagerSingleton getInstance()
    {
        return instance;
    }

    public String getName()
    {
        return name;
    }

    public int getNum()
    {
        return num;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNum(int num)
    {
        this.num = num;
    }
    
    
    
    
}
