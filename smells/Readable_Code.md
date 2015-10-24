# Readable Code

Reduce the *"time it takes to understanding"* in your code by making it more readable. 

## Conditionals

Prefer the **positive** case of an if else structure first

	if (shipReadyToLaunch())
	{
		buckleUp();
		...
	}
	else
	{
		everyBodyGoHome();
		...
	}
	
reads better than:

	if (!shipReadyToLaunch())
	{
		everyBodyGoHome();
		...
	}
	else
	{
		releaseLocks();
		...
	}	
	
#### Order of arguments in conditionals

`if (length >= 10)` reads better than `if (10 <= length)`

**Left-hand side** | **Right-hand side**
-------------------|--------------------
The expression "being interrogated," whose value is more in flux | The expression being compared against, whose value is more constant


#### Ternary Operator

Prefer simple `if else` structures over `condition ? true : false` ternary operators in all cases except possibly the most simple. Ternary usage can become harder to read quickly. 

>Instead of minimizing the number of lines, a better metric is to minmize the time needed for someone to understand it. 


	