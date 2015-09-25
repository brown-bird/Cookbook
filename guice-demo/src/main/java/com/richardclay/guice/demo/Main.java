/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardclay.guice.demo;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 * @author Richard
 */
public class Main
{
	public static void main(String[] args)
	{
		Injector injector = Guice.createInjector(new MyModule());
		Student goodStudent = injector.getInstance(Student.class);
		System.out.println("goodStudent = " + goodStudent);
		goodStudent.study(6);
		System.out.println(goodStudent.getStatus());
	}
}
