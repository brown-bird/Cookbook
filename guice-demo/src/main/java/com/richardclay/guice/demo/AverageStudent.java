package com.richardclay.guice.demo;

/**
 *
 * @author Richard
 */
public class AverageStudent extends AbstractStudent
{
	public AverageStudent(String name, double gpa, ClassLevel classLevel)
	{
		super(name, gpa, classLevel);
	}

	@Override
	public void eat(Food food)
	{
		status = "Taking a break to eat some " + food + ".";
	}

	@Override
	public void study(int timePeriod)
	{
		status = "Studying " + (timePeriod > 1 ? timePeriod / 2 : timePeriod) + " hours";
	}

	@Override
	public void sleep(int timePeriod)
	{
		status = "Sleeping " + (timePeriod + 2) + " hours";
	}
}
