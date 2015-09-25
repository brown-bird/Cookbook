/*
 Example of constant-specific method implementation
 */
package reflection;

import enums.*;

public enum Operation implements ReferenceEnum
{
	// passing an argument to the constructor
    PLUS("+")
    {
		//implementing the abstract "apply" method
        double apply(double x, double y){return x + y;}
		// you can implement more than one abstract method
        String whoAmI(){return "I am Plus";} 
    },
    MINUS("-")
    {
        double apply(double x, double y){return x - y;}
        String whoAmI(){return "I am Minus";}
    },
    TIMES("*")
    {
        double apply(double x, double y){return x * y;}
        String whoAmI(){return "I am Times";}
    },
    DIVIDE("/")
    {
        double apply(double x, double y){return x / y;}
        String whoAmI(){return "I am Divide";}
    };
    

    // private member variable
    private String symbol;
    
    // private constructor
    private Operation(String symbol)
    {
        this.symbol = symbol;
    }
    
    
    // abstract methods to be implemented
    abstract double apply(double x, double y);
    abstract String whoAmI();

    // public getter
    public String getSymbol()
    {
        return this.symbol;
    }

    // overriding the tostring
    @Override
    public String toString()
    {
        return symbol;
    }
    
    @Override
    public String getName()
    {
        return this.symbol;
    }
}
