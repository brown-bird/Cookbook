package com.richardclay.guice.demo;

/**
 *
 * @author Richard
 */
public interface Student
{
	void eat(Food food);
	void study(int timePeriod);
	void sleep(int timePeriod);
	double gpa();
	public String getStatus();
}
