package com.richardclay.guice.demo;

/**
 *
 * @author Richard
 */
public interface Instructor
{
	int grade(Assignment assignment);
	boolean pass(Student student);
	boolean fail(Student student);
}
