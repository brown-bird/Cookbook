/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardclay.guice.demo;

import Cars.Car;
import Cars.M3Module;
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
//		Injector injector = Guice.createInjector(new MyModule());
//		Student goodStudent = injector.getInstance(Student.class);
//		System.out.println("goodStudent = " + goodStudent);
//		goodStudent.study(6);
//		System.out.println(goodStudent.getStatus());
            
            
            Injector injector = Guice.createInjector(new M3Module());
            Car m3 = injector.getInstance(Car.class);
            System.out.println(m3.startIgnition());
            System.out.println(m3.revEngine());
	}
}
