package com.richardclay.guice.demo;

import com.google.inject.AbstractModule;

/**
 *
 * @author Richard
 */
public class MyModule extends AbstractModule
{

	@Override
	protected void configure()
	{
		bind(Student.class).to(GoodStudent.class);
		bind(ClassLevel.class).toInstance(ClassLevel.FRESHMAN);
		bind(Double.class).toInstance(4.0);
		bind(String.class)
				.annotatedWith(StudentName.class)
				.toInstance("Harry Potter");
	}
	
}
