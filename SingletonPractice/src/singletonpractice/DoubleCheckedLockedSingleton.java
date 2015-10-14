
package singletonpractice;

/**
 *
 * @author Richard
 */
public class DoubleCheckedLockedSingleton
{

    private volatile static DoubleCheckedLockedSingleton instance;
    private String name;
    private int num;

    private DoubleCheckedLockedSingleton()
    {
    }

    public static DoubleCheckedLockedSingleton getInstance()
    {
        if (instance == null)
        {
            synchronized (DoubleCheckedLockedSingleton.class)
            {
                if (instance == null)
                {
                    instance = new DoubleCheckedLockedSingleton();
                }
            }
        }

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
