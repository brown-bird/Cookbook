
package predicates;

public class Foo
{
    private boolean isValid;
    private String name;
    
    public Foo(boolean isValid, String name)
    {
        this.isValid = isValid;
        this.name = name;
    }

    public boolean isValid()
    {
        return isValid;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return this.name + " " + this.isValid;
    }
}
