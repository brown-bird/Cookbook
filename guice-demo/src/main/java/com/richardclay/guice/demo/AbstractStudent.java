/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardclay.guice.demo;

/**
 *
 * @author Richard
 */
public abstract class AbstractStudent implements Student, Comparable<Student>
{
	protected final ClassLevel classLevel;
	protected final String name;
	protected final double gpa;
	protected String status;

	public AbstractStudent(String name, double gpa, ClassLevel classLevel)
	{
		this.name = name;
		this.gpa = gpa;
		this.classLevel = classLevel;
	}

	public String getName()
	{
		return name;
	}

	public double getGpa()
	{
		return gpa;
	}

	public ClassLevel getClassLevel()
	{
		return classLevel;
	}

	public String getStatus()
	{
		return status;
	}

	@Override
	public double gpa()
	{
		return this.gpa;
	}

	public int compareTo(Student other)
	{
		double tolerance = 0.001;
		return this.gpa() - other.gpa() < tolerance ? 0
				: this.gpa() > other.gpa() ? 1 : -1;
	}

	@Override
	public String toString()
	{
		return "Student{" + "name=" + name + ", gpa=" + gpa + ", classLevel=" + classLevel + ", status=" + status + '}';
	}

}
