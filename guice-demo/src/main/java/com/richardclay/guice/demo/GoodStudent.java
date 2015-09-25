package com.richardclay.guice.demo;

import com.google.inject.Inject;

/**
 *
 * @author Richard
 */
public class GoodStudent extends AbstractStudent 
{
	@Inject
	public GoodStudent(@StudentName String name, double gpa, ClassLevel classLevel)
	{
		super(name, gpa, classLevel);
	}

	@Override
	public void eat(Food food)
	{
		status = "Waiting to eat some " + " after I finish studying";
	}

	@Override
	public void study(int timePeriod)
	{
		this.status = " studying for " + timePeriod + " hours";
	}

	@Override
	public void sleep(int timePeriod)
	{
		status = "Sleeping for " + (timePeriod > 2 ? timePeriod - 1 : timePeriod)
				+ " hours";
	}
	

	@Override
	public String toString()
	{
		return "GoodStudent{" + "name=" + name + ", gpa=" + gpa + ", classLevel=" + classLevel + '}';
	}

}
	