package com.richardclay.guice.demo;

/**
 *
 * @author Richard
 */
public class BadStudent extends AbstractStudent implements Student, Comparable<Student>
{
	
	public BadStudent(String name, double gpa, ClassLevel classLevel)
	{
		super(name, gpa, classLevel);
	}

	@Override
	public void eat(Food food)
	{
		status = "That " + food + " was yummy!";
	}

	@Override
	public void study(int timePeriod)
	{
		status = "What's a studying?";
	}

	@Override
	public void sleep(int timePeriod)
	{
		status = "Sleeping " + (2 * timePeriod) + " hours";
	}

	@Override
	public String getStatus()
	{
		return status;  
	}
	
}
